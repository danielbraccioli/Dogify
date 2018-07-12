package negocio;

import java.util.Date;

import dao.PagoDAO;
import excepciones.ReservaException;

public class MercadoPago extends Pago {
	
	private String nroTarjeta;
	private Date vtoTarjeta;
	private String titularNombre;
	private String dni;
	
	public MercadoPago(int idPago, Date fecha, Reserva reserva, Cliente cliente, String nroTarjeta,
			Date vtoTarjeta, String titularNombre, String dni) {
		super(idPago, fecha, reserva, cliente);
		this.nroTarjeta = nroTarjeta;
		this.vtoTarjeta = vtoTarjeta;
		this.titularNombre = titularNombre;
		this.dni = dni;
	}
	
	public void save() throws ReservaException{
		PagoDAO.getInstancia().save(this);
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
