package excepciones;

public class PaseoException extends Exception{

	private static final long serialVersionUID = -1196902477228934099L;

	public PaseoException(String mensaje){
		super(mensaje);
	}

}