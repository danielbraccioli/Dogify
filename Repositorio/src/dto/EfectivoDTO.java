package dto;

import java.io.Serializable;
import java.util.Date;


public class EfectivoDTO extends PagoDTO  implements Serializable{

	public EfectivoDTO(int idPago, Date fechaHora, ReservaDTO reserva, ClienteDTO cliente) {
		super(idPago, fechaHora, reserva, cliente);
		// TODO Auto-generated constructor stub
	}
	
	

}
