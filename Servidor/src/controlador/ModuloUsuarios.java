package controlador;

import java.rmi.Naming;
import java.util.Vector;

import dao.*;
import dto.UsuarioDTO;
import entity.*;
import negocio.Usuario;


public class ModuloUsuarios {
	

	private static ModuloUsuarios instancia;
	
	ModuloUsuarios() {
	
	}
	
	public static ModuloUsuarios getInstancia() {
        if (instancia == null)
                instancia = new ModuloUsuarios();
        return instancia;
	}
	
	public boolean altaCliente(){

		return true;
			
	}
	
	public boolean altaPaseador(){
		return true;	
	}
	
	public UsuarioDTO login(String email, String password){

		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setPassword(password);
		
		return usuario.BuscarUsuarioByEmail(usuario); 		
	}



}