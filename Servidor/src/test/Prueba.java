package test;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Date;

import controlador.ModuloPagos;
import controlador.ModuloPaseos;
import controlador.ModuloUsuarios;
import dto.ClienteDTO;
import dto.PaseoDTO;
import dto.PerroDTO;
import dto.ReservaDTO;
import dto.UsuarioDTO;
import excepciones.PaseoException;
import excepciones.ReservaException;
import excepciones.UsuarioException;

public class Prueba {

	public static void main(String[] args) throws UsuarioException, PaseoException, ReservaException, UnsupportedEncodingException, MalformedURLException {
		UsuarioDTO usuario = ModuloUsuarios.getInstancia().login("fpotilinski@gmail.com", "1");
		System.out.println(usuario.getNombre());
		//ClienteDTO cliente = (ClienteDTO) usuario;
		ClienteDTO cliente = new ClienteDTO();
		cliente.setIdUsuario(1);
	//	System.out.println(cliente.getPerros().get(0).getNombre());
		
		PaseoDTO paseo = new PaseoDTO();
		paseo.setIdPaseo(1);
		PerroDTO perro = new PerroDTO();
		perro.setIdPerro(1);
		ReservaDTO reserva = new ReservaDTO();
		reserva.setIdReserva(1);
//		ModuloPaseos.getInstancia().reservarPaseo(paseo, cliente, perro);
	//	ModuloPaseos.getInstancia().cancelarPaseo(paseo);
		//ModuloPaseos.getInstancia().iniciarPaseo(paseo);
		//ModuloPaseos.getInstancia().retirarPerro(reserva);
		//ModuloPaseos.getInstancia().devolverPerro(reserva);
		//ModuloPaseos.getInstancia().finalizarPaseo(paseo);
		//ModuloPaseos.getInstancia().compartirUbicacion(paseo);
		ModuloPaseos.getInstancia().calificarPaseador(reserva, 10, "excelente");
		if (usuario != null) {
			//List<ReservaDTO> reservas = ModuloPaseos.getInstancia().reservasCliente((ClienteDTO) usuario);
			//System.out.println(reservas);
		}

	}

}
