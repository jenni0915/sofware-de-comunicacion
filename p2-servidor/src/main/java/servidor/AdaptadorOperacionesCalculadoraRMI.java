package servidor;

import java.rmi.RemoteException;

import calculadora.OperacionesCalculadora;
import rmiCalculadora.CalculadoraException;
import rmiCalculadora.ICalculadoraRMI;

public class AdaptadorOperacionesCalculadoraRMI implements ICalculadoraRMI{
	
	final private OperacionesCalculadora calculadora;
	public AdaptadorOperacionesCalculadoraRMI() {
		calculadora = new OperacionesCalculadora();
	}
	@Override
	public double sumar(double o1, double o2) throws RemoteException {
		
		return calculadora.implementacionSumar(o1, o2);
	}

	@Override
	public double restar(double o1, double o2) throws RemoteException {
		// TODO Auto-generated method stub
		return calculadora.implementacionRestar(o1, o2);
	}

	@Override
	public double multiplicar(double o1, double o2) throws RemoteException {
		// TODO Auto-generated method stub
		return calculadora.implementacionMultiplicar(o1, o2);
	}

	@Override
	public double dividir(double dividendo, double divisor) throws RemoteException, CalculadoraException {
		// TODO Auto-generated method stub
		try {
			return calculadora.implementacionDividir(dividendo, divisor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new CalculadoraException(e.getMessage());
			return 0.0;
		}
		
	}

	@Override
	public double obtenerUltimoResultado() throws RemoteException {
		// TODO Auto-generated method stub
		return calculadora.implementacionUR();
	}

	@Override
	public void memoriaLimpiar() throws RemoteException {
		// TODO Auto-generated method stub
		calculadora.implementacionML();
	}
	
	@Override
	public void memoriaAniadir() throws RemoteException {
		// TODO Auto-generated method stub
		calculadora.implementacionMA();
	}

	@Override
	public double memoriaObtener() throws RemoteException {
		// TODO Auto-generated method stub
		return calculadora.implementacionMO();
	}

	@Override
	public double elevarAlCuadrado(double o) throws RemoteException {
		// TODO Auto-generated method stub
		return calculadora.implementacionCuadrado(o);
	}

}
