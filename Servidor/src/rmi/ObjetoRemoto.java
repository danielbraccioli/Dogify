package rmi;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;
import controlador.ModuloPagos;
import controlador.ModuloPaseos;
import controlador.ModuloUsuarios;
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

public class ObjetoRemoto  extends UnicastRemoteObject implements InterfazRemota {

		private static ObjetoRemoto instancia;
		private static final long serialVersionUID = 1L;

		private ObjetoRemoto() throws RemoteException {
			super();
		}

		public static ObjetoRemoto getInstance() {
			if (instancia == null)
			{
				try {
					instancia = new ObjetoRemoto();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		return instancia;
		}
		public UsuarioDTO loginUsuario(String email, String password) throws RemoteException, UsuarioException {
			return ModuloUsuarios.getInstancia().login(email, password);
		}
		public List<PaseoDTO> buscarPaseosByFechaBarrio(Date fecha, String barrio) throws RemoteException, PaseoException {
			return ModuloPaseos.getInstancia().buscarPaseosByFechaBarrio(fecha, barrio);
		}
		public void reservarPaseo(PaseoDTO paseo, ClienteDTO cliente, PerroDTO perro) throws RemoteException, PaseoException, ReservaException {
			ModuloPaseos.getInstancia().reservarPaseo(paseo, cliente, perro);
		}
		public List<ReservaDTO> reservasCliente(ClienteDTO cliente) throws RemoteException {
			return ModuloPaseos.getInstancia().reservasCliente(cliente); 
		}
		public ReservaDTO reservaCliente(int idReserva) throws RemoteException, ReservaException{
			return ModuloPaseos.getInstancia().buscarReservaById(idReserva);
		}
		public List<PaseoDTO> paseosPaseador(PaseadorDTO paseador) throws RemoteException, PaseoException {
			return ModuloPaseos.getInstancia().buscarPaseosPaseador(paseador);
		}
		public List<PaseoDTO> buscarPaseosByMesAnio(int mes, int anio) throws RemoteException, PaseoException {
			return ModuloPaseos.getInstancia().buscarPaseosByMesAnio(mes, anio);
		}
		public List<PaseoDTO> buscarPaseosByFecha(Date fecha) throws RemoteException, PaseoException {
			return ModuloPaseos.getInstancia().buscarPaseosByFecha(fecha);
		}
		public void iniciarPaseo(PaseoDTO paseo) throws RemoteException, PaseoException {
			ModuloPaseos.getInstancia().iniciarPaseo(paseo);
		}
		public void finalizarPaseo(PaseoDTO paseo) throws RemoteException, PaseoException, ReservaException {
			ModuloPaseos.getInstancia().finalizarPaseo(paseo);
		}
		public void compartirUbicacion(PaseoDTO paseo) throws RemoteException, PaseoException {
			ModuloPaseos.getInstancia().compartirUbicacion(paseo);
		}
		public void subirFoto(PaseoDTO paseo, String imagen) throws IOException, PaseoException {
			ModuloPaseos.getInstancia().subirFotoPaseo(paseo, imagen); 
		}
		public void retirarPerro(ReservaDTO reserva) throws RemoteException, ReservaException {
			ModuloPaseos.getInstancia().retirarPerro(reserva);
		}
		public void devolverPerro(ReservaDTO reserva) throws RemoteException, ReservaException {
			ModuloPaseos.getInstancia().devolverPerro(reserva);
		}
		public PaseadorDTO perfilPaseador(int idPaseador) throws RemoteException, UsuarioException {
			return ModuloUsuarios.getInstancia().perfilPaseador(idPaseador);
		}
		public void calificarPaseador(ReservaDTO reserva, int puntaje, String observaciones)
				throws RemoteException, UsuarioException, ReservaException {
			ModuloPaseos.getInstancia().calificarPaseador(reserva, puntaje, observaciones);
		}
		public void pagarReservaEfectivo(ReservaDTO reserva) throws RemoteException, ReservaException {
			ModuloPagos.getInstancia().pagarReservaEfe(reserva);
		}
		public void pagarReservaMercadoPago(ReservaDTO reserva, String nroTarjeta, Date vtoTarjeta,
				String titularNombre, String titularDNI) throws RemoteException, ReservaException {
			ModuloPagos.getInstancia().pagarReservaMP(reserva, nroTarjeta, vtoTarjeta, titularNombre, titularDNI);
		}
		public PaseoDTO paseoPaseador(int idPaseo) throws RemoteException,PaseoException {
			return ModuloPaseos.getInstancia().paseoPaseador(idPaseo);
		}

		@Override
		public PerroDTO buscarPerroById(int idPerro) throws RemoteException, UsuarioException {
			return ModuloUsuarios.getInstancia().buscarPerroById(idPerro);
		}
}