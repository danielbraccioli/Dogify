package dto;

import java.io.Serializable;
import java.util.Date;

public class CalificacionDTO implements Serializable {
	private int idCalificacion;
	private int puntaje;
	private String comentarios;
	private Date fecha;
	private ReservaDTO reserva;
	
	
	
	public CalificacionDTO() {}
	
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
	public ReservaDTO getReserva() {
		return reserva;
	}
	public void setReserva(ReservaDTO reserva) {
		this.reserva = reserva;
	}
	
	
	
	
}
