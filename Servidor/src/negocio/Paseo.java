package negocio;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.PaseoDAO;
import excepciones.PaseoException;
import excepciones.ReservaException;

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
		private List<Foto> fotos = new ArrayList<Foto>();
		private Paseador paseador;
		
		
		
		public Paseo(int idPaseo, List<Reserva> reservas, Date fecha, String estado, float tarifa, String horarioInicio,
				String horarioFin, String horaInicio, String horaFin, int capacidad, String barrio,
				String ubicacionLatitud, String ubicacionLongitud, List<Foto> fotos, Paseador paseador) {
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
			this.setPaseador(paseador);
		}
		
		public void altaReserva(Cliente cliente, Perro perro) throws PaseoException, ReservaException {
			if(estado.equals("PENDIENTE")) {
				Reserva reserva = new Reserva(0, "PENDIENTE", null, null, null, cliente, perro, this);
				reservas.add(reserva);
				reserva.save();
			}else {
				throw new PaseoException("Estado del paseo impide generar reserva");
			}
		}
		
		public void cancelarPaseo() throws PaseoException, ReservaException {
			if(estado.equals("PENDIENTE")) {
				for(Reserva reserva : reservas) {
					reserva.actualizarEstado("CANCELADO");
				}
				this.estado = "CANCELADO";
				this.update();
			}else {
				throw new PaseoException("Estado del paseo impide cancelarlo");
			}
		}
		
		public void iniciarPaseo() throws PaseoException {
			if(estado.equals("PENDIENTE")) {
				this.estado = "EN CURSO";
				Date date = new Date();
				DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
				this.horaInicio = hourFormat.format(date);
				this.update();
			}else {
				throw new PaseoException("Estado del paseo impide iniciarlo");
			}
		}
		
		public void finalizarPaseo() throws PaseoException, ReservaException{
			if(estado.equals("EN CURSO")) {
				for(Reserva reserva : reservas) {
					if(reserva.getEstado().equals("RETIRADO")) {
						throw new ReservaException("Estado de reserva impide finalizar el paseo");
					}
				}
				this.estado = "FINALIZADO";
				Date date = new Date();
				DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
				this.horaFin = hourFormat.format(date);
				this.update();
			}else {
				throw new PaseoException("Estado del paseo impide finalizarlo");
			}
		}
		
		public int lugaresDisponibles() {
			int ocupados = 0;
			for(Reserva reserva : reservas) {
				if(reserva.getEstado().equals("Pendiente")) {
					ocupados += 1;
				}
			}
			return capacidad - ocupados;
		}
		
		public void actualizarUbicacion(String latitud, String longitud) throws PaseoException {
			if(estado.equals("EN CURSO")) {
				this.ubicacionLatitud = latitud;
				this.ubicacionLongitud = longitud;
				this.update();
			}else {
				throw new PaseoException("Estado del paseo impide actualizar ubicación");
			}
		}
		
		public void subirFoto(BufferedImage imagen) throws PaseoException{
			if(estado.equals("EN CURSO")) {
				Date fecha = new Date();
				Foto foto = new Foto(0, fecha, imagen, this);
				fotos.add(foto);
				foto.save();
			}else {
				throw new PaseoException("Estado del paseo impide subir foto");
			}
		}
		
		
		public void update() throws PaseoException {
			PaseoDAO.getInstancia().update(this);
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
		public List<Foto> getFotos() {
			return fotos;
		}
		public void setFotos(List<Foto> fotos) {
			this.fotos = fotos;
		}
		
		public Paseador getPaseador() {
			return paseador;
		}

		public void setPaseador(Paseador paseador) {
			this.paseador = paseador;
		}
		
		
		
		
		
		
	

}
