package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
	
	
	private List<PaseoDTO> recuperarPaseos(List<PaseoEntity> paseosE) {
			List<PaseoDTO> PaseosDTO = new ArrayList<PaseoDTO>();
		
		for (PaseoEntity pas : paseosE){
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
	
	public List<PaseoDTO> listaPaseos(Date fecha,String barrio) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			java.util.Date dutyDay = (java.util.Date) dateFormat.parse(dateFormat.format(fecha));
			Session session = sf.openSession();
			session.beginTransaction();
			List<PaseoEntity> listaPaseosEntity = session.createQuery("from PaseoEntity p where p.fecha = :fecha and p.barrio = :barrio")
			.setParameter("fecha", dutyDay)
			.setParameter("barrio",barrio).list();
			session.getTransaction().commit();
			session.close();
			return recuperarPaseos(listaPaseosEntity);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error PaseoDAO.listaPaseos");
			return null;
		}
	}
	
	public PaseoEntity recuperarPaseo(int idPaseo) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			PaseoEntity paseo = (PaseoEntity) session
					.createQuery("from PaseoEntity c where c.idPaseo = :idPaseo ")
					.setParameter("idPaseo", idPaseo).uniqueResult();
			session.getTransaction().commit();
			session.close();
			return paseo;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error PaseoDAO.recuperarPaseo");
		}
		return null;
	}
	

	
	public void modificarPaseo(PaseoEntity paseo) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			session.update(paseo);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error PaseoDAO.modificarPaseo");
		}
	}

	public void agregarReserva(int idPaseo, int idReserva) {
		ReservaEntity reserva = ReservaDAO.getInstancia().recuperarReserva(idReserva);
		PaseoEntity paseo = this.recuperarPaseo(idPaseo);
		paseo.agregarReserva(reserva);
		this.modificarPaseo(paseo);
		
	}
	

}