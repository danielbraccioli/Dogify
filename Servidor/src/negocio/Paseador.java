package negocio;

import java.util.*;

public class Paseador extends Usuario {
	
		private String numeroRegistro;
		private String perfil;
		private int reputacion;
		private List<Calificacion> calificaciones = new ArrayList<Calificacion>();
		private List<Paseo> paseos = new ArrayList<Paseo>();

		
		
		
		public Paseador(String email2, String password2, String nombre2, String apellido2, String dni2,
				Date fechaNacimiento2, String avatar2, Direccion direccion2, String numeroRegistro, String perfil,
				int reputacion, List<Calificacion> calificaciones, List<Paseo> paseos) {
			super(email2, password2, nombre2, apellido2, dni2, fechaNacimiento2, avatar2, direccion2);
			this.numeroRegistro = numeroRegistro;
			this.perfil = perfil;
			this.reputacion = reputacion;
			this.calificaciones = calificaciones;
			this.paseos = paseos;
		}
		
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
