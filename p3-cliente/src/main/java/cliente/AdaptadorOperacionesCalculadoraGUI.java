package cliente;


import java.net.URL;

import javax.xml.namespace.QName;

import CalculadoraGUI.ICalculadora;
import wsCalculadora.*;
/** Esta clase sirve para adaptar la interfaz de la clase calculadora.OperacionesCalculadora a la interfaz
 * de CalculadoraGUI.ICalculadora.
 * Se peude utilizar un adaptador de clase o de objeto.
 */
public class AdaptadorOperacionesCalculadoraGUI implements ICalculadora{
    private static final QName SERVICE_NAME = new QName("http://calculadora/", "OperacionesCalculadoraService");
	OperacionesCalculadoraService service ;
	OperacionesCalculadora port;
	
	public AdaptadorOperacionesCalculadoraGUI() {
        URL wsdlURL = OperacionesCalculadoraService.WSDL_LOCATION;
		service = new OperacionesCalculadoraService(wsdlURL,SERVICE_NAME);
		port = service.getOperacionesCalculadoraPort();
	}

	@Override
	public double dividir(double dividendo, double divisor) throws Exception_Exception {
		return port.implementacionDividir(dividendo, divisor);
	}

	@Override
	public String[] getOperaciones(int numeroBotonesDisponibles) {
		
		return port.implementacionGetOperaciones(numeroBotonesDisponibles).toArray(new String[0]);
		
	}

	@Override
	public void memoriaAniadir() {
		port.implementacionMA();
	}

	@Override
	public void memoriaLimpiar() {
		port.implementacionML();
	}

	@Override
	public double memoriaObtener() {
		return port.implementacionMO();
		
	}

	@Override
	public double multiplicar(double operando1, double operando2) {
		
		return port.implementacionMultiplicar(operando1, operando2);
	}

	@Override
	public double obtenerUltimoResultado() {
		return port.implementacionUR();
	}

	@Override
	public double operar(int numeroDeOperacion, double operando) {
		
		return port.implementacionOperar(numeroDeOperacion, operando);
	}

	@Override
	public double restar(double operando1, double operando2) {
		
		return port.implementacionRestar(operando1, operando2);
	}

	@Override
	public double sumar(double operando1, double operando2) {
		
		return port.implementacionSumar(operando1, operando2);
	}
	
	
}
