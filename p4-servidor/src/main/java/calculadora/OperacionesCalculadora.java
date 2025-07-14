package calculadora;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/** Esta clase contiene la implementación final de cada operación disponible en la calculadora.
 * Debe contener un método público de instancia por cada método de la interfaz CalculadoraGUI.ICalculadora.
 * Para evitar confusiones, se recomienda que cada uno de los métodos citados anteponga 'implementacion' al
 * nombre del método de CalculadoraGUI.ICalculadora. Por ejemplo: si se desea crear el método que implementa
 * la suma, su nombre en esta clase será 'implementacionSumar'.
 */
@WebService(targetNamespace = "http://calculadora/", portName = "OperacionesCalculadoraPort", serviceName = "OperacionesCalculadoraService")
public class OperacionesCalculadora {
	
	double result ;
	double memory;
	
	public OperacionesCalculadora() {
		result = 0;
		memory = 0;
		
	}
	
	public synchronized double implementacionSumar (@WebParam(name = "arg0") double o1, @WebParam(name = "arg1") double o2) {
		
			result = o1 + o2;
			return  result;
		
		
	}
	
	public synchronized double implementacionRestar (@WebParam(name = "arg0") double o1, @WebParam(name = "arg1") double o2) {
		
			result = o1 - o2;
			return result;
		
	}

	public synchronized double implementacionMultiplicar (@WebParam(name = "arg0") double o1, @WebParam(name = "arg1") double o2) {
		
			result = o1*o2;
			return result;
		
	}
	
	public synchronized double implementacionDividir  (@WebParam(name = "arg0") double o1, @WebParam(name = "arg1") double o2) throws Exception{
		
			if( (o2 == 0) ) {
				if( o1 == 0 ) {
					throw new Exception("Indeterminación 0/0");
				}else throw new Exception("Operación entre 0");
			}else 
				result = o1/o2;
			return result;
			
		
	}
	
	@WebMethod(operationName = "implementacionUR", action = "urn:ImplementacionUR")
	public synchronized double implementacionUR () {
		
			return result;
		
	}
	
	public synchronized void implementacionML () {
		
			memory = 0;
		
	}
	
	public synchronized void implementacionMA () {
		
			memory += result;
		
	}
	
	public synchronized double implementacionMO () {
		
			return memory;
		
	}
	
	public synchronized String[] implementacionGetOperaciones(int nBotones) {
		String[] operaciones = new String[nBotones];
		switch(nBotones) {
		case 1:
			operaciones[0] = "X^2";
			break;
		case 2:
			operaciones[0] = "X^2";
			operaciones[1] = "sqrt(x)";
			break;
		case 3:
			operaciones[0] = "X^2";
			operaciones[1] = "sqrt(x)";
			operaciones[2] = "ln(x)";
			break;
		case 4:
			operaciones[0] = "X^2";
			operaciones[1] = "sqrt(x)";
			operaciones[2] = "ln(x)";
			operaciones[3] = "tg(x)";
			break;
		
		}
		return operaciones;
	}
	
	public synchronized double implementacionOperar (int nOperacion,  double o)throws Exception {
		
			switch(nOperacion) {
			case 0:
				result = Math.pow(o, 2);
				break;
			case 1:
				result = Math.sqrt(o);
				break;
			case 2:
				result = Math.log(o);
				break;
			case 3:
				result = Math.tan(o);
				break;
			default:
				throw new Exception("número de operación inválido.");
			}
			return result;
		
		
	}
}

