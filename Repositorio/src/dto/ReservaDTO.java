package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReservaDTO implements Serializable {

	private int idReserva;
	private String estado;
	private String horaRetiro;
	private String horaDevolucion;
	private List<MensajeDTO> mensajes = new ArrayList<MensajeDTO>();
	private ClienteDTO cliente;
	private PaseoDTO paseo;
	private PerroDTO perro;
	
	public ReservaDTO() {}
	

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public PaseoDTO getPaseo() {
		return paseo;
	}

	public void setPaseo(PaseoDTO paseo) {
		this.paseo = paseo;
	}

	public PerroDTO getPerro() {
		return perro;
	}

	public void setPerro(PerroDTO perro) {
		this.perro = perro;
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

	public List<MensajeDTO> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<MensajeDTO> mensajes) {
		this.mensajes = mensajes;
	}
	
	

	
}
