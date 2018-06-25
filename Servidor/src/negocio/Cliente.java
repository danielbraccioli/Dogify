package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.UsuarioDAO;
import dto.ReservaDTO;

public class Cliente extends Usuario {
	

		private List<Perro> perros = new ArrayList<Perro>();
		private List<Reserva> reservas = new ArrayList<Reserva>();
		private float cuentaCorriente ;

		



		public List<Perro> getPerros() {
			return perros;
		}


		public void setPerros(List<Perro> perros) {
			this.perros = perros;
		}


		public List<Reserva> getReservas() {
			return reservas;
		}


		public void setReservas(List<Reserva> reservas) {
			this.reservas = reservas;
		}


		public float getCuentaCorriente() {
			return cuentaCorriente;
		}


		public void setCuentaCorriente(float cuentaCorriente) {
			this.cuentaCorriente = cuentaCorriente;
		}


		public void agregarReserva(int idReserva) {

			UsuarioDAO.getInstancia().agregarReserva(this.getIdUsuario(),idReserva);
			
		}


		public List<ReservaDTO> reservasCliente() {
			// TODO Auto-generated method stub
			return UsuarioDAO.getInstancia().recuperarReservas(this.getIdUsuario());
		}	
	
		



}
