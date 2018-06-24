package negocio;

import java.util.*;

import dto.PaseoDTO;

public class Paseo {
	
		private int idPaseo;
		private List<Reserva> reservas = new ArrayList<Reserva>();
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
		private List<String> fotos = new ArrayList<String>();
		
		
		
		public Paseo(int idPaseo, List<Reserva> reservas, Date fecha, String estado, float tarifa, String horarioInicio,
				String horarioFin, String horaInicio, String horaFin, int capacidad, String barrio,
				String ubicacionLatitud, String ubicacionLongitud, List<String> fotos) {
			super();
			this.idPaseo = idPaseo;
			this.reservas = reservas;
			this.fecha = fecha;
			this.estado = estado;
			this.tarifa = tarifa;
			this.horarioInicio = horarioInicio;
			this.horarioFin = horarioFin;
			this.horaInicio = horaInicio;
			this.horaFin = horaFin;
			this.capacidad = capacidad;
			this.barrio = barrio;
			this.ubicacionLatitud = ubicacionLatitud;
			this.ubicacionLongitud = ubicacionLongitud;
			this.fotos = fotos;
		}
		
		
		
		public Paseo() {
			// TODO Auto-generated constructor stub
		}



		public int getIdPaseo() {
			return idPaseo;
		}
		public void setIdPaseo(int idPaseo) {
			this.idPaseo = idPaseo;
		}
		public List<Reserva> getReservas() {
			return reservas;
		}
		public void setReservas(List<Reserva> reservas) {
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
		public List<String> getFotos() {
			return fotos;
		}
		public void setFotos(List<String> fotos) {
			this.fotos = fotos;
		}
		public List<PaseoDTO> recuperarPaseos() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
		
	

}
