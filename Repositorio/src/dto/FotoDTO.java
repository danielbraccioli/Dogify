package dto;

import java.io.Serializable;
import java.util.Date;

public class FotoDTO  implements Serializable{
	private int idFoto;
	private Date fechaCarga;
	private String imagen;
	private PaseoDTO paseo;

	public FotoDTO() {}

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

	public PaseoDTO getPaseo() {
		return paseo;
	}

	public void setPaseo(PaseoDTO paseo) {
		this.paseo = paseo;
	}
	
	
}
	