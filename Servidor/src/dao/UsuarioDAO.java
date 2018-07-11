package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.CalificacionDTO;
import dto.ClienteDTO;
import dto.PaseadorDTO;
import dto.PerroDTO;
import dto.ReservaDTO;
import entity.CalificacionEntity;
import entity.ClienteEntity;
import entity.PaseadorEntity;
import entity.PerroEntity;
import entity.ReservaEntity;
import entity.UsuarioEntity;
import hibernate.HibernateUtil;
import negocio.Calificacion;
import negocio.Cliente;
import negocio.Direccion;
import negocio.Paseador;
import negocio.Paseo;
import negocio.Perro;
import negocio.Reserva;


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

	public ClienteDTO loginUsuario(String email, String password) throws SQLException{
		ClienteDTO usuarioD = new ClienteDTO();
			Session session = sf.openSession();
			session.beginTransaction();
			UsuarioEntity usuarioE = (UsuarioEntity) session
					.createQuery("from UsuarioEntity c where c.email = :email and c.password = :password")
					.setParameter("email",email)
					.setParameter("password",password).uniqueResult();
			session.getTransaction().commit();
			session.close();
			if (usuarioE instanceof ClienteEntity){
			//	System.out.println(((ClienteEntity) usuarioE).getPerros().get(0).getNombre());
			//	System.out.println(((ClienteEntity) usuarioE).getReservas().get(0).getPaseo().getPaseador().getNombre());
			}
			return toDTO((ClienteEntity) usuarioE);
	}
	
	public Cliente buscarClienteById(int idCliente) {
		Session session = sf.openSession();
		session.beginTransaction();
		ClienteEntity cliente = (ClienteEntity) session
				.createQuery("from ClienteEntity c where c.idUsuario = :idUsuario ")
				.setParameter("idUsuario", idCliente).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return toNegocio(cliente);
	}
	
	public Cliente toNegocio(ClienteEntity cliente) {
		Cliente aux = new Cliente(cliente.getIdUsuario(), cliente.getEmail(), cliente.getPassword(), cliente.getNombre(),
				cliente.getApellido(), cliente.getDni(), cliente.getFechaNacimiento(), cliente.getAvatar(), null, 
				null, null, cliente.getCuentaCorriente());
		aux.setDireccion(DireccionDAO.getInstancia().toNegocio(cliente.getDireccion()));
		List<Perro> auxPerros = new ArrayList<Perro>();
		for(PerroEntity perro : cliente.getPerros()) {
			auxPerros.add(PerroDAO.getInstancia().toNegocio(perro));
		}
		aux.setPerros(auxPerros);
		List<Reserva> auxReservas = new ArrayList<Reserva>();
		for(ReservaEntity reserva : cliente.getReservas()) {
			auxReservas.add(ReservaDAO.getInstancia().toNegocio(reserva));
		}
		aux.setReservas(auxReservas);
		return aux;
	}
	
	public Cliente toNegocioSimple(ClienteEntity cliente) {
		Cliente aux = new Cliente(cliente.getIdUsuario(), cliente.getEmail(), cliente.getPassword(), cliente.getNombre(),
				cliente.getApellido(), cliente.getDni(), cliente.getFechaNacimiento(), cliente.getAvatar(), null, 
				null, null, cliente.getCuentaCorriente());
		aux.setDireccion(DireccionDAO.getInstancia().toNegocio(cliente.getDireccion()));
		List<Perro> auxPerros = new ArrayList<Perro>();
		for(PerroEntity perro : cliente.getPerros()) {
			auxPerros.add(PerroDAO.getInstancia().toNegocio(perro));
		}
		aux.setPerros(auxPerros);
		return aux;
	}
	
	public Paseador toNegocio(PaseadorEntity paseador) {
		Paseador aux = new Paseador(paseador.getIdUsuario(), paseador.getEmail(), paseador.getPassword(), paseador.getNombre(), paseador.getApellido(), paseador.getDni(),
				paseador.getFechaNacimiento(), paseador.getAvatar(), null, paseador.getNumeroRegistro(), paseador.getPerfil(),
				paseador.getReputacion(), null, null);
		aux.setDireccion(DireccionDAO.getInstancia().toNegocio(paseador.getDireccion()));
		List<Calificacion> calificacionesAux = new ArrayList<Calificacion>();
		for(CalificacionEntity calificacion : paseador.getCalificaciones()) {
			Calificacion calif = CalificacionDAO.getInstancia().toNegocio(calificacion);
			calif.setPaseador(aux);
			calificacionesAux.add(calif);
		}
		aux.setCalificaciones(calificacionesAux);
		return aux;
	}
	
	public ClienteEntity recuperarCliente(int idUsuario) throws SQLException{
		Session session = sf.openSession();
		session.beginTransaction();
		ClienteEntity cliente = (ClienteEntity) session
				.createQuery("from ClienteEntity c where c.idUsuario = :idUsuario ")
				.setParameter("idUsuario", idUsuario).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return cliente;
	}
	

	
	public void modificarCliente(ClienteEntity cliente) throws SQLException{
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(cliente);
		session.getTransaction().commit();
		session.close();
	}
	

	public void agregarReserva(int idUsuario, int idReserva) throws SQLException{
		ReservaEntity reserva = ReservaDAO.getInstancia().recuperarReserva(idReserva);
		ClienteEntity cliente = this.recuperarCliente(idUsuario);
		cliente.agregarReserva(reserva);
		this.modificarCliente(cliente);
	}
	
//	public ClienteEntity toEntity(Cliente cliente) {
//		ClienteEntity clienteEntity = new clienteEntity();
//		clienteEntity.setApellido(cliente.getApellido());
//		clienteEntity.setAvatar(cliente.getApellido());
//		clienteEntity.setCuentaCorriente(cliente.getCuentaCorriente());
//		clienteEntity.setDireccion(DireccionDAO.getInstancia().toEntity(cliente.getDireccion()));
//		clienteEntity.setDni(cliente.getDni());
//		clienteEntity.setEmail(cliente.getEmail());
//		clienteEntity.setFechaNacimiento(cliente.getFechaNacimiento());
//		clienteEntity.setIdUsuario(cliente.getIdUsuario());
//		clienteEntity.setNombre(cliente.getNombre());
//		clienteEntity.setPassword(cliente.getPassword());
//		List<ReservaEntity> reservasEntity = new ArrayList<ReservaEntity>();
////		for(Reserva reserva : cliente.getReservas())
////			reservasEntity.add(ReservaDAO.getInstancia().toEntity(reserva));
//	}

	public ClienteDTO toDTO(ClienteEntity cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setApellido(cliente.getApellido());
		clienteDTO.setAvatar(cliente.getAvatar());
		clienteDTO.setCuentaCorriente(cliente.getCuentaCorriente());
		clienteDTO.setDireccion(DireccionDAO.getInstancia().toDTO(cliente.getDireccion()));
		clienteDTO.setDni(cliente.getDni());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setFechaNacimiento(cliente.getFechaNacimiento());
		clienteDTO.setIdUsuario(cliente.getIdUsuario());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setPassword(cliente.getPassword());
		List<PerroDTO> perrosDTO = new ArrayList<PerroDTO>();
		for(PerroEntity perro : cliente.getPerros()) {
			
			perrosDTO.add(PerroDAO.getInstancia().toDTO(perro));
		}
		List<ReservaDTO> reservasDTO = new ArrayList<ReservaDTO>();
		for(ReservaEntity reserva : cliente.getReservas()) {
			reservasDTO.add(ReservaDAO.getInstancia().toDTO(reserva));
		}
		return clienteDTO;
	}
	
	public ClienteDTO toDTOSimple(ClienteEntity cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setApellido(cliente.getApellido());
		clienteDTO.setAvatar(cliente.getAvatar());
		clienteDTO.setCuentaCorriente(cliente.getCuentaCorriente());
		clienteDTO.setDireccion(DireccionDAO.getInstancia().toDTO(cliente.getDireccion()));
		clienteDTO.setDni(cliente.getDni());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setFechaNacimiento(cliente.getFechaNacimiento());
		clienteDTO.setIdUsuario(cliente.getIdUsuario());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setPassword(cliente.getPassword());
		return clienteDTO;
	}
	
	public PaseadorDTO toDTOSimple(PaseadorEntity paseador) {
		PaseadorDTO paseadorDTO = new PaseadorDTO();
		paseadorDTO.setApellido(paseador.getApellido());
		paseadorDTO.setAvatar(paseador.getAvatar());
		List<CalificacionDTO> calificacionesDTO = new ArrayList<CalificacionDTO>();
		//for(CalificacionEntity calificacion : paseador.getCalificaciones())
		//	calificacionesDTO.add(CalificacionDAO.getInstancia().toDTO(calificacion));
		paseadorDTO.setCalificaciones(calificacionesDTO);
		paseadorDTO.setDireccion(DireccionDAO.getInstancia().toDTO(paseador.getDireccion()));
		paseadorDTO.setDni(paseador.getDni());
		paseadorDTO.setEmail(paseador.getEmail());
		paseadorDTO.setFechaNacimiento(paseador.getFechaNacimiento());
		paseadorDTO.setIdUsuario(paseador.getIdUsuario());
		paseadorDTO.setNombre(paseador.getNombre());
		paseadorDTO.setNumeroRegistro(paseador.getNumeroRegistro());
		paseadorDTO.setPassword(paseador.getPassword());
		paseadorDTO.setPerfil(paseador.getPerfil());
		paseadorDTO.setReputacion(paseador.getReputacion());
		return paseadorDTO;
	}
	
	public PaseadorEntity toEntity(Paseador paseador) {
		PaseadorEntity paseadorEntity = new PaseadorEntity();
		paseadorEntity.setApellido(paseador.getApellido());
		paseadorEntity.setAvatar(paseador.getAvatar());
		paseadorEntity.setDireccion(DireccionDAO.getInstancia().toEntity(paseador.getDireccion()));
		paseadorEntity.setDni(paseador.getDni());
		paseadorEntity.setEmail(paseador.getEmail());
		paseadorEntity.setFechaNacimiento(paseador.getFechaNacimiento());
		paseadorEntity.setIdUsuario(paseador.getIdUsuario());
		paseadorEntity.setNombre(paseador.getNombre());
		paseadorEntity.setNumeroRegistro(paseador.getNumeroRegistro());
		paseadorEntity.setPassword(paseador.getPassword());
		paseadorEntity.setPerfil(paseador.getPerfil());
		paseadorEntity.setReputacion(paseador.getReputacion());
		return paseadorEntity;
	}
	
	public ClienteEntity toEntity(Cliente cliente) {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setApellido(cliente.getApellido());
		clienteEntity.setAvatar(cliente.getAvatar());
		clienteEntity.setCuentaCorriente(cliente.getCuentaCorriente());
		clienteEntity.setDireccion(DireccionDAO.getInstancia().toEntity(cliente.getDireccion()));
		clienteEntity.setDni(cliente.getDni());
		clienteEntity.setEmail(cliente.getEmail());
		clienteEntity.setFechaNacimiento(cliente.getFechaNacimiento());
		clienteEntity.setIdUsuario(cliente.getIdUsuario());
		clienteEntity.setNombre(cliente.getNombre());
		clienteEntity.setPassword(cliente.getPassword());
		return clienteEntity;
	}

}