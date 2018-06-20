package entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Paseador")
public class PaseadorEntity extends UsuarioEntity implements Serializable {
	
		private String numeroRegistro;
		private String perfil;
		private int reputacion;

		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "idcliente")
		private List<CalificacionEntity> calificaciones = new ArrayList<CalificacionEntity>();
		
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "idcliente")
		private List<PaseoEntity> paseos = new ArrayList<PaseoEntity>();

		
		

		
		public PaseadorEntity(int idUsuario, String email, String password, String nombre, String apellido, String dni,
				Date fechaNacimiento, String avatar, DireccionEntity direccion, String numeroRegistro, String perfil,
				int reputacion, List<CalificacionEntity> calificaciones, List<PaseoEntity> paseos) {
			super(idUsuario, email, password, nombre, apellido, dni, fechaNacimiento, avatar, direccion);
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
