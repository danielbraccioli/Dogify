package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import dto.*;


public interface InterfazRemota extends Remote{
	public static final String url = "localhost/ObjetoRemoto";
	
	
	public boolean altaCliente() throws RemoteException;
	public UsuarioDTO loginUsuario(String email,String password) throws RemoteException;
	public List<PaseoDTO> buscarPaseosByFechaBarrio(Date fecha,String barrio) throws RemoteException;
	public boolean reservarPaseo(UsuarioDTO usuario,PaseoDTO paseo) throws RemoteException;
	public List<ReservaDTO> reservasCliente(ClienteDTO cliente) throws RemoteException;
	



}