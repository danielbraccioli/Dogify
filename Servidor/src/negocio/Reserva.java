package negocio;

import java.util.ArrayList;
import java.util.List;

public class Reserva {

	private int idReserva;
	private String estado;
	private String horaRetiro;
	private String horaDevolucion;
	private List<Mensaje> mensajes = new ArrayList<Mensaje>();
	
	
	public Reserva(int idReserva, String estado, String horaRetiro, String horaDevolucion, List<Mensaje> mensajes) {
		super();
		this.idReserva = idReserva;
		this.estado = estado;
		this.horaRetiro = horaRetiro;
		this.horaDevolucion = horaDevolucion;
		this.mensajes = mensajes;
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
	
	

	
}
