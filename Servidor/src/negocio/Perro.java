package negocio;

public class Perro {
	
	private int idPerro;
	private String nombre;
	private String raza;
	private int edad;
	private String sexo;
	private String observaciones;
	private String dadoDeBaja;
	private String requiereBozal;
	private String tamano;
	
	public Perro(int idPerro, String nombre, String raza, int edad, String sexo, String observaciones,
			String dadoDeBaja, String requiereBozal, String tamano) {
		super();
		this.idPerro = idPerro;
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.sexo = sexo;
		this.observaciones = observaciones;
		this.dadoDeBaja = dadoDeBaja;
		this.requiereBozal = requiereBozal;
		this.tamano = tamano;
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
