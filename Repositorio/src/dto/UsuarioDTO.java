package dto;

import java.io.Serializable;
import java.util.Date;

public class UsuarioDTO implements Serializable {
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	private String dni;
	private Date fechaNacimiento;
	private String avatar;
	private DireccionDTO direccion;

	
	
	public UsuarioDTO(String email2, String password2, String nombre2, String apellido2, String dni2,
			Date fechaNacimiento2, String avatar2, DireccionDTO direccion2) {
		// TODO Auto-generated constructor stub
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
	public DireccionDTO getDireccion() {
		return direccion;
	}
	public void setDireccion(DireccionDTO direccion) {
		this.direccion = direccion;
	}
	
	
	
	

}
