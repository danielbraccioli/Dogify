package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import negocio.Cliente;
import negocio.Paseo;
import negocio.Perro;


@Entity
@Table(name = "Reserva")
public class ReservaEntity implements Serializable {

	private static final long serialVersionUID = -3763963615523243215L;
	
	@Id
	@GeneratedValue	
	private int idReserva;
	private String estado;
	private String horaRetiro;
	private String horaDevolucion;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "idReserva")
	private List<MensajeEntity> mensajes = new ArrayList<MensajeEntity>();
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "idCliente")
	private ClienteEntity cliente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "idPerro")
	private PerroEntity perro;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "idPaseo")
	private PaseoEntity paseo;
	

	
	public ClienteEntity getCliente() {
		return cliente;
	}
	
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	
	public PerroEntity getPerro() {
		return perro;
	}
	
	public void setPerro(PerroEntity perro) {
		this.perro = perro;
	}
	
	public void setPaseo(PaseoEntity paseo) {
		this.paseo = paseo;
	}
	
	public PaseoEntity getPaseo() {
		return paseo;
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

	public List<MensajeEntity> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<MensajeEntity> mensajes) {
		this.mensajes = mensajes;
	}
	
	

	
}
