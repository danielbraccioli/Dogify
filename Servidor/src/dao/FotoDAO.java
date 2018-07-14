package dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.FotoDTO;
import entity.FotoEntity;
import excepciones.PaseoException;
import hibernate.HibernateUtil;
import negocio.Foto;

public class FotoDAO {
	private static FotoDAO instancia;
	private SessionFactory sf;

	public FotoDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static FotoDAO getInstancia() {
		if (instancia == null) {
			instancia = new FotoDAO();
		}
		return instancia;
	}
	
	public void save(Foto foto) throws PaseoException{
		FotoEntity aux = toEntity(foto);
		try {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(aux);
		s.getTransaction().commit();
		s.close();
		}catch(Exception e) {
			new PaseoException("Error en subir foto en BD, reintente");
		}
	}
	
	public Foto toNegocio(FotoEntity foto) {
		Foto aux = new Foto(foto.getIdFoto(), foto.getFechaCarga(), foto.getImagen(), null);
		return aux;
	}
	
	public FotoDTO toDTO(FotoEntity foto) {
		FotoDTO fotoAux = new FotoDTO();
		fotoAux.setFechaCarga(foto.getFechaCarga());
		fotoAux.setIdFoto(foto.getIdFoto());
		fotoAux.setImagen(foto.getImagen());
		fotoAux.setPaseo(null);
		return fotoAux;
	}
	
	public FotoEntity toEntity(Foto foto) {
		FotoEntity fotoEntity = new FotoEntity();
		fotoEntity.setFechaCarga(foto.getFechaCarga());
		fotoEntity.setIdFoto(foto.getIdFoto());
		fotoEntity.setImagen(foto.getImagen());
		fotoEntity.setPaseo(PaseoDAO.getInstancia().toEntity(foto.getPaseo()));
		return fotoEntity;
	}
}
