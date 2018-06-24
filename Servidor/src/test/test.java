package test;

import java.rmi.RemoteException;

import dto.UsuarioDTO;
import rmi.ObjetoRemoto;

public class test {

	public static void main(String[] args) {
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

}
