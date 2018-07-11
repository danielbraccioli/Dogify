package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@DiscriminatorValue("Cliente")
public class ClienteEntity extends UsuarioEntity implements Serializable {
	
		@OneToMany(fetch=FetchType.EAGER, mappedBy = "cliente")
		@Fetch(value = FetchMode.SUBSELECT)
		//@JoinColumn(name = "idCliente")
		private List<PerroEntity> perros = new ArrayList<PerroEntity>();
		
		@OneToMany(fetch=FetchType.EAGER, mappedBy = "cliente")
		@Fetch(value = FetchMode.SUBSELECT)
		private List<ReservaEntity> reservas = new ArrayList<ReservaEntity>();
		private float cuentaCorriente ;

		

		public List<PerroEntity> getPerros() {
			return perros;
		}


		public void setPerros(List<PerroEntity> perros) {
			this.perros = perros;
		}


		public List<ReservaEntity> getReservas() {
			return reservas;
		}


		public void setReservas(List<ReservaEntity> reservas) {
			this.reservas = reservas;
		}


		public float getCuentaCorriente() {
			return cuentaCorriente;
		}


		public void setCuentaCorriente(float cuentaCorriente) {
			this.cuentaCorriente = cuentaCorriente;
		}	
	
		public void agregarReserva(ReservaEntity reserva){
			reservas.add(reserva);
		}
		



}
