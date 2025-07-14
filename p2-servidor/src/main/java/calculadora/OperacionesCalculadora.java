package calculadora;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/** Esta clase contiene la implementación final de cada operación disponible en la calculadora.
 * Debe contener un método público de instancia por cada método de la interfaz CalculadoraGUI.ICalculadora.
 * Para evitar confusiones, se recomienda que cada uno de los métodos citados anteponga 'implementacion' al
 * nombre del método de CalculadoraGUI.ICalculadora. Por ejemplo: si se desea crear el método que implementa
 * la suma, su nombre en esta clase será 'implementacionSumar'.
 */
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
	
	public double implementacionSumar (double o1, double o2) {
		wLock.lock();
		try {
			result = o1 + o2;
			return  result;
		}finally {
			wLock.unlock();
		}
		
	}
	
	public double implementacionRestar (double o1, double o2) {
		wLock.lock();
		try {
			result = o1 - o2;
			return result;
		}finally {
			wLock.unlock();
		}
	}

	public double implementacionMultiplicar (double o1, double o2) {
		wLock.lock();
		try {
			result = o1*o2;
			return result;
		}finally {
			wLock.unlock();
		}
	}
	
	public double implementacionDividir  (double o1, double o2) throws Exception{
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
	
	public double implementacionUR () {
		rLock.lock();
		try {
			return result;
		}finally {
			rLock.unlock();
		}
	}
	
	public void implementacionML () {
		wLock.lock();
		try {
			memory = 0;
		}finally {
			wLock.unlock();
		}
	}
	
	public void implementacionMA () {
		wLock.lock();
		try {
			memory += result;
		}finally {
			wLock.unlock();
		}
	}
	
	public double implementacionMO () {
		rLock.lock();
		try {
			return memory;
		}finally {
			rLock.unlock();
		}
	}
	
	public double implementacionCuadrado (double o) {
		wLock.lock();
		try {
			return o * o;
		}finally {
			wLock.unlock();
		}
	}
}

