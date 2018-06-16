package dto;

import java.io.Serializable;

import net.sourceforge.jtds.jdbc.DateTime;

public class PagoDTO implements Serializable {
		private int idPago;
		private DateTime fechaHora;
		private ReservaDTO reserva;
		private ClienteDTO cliente;
	
		public PagoDTO(int idPago, DateTime fechaHora, ReservaDTO reserva, ClienteDTO cliente) {
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
		public ReservaDTO getReserva() {
			return reserva;
		}
		public void setReserva(ReservaDTO reserva) {
			this.reserva = reserva;
		}
		public ClienteDTO getCliente() {
			return cliente;
		}
		public void setCliente(ClienteDTO cliente) {
			this.cliente = cliente;
		}
		

		

}
