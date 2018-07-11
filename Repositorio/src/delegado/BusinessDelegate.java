package delegado;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import dto.ClienteDTO;
import dto.ReservaDTO;
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
	
	public List<ReservaDTO> reservasCliente(ClienteDTO cliente) throws RemoteException{
		return ir.reservasCliente(cliente);
	}
	
	public ReservaDTO reservaCliente(int idReserva) throws RemoteException{
		return ir.reservaCliente(idReserva);
	}
	
}