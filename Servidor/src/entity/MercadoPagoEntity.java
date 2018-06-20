package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import net.sourceforge.jtds.jdbc.DateTime;

@Entity
@DiscriminatorValue("MPago")
public class MercadoPagoEntity extends PagoEntity implements Serializable {
	
	private String nroTarjeta;
	private Date vtoTarjeta;
	private String titularNombre;
	private String dni;
	
	public MercadoPagoEntity(int idPago, Date fechaHora, ReservaEntity reserva, ClienteEntity cliente, String nroTarjeta,
			Date vtoTarjeta, String titularNombre, String dni) {
		super(idPago, fechaHora, reserva, cliente);
		this.nroTarjeta = nroTarjeta;
		this.vtoTarjeta = vtoTarjeta;
		this.titularNombre = titularNombre;
		this.dni = dni;
	}

	public String getNroTarjeta() {
		return nroTarjeta;
	}

	public void setNroTarjeta(String nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}

	public Date getVtoTarjeta() {
		return vtoTarjeta;
	}

	public void setVtoTarjeta(Date vtoTarjeta) {
		this.vtoTarjeta = vtoTarjeta;
	}

	public String getTitularNombre() {
		return titularNombre;
	}

	public void setTitularNombre(String titularNombre) {
		this.titularNombre = titularNombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	

}
