package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.ReservaDTO;
import entity.MensajeEntity;
import entity.ReservaEntity;
import excepciones.ReservaException;
import hibernate.HibernateUtil;
import negocio.Mensaje;
import negocio.Paseo;
import negocio.Reserva;


public class ReservaDAO {

	private static ReservaDAO instancia;
	private SessionFactory sf;

	public ReservaDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static ReservaDAO getInstancia() {
		if (instancia == null) {
			instancia = new ReservaDAO();
		}
		return instancia;
	}
	
	public void update(Reserva reserva) throws ReservaException{
		ReservaEntity aux = toEntity(reserva);
		try {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.update(aux);
		s.getTransaction().commit();
		s.close();
		}catch(Exception e) {
			new ReservaException("Error en actualizacion de reserva en BD, reintente");
		}
	}
	
	public void save(Reserva reserva) throws ReservaException{
		ReservaEntity aux = toEntity(reserva);
		try {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(aux);
		s.getTransaction().commit();
		s.close();
		}catch(Exception e) {
			new ReservaException("Error en alta de reserva en BD, reintente");
		}
	}
	
	public Reserva toNegocio(ReservaEntity reserva) {
		Reserva aux = new Reserva(reserva.getIdReserva(), reserva.getEstado(), reserva.getHoraRetiro(), reserva.getHoraDevolucion(),
				null, null, null, null);
		List<Mensaje> mensajesAux = new ArrayList<Mensaje>();
		for(MensajeEntity mensaje : reserva.getMensajes()) {
			mensajesAux.add(MensajeDAO.getInstancia().toNegocio(mensaje));
		}
		aux.setMensajes(mensajesAux);
		aux.setCliente(UsuarioDAO.getInstancia().toNegocioSimple(reserva.getCliente()));
		aux.setPaseo(PaseoDAO.getInstancia().toNegocio(reserva.getPaseo()));
		aux.setPerro(PerroDAO.getInstancia().toNegocio(reserva.getPerro()));
		return aux;
	}
	
	public Reserva toNegocio(ReservaEntity reserva, Paseo paseo) {
		Reserva aux = new Reserva(reserva.getIdReserva(), reserva.getEstado(), reserva.getHoraRetiro(), reserva.getHoraDevolucion(),
				null, null, null, null);
		List<Mensaje> mensajesAux = new ArrayList<Mensaje>();
		for(MensajeEntity mensaje : reserva.getMensajes()) {
			mensajesAux.add(MensajeDAO.getInstancia().toNegocio(mensaje));
		}
		aux.setMensajes(mensajesAux);
		aux.setCliente(UsuarioDAO.getInstancia().toNegocioSimple(reserva.getCliente()));
		aux.setPaseo(paseo);
		aux.setPerro(PerroDAO.getInstancia().toNegocio(reserva.getPerro()));
		return aux;
	}
	
	public ReservaEntity toEntity(Reserva reserva) {
		ReservaEntity reservaEntity = new ReservaEntity();
		reservaEntity.setCliente(UsuarioDAO.getInstancia().toEntity(reserva.getCliente()));
		reservaEntity.setPaseo(PaseoDAO.getInstancia().toEntity(reserva.getPaseo()));
		reservaEntity.setPerro(PerroDAO.getInstancia().toEntity(reserva.getPerro()));
		reservaEntity.setEstado(reserva.getEstado());
		reservaEntity.setHoraDevolucion(reserva.getHoraDevolucion());
		reservaEntity.setHoraRetiro(reserva.getHoraRetiro());
		reservaEntity.setIdReserva(reserva.getIdReserva());
		return reservaEntity;
	}


	public int reservarPaseo(Reserva reserva) {
		ReservaEntity reservaE = new ReservaEntity();
		reservaE.setEstado(reserva.getEstado());
		reservaE.setHoraDevolucion(reserva.getHoraDevolucion());
		reservaE.setHoraRetiro(reserva.getHoraRetiro());
		
			try {
				Session session = sf.openSession();
				session.beginTransaction();
				int idGenerado = (int) session.save(reservaE);
				session.getTransaction().commit();
				session.close();
				return idGenerado;
				
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Error ReservaDAO. reservarPaseo");
				return -1;
			}
		}
	
	public List<ReservaDTO> recuperarReservas(Integer idUsuario) {
		try{
			Session session = sf.openSession();
			session.beginTransaction();
			List<ReservaEntity> listaReservas = session.createQuery("From ReservaEntity r where r.cliente = ?").setInteger(0, idUsuario).list();
			session.getTransaction().commit();
			session.close();
			List<ReservaDTO> reservasDTO = new ArrayList<ReservaDTO>();
			for(ReservaEntity reserva : listaReservas)
				reservasDTO.add(this.toDTO(reserva));
			return reservasDTO;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error UsuarioDAO.recuperarReservas");
			return null;
		}
	}
	
	public Reserva buscarReservaById(int idReserva) throws ReservaException{
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			ReservaEntity reserva = (ReservaEntity) session
					.createQuery("from ReservaEntity r where r.idReserva = :idReserva ")
					.setParameter("idReserva", idReserva).uniqueResult();
			session.getTransaction().commit();
			session.close();
			return toNegocio(reserva);
		} catch (Exception e) {
			new ReservaException("Error en busqueda de reserva en BD, reintente");
		}
		return null;
	}
	
	public ReservaDTO buscarReservaByIdDTO(int idReserva) throws ReservaException{
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			ReservaEntity reserva = (ReservaEntity) session
					.createQuery("from ReservaEntity r where r.idReserva = :idReserva ")
					.setParameter("idReserva", idReserva).uniqueResult();
			session.getTransaction().commit();
			session.close();
			return toDTO(reserva);
		} catch (Exception e) {
			new ReservaException("Error en busqueda de reserva en BD, reintente");
		}
		return null;
	}
	
	public ReservaEntity recuperarReserva(int idReserva) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			ReservaEntity reserva = (ReservaEntity) session
					.createQuery("from ReservaEntity r where r.idReserva = :idReserva ")
					.setParameter("idReserva", idReserva).uniqueResult();
			session.getTransaction().commit();
			session.close();
			return reserva;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error UsuarioDAO.recuperarReserva");
		}
		return null;
	}
	
	public ReservaDTO toDTO(ReservaEntity reserva) {
		ReservaDTO reservaDTO = new ReservaDTO();
		reservaDTO.setIdReserva(reserva.getIdReserva());
		reservaDTO.setEstado(reserva.getEstado());
		reservaDTO.setHoraDevolucion(reserva.getHoraDevolucion());
		reservaDTO.setHoraRetiro(reserva.getHoraRetiro());
		//reservaDTO.setCliente(UsuarioDAO.getInstancia().toDTO(reserva.getCliente()));
		reservaDTO.setPerro(PerroDAO.getInstancia().toDTO(reserva.getPerro()));
		reservaDTO.setPaseo(PaseoDAO.getInstancia().toDTOSimple(reserva.getPaseo()));
		return reservaDTO;
	}
	
	public ReservaDTO toDTOPaseo(ReservaEntity reserva) {
		ReservaDTO reservaDTO = new ReservaDTO();
		reservaDTO.setIdReserva(reserva.getIdReserva());
		reservaDTO.setEstado(reserva.getEstado());
		reservaDTO.setHoraDevolucion(reserva.getHoraDevolucion());
		reservaDTO.setHoraRetiro(reserva.getHoraRetiro());
		reservaDTO.setCliente(UsuarioDAO.getInstancia().toDTOSimple(reserva.getCliente()));
		reservaDTO.setPerro(PerroDAO.getInstancia().toDTO(reserva.getPerro()));
		reservaDTO.setPaseo(PaseoDAO.getInstancia().toDTOSimple(reserva.getPaseo()));
		return reservaDTO;
	}
	
	
	
//	public ReservaEntity toEntity(Reserva reserva) {
//		ReservaEntity reservaEntity = new ReservaEntity();
//		reservaEntity.setCliente(UsuarioDAO.getInstancia().to);
//	}
		
	

	

}