package servidor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import calculadora.OperacionesCalculadora;
import entidades.*;
@Path("/calculadora")
public class OperacionesCalculadoraREST {
	
	/*private OperacionesCalculadora operacion;
	public OperacionesCalculadoraREST() {
		operacion = new OperacionesCalculadora();
	}*/
	
	@Context private HttpServletRequest hsr;
	private OperacionesCalculadora getOperacionesCalculadora () {
		final String ATRIBUTOCALCULADORA = "operaciones";
		final HttpSession sesion = hsr.getSession();
		OperacionesCalculadora operaciones =
				(OperacionesCalculadora)
				sesion.getAttribute(ATRIBUTOCALCULADORA);
		if(operaciones == null) {
			operaciones = new OperacionesCalculadora();
			sesion.setAttribute(ATRIBUTOCALCULADORA, operaciones);
		}
		return operaciones;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/operaciones")
	public Response operaciones(@QueryParam("numeroOperaciones")int nOperaciones) {
		ResponseBuilder rb = null;
		rb = Response.ok();
		String[] botonesOperaciones = getOperacionesCalculadora().implementacionGetOperaciones(nOperaciones);
		rb = rb.entity(new Operaciones(botonesOperaciones));
		return rb.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/operar")
	public Response operar(@QueryParam("operacion") int operacion, @QueryParam("operando") double operado) {
		ResponseBuilder rb = null;
		try {
			rb = Response.ok();
			rb = rb.entity(new Resultado(getOperacionesCalculadora().implementacionOperar(operacion, operado)));
		} catch (Exception e) {
			e.printStackTrace();
			rb= Response.status(Response.Status.PRECONDITION_FAILED);
		}
		return rb.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/sumar")
	public Response sumar(@QueryParam("operando1")double o1, @QueryParam("operando2") double o2) {
		ResponseBuilder rb = null;
		rb = Response.ok();
		rb.entity(new Resultado(getOperacionesCalculadora().implementacionSumar(o1, o2)));
		return rb.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/restar")
	public Response restar(@QueryParam("operando1")double o1, @QueryParam("operando2") double o2) {
		ResponseBuilder rb = null;
		rb = Response.ok();
		rb.entity(new Resultado(getOperacionesCalculadora().implementacionRestar(o1, o2)));
		return rb.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/multiplicar")
	public Response multiplicar(@QueryParam("operando1")double o1, @QueryParam("operando2") double o2) {
		ResponseBuilder rb = null;
		rb = Response.ok();
		rb.entity(new Resultado(getOperacionesCalculadora().implementacionMultiplicar(o1, o2)));
		return rb.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/dividir")
	public Response dividir(@QueryParam("dividendo")double o1, @QueryParam("divisor") double o2) {
		ResponseBuilder rb = null;
		double result = 0;
		try {
			rb = Response.ok();
			result = getOperacionesCalculadora().implementacionDividir(o1, o2);
			rb.entity(new Resultado(result));
		} catch (Exception e) {
			e.printStackTrace();
			rb= Response.status(Response.Status.PRECONDITION_FAILED);
			rb = rb.entity("Parámetro(s) inválidos");
		}
		return rb.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/ur")
	public Response ur() { 
		ResponseBuilder rb = null;
		rb = Response.ok();
		rb.entity(new Resultado(getOperacionesCalculadora().implementacionUR()));
		return rb.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/memoria")
	public Response mo() {
		ResponseBuilder rb = null;
		rb = Response.ok();
		rb.entity(new Resultado(getOperacionesCalculadora().implementacionMO()));
		return rb.build();
	}
	
	@HEAD
	@Path("/memoria")
	public Response ma() {
		ResponseBuilder rb = null;
		getOperacionesCalculadora().implementacionMA();
		rb = Response.ok();
		rb.entity("Resultado añadido.");
		return rb.build();
	}
	
	@DELETE
	@Path("/memoria")
	public Response ml() {
		ResponseBuilder rb = null;
		getOperacionesCalculadora().implementacionML();
		rb = Response.ok();
		rb.entity("Memoria limpiado.");
		return rb.build();
	}
	
	
}
