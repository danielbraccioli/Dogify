package entity;

import javax.persistence.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "Mensaje")
public class MensajeEntity implements Serializable {
	
	@Id
	@GeneratedValue	
	private int idMensaje;
	private Date fechaHora;
	private String mensaje;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity cliente;


	public MensajeEntity(int idMensaje, Date fechaHora, String mensaje, UsuarioEntity cliente, UsuarioEntity paseador) {
		super();
		this.idMensaje = idMensaje;
		this.fechaHora = fechaHora;
		this.mensaje = mensaje;
  		this.cliente = cliente;
	}

	public int getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public UsuarioEntity getCliente() {
		return cliente;
	}

	public void setCliente(UsuarioEntity cliente) {
		this.cliente = cliente;
	}

	
	

}
