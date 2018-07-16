package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.PaseadorDTO;
import dto.PerroDTO;
import entity.ClienteEntity;
import entity.PaseadorEntity;
import entity.PerroEntity;
import excepciones.UsuarioException;
import hibernate.HibernateUtil;
import negocio.Cliente;
import negocio.Perro;

public class PerroDAO {
	private static PerroDAO instancia;
	private SessionFactory sf;

	public PerroDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static PerroDAO getInstancia() {
		if (instancia == null) {
			instancia = new PerroDAO();
		}
		return instancia;
	}
	
	public PerroDTO buscarPerroById(int idPerro) throws UsuarioException{
		PerroEntity perro = null;
		try {
		Session session = sf.openSession();
		session.beginTransaction();
		perro = (PerroEntity) session
				.createQuery("from PerroEntity c where c.idPerro = :idPerro ")
				.setParameter("idPerro", idPerro).uniqueResult();
		session.getTransaction().commit();
		session.close();
		}catch(Exception e) {
			new UsuarioException("Error en buscar paseador en BD, reintente");
		}
		return toDTO(perro);
	}
	
	public Perro toNegocio(PerroEntity perro) {
		Perro aux = new Perro(perro.getIdPerro(), perro.getNombre(), perro.getRaza(), perro.getEdad(), perro.getSexo(), perro.getObservaciones(), perro.getDadoDeBaja(), perro.getRequiereBozal(), perro.getTamano(), perro.getAvatar(), null);
		return aux;
	}  
	
	public PerroDTO toDTO(PerroEntity perro) {
		PerroDTO perroDTO = new PerroDTO();
		//perroDTO.setCliente(UsuarioDAO.getInstancia().toDTOSimple(perro.getCliente()));
		perroDTO.setDadoDeBaja(perro.getDadoDeBaja());
		perroDTO.setEdad(perro.getEdad());
		perroDTO.setIdPerro(perro.getIdPerro());
		perroDTO.setNombre(perro.getNombre());
		perroDTO.setObservaciones(perro.getObservaciones());
		perroDTO.setRaza(perro.getRaza());
		perroDTO.setRequiereBozal(perro.getRequiereBozal());
		perroDTO.setSexo(perro.getSexo());
		perroDTO.setTamano(perro.getTamano());
		perroDTO.setAvatar(perro.getAvatar());
		return perroDTO;
	}

	public PerroEntity toEntity(Perro perro) {
		PerroEntity perroAux = new PerroEntity();
		perroAux.setDadoDeBaja(perro.getDadoDeBaja());
		perroAux.setEdad(perro.getEdad());
		perroAux.setIdPerro(perro.getIdPerro());
		perroAux.setNombre(perro.getNombre());
		perroAux.setObservaciones(perro.getObservaciones());
		perroAux.setRaza(perro.getRaza());
		perroAux.setRequiereBozal(perro.getRequiereBozal());
		perroAux.setSexo(perro.getSexo());
		perroAux.setTamano(perro.getTamano());
		perroAux.setAvatar(perro.getAvatar());
		return perroAux;
	}
	
	

}
