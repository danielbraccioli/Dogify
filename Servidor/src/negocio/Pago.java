package negocio;

import net.sourceforge.jtds.jdbc.DateTime;

public class Pago {
		private int idPago;
		private DateTime fechaHora;
		private Reserva reserva;
		private Cliente cliente;
	
		public Pago(int idPago, DateTime fechaHora, Reserva reserva, Cliente cliente) {
			super();
			this.idPago = idPago;
			this.fechaHora = fechaHora;
			this.reserva = reserva;
			this.cliente = cliente;
		}
		public int getIdPago() {
			return idPago;
		}
		public void setIdPago(int idPago) {
			this.idPago = idPago;
		}
		public DateTime getFechaHora() {
			return fechaHora;
		}
		public void setFechaHora(DateTime fechaHora) {
			this.fechaHora = fechaHora;
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
		

		

}
