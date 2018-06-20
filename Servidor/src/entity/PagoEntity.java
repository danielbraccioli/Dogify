package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "Pago")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pago", discriminatorType = DiscriminatorType.STRING)
public class PagoEntity implements Serializable{
	
		@Id
		@GeneratedValue
		private int idPago;
		private Date fechaHora;
		
		@ManyToOne
		@JoinColumn(name="idReserva")
		private ReservaEntity reserva;

		@ManyToOne
		@JoinColumn(name="idUsuario")
		private ClienteEntity cliente;
	
		public PagoEntity(int idPago, Date fechaHora, ReservaEntity reserva, ClienteEntity cliente) {
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
		public ReservaEntity getReserva() {
			return reserva;
		}
		public void setReserva(ReservaEntity reserva) {
			this.reserva = reserva;
		}
		public ClienteEntity getCliente() {
			return cliente;
		}
		public void setCliente(ClienteEntity cliente) {
			this.cliente = cliente;
		}
		

		

}
