package dto;

import java.io.Serializable;

import net.sourceforge.jtds.jdbc.DateTime;

public class MensajeDTO  implements Serializable{
	private int idMensaje;
	private DateTime fechaHora;
	private String mensaje;
	private UsuarioDTO cliente;
	private UsuarioDTO paseador;
	
	public MensajeDTO(int idMensaje, DateTime fechaHora, String mensaje, UsuarioDTO cliente, UsuarioDTO paseador) {
		super();
		this.idMensaje = idMensaje;
		this.fechaHora = fechaHora;
		this.mensaje = mensaje;
		this.cliente = cliente;
		this.paseador = paseador;
	}

	public int getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}

	public DateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(DateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public UsuarioDTO getCliente() {
		return cliente;
	}

	public void setCliente(UsuarioDTO cliente) {
		this.cliente = cliente;
	}

	public UsuarioDTO getPaseador() {
		return paseador;
	}

	public void setPaseador(UsuarioDTO paseador) {
		this.paseador = paseador;
	}
	
	
	
	

}
