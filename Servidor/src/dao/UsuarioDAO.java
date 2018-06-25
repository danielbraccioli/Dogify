package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.*;
import entity.*;
import hibernate.HibernateUtil;
import negocio.*;


public class UsuarioDAO {

	private static UsuarioDAO instancia;
	private SessionFactory sf;

	public UsuarioDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static UsuarioDAO getInstancia() {
		if (instancia == null) {
			instancia = new UsuarioDAO();
		}
		return instancia;
	}

	public UsuarioDTO loginUsuario(Usuario usuario){
		UsuarioDTO usuarioD = new UsuarioDTO();
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			UsuarioEntity usuarioE = (UsuarioEntity) session
					.createQuery("from UsuarioEntity c where c.email = :email and c.password = :password")
					.setParameter("email",usuario.getEmail())
					.setParameter("password",usuario.getPassword()).uniqueResult();
			session.getTransaction().commit();
			session.close();
			if (usuarioE != null){
				usuarioD.setApellido(usuarioE.getApellido());
				usuarioD.setNombre(usuarioE.getNombre());
				usuarioD.setDni(usuarioE.getDni());
				usuarioD.setEmail(usuarioE.getEmail());
				usuarioD.setPassword(usuarioE.getPassword());
				return usuarioD;
			}
			else
				return null;
				
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error UsuarioDAO.recuperarUsuario");
		}
		return null;
	}
	
	public ClienteEntity recuperarCliente(int idUsuario) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			ClienteEntity cliente = (ClienteEntity) session
					.createQuery("from ClienteEntity c where c.idUsuario = :idUsuario ")
					.setParameter("idUsuario", idUsuario).uniqueResult();
			session.getTransaction().commit();
			session.close();
			return cliente;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error UsuarioDAO.recuperarCliente");
		}
		return null;
	}
	

	
	public void modificarCliente(ClienteEntity cliente) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			session.update(cliente);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error UsuarioDAO.modificarCliente");
		}
	}
	

	public void agregarReserva(int idUsuario, int idReserva) {
		ReservaEntity reserva = ReservaDAO.getInstancia().recuperarReserva(idReserva);
		ClienteEntity cliente = this.recuperarCliente(idUsuario);
		cliente.agregarReserva(reserva);
		this.modificarCliente(cliente);
		
	}
	
	public List<ReservaDTO> convertirReservaDTO(List<ReservaEntity> reservasE){
		List<ReservaDTO> reservasD = new ArrayList<ReservaDTO>();
		
		for (ReservaEntity reservaE : reservasE){
			ReservaDTO r = new ReservaDTO();
			r.setEstado(reservaE.getEstado());
			r.setHoraDevolucion(reservaE.getHoraDevolucion());
			r.setHoraRetiro(reservaE.getHoraRetiro());
			r.setIdReserva(reservaE.getIdReserva());
			reservasD.add(r);
		}
				
		return reservasD;
	}
	

	public List<ReservaDTO> recuperarReservas(int idUsuario) {
		try{
			Session session = sf.openSession();
			session.beginTransaction();
			List<ReservaEntity> listaReservas = session.createQuery("select r from UsuarioEntity u join u.reservas r where u.idUsuario = :idUsuario")
			.setParameter("idUsuario", idUsuario).list();
			session.getTransaction().commit();
			session.close();
			return convertirReservaDTO(listaReservas);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error UsuarioDAO.recuperarReservas");
			return null;
		}
	}
		
	

}