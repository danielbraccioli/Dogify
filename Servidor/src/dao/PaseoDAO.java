package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.*;
import entity.*;
import hibernate.HibernateUtil;
import negocio.*;


public class PaseoDAO {

	private static PaseoDAO instancia;
	private SessionFactory sf;

	public PaseoDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static PaseoDAO getInstancia() {
		if (instancia == null) {
			instancia = new PaseoDAO();
		}
		return instancia;
	}

	public boolean grabarPaseo(PaseoEntity paseoEntity) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(paseoEntity);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error PaseoDAO. Alta Paseo");
			return false;
		}
	}
	
	
	public List<PaseoDTO> recuperarFacturas() {
		List<PaseoEntity> paseos = this.listaPaseo();
		List<PaseoDTO> PaseosDTO = new ArrayList<PaseoDTO>();
		
		for (PaseoEntity pas : paseos){
			PaseoDTO pasDTO = new PaseoDTO();
			pasDTO.setIdPaseo(pas.getIdPaseo());
			pasDTO.setBarrio(pas.getBarrio());
			pasDTO.setCapacidad(pas.getCapacidad());
			pasDTO.setEstado(pas.getEstado());
			pasDTO.setFecha(pas.getFecha());
			pasDTO.setHoraFin(pas.getHoraFin());
			pasDTO.setHoraInicio(pas.getHoraInicio());
			pasDTO.setHorarioInicio(pas.getHorarioInicio());
			pasDTO.setHorarioFin(pas.getHorarioFin());
			pasDTO.setTarifa(pas.getTarifa());
			pasDTO.setUbicacionLatitud(pas.getUbicacionLatitud());
			pasDTO.setUbicacionLongitud(pas.getUbicacionLongitud());
			
			PaseosDTO.add(pasDTO);
			
			
		}
				
		return PaseosDTO;
	}
	
	public List<PaseoEntity> listaPaseo() {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			List<PaseoEntity> listaPaseosEntity = session.createQuery("from PaseoEntity").list();
			session.getTransaction().commit();
			session.close();
			return listaPaseosEntity;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error PaseoDAO.listaFacturas");
			return null;
		}
	}
	

}