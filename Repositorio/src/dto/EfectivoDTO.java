package dto;

import java.io.Serializable;

import net.sourceforge.jtds.jdbc.DateTime;

public class EfectivoDTO extends PagoDTO  implements Serializable{

	public EfectivoDTO(int idPago, DateTime fechaHora, ReservaDTO reserva, ClienteDTO cliente) {
		super(idPago, fechaHora, reserva, cliente);
		// TODO Auto-generated constructor stub
	}
	
	

}
