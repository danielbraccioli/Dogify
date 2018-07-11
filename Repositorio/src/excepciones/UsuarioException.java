package excepciones;

public class UsuarioException extends Exception{

	private static final long serialVersionUID = -1196902477228934099L;

	public UsuarioException(String mensaje){
		super(mensaje);
	}

}