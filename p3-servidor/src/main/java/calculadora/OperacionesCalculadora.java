package calculadora;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

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
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private final ReadLock rLock;
	private final WriteLock wLock;
	public OperacionesCalculadora() {
		result = 0;
		memory = 0;
		rLock = lock.readLock();
		wLock = lock.writeLock();
	}
	
	@WebMethod(operationName = "implementacionSumar", action = "urn:ImplementacionSumar")
	public double implementacionSumar (@WebParam(name = "arg0") double o1, @WebParam(name = "arg1") double o2) {
		wLock.lock();
		try {
			result = o1 + o2;
			return  result;
		}finally {
			wLock.unlock();
		}
		
	}
	
	@WebMethod(operationName = "implementacionRestar", action = "urn:ImplementacionRestar")
	public double implementacionRestar (@WebParam(name = "arg0") double o1, @WebParam(name = "arg1") double o2) {
		wLock.lock();
		try {
			result = o1 - o2;
			return result;
		}finally {
			wLock.unlock();
		}
	}

	@WebMethod(operationName = "implementacionMultiplicar", action = "urn:ImplementacionMultiplicar")
	public double implementacionMultiplicar (@WebParam(name = "arg0") double o1, @WebParam(name = "arg1") double o2) {
		wLock.lock();
		try {
			result = o1*o2;
			return result;
		}finally {
			wLock.unlock();
		}
	}
	
	@WebMethod(operationName = "implementacionDividir", action = "urn:ImplementacionDividir")
	public double implementacionDividir  (@WebParam(name = "arg0") double o1, @WebParam(name = "arg1") double o2) throws Exception{
		wLock.lock();
		try {
			if( (o2 == 0) ) {
				if( o1 == 0 ) {
					throw new Exception("Indeterminación 0/0");
				}else throw new Exception("Operación entre 0");
			}else 
				result = o1/o2;
			return result;
			
		}finally {
			wLock.unlock();
		}
	}
	
	@WebMethod(operationName = "implementacionUR", action = "urn:ImplementacionUR")
	public double implementacionUR () {
		rLock.lock();
		try {
			return result;
		}finally {
			rLock.unlock();
		}
	}
	
	@WebMethod(operationName = "implementacionML", action = "urn:ImplementacionML")
	public void implementacionML () {
		wLock.lock();
		try {
			memory = 0;
		}finally {
			wLock.unlock();
		}
	}
	
	@WebMethod(operationName = "implementacionMA", action = "urn:ImplementacionMA")
	public void implementacionMA () {
		wLock.lock();
		try {
			memory += result;
		}finally {
			wLock.unlock();
		}
	}
	
	@WebMethod(operationName = "implementacionMO", action = "urn:ImplementacionMO")
	public double implementacionMO () {
		rLock.lock();
		try {
			return memory;
		}finally {
			rLock.unlock();
		}
	}
	
	@WebMethod(operationName = "implementacionGetOperaciones", action = "urn:ImplementacionGetOperaciones")
	public String[] implementacionGetOperaciones(@WebParam(name = "arg0") int nBotones) {
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
	
	@WebMethod(operationName = "implementacionOperar", action = "urn:ImplementacionOperar")
	public double implementacionOperar (@WebParam(name = "arg0") int nOperacion, @WebParam(name = "arg1") double o)throws Exception {
		wLock.lock();
		try {
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
		}finally {
			wLock.unlock();
		}
		
	}
}

