package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClienteDTO extends UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 6233813042116418758L;
	
	public ClienteDTO(){}

		private List<PerroDTO> perros = new ArrayList<PerroDTO>();
		private List<ReservaDTO> reservas = new ArrayList<ReservaDTO>();
		private float cuentaCorriente ;

	

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
