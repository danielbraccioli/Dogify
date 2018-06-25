package test;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.*;

import dto.*;
import rmi.ObjetoRemoto;

public class test {

	public static void main(String[] args) {
	//	login();
	// 	listarpaseos();
	//	listarReservasCliente();	
		
	}
	
	private static void listarReservasCliente() {
		ClienteDTO usuario = new ClienteDTO();
		usuario.setIdUsuario(1);
		List<ReservaDTO> r = new ArrayList<ReservaDTO>();
		
		
		try {
			r=ObjetoRemoto.getInstance().reservasCliente(usuario);
			
			for (ReservaDTO r2 : r){
				System.out.println(r2.getIdReserva());
				
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
	}

	public static void login(){
		
		UsuarioDTO usuario = new UsuarioDTO();

		
		try {
			usuario= ObjetoRemoto.getInstance().loginUsuario("cliete1@gmail.com","cliente1");
			if (usuario==null){
				System.out.println("No encontro el usuario");
			}
			else
				System.out.println("Encontro el usuario");
				
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void listarpaseos(){
		List<PaseoDTO> paseos = new ArrayList<PaseoDTO>();
		
		Date fecha = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018,05,25,00,00,00);
		fecha = calendar.getTime();
		
		PaseoDTO paseo = new PaseoDTO();
		
		try{
			paseos = ObjetoRemoto.getInstance().buscarPaseosByFechaBarrio(fecha,"Monserrat");
	
			for (PaseoDTO pas : paseos){
				System.out.println(pas.getIdPaseo());
				
				UsuarioDTO usuario = new UsuarioDTO();
				usuario.setIdUsuario(1);
				if (ObjetoRemoto.getInstance().reservarPaseo(usuario, pas)== true){
					System.out.println("Reserva OK");
				}

			
				
				
			}
			
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
