package controlador;

import java.sql.SQLException;

import dao.UsuarioDAO;
import dto.PaseadorDTO;
import dto.UsuarioDTO;
import excepciones.UsuarioException;
import negocio.Cliente;


public class ModuloUsuarios {
	private static ModuloUsuarios instancia;

	public static ModuloUsuarios getInstancia() {
		if (instancia == null)
			instancia = new ModuloUsuarios();
		return instancia;
	}
	
	public UsuarioDTO login(String email, String password) throws UsuarioException{
		UsuarioDTO usuario = null;
		try {
			usuario = UsuarioDAO.getInstancia().loginUsuario(email, password);
		} catch (SQLException e) {
			new UsuarioException("Error en login de usuario en BD, reintente");
		}	
		return usuario;
	}
	
	public Cliente buscarClienteById(int idCliente) {
		return UsuarioDAO.getInstancia().buscarClienteById(idCliente);
	}
	
	public PaseadorDTO perfilPaseador(int idPaseador) throws UsuarioException {
		return UsuarioDAO.getInstancia().buscarPaseadorById(idPaseador);
	}
	
	
}