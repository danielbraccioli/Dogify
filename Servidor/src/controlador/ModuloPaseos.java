package controlador;

import java.util.List;

import dto.*;
import negocio.*;

public class ModuloPaseos {
	
	private static ModuloPaseos instancia;

	public static ModuloPaseos getInstancia() {
		if (instancia == null)
			instancia = new ModuloPaseos();
		return instancia;
	}

	
	public List<PaseoDTO> recuperarPaseos() {
		Paseo paseo = new Paseo();
		return paseo.recuperarPaseos();
	}
	
}
