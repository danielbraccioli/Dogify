package dto;

import java.io.Serializable;
import java.util.Date;

import net.sourceforge.jtds.jdbc.DateTime;

public class PagoDTO implements Serializable {
		private int idPago;
		private Date fechaHora;
		private ReservaDTO reserva;
		private ClienteDTO cliente;
	
		public PagoDTO(int idPago, Date fechaHora, ReservaDTO reserva, ClienteDTO cliente) {
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
		public Date getFechaHora() {
			return fechaHora;
		}
		public void setFechaHora(Date fechaHora) {
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
