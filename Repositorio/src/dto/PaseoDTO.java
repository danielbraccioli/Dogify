package dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaseoDTO implements Serializable {
	
		private int idPaseo;
		private List<ReservaDTO> reservas = new ArrayList<ReservaDTO>();
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
		private PaseadorDTO paseador;
		private List<FotoDTO> fotos;
		
		public List<FotoDTO> getFotos() {
			return fotos;
		}

		public void setFotos(List<FotoDTO> fotos) {
			this.fotos = fotos;
		}

		public PaseoDTO() {}
		
		public int getIdPaseo() {
			return idPaseo;
		}
		public PaseadorDTO getPaseador() {
			return paseador;
		}
		public void setPaseador(PaseadorDTO paseador) {
			this.paseador = paseador;
		}
		public void setIdPaseo(int idPaseo) {
			this.idPaseo = idPaseo;
		}
		public List<ReservaDTO> getReservas() {
			return reservas;
		}
		public void setReservas(List<ReservaDTO> reservas) {
			this.reservas = reservas;
		}
		
		public String getFechaPaseoFormateada() {
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
			return format.format(this.getFecha());
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
		
		public int getParticipantes() {
			return this.reservas.size();
		}
		
		public int getDisponibles() {
			return (this.capacidad - this.reservas.size());
		}
		


}
