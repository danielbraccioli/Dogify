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
	
	public void pagarReservaMP(ReservaDTO reserva, String nroTarjeta, Date vtoTarjeta, String titularNombre, String titularDNI) {
		Reserva aux = ReservaDAO.getInstancia().buscarReservaById(reserva.getIdReserva());
		Date fecha = new Date();
		MercadoPago mp = new MercadoPago(0, fecha, aux, aux.getCliente(), nroTarjeta, vtoTarjeta, titularNombre, titularDNI);
		try {
			mp.save(); 
			aux.actualizarEstado("Pagada");
		} catch (SQLException e) {
			new ReservaException("Error en actualización de pago en BD, reintente");
		}
	}
	
	public void pagarReservaEfe(ReservaDTO reserva) {
		Reserva aux = ReservaDAO.getInstancia().buscarReservaById(reserva.getIdReserva());
		Date fecha = new Date();
		Efectivo efe = new Efectivo(0, fecha, aux, aux.getCliente());
		try {
			efe.save();
			aux.actualizarEstado("Pagada");
		} catch (SQLException e) {
			new ReservaException("Error en actualización de pago en BD, reintente");
		}
	}
	
}