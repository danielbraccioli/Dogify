package dto;

import java.io.Serializable;

public class PerroDTO implements Serializable {
	
	private int idPerro;
	private String nombre;
	private String raza;
	private int edad;
	private String sexo;
	private String observaciones;
	private String dadoDeBaja;
	private String requiereBozal;
	private String tamano;
	private String avatar;
	
	public String getAvatar() {
		if (this.avatar != null) {
		return avatar;
		}else {
			return "http://localhost:8080/ClienteWeb/perro1.png";
		}
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	private ClienteDTO cliente;
	
	public PerroDTO() {}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	
	public int getIdPerro() {
		return idPerro;
	}

	public void setIdPerro(int idPerro) {
		this.idPerro = idPerro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getDadoDeBaja() {
		return dadoDeBaja;
	}

	public void setDadoDeBaja(String dadoDeBaja) {
		this.dadoDeBaja = dadoDeBaja;
	}

	public String getRequiereBozal() {
		return requiereBozal;
	}

	public void setRequiereBozal(String requiereBozal) {
		this.requiereBozal = requiereBozal;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

}
