package interfaz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
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


public interface InterfazRemota extends Remote{
	public static final String url = "//localhost/ObjetoRemoto";
	
	// Ambos
	public UsuarioDTO loginUsuario(String email,String password) throws RemoteException, UsuarioException;
	
	// Paseador
	public List<PaseoDTO> paseosPaseador(PaseadorDTO paseador) throws RemoteException, PaseoException;
	public void iniciarPaseo(PaseoDTO paseo) throws RemoteException, PaseoException;
	public void finalizarPaseo(PaseoDTO paseo) throws RemoteException, PaseoException, ReservaException;
	public void compartirUbicacion(PaseoDTO paseo) throws RemoteException, PaseoException;
	public void subirFoto(PaseoDTO paseo, String imagen) throws RemoteException, IOException, PaseoException;
	public void retirarPerro(ReservaDTO reserva) throws RemoteException, ReservaException;
	public void devolverPerro(ReservaDTO reserva) throws RemoteException, ReservaException;
	public PaseadorDTO perfilPaseador(int idPaseador) throws RemoteException, UsuarioException;
	public PaseoDTO paseoPaseador(int idPaseo) throws PaseoException, RemoteException;
	
	// Cliente
	public List<PaseoDTO> buscarPaseosByFechaBarrio(Date fecha,String barrio) throws RemoteException, PaseoException;
	public void reservarPaseo(PaseoDTO paseo, ClienteDTO cliente, PerroDTO perro) throws RemoteException, PaseoException, ReservaException;
	public void calificarPaseador(ReservaDTO reserva, int puntaje, String observaciones) throws RemoteException, UsuarioException, ReservaException;
	public void pagarReservaEfectivo(ReservaDTO reserva) throws RemoteException, ReservaException;
	public void pagarReservaMercadoPago(ReservaDTO reserva, String nroTarjeta, Date vtoTarjeta, String titularNombre, String titularDNI) throws RemoteException, ReservaException;
	public ReservaDTO reservaCliente(int idReserva) throws RemoteException, ReservaException;
	public List<ReservaDTO> reservasCliente(ClienteDTO cliente) throws RemoteException, ReservaException;
	public List<PaseoDTO> buscarPaseosByMesAnio(int mes, int anio) throws RemoteException, PaseoException;
	public List<PaseoDTO> buscarPaseosByFecha(Date fecha) throws RemoteException, PaseoException;
}