package excepciones;

public class ReservaException extends Exception{
	private static final long serialVersionUID = -5674399549554707117L;

	public ReservaException(String mensaje){
		super(mensaje);
	}

}