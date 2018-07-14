package controlador;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import dao.PaseoDAO;
import dao.ReservaDAO;
import dto.ClienteDTO;
import dto.PaseadorDTO;
import dto.PaseoDTO;
import dto.PerroDTO;
import dto.ReservaDTO;
import excepciones.PaseoException;
import excepciones.ReservaException;
import excepciones.UsuarioException;
import maps.java.Geocoding;
import maps.java.MapsJava;
import negocio.Cliente;
import negocio.Paseo;
import negocio.Perro;
import negocio.Reserva;

public class ModuloPaseos {
	
	private static ModuloPaseos instancia;
 
	public static ModuloPaseos getInstancia() {
		if (instancia == null)
			instancia = new ModuloPaseos();
		return instancia;
	}
	
	public List<PaseoDTO> buscarPaseosPaseador(PaseadorDTO paseador) throws PaseoException {
		return PaseoDAO.getInstancia().buscarPaseosByPaseadorId(paseador.getIdUsuario());
	}

	public List<PaseoDTO> buscarPaseosByFechaBarrio(Date fecha, String barrio) throws PaseoException {
		List<PaseoDTO> paseos = null;
		paseos = PaseoDAO.getInstancia().buscarPaseosByFechaBarrio(fecha, barrio);
		return paseos;
	}
	
	public List<PaseoDTO> buscarPaseosByMesAnio(int mes, int anio) throws PaseoException {
		return PaseoDAO.getInstancia().buscarPaseosByMesAnio(mes, anio);
	}
	
	public List<PaseoDTO> buscarPaseosByFecha(Date fecha) throws PaseoException {
		return PaseoDAO.getInstancia().buscarPaseosByFecha(fecha);
	}

	
	public PaseoDTO paseoPaseador(int idPaseo) throws PaseoException {
		PaseoDTO paseo = null;
		paseo = PaseoDAO.getInstancia().buscarPaseoByIdDTO(idPaseo);
		return paseo;
	}
	
	public List<ReservaDTO> reservasCliente(ClienteDTO cliente) {
		return ReservaDAO.getInstancia().recuperarReservas(cliente.getIdUsuario());
	}
	
	public Paseo buscarPaseoById(int idPaseo) throws PaseoException {
		Paseo paseo = null;
		paseo = PaseoDAO.getInstancia().buscarPaseoById(idPaseo);
		return paseo;
	}
	
	public void compartirUbicacion(PaseoDTO paseo) throws PaseoException {
		try {
		Geocoding ObjGeocod=new Geocoding();
		MapsJava.setKey("AIzaSyDkBgIxRpAnjSJS4WeovRC4kiriTxrpD6A");
        Point2D.Double resultadoCD=ObjGeocod.getCoordinates("Buenos Aires, UADE");
        Paseo paseoAux = PaseoDAO.getInstancia().buscarPaseoById(paseo.getIdPaseo());
		paseoAux.actualizarUbicacion(String.valueOf(resultadoCD.x), String.valueOf(resultadoCD.y));
		}catch(Exception e) {
			new PaseoException("Error en compartir ubicación, reintente");
		}
	}
	
	public void subirFotoPaseo(PaseoDTO paseo, String img) throws IOException, PaseoException {
		Paseo aux = PaseoDAO.getInstancia().buscarPaseoById(paseo.getIdPaseo());
		aux.subirFoto(img);
	}
	
	public void reservarPaseo(PaseoDTO paseo, ClienteDTO cliente, PerroDTO perro) throws PaseoException, ReservaException {
		Paseo auxPaseo = ModuloPaseos.getInstancia().buscarPaseoById(paseo.getIdPaseo());
		Cliente auxCliente = ModuloUsuarios.getInstancia().buscarClienteById(cliente.getIdUsuario());
		Perro auxPerro = null;
		for(Perro perro1 : auxCliente.getPerros()) {
			if (perro.getIdPerro() == perro.getIdPerro()) {
				auxPerro = perro1;
			}
		}
		auxPaseo.altaReserva(auxCliente, auxPerro);
	}
	
	public void cancelarReserva(ReservaDTO reserva) throws ReservaException{
		try {
			Reserva reservaAux = ReservaDAO.getInstancia().buscarReservaById(reserva.getIdReserva());
			reservaAux.cancelarReserva();
		} catch (SQLException e) {
			new ReservaException("Error en cancelar reserva en BD, reintente");
		}
	}
	
	public void retirarPerro(ReservaDTO reserva) throws ReservaException{
		try {
			Reserva reservaAux = ReservaDAO.getInstancia().buscarReservaById(reserva.getIdReserva());
			reservaAux.retirarPerro();
		} catch (SQLException e) {
			new ReservaException("Error en cancelar reserva en BD, reintente");
		}
	}
	
	public void devolverPerro(ReservaDTO reserva) throws ReservaException{
		try {
			Reserva reservaAux = ReservaDAO.getInstancia().buscarReservaById(reserva.getIdReserva());
			reservaAux.devolverPerro();
		} catch (SQLException e) {
			new ReservaException("Error en cancelar reserva en BD, reintente");
		}
	}
	
	public void cancelarPaseo(PaseoDTO paseo) throws PaseoException, ReservaException {
			Paseo paseoAux = PaseoDAO.getInstancia().buscarPaseoById(paseo.getIdPaseo());
			paseoAux.cancelarPaseo();
	}
	
	public ReservaDTO buscarReservaById(int idReserva) throws ReservaException {
		ReservaDTO reserva = ReservaDAO.getInstancia().buscarReservaByIdDTO(idReserva);
		return reserva;
	}
	public void iniciarPaseo(PaseoDTO paseo) throws PaseoException {
		Paseo paseoAux = PaseoDAO.getInstancia().buscarPaseoById(paseo.getIdPaseo());
		paseoAux.iniciarPaseo();
	}
	
	public void finalizarPaseo(PaseoDTO paseo) throws PaseoException, ReservaException {
		Paseo paseoAux = PaseoDAO.getInstancia().buscarPaseoById(paseo.getIdPaseo());
		paseoAux.finalizarPaseo();
	}
	
	public void calificarPaseador(ReservaDTO reserva, int puntaje, String observaciones) throws UsuarioException, ReservaException {
		Reserva reservaAux = ReservaDAO.getInstancia().buscarReservaById(reserva.getIdReserva());
		reservaAux.getPaseo().getPaseador().calificar(reservaAux, puntaje, observaciones);
	}
}