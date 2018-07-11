package entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Foto")
public class FotoEntity implements Serializable {
	@Id
	@GeneratedValue	
	private int idFoto;
	private Date fechaCarga;
	private Blob imagen;
	
	@ManyToOne
	@JoinColumn(name = "idPaseo")
	private PaseoEntity paseo;
	
	public FotoEntity() {}

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

	public Blob getImagen() {
		return imagen;
	}

	public void setImagen(Blob imagen) {
		this.imagen = imagen;
	}

	public PaseoEntity getPaseo() {
		return paseo;
	}

	public void setPaseo(PaseoEntity paseo) {
		this.paseo = paseo;
	}
	
}
