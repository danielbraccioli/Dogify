package negocio;

import net.sourceforge.jtds.jdbc.DateTime;

public class Mensaje {
	private int idMensaje;
	private DateTime fechaHora;
	private String mensaje;
	private Usuario cliente;
	private Usuario paseador;
	
	public Mensaje(int idMensaje, DateTime fechaHora, String mensaje, Usuario cliente, Usuario paseador) {
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

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Usuario getPaseador() {
		return paseador;
	}

	public void setPaseador(Usuario paseador) {
		this.paseador = paseador;
	}
	
	
	
	

}
