package negocio;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.ReservaDAO;
import excepciones.PaseoException;
import excepciones.ReservaException;

public class Reserva {

	private int idReserva;
	private String estado;
	private String horaRetiro;
	private String horaDevolucion;
	private List<Mensaje> mensajes = new ArrayList<Mensaje>();
	private Cliente cliente;
	private Perro perro;
	private Paseo paseo;
	
	public Reserva(int idReserva, String estado, String horaRetiro, String horaDevolucion,
			List<Mensaje> mensajes, Cliente cliente, Perro perro, Paseo paseo) {
		this.idReserva = idReserva;
		this.estado = estado;
		this.horaRetiro = horaRetiro;
		this.horaDevolucion = horaDevolucion;
		this.mensajes = mensajes;
		this.cliente = cliente;
		this.perro = perro;
		this.setPaseo(paseo);
	}
	
	public void retirarPerro() throws ReservaException, SQLException {
		if(estado.equals("PENDIENTE")) {
		this.estado = "RETIRADO";
		Date date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		this.horaRetiro = hourFormat.format(date);
		this.update();
		}else {
			throw new ReservaException("Estado de la reserva impide retirar perro");
		}
	}
	
	public void cancelarReserva() throws ReservaException, SQLException {
		if(estado.equals("PENDIENTE")) {
			this.estado = "CANCELADA";
			this.update();
		}else {
			throw new ReservaException("Estado de la reserva impide cancelarla");
		}
	}
	
	public void actualizarEstado(String estado) throws ReservaException  {
		this.estado = estado;
		this.update();
	}
	
	public void devolverPerro() throws ReservaException, SQLException {
		if(estado.equals("RETIRADO")) {
			this.estado = "DEVUELTO";
			Date date = new Date();
			DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
			this.horaDevolucion = hourFormat.format(date);
			this.update();
		}else {
			throw new ReservaException("Estado de la reserva impide devolver perro");
		}
	}
	
	public void cargarMensaje(Usuario usuario, String mensajeEnviado) throws PaseoException {
		Date date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		String hora = hourFormat.format(date);
		Mensaje mensaje = new Mensaje(0, date, hora, mensajeEnviado, usuario);
		mensajes.add(mensaje);
		mensaje.save();
	}
	
	public void save() throws ReservaException{
		ReservaDAO.getInstancia().save(this);
	}
	
	public void update() throws ReservaException{
		ReservaDAO.getInstancia().update(this);
	}
	
	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getHoraRetiro() {
		return horaRetiro;
	}

	public void setHoraRetiro(String horaRetiro) {
		this.horaRetiro = horaRetiro;
	}

	public String getHoraDevolucion() {
		return horaDevolucion;
	}

	public void setHoraDevolucion(String horaDevolucion) {
		this.horaDevolucion = horaDevolucion;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public int reservarPaseo() {
		return ReservaDAO.getInstancia().reservarPaseo(this);
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Perro getPerro() {
		return perro;
	}

	public void setPerro(Perro perro) {
		this.perro = perro;
	}

	public Paseo getPaseo() {
		return paseo;
	}

	public void setPaseo(Paseo paseo) {
		this.paseo = paseo;
	}

}
