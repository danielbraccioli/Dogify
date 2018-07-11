package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.ClienteEntity;
import entity.MensajeEntity;
import excepciones.PaseoException;
import hibernate.HibernateUtil;
import negocio.Cliente;
import negocio.Mensaje;
import negocio.Paseador;

public class MensajeDAO {
	private static MensajeDAO instancia;
	private SessionFactory sf;

	public MensajeDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static MensajeDAO getInstancia() {
		if (instancia == null) {
			instancia = new MensajeDAO();
		}
		return instancia;
	}
	
	public void save(Mensaje mensaje) throws PaseoException{
		MensajeEntity aux = toEntity(mensaje);
		try {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(aux);
		s.getTransaction().commit();
		s.close();
		}catch(Exception e) {
			new PaseoException("Error en guardar mensaje en paseo en BD, reintente");
		}
	}
	
	public Mensaje toNegocio(MensajeEntity mensaje) {
		Mensaje aux = new Mensaje(mensaje.getIdMensaje(), mensaje.getFecha(), mensaje.getHora(), mensaje.getMensaje(), null);
		if (mensaje.getUsuario() instanceof ClienteEntity) {
			aux.setUsuario(UsuarioDAO.getInstancia().toNegocio((ClienteEntity) mensaje.getUsuario()));
		}else {
			// pasar a paseador
		}
		return aux;
	}
	
	public MensajeEntity toEntity(Mensaje mensaje) {
		MensajeEntity mensajeEntity = new MensajeEntity();
		mensajeEntity.setFecha(mensaje.getFecha());
		mensajeEntity.setHora(mensaje.getHora());
		mensajeEntity.setIdMensaje(mensaje.getIdMensaje());
		mensajeEntity.setMensaje(mensaje.getMensaje());
		if (mensaje.getUsuario() instanceof Paseador)
			mensajeEntity.setUsuario(UsuarioDAO.getInstancia().toEntity((Paseador) mensaje.getUsuario()));
		else
			mensajeEntity.setUsuario(UsuarioDAO.getInstancia().toEntity((Cliente) mensaje.getUsuario()));
		return mensajeEntity;
	}
}
