package servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlets/ServletModuloPaseos")
public class ServletModuloPaseos extends HttpServlet{
	private static final long serialVersionUID = 5911629597568300143L;
	
	public ServletModuloPaseos() {
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
			if(request.getParameter("action").equalsIgnoreCase("reservasCliente")){
				RequestDispatcher dispatcher;
	    		List<ReservaDTO> reservas = new ArrayList<ReservaDTO>();
	    		ClienteDTO cliente = new ClienteDTO();
	    		cliente.setIdUsuario(3);
	    		try {
					reservas = BusinessDelegate.getInstancia().reservasCliente(cliente);
					request.setAttribute("reservas", reservas);
					dispatcher=request.getRequestDispatcher("/reservasCliente.jsp");
		    		dispatcher.forward(request, response);

				}catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				if(request.getParameter("action").equalsIgnoreCase("reservasCliente")){
					RequestDispatcher dispatcher;
		    		
		    		try {
		    			ClienteDTO cliente = null;
						List<ReservaDTO> reserva = BusinessDelegate.getInstancia().reservasCliente(cliente);
						request.setAttribute("reserva", reserva);
						dispatcher=request.getRequestDispatcher("/paseoCliente.jsp");
			    		dispatcher.forward(request, response);

					}catch (Exception e) {
						e.printStackTrace();
					}
			} else {
				if(request.getParameter("action").equalsIgnoreCase("paseoCliente")){
					RequestDispatcher dispatcher;
					
					try {
		    			ClienteDTO cliente = null;
						ReservaDTO reserva = BusinessDelegate.getInstancia().buscarReserva(int idReserva);
						request.setAttribute("reserva", reserva);
						dispatcher=request.getRequestDispatcher("/paseoCliente.jsp");
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
