package test;

import java.awt.geom.Point2D;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dto.ClienteDTO;
import dto.PaseoDTO;
import dto.ReservaDTO;
import dto.UsuarioDTO;
import excepciones.PaseoException;
import excepciones.UsuarioException;
import maps.java.Geocoding;
import maps.java.MapsJava;
import maps.java.Route;
import rmi.ObjetoRemoto;

public class test {

	public static void main(String[] args) {	
		Geocoding ObjGeocod=new Geocoding();
		MapsJava.setKey("AIzaSyDkBgIxRpAnjSJS4WeovRC4kiriTxrpD6A");
        try {     
            Point2D.Double resultadoCD=ObjGeocod.getCoordinates("Buenos Aires, UADE");
            System.out.println("Las coordenadas de \"Buenos Aires, Obelisco\", son: " +
                    resultadoCD.x + "," + resultadoCD.y);
            
            System.out.println("Los resultados obtenidos para la búsqueda de dirección de " +
                    resultadoCD.x + "," + resultadoCD.y + " son:");
            ArrayList<String> resultadoCI=ObjGeocod.getAddress(resultadoCD.x,resultadoCD.y);
            for(String item:resultadoCI){
                System.out.println(item);
            }
            
            
            Route ObjRout=new Route();
            ArrayList<String> intermedios = new ArrayList<String>();
            intermedios.add("Buenos Aires, Thames 516");
            intermedios.add("Buenos Aires, Moreno 970");
            intermedios.add("Buenos Aires, Camargo 1021");
            String[][] resultado=ObjRout.getRoute("Buenos Aires, Congreso", "Buenos Aires, UADE", intermedios, Boolean.TRUE, Route.mode.walking, Route.avoids.nothing);
            for(int i=0;i< resultado.length;i++){
               System.out.println("Tramo " + i + ":");
               for(int j=0;j< resultado [0].length;j++){
                  System.out.print(resultado[i][j] + "\t");
               }
            }
        } catch (Exception e) {
           
        }
	}
	
	private static void listarReservasCliente() {
		ClienteDTO usuario = new ClienteDTO();
		usuario.setIdUsuario(2);
		List<ReservaDTO> r = new ArrayList<ReservaDTO>();
		
		
		try {
			r=ObjetoRemoto.getInstance().reservasCliente(usuario);
			
			for (ReservaDTO r2 : r){
				System.out.println(r2.getIdReserva());
				
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
	}

	public static void login(){
		
		UsuarioDTO usuario = new UsuarioDTO();

		
		try {
			usuario= ObjetoRemoto.getInstance().loginUsuario("cliete1@gmail.com","cliente1");
			if (usuario==null){
				System.out.println("No encontro el usuario");
			}
			else
				System.out.println("Encontro el usuario");
				
		} catch (RemoteException | UsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void listarpaseos(){
		List<PaseoDTO> paseos = new ArrayList<PaseoDTO>();
		
		Date fecha = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018,05,25,00,00,00);
		fecha = calendar.getTime();
		
		PaseoDTO paseo = new PaseoDTO();
		
		try{
			paseos = ObjetoRemoto.getInstance().buscarPaseosByFechaBarrio(fecha,"Monserrat");
	
			for (PaseoDTO pas : paseos){
				System.out.println(pas.getIdPaseo());
				
				UsuarioDTO usuario = new UsuarioDTO();
				usuario.setIdUsuario(1);
	/*			if (ObjetoRemoto.getInstance().reservarPaseo(usuario, pas)== true){
					System.out.println("Reserva OK");
				}
*/
			
				
				
			}
			
		
		} catch (RemoteException | PaseoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
