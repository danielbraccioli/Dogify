package negocio;

import java.sql.SQLException;
import java.util.Date;

import dao.PagoDAO;

public class Efectivo extends Pago {

	public Efectivo(int idPago, Date fecha, Reserva reserva, Cliente cliente) {
		super(idPago, fecha, reserva, cliente);
		// TODO Auto-generated constructor stub
	}
	
	public void save() throws SQLException {
		PagoDAO.getInstancia().save(this);
	}
	
	

}
