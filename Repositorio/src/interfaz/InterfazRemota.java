package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dto.*;


public interface InterfazRemota extends Remote{
	public static final String url = "localhost/ObjetoRemoto";
	
	
	public boolean altaCliente() throws RemoteException;


}