package dto;

import java.io.Serializable;
import java.util.*;

public class PaseadorDTO extends UsuarioDTO implements Serializable {
	
		private String numeroRegistro;
		private String perfil;
		private int reputacion;
		private List<CalificacionDTO> calificaciones = new ArrayList<CalificacionDTO>();
		private List<PaseoDTO> paseos = new ArrayList<PaseoDTO>();
		
		
			
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
