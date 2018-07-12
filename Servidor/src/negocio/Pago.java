package negocio;

import java.util.Date;

import excepciones.ReservaException;

public abstract class Pago {
		private int idPago;
		private Date fecha;
		private Reserva reserva;
		private Cliente cliente;
	
		public Pago(int idPago, Date fecha, Reserva reserva, Cliente cliente) {
			super();
			this.idPago = idPago;
			this.fecha = fecha;
			this.reserva = reserva;
			this.cliente = cliente;
		}
		public int getIdPago() {
			return idPago;
		}
		public void setIdPago(int idPago) {
			this.idPago = idPago;
		}
		public Date getFechaHora() {
			return fecha;
		}
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		public Reserva getReserva() {
			return reserva;
		}
		public void setReserva(Reserva reserva) {
			this.reserva = reserva;
		}
		public Cliente getCliente() {
			return cliente;
		}
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		
		public abstract void save() throws ReservaException;
		

}
