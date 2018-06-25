package controlador;

import java.util.Date;
import java.util.List;

import dto.*;
import negocio.*;

public class ModuloPaseos {
	
	private static ModuloPaseos instancia;

	public static ModuloPaseos getInstancia() {
		if (instancia == null)
			instancia = new ModuloPaseos();
		return instancia;
	}

	
	public List<PaseoDTO> recuperarPaseos(Date fecha, String barrio) {
		Paseo paseo = new Paseo();
		return paseo.recuperarPaseos(fecha,barrio);
	}


	public boolean reservarPaseo(UsuarioDTO usuario, PaseoDTO paseo) {
		Reserva reserva = new Reserva();
		reserva.setEstado("No iniciado");
		reserva.setHoraDevolucion(paseo.getHoraFin());
		reserva.setHoraRetiro(paseo.getHoraInicio());
		int idReserva = reserva.reservarPaseo();
		
		if (idReserva>0){
			
			Cliente cliente = new Cliente();
			cliente.setIdUsuario(usuario.getIdUsuario());
			cliente.agregarReserva(idReserva);
			
			Paseo paseoN = new Paseo();
			paseoN.setIdPaseo(paseo.getIdPaseo());
			paseoN.agregarReserva(idReserva);
			
			return true;
		}
		else
			return false;
		
	}


	public List<ReservaDTO> reservasCliente(ClienteDTO cliente) {
		Cliente clienteN = new Cliente();
		clienteN.setIdUsuario(cliente.getIdUsuario());
		return clienteN.reservasCliente();
	}
	
}
