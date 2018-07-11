package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import controlador.ModuloPaseos;
import controlador.ModuloUsuarios;
import dto.ClienteDTO;
import dto.PaseoDTO;
import dto.ReservaDTO;
import dto.UsuarioDTO;
import excepciones.PaseoException;
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

		
		public boolean altaCliente() throws RemoteException {
		//	return ModuloUsuarios.getInstancia().altaCliente();
			return true;
		}

		@Override
		public UsuarioDTO loginUsuario(String email, String password) throws RemoteException, UsuarioException {
			// TODO Auto-generated method stub
			return ModuloUsuarios.getInstancia().login(email, password);
		}

		@Override
		public List<PaseoDTO> buscarPaseosByFechaBarrio(Date fecha, String barrio) throws RemoteException, PaseoException {
			// TODO Auto-generated method stub
			return ModuloPaseos.getInstancia().buscarPaseosByFechaBarrio(fecha, barrio);
		}

		@Override
		public boolean reservarPaseo(UsuarioDTO usuario, PaseoDTO paseo) throws RemoteException {
		//	return ModuloPaseos.getInstancia().reservarPaseo(usuario,paseo);
			return true;
			
		}

		@Override
		public List<ReservaDTO> reservasCliente(ClienteDTO cliente) throws RemoteException {
			// TODO Auto-generated method stub
			return ModuloPaseos.getInstancia().reservasCliente(cliente);
		}
		
		public ReservaDTO reservaCliente(int idReserva) throws RemoteException{
			return ModuloPaseos.getInstancia().buscarReservaById(idReserva);
		}
		



}