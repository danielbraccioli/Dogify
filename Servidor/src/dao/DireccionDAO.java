package dao;

import org.hibernate.SessionFactory;

import dto.DireccionDTO;
import entity.DireccionEntity;
import hibernate.HibernateUtil;
import negocio.Direccion;

public class DireccionDAO {
	private static DireccionDAO instancia;
	private SessionFactory sf;

	public DireccionDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static DireccionDAO getInstancia() {
		if (instancia == null) {
			instancia = new DireccionDAO();
		}
		return instancia;
	}
	
	public Direccion toNegocio(DireccionEntity direccion) {
		Direccion aux = new Direccion(direccion.getCalle(), direccion.getNumero(), direccion.getPiso(), direccion.getDpto(), direccion.getBarrio());
		return aux;
	}
	
	
	public DireccionDTO toDTO(DireccionEntity direccion) {
		DireccionDTO direccionDTO = new DireccionDTO();
		direccionDTO.setBarrio(direccion.getBarrio());
		direccionDTO.setCalle(direccion.getCalle());
		direccionDTO.setDpto(direccion.getDpto());
		direccionDTO.setNumero(direccion.getNumero());
		direccionDTO.setPiso(direccion.getPiso());
		return direccionDTO;
	}
	
	public DireccionEntity toEntity(Direccion direccion) {
		DireccionEntity direccionEntity = new DireccionEntity();
		direccionEntity.setBarrio(direccion.getBarrio());
		direccionEntity.setCalle(direccion.getCalle());
		direccionEntity.setDpto(direccion.getDpto());
		direccionEntity.setNumero(direccion.getNumero());
		direccionEntity.setPiso(direccion.getPiso());
		return direccionEntity;
	}

}
