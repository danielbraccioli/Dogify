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
import dto.ReservaDTO;

@WebServlet("/servlets/ServletModuloPagos")
public class ServletModuloPagos extends HttpServlet{
	private static final long serialVersionUID = -6095554409941095597L;
	public ServletModuloPagos() {
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			if(request.getParameter("action").equalsIgnoreCase("pagarReservaEfectivo")){
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
				if(request.getParameter("action").equalsIgnoreCase("pagarReservaMercadoPago")){
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
				}
			}
		
		}
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			doGet(req, resp);
		}
}