package dto;

import java.io.Serializable;
import java.util.*;

public class PaseadorDTO extends UsuarioDTO implements Serializable {
	
		private String numeroRegistro;
		private String perfil;
		private int reputacion;
		private List<CalificacionDTO> calificaciones = new ArrayList<CalificacionDTO>();
		private List<PaseoDTO> paseos = new ArrayList<PaseoDTO>();

		
		
		
		public PaseadorDTO(String email2, String password2, String nombre2, String apellido2, String dni2,
				Date fechaNacimiento2, String avatar2, DireccionDTO direccion2, String numeroRegistro, String perfil,
				int reputacion, List<CalificacionDTO> calificaciones, List<PaseoDTO> paseos) {
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
		public List<CalificacionDTO> getCalificaciones() {
			return calificaciones;
		}
		public void setCalificaciones(List<CalificacionDTO> calificaciones) {
			this.calificaciones = calificaciones;
		}
		public List<PaseoDTO> getPaseos() {
			return paseos;
		}
		public void setPaseos(List<PaseoDTO> paseos) {
			this.paseos = paseos;
		}
		
		
		
		
		

}
