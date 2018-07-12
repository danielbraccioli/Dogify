package servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegado.BusinessDelegate;
import dto.ClienteDTO;
import dto.PaseadorDTO;
import dto.PaseoDTO;
import dto.ReservaDTO;
import dto.UsuarioDTO;

@WebServlet("/servlets/ServletModuloUsuarios")
public class ServletModuloUsuarios extends HttpServlet{
	private static final long serialVersionUID = -2995544905709948607L;
	public ServletModuloUsuarios() {
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			if(request.getParameter("action").equalsIgnoreCase("loginUsuarios")){
				RequestDispatcher dispatcher;
	    		UsuarioDTO usuario = null;
	    		String email = ((String)request.getParameter("email"));
	    		String password = ((String)request.getParameter("password"));
	    		try {
					usuario = BusinessDelegate.getInstancia().loginUsuario(email, password);
					if(usuario != null) {
						if (usuario instanceof ClienteDTO) {
							ClienteDTO cliente = (ClienteDTO) usuario;
							List<ReservaDTO> reservas = null;
							try {
								reservas = BusinessDelegate.getInstancia().reservasCliente(cliente);
								request.setAttribute("reservas", reservas);
								dispatcher=request.getRequestDispatcher("/reservasCliente.jsp");
					    		dispatcher.forward(request, response);
							}catch (Exception e) {
								e.printStackTrace();
							}
						}else {
							PaseadorDTO paseador = (PaseadorDTO) usuario;
				    		List<PaseoDTO> paseos = null;
				    		try {
								paseos = BusinessDelegate.getInstancia().paseosPaseador(paseador);
								request.setAttribute("paseos", paseos);
								dispatcher=request.getRequestDispatcher("/paseosPaseador.jsp");
					    		dispatcher.forward(request, response);
							}catch (Exception e) {
								e.printStackTrace();
							}
						}
					}else {
						
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				if(request.getParameter("action").equalsIgnoreCase("perfilPaseador")){
					RequestDispatcher dispatcher;
					int nroPaseador = Integer.parseInt((String)request.getParameter("idPaseador"));
		    		PaseadorDTO paseador = null;
					try {
						paseador = BusinessDelegate.getInstancia().perfilPaseador(nroPaseador);
						request.setAttribute("paseador", paseador);
						dispatcher=request.getRequestDispatcher("/perfilPaseador.jsp");
			    		dispatcher.forward(request, response);

					}catch (Exception e) {
						e.printStackTrace();
					}
				}else {
					if(request.getParameter("action").equalsIgnoreCase("perfilPerro")){
						RequestDispatcher dispatcher;
			    		List<ReservaDTO> reservas = new ArrayList<ReservaDTO>();
			    		ClienteDTO cliente = new ClienteDTO();
			    		cliente.setIdUsuario(2);
			    		try {
							reservas = BusinessDelegate.getInstancia().reservasCliente(cliente);
							request.setAttribute("reservas", reservas);
							dispatcher=request.getRequestDispatcher("/reservasCliente.jsp");
				    		dispatcher.forward(request, response);

						}catch (Exception e) {
							e.printStackTrace();
						}
					}else {
					if(request.getParameter("action").equalsIgnoreCase("logoutUsuarios")){
						RequestDispatcher dispatcher;
			    		
			    		try {
			    			// matar sesion!!!!
			    			dispatcher=request.getRequestDispatcher("/login.jsp");
				    		dispatcher.forward(request, response);
			    		}catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			}
		}
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			doPost(req, resp);
		}
}