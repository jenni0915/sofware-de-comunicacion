package cliente;

import entidades.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import CalculadoraGUI.ICalculadora;

/** Esta clase sirve para adaptar la interfaz de la clase calculadora.OperacionesCalculadora a la interfaz
 * de CalculadoraGUI.ICalculadora.
 * Se peude utilizar un adaptador de clase o de objeto.
 */
public class AdaptadorOperacionesCalculadoraGUI implements ICalculadora{
	
	private Cookie sessionId;
	
	private static String url = "http://localhost:8080/p4-servidor/rest/calculadora";

	public AdaptadorOperacionesCalculadoraGUI() {
		sessionId = null;
	}
	
	@Override
	public double dividir(double dividendo, double divisor) throws Exception {
		double result = 0.0;
		Client cliente = ClientBuilder.newClient();
		WebTarget target = cliente.target(url);
		target = target.path("/dividir").queryParam("dividendo", dividendo).queryParam("divisor", divisor);
		Builder peticion = target.request();
		peticion.accept(MediaType.APPLICATION_XML);
		if(sessionId != null)
			peticion = peticion.cookie(sessionId);
		final Response response =  peticion.get();
		if(response.getStatus() == 200) {
			final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
			if(sessionId == null)
				sessionId = thisSessionId;
			result = response.readEntity(Resultado.class).getResult();
		}else {
			throw new Exception(response.readEntity(String.class));
		}
		return result;
	}

	@Override
	public String[] getOperaciones(int numeroBotonesDisponibles) {
		String[] result = null;
		Client cliente = ClientBuilder.newClient();
		WebTarget target = cliente.target(url);
		target = target.path("/operaciones").queryParam("numeroOperaciones", numeroBotonesDisponibles);
		Builder peticion = target.request().accept(MediaType.APPLICATION_XML);
		
		if(sessionId != null)
			peticion = peticion.cookie(sessionId);
		final Response response =  peticion.get();
		if(response.getStatus() == 200) {
			final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
			if(sessionId == null)
				sessionId = thisSessionId;
		result = response.readEntity(Operaciones.class).getResult();
		}
		return result;
	}

	@Override
	public void memoriaAniadir() {
		Client cliente = ClientBuilder.newClient();
		WebTarget target = cliente.target(url);
		target = target.path("/memoria");
		Builder peticion = target.request().accept(MediaType.APPLICATION_XML);
		//peticion.accept(MediaType.TEXT_PLAIN);

		if(sessionId != null)
			peticion = peticion.cookie(sessionId);
		final Response response =  peticion.head();
		if(response.getStatus() == 200) {
			final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
			if(sessionId == null)
				sessionId = thisSessionId;
		}
	}

	@Override
	public void memoriaLimpiar() {
		Client cliente = ClientBuilder.newClient();
		WebTarget target = cliente.target(url);
		target = target.path("/memoria");
		Builder peticion = target.request().accept(MediaType.APPLICATION_XML);
		//peticion.accept(MediaType.TEXT_PLAIN);

		if(sessionId != null)
			peticion = peticion.cookie(sessionId);
		final Response response =  peticion.delete();
		if(response.getStatus() == 200) {
			final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
			if(sessionId == null)
				sessionId = thisSessionId;
			
		}
	}

	@Override
	public double memoriaObtener() {
		double result = 0.0;
		Client cliente = ClientBuilder.newClient();
		WebTarget target = cliente.target(url);
		target = target.path("/memoria");
		Builder peticion = target.request();
		peticion.accept(MediaType.APPLICATION_XML);
		peticion.accept(MediaType.TEXT_PLAIN);

		if(sessionId != null)
			peticion = peticion.cookie(sessionId);
		final Response response =  peticion.get();
		if(response.getStatus() == 200) {
			final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
			if(sessionId == null)
				sessionId = thisSessionId;
			result = response.readEntity(Resultado.class).getResult();
		}
		return result;
	}

	@Override
	public double multiplicar(double operando1, double operando2) {
		double result = 0.0;
		Client cliente = ClientBuilder.newClient();
		WebTarget target = cliente.target(url);
		target = target.path("/multiplicar").queryParam("operando1", operando1).queryParam("operando2", operando2);
		Builder peticion = target.request().accept(MediaType.APPLICATION_XML);
		//peticion.accept(MediaType.TEXT_PLAIN);

		if(sessionId != null)
			peticion = peticion.cookie(sessionId);
		Response response = (Response) peticion.get();
		if(response.getStatus() == 200) {
			final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
			if(sessionId == null )
				sessionId = thisSessionId;
			result = response.readEntity(Resultado.class).getResult();
		}
		return result;
	}

	@Override
	public double obtenerUltimoResultado() {
		double result = 0.0;
		Client cliente = ClientBuilder.newClient();
		WebTarget target = cliente.target(url);
		target = target.path("/ur");
		Builder peticion = target.request().accept(MediaType.APPLICATION_XML);
		//peticion.accept(MediaType.TEXT_PLAIN);

		if(sessionId != null)
			peticion = peticion.cookie(sessionId);
		Response response = peticion.get();
		if(response.getStatus() == 200) {
			final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
			if(sessionId == null )
				sessionId = thisSessionId;
			result = response.readEntity(Resultado.class).getResult();
		}
		return result;

	}

	@Override
	public double operar(int numeroDeOperacion, double operando) throws Exception {
		double result = 0.0;
		Client cliente = ClientBuilder.newClient();
		WebTarget target = cliente.target(url);
		target = target.path("/operar").queryParam("operacion", numeroDeOperacion).queryParam("operando", operando);
		Builder peticion = target.request().accept(MediaType.APPLICATION_XML);
		//peticion.accept(MediaType.TEXT_PLAIN);

		if(sessionId != null)
			peticion = peticion.cookie(sessionId);
		Response respuesta = (Response) peticion.get();
		if(respuesta.getStatus() == 200) {
			final Cookie thisSessionId = respuesta.getCookies().get("JSESSIONID");
			if(sessionId == null )
				sessionId = thisSessionId;
			result = respuesta.readEntity(Resultado.class).getResult();
		}
		return result;
	}

	@Override
	public double restar(double operando1, double operando2) {
		double result = 0.0;
		Client cliente = ClientBuilder.newClient();
		WebTarget target = cliente.target(url);
		target = target.path("/restar").queryParam("operando1", operando1).queryParam("operando2", operando2);
		Builder peticion = target.request().accept(MediaType.APPLICATION_XML);	
		//peticion.accept(MediaType.TEXT_PLAIN);

		if(sessionId != null)
			peticion = peticion.cookie(sessionId);
		Response respuesta = (Response) peticion.get();
		if(respuesta.getStatus() == 200) {
			final Cookie thisSessionId = respuesta.getCookies().get("JSESSIONID");
			if(sessionId == null )
				sessionId = thisSessionId;
			result = respuesta.readEntity(Resultado.class).getResult();
		}
		return result;
	}

	@Override
	public double sumar(double operando1, double operando2) {
		double result = 0.0;
		Client cliente = ClientBuilder.newClient();
		WebTarget target = cliente.target(url);
		target = target.path("/sumar").queryParam("operando1", operando1).queryParam("operando2", operando2);
		Builder peticion = target.request().accept(MediaType.APPLICATION_XML);
		//peticion.accept(MediaType.TEXT_PLAIN);

		if(sessionId != null)
			peticion = peticion.cookie(sessionId);
		Response respuesta = (Response) peticion.get();
		if(respuesta.getStatus() == 200) {
			final Cookie thisSessionId = respuesta.getCookies().get("JSESSIONID");
			if(sessionId == null )
				sessionId = thisSessionId;
			result = respuesta.readEntity(Resultado.class).getResult();
		}
		return result;
	}
	 
}
