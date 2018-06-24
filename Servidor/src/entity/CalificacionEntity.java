package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Calificacion")
public class CalificacionEntity implements Serializable {
	
	@Id
	@GeneratedValue	
	private int idCalificacion;
	private int puntaje;
	private String comentarios;
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "idReserva")
	private ReservaEntity reserva;
		
	
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
	public ReservaEntity getReserva() {
		return reserva;
	}
	public void setReserva(ReservaEntity reserva) {
		this.reserva = reserva;
	}
	
	
	
	
}
