package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entity.EfectivoEntity;
import entity.MercadoPagoEntity;
import excepciones.ReservaException;
import hibernate.HibernateUtil;
import negocio.Efectivo;
import negocio.MercadoPago;
import negocio.Pago;

public class PagoDAO {
	private static PagoDAO instancia;
	private SessionFactory sf;

	public PagoDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static PagoDAO getInstancia() {
		if (instancia == null) {
			instancia = new PagoDAO();
		}
		return instancia;
	}
	
	public void save(Pago pago) throws ReservaException{
		try {
		if(pago instanceof Efectivo) {
			EfectivoEntity aux = toEntity((Efectivo) pago);
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(aux);
			s.getTransaction().commit();
			s.close();
		}else {
			if(pago instanceof MercadoPago) {
				MercadoPagoEntity aux = toEntity((MercadoPago) pago);
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session s = sf.openSession();
				s.beginTransaction();
				s.save(aux);
				s.getTransaction().commit();
				s.close();
			}
		}
		}catch(Exception e) {
			new ReservaException("Error en grabar pago en BD, reintente");
		}
	}
	
	public EfectivoEntity toEntity(Efectivo efectivo) {
		EfectivoEntity efectivoE = new EfectivoEntity();
		efectivoE.setCliente(UsuarioDAO.getInstancia().toEntity(efectivo.getCliente()));
		efectivoE.setFechaHora(efectivo.getFechaHora());
		efectivoE.setIdPago(efectivo.getIdPago());
		efectivoE.setReserva(ReservaDAO.getInstancia().toEntity(efectivo.getReserva()));
		return efectivoE;
	}
	
	public MercadoPagoEntity toEntity(MercadoPago mp) {
		MercadoPagoEntity mpE = new MercadoPagoEntity();
		mpE.setCliente(UsuarioDAO.getInstancia().toEntity(mp.getCliente()));
		mpE.setDni(mp.getDni());
		mpE.setFechaHora(mp.getFechaHora());
		mpE.setIdPago(mp.getIdPago());
		mpE.setNroTarjeta(mp.getNroTarjeta());
		mpE.setReserva(ReservaDAO.getInstancia().toEntity(mp.getReserva()));
		mpE.setTitularNombre(mp.getTitularNombre());
		mpE.setVtoTarjeta(mp.getVtoTarjeta());
		return mpE;
	}

}