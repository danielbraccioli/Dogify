package rmi;

import interfaz.InterfazRemota;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import controlador.*;
import dto.*;

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
			return ModuloUsuarios.getInstancia().altaCliente();
		}

		@Override
		public UsuarioDTO loginUsuario(String email, String password) throws RemoteException {
			// TODO Auto-generated method stub
			return ModuloUsuarios.getInstancia().login(email, password);
		}

		@Override
		public List<PaseoDTO> buscarPaseosByFechaBarrio(Date fecha, String barrio) throws RemoteException {
			// TODO Auto-generated method stub
			return ModuloPaseos.getInstancia().recuperarPaseos(fecha, barrio);
		}

		@Override
		public boolean reservarPaseo(UsuarioDTO usuario, PaseoDTO paseo) throws RemoteException {
			return ModuloPaseos.getInstancia().reservarPaseo(usuario,paseo);
			
		}

		@Override
		public List<ReservaDTO> reservasCliente(ClienteDTO cliente) throws RemoteException {
			// TODO Auto-generated method stub
			return ModuloPaseos.getInstancia().reservasCliente(cliente);
		}
		
		



}