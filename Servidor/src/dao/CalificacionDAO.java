package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.CalificacionDTO;
import entity.CalificacionEntity;
import excepciones.UsuarioException;
import hibernate.HibernateUtil;
import negocio.Calificacion;

public class CalificacionDAO {
	private static CalificacionDAO instancia;
	private SessionFactory sf;

	public CalificacionDAO() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	public void save(Calificacion calificacion) throws UsuarioException{
		try {
			CalificacionEntity aux = toEntity(calificacion);
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(aux);
			s.getTransaction().commit();
			s.close();
		} catch(Exception e) {
			new UsuarioException("Error en calificar paseador en BD, reintente");
		}
	}
	
	public Calificacion toNegocio(CalificacionEntity calificacion) {
		Calificacion aux = new Calificacion(calificacion.getIdCalificacion(), calificacion.getPuntaje(), calificacion.getComentarios(),
				calificacion.getFecha(), null, null);
		return aux;
	}

	
	public CalificacionEntity toEntity(Calificacion calificacion) {
		CalificacionEntity calificacionEntity = new CalificacionEntity();
		calificacionEntity.setComentarios(calificacion.getComentarios());
		calificacionEntity.setFecha(calificacion.getFecha());
		calificacionEntity.setIdCalificacion(calificacion.getIdCalificacion());
		calificacionEntity.setPuntaje(calificacion.getPuntaje());
		calificacionEntity.setReserva(ReservaDAO.getInstancia().toEntity(calificacion.getReserva()));
		calificacionEntity.setPaseador(UsuarioDAO.getInstancia().toEntity(calificacion.getPaseador()));
		return calificacionEntity;
	}

	public static CalificacionDAO getInstancia() {
		if (instancia == null) {
			instancia = new CalificacionDAO();
		}
		return instancia;
	}
	
	public CalificacionDTO toDTO(CalificacionEntity calificacion) {
		CalificacionDTO calificacionDTO = new CalificacionDTO();
		calificacionDTO.setComentarios(calificacion.getComentarios());
		calificacionDTO.setFecha(calificacion.getFecha());
		calificacionDTO.setIdCalificacion(calificacion.getIdCalificacion());
		calificacionDTO.setPuntaje(calificacion.getPuntaje());
		calificacionDTO.setReserva(ReservaDAO.getInstancia().toDTO(calificacion.getReserva()));
		return calificacionDTO;
	}
}
