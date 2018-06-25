package negocio;

import java.util.*;

public class Paseador extends Usuario {
	
		private String numeroRegistro;
		private String perfil;
		private int reputacion;
		private List<Calificacion> calificaciones = new ArrayList<Calificacion>();
		private List<Paseo> paseos = new ArrayList<Paseo>();

		
		
		
		
		public String getNumeroRegistro() {
			return numeroRegistro;
		}
		public void setNumeroRegistro(String numeroRegistro) {
			this.numeroRegistro = numeroRegistro;
		}
		public String getPerfil() {
			return perfil;
		}
		public void setPerfil(String perfil) {
			this.perfil = perfil;
		}
		public int getReputacion() {
			return reputacion;
		}
		public void setReputacion(int reputacion) {
			this.reputacion = reputacion;
		}
		public List<Calificacion> getCalificaciones() {
			return calificaciones;
		}
		public void setCalificaciones(List<Calificacion> calificaciones) {
			this.calificaciones = calificaciones;
		}
		public List<Paseo> getPaseos() {
			return paseos;
		}
		public void setPaseos(List<Paseo> paseos) {
			this.paseos = paseos;
		}
		
		
		
		
		

}
