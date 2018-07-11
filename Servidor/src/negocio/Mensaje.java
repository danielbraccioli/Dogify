package negocio;

import java.sql.SQLException;
import java.util.Date;

import dao.MensajeDAO;
import excepciones.PaseoException;

public class Mensaje {
	private int idMensaje;
	private Date fecha;
	private String hora;
	private String mensaje;
	private Usuario usuario;
	
	public Mensaje(int idMensaje, Date fecha, String hora, String mensaje, Usuario usuario) {
		this.idMensaje = idMensaje;
		this.fecha = fecha;
		this.hora = hora;
		this.mensaje = mensaje;
		this.usuario = usuario;
	}
	
	public void save() throws PaseoException{
		MensajeDAO.getInstancia().save(this);
	}
	
	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public String getHora() {
		return hora;
	}



	public void setHora(String hora) {
		this.hora = hora;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public int getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
