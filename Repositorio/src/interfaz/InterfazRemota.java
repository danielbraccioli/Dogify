package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import dto.ClienteDTO;
import dto.PaseoDTO;
import dto.ReservaDTO;
import dto.UsuarioDTO;
import excepciones.PaseoException;
import excepciones.UsuarioException;


public interface InterfazRemota extends Remote{
	public static final String url = "//localhost/ObjetoRemoto";
	
	
	public boolean altaCliente() throws RemoteException;
	public UsuarioDTO loginUsuario(String email,String password) throws RemoteException, UsuarioException;
	public List<PaseoDTO> buscarPaseosByFechaBarrio(Date fecha,String barrio) throws RemoteException, PaseoException;
	public boolean reservarPaseo(UsuarioDTO usuario,PaseoDTO paseo) throws RemoteException;
	public List<ReservaDTO> reservasCliente(ClienteDTO cliente) throws RemoteException;
	public ReservaDTO reservaCliente(int idReserva) throws RemoteException;



}