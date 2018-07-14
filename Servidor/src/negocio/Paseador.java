package negocio;

import java.sql.SQLException;
import java.util.*;

import excepciones.UsuarioException;

public class Paseador extends Usuario {
	
		private String numeroRegistro;
		private String perfil;
		private int reputacion;
		private List<Calificacion> calificaciones = new ArrayList<Calificacion>();
		private List<Paseo> paseos = new ArrayList<Paseo>();

		public Paseador(int idUsuario, String email, String password, String nombre, String apellido, String dni,
				Date fechaNacimiento, String avatar, Direccion direccion, String numeroRegistro, String perfil,
				int reputacion, List<Calificacion> calificaciones, List<Paseo> paseos) {
			super(idUsuario, email, password, nombre, apellido, dni, fechaNacimiento, avatar, direccion);
			this.numeroRegistro = numeroRegistro;
			this.perfil = perfil;
			this.reputacion = reputacion;
			this.calificaciones = calificaciones;
			this.paseos = paseos;
		}
		
		public void calificar(Reserva reserva, int puntaje, String observaciones) throws UsuarioException {
			Date fecha = new Date();
			Calificacion calificacion = new Calificacion(0, puntaje, observaciones, fecha, reserva, this);
			calificaciones.add(calificacion);
			calificacion.save();
			if (this.getReputacion() != 0) {
				this.reputacion = Math.round(this.reputacion + puntaje)/2;
			}else {
				this.reputacion = puntaje;
			}
			
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
