package negocio;

import java.sql.SQLException;
import java.util.Date;

import dao.CalificacionDAO;
import excepciones.UsuarioException;

public class Calificacion {
	private int idCalificacion;
	private int puntaje;
	private String comentarios;
	private Date fecha;
	private Reserva reserva;
	private Paseador paseador;
	
	
	public Calificacion(int idCalificacion, int puntaje, String comentarios, Date fecha, Reserva reserva, Paseador paseador) {
		this.idCalificacion = idCalificacion;
		this.puntaje = puntaje;
		this.comentarios = comentarios;
		this.fecha = fecha;
		this.reserva = reserva;
		this.paseador = paseador;
	}
	
	public void save() throws UsuarioException {
		CalificacionDAO.getInstancia().save(this);
	}
	
	
	public Paseador getPaseador() {
		return paseador;
	}


	public void setPaseador(Paseador paseador) {
		this.paseador = paseador;
	}


	public int getIdCalificacion() {
		return idCalificacion;
	}
	public void setIdCalificacion(int idCalificacion) {
		this.idCalificacion = idCalificacion;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	
	
	
}
