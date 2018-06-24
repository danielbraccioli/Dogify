package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.*;
import entity.*;
import hibernate.HibernateUtil;
import negocio.*;


public class UsuarioDAO {

	private static UsuarioDAO instancia;
	private SessionFactory sf;

	public UsuarioDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static UsuarioDAO getInstancia() {
		if (instancia == null) {
			instancia = new UsuarioDAO();
		}
		return instancia;
	}

	public UsuarioDTO loginUsuario(Usuario usuario){
		UsuarioDTO usuarioD = new UsuarioDTO();
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			UsuarioEntity usuarioE = (UsuarioEntity) session
					.createQuery("from UsuarioEntity c where c.email = :email and c.password = :password")
					.setParameter("email",usuario.getEmail())
					.setParameter("password",usuario.getPassword()).uniqueResult();
			session.getTransaction().commit();
			session.close();
			if (usuarioE != null){
				usuarioD.setApellido(usuarioE.getApellido());
				usuarioD.setNombre(usuarioE.getNombre());
				usuarioD.setDni(usuarioE.getDni());
				usuarioD.setEmail(usuarioE.getEmail());
				usuarioD.setPassword(usuarioE.getPassword());
				return usuarioD;
			}
			else
				return null;
				
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error UsuarioDAO.recuperarUsuario");
		}
		return null;
	}

	

}