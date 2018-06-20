package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Cliente")
public class ClienteEntity extends UsuarioEntity implements Serializable {
	
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "idcliente")
		private List<PerroEntity> perros = new ArrayList<PerroEntity>();
		
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "idcliente")
		private List<ReservaEntity> reservas = new ArrayList<ReservaEntity>();
		private float cuentaCorriente ;

		




		public ClienteEntity(int idUsuario, String email, String password, String nombre, String apellido, String dni,
				Date fechaNacimiento, String avatar, DireccionEntity direccion, List<PerroEntity> perros,
				List<ReservaEntity> reservas, float cuentaCorriente) {
			super(idUsuario, email, password, nombre, apellido, dni, fechaNacimiento, avatar, direccion);
			this.perros = perros;
			this.reservas = reservas;
			this.cuentaCorriente = cuentaCorriente;
		}


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
	
		



}
