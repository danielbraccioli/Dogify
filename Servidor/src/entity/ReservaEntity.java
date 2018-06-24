package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "Reserva")
public class ReservaEntity implements Serializable {

	@Id
	@GeneratedValue	
	private int idReserva;
	private String estado;
	private String horaRetiro;
	private String horaDevolucion;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "idReserva")
	private List<MensajeEntity> mensajes = new ArrayList<MensajeEntity>();
	
	
	
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

	public List<MensajeEntity> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<MensajeEntity> mensajes) {
		this.mensajes = mensajes;
	}
	
	

	
}
