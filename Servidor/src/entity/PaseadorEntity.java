package entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@DiscriminatorValue("Paseador")
public class PaseadorEntity extends UsuarioEntity implements Serializable {
	
		private String numeroRegistro;
		private String perfil;
		private int reputacion;

		@OneToMany(fetch=FetchType.EAGER, mappedBy = "paseador")
		@Fetch(value = FetchMode.SUBSELECT)
		private List<CalificacionEntity> calificaciones;
		
		@OneToMany(fetch=FetchType.EAGER, mappedBy = "paseador")
		@Fetch(value = FetchMode.SUBSELECT)
		private List<PaseoEntity> paseos;

		public PaseadorEntity() {}
		
		

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
		public List<CalificacionEntity> getCalificaciones() {
			return calificaciones;
		}
		public void setCalificaciones(List<CalificacionEntity> calificaciones) {
			this.calificaciones = calificaciones;
		}
		public List<PaseoEntity> getPaseos() {
			return paseos;
		}
		public void setPaseos(List<PaseoEntity> paseos) {
			this.paseos = paseos;
		}
		
		
		
		
		

}
