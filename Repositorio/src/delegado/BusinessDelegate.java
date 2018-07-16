package delegado;

import java.io.File;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import dto.ClienteDTO;
import dto.PaseadorDTO;
import dto.PaseoDTO;
import dto.PerroDTO;
import dto.ReservaDTO;
import dto.UsuarioDTO;
import excepciones.PaseoException;
import excepciones.ReservaException;
import excepciones.UsuarioException;
import interfaz.InterfazRemota;


public class BusinessDelegate {
	
	private static BusinessDelegate instancia;
	private InterfazRemota ir;
	
	public static BusinessDelegate getInstancia() {
		if (instancia == null)
			instancia = new BusinessDelegate();
		return instancia;
	}

	private BusinessDelegate() {
		
		try {
			ir = (InterfazRemota) Naming.lookup ("//localhost/ObjetoRemoto");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Paseador
	public List<PaseoDTO> paseosPaseador(PaseadorDTO paseador) throws RemoteException, PaseoException{
		return ir.paseosPaseador(paseador);
	}
	public void iniciarPaseo(PaseoDTO paseo) throws RemoteException, PaseoException{
		ir.iniciarPaseo(paseo);
	}
	public void finalizarPaseo(PaseoDTO paseo) throws RemoteException, PaseoException, ReservaException{
		ir.finalizarPaseo(paseo);
	}
	public void compartirUbicacion(PaseoDTO paseo) throws RemoteException, PaseoException{
		ir.compartirUbicacion(paseo);
	}
	public void subirFoto(PaseoDTO paseo, String imagen) throws RemoteException, IOException, PaseoException{
		ir.subirFoto(paseo, imagen);
	}
	public void retirarPerro(ReservaDTO reserva) throws RemoteException, ReservaException{
		ir.retirarPerro(reserva);
	}
	public void devolverPerro(ReservaDTO reserva) throws RemoteException, ReservaException{
		ir.devolverPerro(reserva);
	}
	public PaseadorDTO perfilPaseador(int idPaseador) throws RemoteException, UsuarioException{
		return ir.perfilPaseador(idPaseador);
	}
	public PaseoDTO paseoPaseador(int idPaseo) throws PaseoException, RemoteException {
		return ir.paseoPaseador(idPaseo);
	}
	
	// Cliente
	public List<PaseoDTO> buscarPaseosByFechaBarrio(Date fecha,String barrio) throws RemoteException, PaseoException{
		return ir.buscarPaseosByFechaBarrio(fecha, barrio);
	}
	public void reservarPaseo(PaseoDTO paseo, ClienteDTO cliente, PerroDTO perro) throws RemoteException, PaseoException, ReservaException{
		ir.reservarPaseo(paseo, cliente, perro);
	}
	public void calificarPaseador(ReservaDTO reserva, int puntaje, String observaciones) throws RemoteException, UsuarioException, ReservaException{
		ir.calificarPaseador(reserva, puntaje, observaciones);
	}
	public void pagarReservaEfectivo(ReservaDTO reserva) throws RemoteException, ReservaException{
		ir.pagarReservaEfectivo(reserva);
	}
	public void pagarReservaMercadoPago(ReservaDTO reserva, String nroTarjeta, Date vtoTarjeta, String titularNombre, String titularDNI) throws RemoteException, ReservaException{
		ir.pagarReservaMercadoPago(reserva, nroTarjeta, vtoTarjeta, titularNombre, titularDNI);
	}
	public ReservaDTO reservaCliente(int idReserva) throws RemoteException, ReservaException{
		return ir.reservaCliente(idReserva);
	}
	public List<ReservaDTO> reservasCliente(ClienteDTO cliente) throws RemoteException, ReservaException{
		return ir.reservasCliente(cliente);
	}
	public List<PaseoDTO> buscarPaseosByMesAnio(int mes, int anio) throws RemoteException, PaseoException{
		return ir.buscarPaseosByMesAnio(mes, anio);
	}
	public List<PaseoDTO> buscarPaseosByFecha(Date fecha) throws RemoteException, PaseoException{
		return ir.buscarPaseosByFecha(fecha);
	}
	
	public PerroDTO buscarPerroById(int idPerro) throws RemoteException, UsuarioException{
		return ir.buscarPerroById(idPerro);
	}
	
	// Ambos
	public UsuarioDTO loginUsuario(String email,String password) throws RemoteException, UsuarioException{
		return ir.loginUsuario(email, password);
	}

	
}