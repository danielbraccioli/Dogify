package negocio;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.Date;

import dao.FotoDAO;
import excepciones.PaseoException;

public class Foto {
	private int idFoto;
	private Date fechaCarga;
	private String imagen;
	private Paseo paseo;

	public Foto(int idFoto, Date fechaCarga, String imagen, Paseo paseo) {
		this.idFoto = idFoto;
		this.fechaCarga = fechaCarga;
		this.imagen = imagen;
		this.paseo = paseo;
	}

	public int getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}

	public Date getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Paseo getPaseo() {
		return paseo;
	}

	public void setPaseo(Paseo paseo) {
		this.paseo = paseo;
	}
	
	public void save() throws PaseoException {
		FotoDAO.getInstancia().save(this);
	}
	
}
