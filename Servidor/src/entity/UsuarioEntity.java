package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING)
public class UsuarioEntity implements Serializable {
	
	@Id
	@GeneratedValue
	private int idUsuario;
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	private String dni;
	private Date fechaNacimiento;
	private String avatar;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idDireccion")
	private DireccionEntity direccion;

	
	
	public UsuarioEntity(int idUsuario, String email, String password, String nombre, String apellido, String dni,
			Date fechaNacimiento, String avatar, DireccionEntity direccion) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.avatar = avatar;
		this.direccion = direccion;
	}


	public int getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public DireccionEntity getDireccion() {
		return direccion;
	}
	public void setDireccion(DireccionEntity direccion) {
		this.direccion = direccion;
	}
	
	
	
	

}
