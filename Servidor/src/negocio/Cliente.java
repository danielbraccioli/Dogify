package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Usuario {
	

		private List<Perro> perros = new ArrayList<Perro>();
		private List<Reserva> reservas = new ArrayList<Reserva>();
		private float cuentaCorriente ;

		

		public Cliente(String email, String password, String nombre, String apellido, String dni, Date fechaNacimiento,
				String avatar, Direccion direccion, List<Perro> perros, List<Reserva> reservas, float cuentaCorriente) {
			super(email, password, nombre, apellido, dni, fechaNacimiento, avatar, direccion);
			this.perros = perros;
			this.reservas = reservas;
			this.cuentaCorriente = cuentaCorriente;
		}


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
	
		



}
