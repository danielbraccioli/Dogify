package servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import interfaz.*;
import rmi.ObjetoRemoto;
import org.hibernate.SessionFactory;
import hibernate.HibernateUtil;

public class Servidor extends Thread {
	InterfazRemota objetoRemoto;

	@SuppressWarnings("unused")
	private static SessionFactory sf = null;

	// Constructor del servidor
	public Servidor() {
		iniciar();
	}

	// Main del servidor
	public static void main(String[] args) {
		new Servidor();
	}
	
	public void iniciar() {
		try {
			LocateRegistry.createRegistry(1099);
			objetoRemoto = ObjetoRemoto.getInstance();
			Naming.rebind(InterfazRemota.url, objetoRemoto);
			System.out.println("Servidor inicializado correctamente...");

		
	 		sf = HibernateUtil.getSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
