package entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;


@Entity
@Table(name = "Paseo")
public class PaseoEntity implements Serializable{
	
		@Id
		@GeneratedValue	
		private int idPaseo;
		
		@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
		@JoinColumn(name = "idPaseo")
		private List<ReservaEntity> reservas = new ArrayList<ReservaEntity>();
		private Date fecha;
		private String estado;
		private float tarifa;
		private String horarioInicio;
		private String horarioFin;
		private String horaInicio;
		private String horaFin;
		private int capacidad;
		private String barrio;
		private String ubicacionLatitud;
		private String ubicacionLongitud;
	//	private List<String> fotos = new ArrayList<String>();
		

		
		

		public int getIdPaseo() {
			return idPaseo;
		}
		public void setIdPaseo(int idPaseo) {
			this.idPaseo = idPaseo;
		}
		public List<ReservaEntity> getReservas() {
			return reservas;
		}
		public void setReservas(List<ReservaEntity> reservas) {
			this.reservas = reservas;
		}
		public Date getFecha() {
			return fecha;
		}
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public float getTarifa() {
			return tarifa;
		}
		public void setTarifa(float tarifa) {
			this.tarifa = tarifa;
		}
		public String getHorarioInicio() {
			return horarioInicio;
		}
		public void setHorarioInicio(String horarioInicio) {
			this.horarioInicio = horarioInicio;
		}
		public String getHorarioFin() {
			return horarioFin;
		}
		public void setHorarioFin(String horarioFin) {
			this.horarioFin = horarioFin;
		}
		public String getHoraInicio() {
			return horaInicio;
		}
		public void setHoraInicio(String horaInicio) {
			this.horaInicio = horaInicio;
		}
		public String getHoraFin() {
			return horaFin;
		}
		public void setHoraFin(String horaFin) {
			this.horaFin = horaFin;
		}
		public int getCapacidad() {
			return capacidad;
		}
		public void setCapacidad(int capacidad) {
			this.capacidad = capacidad;
		}
		public String getBarrio() {
			return barrio;
		}
		public void setBarrio(String barrio) {
			this.barrio = barrio;
		}
		public String getUbicacionLatitud() {
			return ubicacionLatitud;
		}
		public void setUbicacionLatitud(String ubicacionLatitud) {
			this.ubicacionLatitud = ubicacionLatitud;
		}
		public String getUbicacionLongitud() {
			return ubicacionLongitud;
		}
		public void setUbicacionLongitud(String ubicacionLongitud) {
			this.ubicacionLongitud = ubicacionLongitud;
		}
//		public List<String> getFotos() {
//			return fotos;
	//	}
//		public void setFotos(List<String> fotos) {
//			this.fotos = fotos;
//		}
		
		
		
		
	

}
