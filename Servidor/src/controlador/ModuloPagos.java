package controlador;

import java.sql.SQLException;
import java.util.Date;

import dao.ReservaDAO;
import dto.ReservaDTO;
import excepciones.ReservaException;
import negocio.Efectivo;
import negocio.MercadoPago;
import negocio.Reserva;

public class ModuloPagos {
	private static ModuloPagos instancia;

	public static ModuloPagos getInstancia() {
		if (instancia == null)
			instancia = new ModuloPagos();
		return instancia;
	}
	
	public void pagarReservaMP(ReservaDTO reserva, String nroTarjeta, Date vtoTarjeta, String titularNombre, String titularDNI) throws ReservaException {
		Reserva aux = ReservaDAO.getInstancia().buscarReservaById(reserva.getIdReserva());
		Date fecha = new Date();
		MercadoPago mp = new MercadoPago(0, fecha, aux, aux.getCliente(), nroTarjeta, vtoTarjeta, titularNombre, titularDNI);
			mp.save(); 
			aux.actualizarEstado("PAGADO");

	}
	
	public void pagarReservaEfe(ReservaDTO reserva) throws ReservaException {
		Reserva aux = ReservaDAO.getInstancia().buscarReservaById(reserva.getIdReserva());
		Date fecha = new Date();
		Efectivo efe = new Efectivo(0, fecha, aux, aux.getCliente());
		efe.save();
		aux.actualizarEstado("PAGADO");
	}
	
}