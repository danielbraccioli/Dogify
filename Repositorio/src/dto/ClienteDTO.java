package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteDTO extends UsuarioDTO implements Serializable {
	

		private List<PerroDTO> perros = new ArrayList<PerroDTO>();
		private List<ReservaDTO> reservas = new ArrayList<ReservaDTO>();
		private float cuentaCorriente ;

		

		public ClienteDTO(String email, String password, String nombre, String apellido, String dni, Date fechaNacimiento,
				String avatar, DireccionDTO direccion, List<PerroDTO> perros, List<ReservaDTO> reservas, float cuentaCorriente) {
			super(email, password, nombre, apellido, dni, fechaNacimiento, avatar, direccion);
			this.perros = perros;
			this.reservas = reservas;
			this.cuentaCorriente = cuentaCorriente;
		}


		public List<PerroDTO> getPerros() {
			return perros;
		}


		public void setPerros(List<PerroDTO> perros) {
			this.perros = perros;
		}


		public List<ReservaDTO> getReservas() {
			return reservas;
		}


		public void setReservas(List<ReservaDTO> reservas) {
			this.reservas = reservas;
		}


		public float getCuentaCorriente() {
			return cuentaCorriente;
		}


		public void setCuentaCorriente(float cuentaCorriente) {
			this.cuentaCorriente = cuentaCorriente;
		}	
	
		



}
