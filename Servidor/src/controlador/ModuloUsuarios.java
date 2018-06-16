package controlador;

import java.rmi.Naming;
import java.util.Vector;

import dao.*;
import entity.*;


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



}