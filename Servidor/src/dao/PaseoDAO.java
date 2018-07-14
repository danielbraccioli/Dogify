package dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.FotoDTO;
import dto.PaseoDTO;
import dto.ReservaDTO;
import entity.FotoEntity;
import entity.PaseoEntity;
import entity.ReservaEntity;
import excepciones.PaseoException;
import hibernate.HibernateUtil;
import negocio.Foto;
import negocio.Paseo;
import negocio.Reserva;


public class PaseoDAO {

	private static PaseoDAO instancia;
	private SessionFactory sf;

	public PaseoDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static PaseoDAO getInstancia() {
		if (instancia == null) {
			instancia = new PaseoDAO();
		}
		return instancia;
	}
	
	public void update(Paseo paseo) throws PaseoException{
		PaseoEntity aux = toEntity(paseo);
		try {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.update(aux);
		s.getTransaction().commit();
		s.close();
		}catch(Exception e) {
			new PaseoException("Error de actualizacion de paseo en BD, reintente");
		}
	}
	
	public PaseoEntity toEntity(Paseo paseo) {
		PaseoEntity paseoEntity = new PaseoEntity();
		paseoEntity.setBarrio(paseo.getBarrio());
		paseoEntity.setCapacidad(paseo.getCapacidad());
		paseoEntity.setEstado(paseo.getEstado());
		paseoEntity.setFecha(paseo.getFecha());
		paseoEntity.setHoraFin(paseo.getHoraFin());
		paseoEntity.setHoraInicio(paseo.getHoraInicio());
		paseoEntity.setHorarioFin(paseo.getHorarioFin());
		paseoEntity.setHorarioInicio(paseo.getHorarioInicio());
		paseoEntity.setIdPaseo(paseo.getIdPaseo());
		paseoEntity.setPaseador(UsuarioDAO.getInstancia().toEntity(paseo.getPaseador()));
		paseoEntity.setTarifa(paseo.getTarifa());
		paseoEntity.setUbicacionLatitud(paseo.getUbicacionLatitud());
		paseoEntity.setUbicacionLongitud(paseo.getUbicacionLongitud());
		return paseoEntity;
	}

	public boolean grabarPaseo(PaseoEntity paseoEntity) throws SQLException{
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(paseoEntity);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error PaseoDAO. Alta Paseo");
			return false;
		}
	}
	
	
	private List<PaseoDTO> recuperarPaseos(List<PaseoEntity> paseosE){
			List<PaseoDTO> PaseosDTO = new ArrayList<PaseoDTO>();
		
		for (PaseoEntity pas : paseosE){
			PaseoDTO pasDTO = new PaseoDTO();
			pasDTO.setIdPaseo(pas.getIdPaseo());
			pasDTO.setBarrio(pas.getBarrio());
			pasDTO.setCapacidad(pas.getCapacidad());
			pasDTO.setEstado(pas.getEstado());
			pasDTO.setFecha(pas.getFecha());
			pasDTO.setHoraFin(pas.getHoraFin());
			pasDTO.setHoraInicio(pas.getHoraInicio());
			pasDTO.setHorarioInicio(pas.getHorarioInicio());
			pasDTO.setHorarioFin(pas.getHorarioFin());
			pasDTO.setTarifa(pas.getTarifa());
			pasDTO.setUbicacionLatitud(pas.getUbicacionLatitud());
			pasDTO.setUbicacionLongitud(pas.getUbicacionLongitud());
			
			PaseosDTO.add(pasDTO);
			
			
		}
				
		return PaseosDTO;
	}
	
	public List<PaseoDTO> buscarPaseosByFechaBarrio(Date fecha,String barrio) throws PaseoException{
		List<PaseoEntity> listaPaseosEntity = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			java.util.Date dutyDay = (java.util.Date) dateFormat.parse(dateFormat.format(fecha));
			Session session = sf.openSession();
			session.beginTransaction();
			listaPaseosEntity = session.createQuery("from PaseoEntity p where p.fecha = :fecha and p.barrio = :barrio")
			.setParameter("fecha", dutyDay)
			.setParameter("barrio",barrio).list();
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e) {
			new PaseoException("Error en busqueda de paseos por fecha y barrio en BD, reintente");
		}
		return recuperarPaseos(listaPaseosEntity);
	}
	
	public Paseo buscarPaseoById(int idPaseo) throws PaseoException{
		PaseoEntity aux1 = null;
		try {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		aux1  = (PaseoEntity)s.createQuery("From PaseoEntity c where c.idPaseo = ?").setInteger(0, idPaseo).uniqueResult();
		}catch(Exception e) {
			new PaseoException("Error en busqueda de Paseo en BD, reintente");
		}
		return toNegocio(aux1);
	}	
	
	public PaseoDTO buscarPaseoByIdDTO(int idPaseo) throws PaseoException{
		PaseoEntity aux1 = null;
		try {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		aux1  = (PaseoEntity)s.createQuery("From PaseoEntity c where c.idPaseo = ?").setInteger(0, idPaseo).uniqueResult();
		}catch(Exception e) {
			new PaseoException("Error en busqueda de Paseo en BD, reintente");
		}
		return toDTO(aux1);
	}	
	
	public Paseo toNegocio(PaseoEntity paseo) {
		Paseo aux = new Paseo(paseo.getIdPaseo(), null, paseo.getFecha(), paseo.getEstado(), paseo.getTarifa(), paseo.getHorarioInicio(),
				paseo.getHorarioFin(), paseo.getHoraInicio(), paseo.getHoraFin(), paseo.getCapacidad(), paseo.getBarrio(), 
				paseo.getUbicacionLatitud(), paseo.getUbicacionLongitud(), null, null);
		List<Reserva> reservasAux = new ArrayList<Reserva>();
		for(ReservaEntity reserva : paseo.getReservas()) {
			reservasAux.add(ReservaDAO.getInstancia().toNegocio(reserva, aux));
		}
		aux.setReservas(reservasAux);
		List<Foto> fotosAux = new ArrayList<Foto>();
		for(FotoEntity foto : paseo.getFotos()) {
			fotosAux.add(FotoDAO.getInstancia().toNegocio(foto));
		}
		aux.setFotos(fotosAux);
		aux.setPaseador(UsuarioDAO.getInstancia().toNegocio(paseo.getPaseador()));
		
		return aux;
	}

	public PaseoDTO toDTO(PaseoEntity paseo) {
		PaseoDTO paseoDTO = new PaseoDTO();
		paseoDTO.setBarrio(paseo.getBarrio());
		paseoDTO.setCapacidad(paseo.getCapacidad());
		paseoDTO.setEstado(paseo.getEstado());
		paseoDTO.setFecha(paseo.getFecha());
		paseoDTO.setHoraFin(paseo.getHoraFin());
		paseoDTO.setHoraInicio(paseo.getHoraInicio());
		paseoDTO.setHorarioFin(paseo.getHorarioFin());
		paseoDTO.setHorarioInicio(paseo.getHorarioInicio());
		paseoDTO.setIdPaseo(paseo.getIdPaseo());
		paseoDTO.setPaseador(UsuarioDAO.getInstancia().toDTOSimple(paseo.getPaseador()));
		List<ReservaDTO> reservasDTO = new ArrayList<ReservaDTO>();
		for(ReservaEntity reserva : paseo.getReservas())
			reservasDTO.add(ReservaDAO.getInstancia().toDTOPaseo(reserva));
		paseoDTO.setReservas(reservasDTO);
		paseoDTO.setTarifa(paseo.getTarifa());
		paseoDTO.setUbicacionLatitud(paseo.getUbicacionLatitud());
		paseoDTO.setUbicacionLongitud(paseo.getUbicacionLongitud());
		List<FotoDTO> fotosDTO = new ArrayList<FotoDTO>();
		for(FotoEntity foto : paseo.getFotos()) {
			fotosDTO.add(FotoDAO.getInstancia().toDTO(foto));
		}
		paseoDTO.setFotos(fotosDTO);
		return paseoDTO;
	}

	public PaseoDTO toDTOSimple(PaseoEntity paseo) {
		PaseoDTO paseoDTO = new PaseoDTO();
		paseoDTO.setBarrio(paseo.getBarrio());
		paseoDTO.setCapacidad(paseo.getCapacidad());
		paseoDTO.setEstado(paseo.getEstado());
		paseoDTO.setFecha(paseo.getFecha());
		paseoDTO.setHoraFin(paseo.getHoraFin());
		paseoDTO.setHoraInicio(paseo.getHoraInicio());
		paseoDTO.setHorarioFin(paseo.getHorarioFin());
		paseoDTO.setHorarioInicio(paseo.getHorarioInicio());
		paseoDTO.setIdPaseo(paseo.getIdPaseo());
		paseoDTO.setPaseador(UsuarioDAO.getInstancia().toDTOSimple(paseo.getPaseador()));
		paseoDTO.setTarifa(paseo.getTarifa());
		paseoDTO.setUbicacionLatitud(paseo.getUbicacionLatitud());
		paseoDTO.setUbicacionLongitud(paseo.getUbicacionLongitud());
		List<FotoDTO> fotosDTO = new ArrayList<FotoDTO>();
		for(FotoEntity foto : paseo.getFotos()) {
			fotosDTO.add(FotoDAO.getInstancia().toDTO(foto));
		}
		paseoDTO.setFotos(fotosDTO);
		return paseoDTO;
	}

	public List<PaseoDTO> buscarPaseosByPaseadorId(int idPaseador) throws PaseoException {
		List<PaseoEntity> aux1 = null;
		List<PaseoDTO> aux2 = new ArrayList<PaseoDTO>();
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			aux1 = session.createQuery("From PaseoEntity r where r.paseador = ?").setInteger(0, idPaseador).list();
			session.getTransaction().commit();
			session.close();
		for(PaseoEntity paseo : aux1) {
			aux2.add(this.toDTO(paseo));
		}
		}catch(Exception e) {
			new PaseoException("Error en busqueda de Paseos paseador en BD, reintente");
		}
		return aux2;
	}	
	
	public List<PaseoDTO> buscarPaseosByMesAnio(int mes, int anio) throws PaseoException {
		List<PaseoEntity> aux1 = null;
		List<PaseoDTO> aux2 = new ArrayList<PaseoDTO>();
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			aux1 = session.createQuery("From PaseoEntity r where month(r.fecha)=? and year(r.fecha)=?").setInteger(0, mes).setInteger(1, anio).list();
			session.getTransaction().commit();
			session.close();
		for(PaseoEntity paseo : aux1) {
			aux2.add(this.toDTO(paseo));
		}
		}catch(Exception e) {
			new PaseoException("Error en busqueda de Paseos paseador en BD, reintente");
		}
		return aux2;
	}	
	
	public List<PaseoDTO> buscarPaseosByFecha(Date fecha) throws PaseoException {
		List<PaseoEntity> aux1 = null;
		List<PaseoDTO> aux2 = new ArrayList<PaseoDTO>();
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			aux1 = session.createQuery("From PaseoEntity r where r.fecha = ?").setDate(0, fecha).list();
			session.getTransaction().commit();
			session.close();
		for(PaseoEntity paseo : aux1) {
			aux2.add(this.toDTO(paseo));
		}
		}catch(Exception e) {
			new PaseoException("Error en busqueda de Paseos paseador en BD, reintente");
		}
		return aux2;
	}	

}