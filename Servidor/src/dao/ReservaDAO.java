package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.*;
import entity.*;
import hibernate.HibernateUtil;
import negocio.*;


public class ReservaDAO {

	private static ReservaDAO instancia;
	private SessionFactory sf;

	public ReservaDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static ReservaDAO getInstancia() {
		if (instancia == null) {
			instancia = new ReservaDAO();
		}
		return instancia;
	}


	public int reservarPaseo(Reserva reserva) {
		ReservaEntity reservaE = new ReservaEntity();
		reservaE.setEstado(reserva.getEstado());
		reservaE.setHoraDevolucion(reserva.getHoraDevolucion());
		reservaE.setHoraRetiro(reserva.getHoraRetiro());
		
			try {
				Session session = sf.openSession();
				session.beginTransaction();
				int idGenerado = (int) session.save(reservaE);
				session.getTransaction().commit();
				session.close();
				return idGenerado;
				
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Error ReservaDAO. reservarPaseo");
				return -1;
			}
		}
	
	public ReservaEntity recuperarReserva(int idReserva) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			ReservaEntity reserva = (ReservaEntity) session
					.createQuery("from ReservaEntity r where r.idReserva = :idReserva ")
					.setParameter("idReserva", idReserva).uniqueResult();
			session.getTransaction().commit();
			session.close();
			return reserva;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error UsuarioDAO.recuperarReserva");
		}
		return null;
	}
		
	

	

}