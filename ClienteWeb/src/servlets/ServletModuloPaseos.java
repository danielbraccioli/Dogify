package servlets;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import delegado.BusinessDelegate;
import dto.ClienteDTO;
import dto.PaseadorDTO;
import dto.PaseoDTO;
import dto.ReservaDTO;

@WebServlet("/servlets/ServletModuloPaseos")
public class ServletModuloPaseos extends HttpServlet{
	private static final long serialVersionUID = 5911629597568300143L;
	
	public ServletModuloPaseos() {
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
			if(request.getParameter("action").equalsIgnoreCase("reservasCliente")){
				RequestDispatcher dispatcher;
				int nroCliente = Integer.parseInt((String)request.getParameter("idCliente"));
	    		ClienteDTO cliente = new ClienteDTO();
	    		cliente.setIdUsuario(nroCliente);
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
				if(request.getParameter("action").equalsIgnoreCase("paseosPaseador")){
					RequestDispatcher dispatcher;
					int nroPaseador = Integer.parseInt((String)request.getParameter("idPaseador"));
		    		PaseadorDTO paseador = new PaseadorDTO();
		    		paseador.setIdUsuario(nroPaseador);
		    		List<PaseoDTO> paseos = null;
		    		try {
						paseos = BusinessDelegate.getInstancia().paseosPaseador(paseador);
						request.setAttribute("paseos", paseos);
						dispatcher=request.getRequestDispatcher("/paseosPaseador.jsp");
			    		dispatcher.forward(request, response);
	
					}catch (Exception e) {
						e.printStackTrace();
					}
				}else {
					if(request.getParameter("action").equalsIgnoreCase("paseoPaseador")){
						RequestDispatcher dispatcher;
						int nroPaseo = Integer.parseInt((String)request.getParameter("idPaseo"));
						PaseoDTO paseo = null;
			    		try {
							paseo = BusinessDelegate.getInstancia().paseoPaseador(nroPaseo);
							request.setAttribute("paseo", paseo);
							dispatcher=request.getRequestDispatcher("/paseoPaseador.jsp");
				    		dispatcher.forward(request, response);
		
						}catch (Exception e) {
							e.printStackTrace();
						}
					}else {
						if(request.getParameter("action").equalsIgnoreCase("iniciarPaseo")){
							RequestDispatcher dispatcher;
							int nroPaseo = Integer.parseInt((String)request.getParameter("idPaseo"));
				    		PaseoDTO paseo = new PaseoDTO();
				    		paseo.setIdPaseo(nroPaseo);
				    		try {
				    			BusinessDelegate.getInstancia().iniciarPaseo(paseo);
				    			paseo = BusinessDelegate.getInstancia().paseoPaseador(nroPaseo);
								request.setAttribute("paseo", paseo);
								dispatcher=request.getRequestDispatcher("/paseoPaseador.jsp");
					    		dispatcher.forward(request, response);
			
							}catch (Exception e) {
								e.printStackTrace();
							}
						}else {
							if(request.getParameter("action").equalsIgnoreCase("retirarPerro")){
								RequestDispatcher dispatcher;
								int nroReserva = Integer.parseInt((String)request.getParameter("idReserva"));
					    		ReservaDTO reserva = new ReservaDTO();
					    		reserva.setIdReserva(nroReserva);
					    		try {
									BusinessDelegate.getInstancia().retirarPerro(reserva);
									int nroPaseo = Integer.parseInt((String)request.getParameter("idPaseo"));
						    		PaseoDTO paseo = new PaseoDTO();
						    		paseo.setIdPaseo(nroPaseo);
									paseo = BusinessDelegate.getInstancia().paseoPaseador(nroPaseo);
									request.setAttribute("paseo", paseo);
									dispatcher=request.getRequestDispatcher("/paseoPaseador.jsp");
						    		dispatcher.forward(request, response);
				
								}catch (Exception e) {
									e.printStackTrace();
								}
							}else {
								if(request.getParameter("action").equalsIgnoreCase("devolverPerro")){
									RequestDispatcher dispatcher;
									int nroReserva = Integer.parseInt((String)request.getParameter("idReserva"));
						    		ReservaDTO reserva = new ReservaDTO();
						    		reserva.setIdReserva(nroReserva);
						    		try {
						    			BusinessDelegate.getInstancia().devolverPerro(reserva);
										int nroPaseo = Integer.parseInt((String)request.getParameter("idPaseo"));
							    		PaseoDTO paseo = new PaseoDTO();
							    		paseo.setIdPaseo(nroPaseo);
										paseo = BusinessDelegate.getInstancia().paseoPaseador(nroPaseo);
										request.setAttribute("paseo", paseo);
										dispatcher=request.getRequestDispatcher("/paseoPaseador.jsp");
							    		dispatcher.forward(request, response);
					
									}catch (Exception e) {
										e.printStackTrace();
									}
								}else {
									if(request.getParameter("action").equalsIgnoreCase("finalizarPaseo")){
										RequestDispatcher dispatcher;
										int nroPaseo = Integer.parseInt((String)request.getParameter("idPaseo"));
							    		PaseoDTO paseo = new PaseoDTO();
							    		paseo.setIdPaseo(nroPaseo);
							    		try {
							    			BusinessDelegate.getInstancia().finalizarPaseo(paseo);
							    			paseo = BusinessDelegate.getInstancia().paseoPaseador(nroPaseo);
											request.setAttribute("paseo", paseo);
											dispatcher=request.getRequestDispatcher("/paseoPaseador.jsp");
								    		dispatcher.forward(request, response);
						
										}catch (Exception e) {
											e.printStackTrace();
										}
									}else {
										if(request.getParameter("action").equalsIgnoreCase("compartirUbicacion")){
											RequestDispatcher dispatcher;
											int nroPaseo = Integer.parseInt((String)request.getParameter("idPaseo"));
								    		PaseoDTO paseo = new PaseoDTO();
								    		paseo.setIdPaseo(nroPaseo);
								    		try {
												BusinessDelegate.getInstancia().compartirUbicacion(paseo);
												paseo = BusinessDelegate.getInstancia().paseoPaseador(nroPaseo);
												request.setAttribute("paseo", paseo);
												dispatcher=request.getRequestDispatcher("/paseoPaseador.jsp");
									    		dispatcher.forward(request, response);
							
											}catch (Exception e) {
												e.printStackTrace();
											}
										}else {
											if(request.getParameter("action").equalsIgnoreCase("subirFoto")){
												RequestDispatcher dispatcher;
												int nroPaseo = Integer.parseInt((String)request.getParameter("idPaseo"));
									    		PaseoDTO paseo = new PaseoDTO();
									    		paseo.setIdPaseo(nroPaseo);
									    		String archivo = (String)request.getParameter("fileFoto");
									    		File imagen = new File("C:/Users/fpotilinski/Desktop/TestBoot/startbootstrap-sb-admin-gh-pages/"+archivo);
									    		Collection<Part> parts = (Collection<Part>)request.getParts();
									    		for(Part part : parts) {
									    	part.getSubmittedFileName();
									    		}
									    		
									    		try {
													BusinessDelegate.getInstancia().subirFoto(paseo, imagen);
													paseo = BusinessDelegate.getInstancia().paseoPaseador(nroPaseo);
													request.setAttribute("paseo", paseo);
													dispatcher=request.getRequestDispatcher("/reservasCliente.jsp");
										    		dispatcher.forward(request, response);
								
												}catch (Exception e) {
													e.printStackTrace();
												}
											}else {
												if(request.getParameter("action").equalsIgnoreCase("perfilPaseador")){
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
													if(request.getParameter("action").equalsIgnoreCase("paseoCliente")){
														RequestDispatcher dispatcher;
														int nroReserva = Integer.parseInt((String)request.getParameter("idReserva"));
											    		ReservaDTO reserva = null;
											    		try {
															reserva = BusinessDelegate.getInstancia().reservaCliente(nroReserva);
															request.setAttribute("reserva", reserva);
															dispatcher=request.getRequestDispatcher("/paseoCliente.jsp");
												    		dispatcher.forward(request, response);
										
														}catch (Exception e) {
															e.printStackTrace();
														}
													}
												}
											
											}
										}
									}
								}
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
