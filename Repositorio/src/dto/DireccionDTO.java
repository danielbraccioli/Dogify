package dto;

import java.io.Serializable;

public class DireccionDTO implements Serializable {
	
		private String calle;
		private int numero;
		private int piso;
		private String dpto;
		private String barrio;
		
		public DireccionDTO(String calle, int numero, int piso, String dpto, String barrio) {
			super();
			this.calle = calle;
			this.numero = numero;
			this.piso = piso;
			this.dpto = dpto;
			this.barrio = barrio;
		}
		
		
		
		public String getCalle() {
			return calle;
		}
		public void setCalle(String calle) {
			this.calle = calle;
		}
		public int getNumero() {
			return numero;
		}
		public void setNumero(int numero) {
			this.numero = numero;
		}
		public int getPiso() {
			return piso;
		}
		public void setPiso(int piso) {
			this.piso = piso;
		}
		public String getDpto() {
			return dpto;
		}
		public void setDpto(String dpto) {
			this.dpto = dpto;
		}
		public String getBarrio() {
			return barrio;
		}
		public void setBarrio(String barrio) {
			this.barrio = barrio;
		}


}
