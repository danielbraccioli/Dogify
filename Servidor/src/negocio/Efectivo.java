package negocio;

import java.util.Date;

import dao.PagoDAO;
import excepciones.ReservaException;

public class Efectivo extends Pago {

	public Efectivo(int idPago, Date fecha, Reserva reserva, Cliente cliente) {
		super(idPago, fecha, reserva, cliente);
		// TODO Auto-generated constructor stub
	}
	
	public void save() throws ReservaException {
		PagoDAO.getInstancia().save(this);
	}
	
	

}
