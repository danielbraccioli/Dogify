package servlets;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
			HttpSession session = request.getSession();
			
			if(request.getParameter("action").equalsIgnoreCase("reservasCliente")){
				RequestDispatcher dispatcher;
				int nroCliente = (int) request.getSession().getAttribute("user");
			//	int nroCliente = Integer.parseInt((String)request.getParameter("idCliente"));
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
									    		String imagen = (String)request.getParameter("fileFoto");
									    		
									    		
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
													}else {
														if(request.getParameter("action").equalsIgnoreCase("disponibilidadPaseos")){
															RequestDispatcher dispatcher;
															Calendar calendario = Calendar.getInstance();
															int mes = calendario.get(Calendar.MONTH) + 1;
															int anio = calendario.get(Calendar.YEAR);
															List<PaseoDTO> paseos = null;
												    		try {
																paseos = BusinessDelegate.getInstancia().buscarPaseosByMesAnio(mes, anio);
																request.setAttribute("paseos", paseos);
																request.setAttribute("anio", anio);
																request.setAttribute("mes", mes);
																dispatcher=request.getRequestDispatcher("/calendarioDisponibilidad.jsp");
													    		dispatcher.forward(request, response);
											
															}catch (Exception e) {
																e.printStackTrace();
															}
														}else {
															if(request.getParameter("action").equalsIgnoreCase("paseosFecha")){
																RequestDispatcher dispatcher;
																String fechaStr= (String)request.getParameter("fecha");
																DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
																Date fecha = new Date();
																try {
																	fecha = dateFormat.parse(fechaStr);
																} catch (ParseException e1) {
																	// TODO Auto-generated catch block
																	e1.printStackTrace();
																}
												
																
																List<PaseoDTO> paseos = null;
													    		try {
																	paseos = BusinessDelegate.getInstancia().buscarPaseosByFecha(fecha);
																	request.setAttribute("paseos", paseos);
																	dispatcher=request.getRequestDispatcher("/paseosDia.jsp");
														    		dispatcher.forward(request, response);
												
																}catch (Exception e) {
																	e.printStackTrace();
																}
															}
															else{
																if(request.getParameter("action").equalsIgnoreCase("reservarPaseo")){
																	RequestDispatcher dispatcher;
																	int nroPaseo = Integer.parseInt((String)request.getParameter("idPaseo"));
																	ClienteDTO cliente = (ClienteDTO) request.getSession().getAttribute("cliente");
																	

																	
																	PaseoDTO paseo = null;
														    		try {
																		paseo = BusinessDelegate.getInstancia().paseoPaseador(nroPaseo);
																		request.setAttribute("cliente", cliente);
																		request.setAttribute("paseo", paseo);
																		dispatcher=request.getRequestDispatcher("/reservarPaseo.jsp");
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
				}
			}
		}
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			doPost(req, resp);
		}
}
