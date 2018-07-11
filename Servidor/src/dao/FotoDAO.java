package dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

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
		Foto aux = new Foto(foto.getIdFoto(), foto.getFechaCarga(), null, null);
		return aux;
	}
	
	public FotoEntity toEntity(Foto foto) {
		FotoEntity fotoEntity = new FotoEntity();
		fotoEntity.setFechaCarga(foto.getFechaCarga());
		fotoEntity.setIdFoto(foto.getIdFoto());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(foto.getImagen(), "png", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Blob blFile = null;
		try {
			blFile = new javax.sql.rowset.serial.SerialBlob(baos.toByteArray());
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fotoEntity.setImagen(blFile);
		fotoEntity.setPaseo(PaseoDAO.getInstancia().toEntity(foto.getPaseo()));
		return fotoEntity;
	}
}
