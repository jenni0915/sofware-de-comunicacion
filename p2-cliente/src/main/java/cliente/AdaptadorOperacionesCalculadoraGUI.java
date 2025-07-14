package cliente;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import CalculadoraGUI.ICalculadora;
import rmiCalculadora.*;
/** Esta clase sirve para adaptar la interfaz de la clase calculadora.OperacionesCalculadora a la interfaz
 * de CalculadoraGUI.ICalculadora.
 * Se peude utilizar un adaptador de clase o de objeto.
 */
public class AdaptadorOperacionesCalculadoraGUI implements ICalculadoraRMI, ICalculadora{
	 
	 private Registry registry;
	 private ICalculadoraRMI stubCliente;
	public AdaptadorOperacionesCalculadoraGUI() {
		try {
			registry = LocateRegistry.getRegistry("Localhost");
			stubCliente = (ICalculadoraRMI)registry.lookup("Calculadora");
		}catch(RemoteException e) {
			System.err.println(e);
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			e.printStackTrace();
		}
		
	}
	@Override
	 public double sumar(double operando1, double operando2){
		try {
			return stubCliente.sumar(operando1, operando2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0.0;
		}
		
	 }
	@Override
	public double dividir(double dividendo, double divisor) throws CalculadoraException {
		try {
			return stubCliente.dividir(dividendo, divisor);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0.0;
		}
	}
	@Override
	public double elevarAlCuadrado(double operando) {
		try {
			return stubCliente.elevarAlCuadrado(operando);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0.0;
		}
	}
	@Override
	public void memoriaAniadir() {
		try {
			stubCliente.memoriaAniadir();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public double memoriaObtener() {
		try {
			return stubCliente.memoriaObtener();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0.0;
		}
	}
	@Override
	public double multiplicar(double operando1, double operando2) {
		try {
			return stubCliente.multiplicar(operando1, operando2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0.0;
		}
	}

	@Override
	public double restar(double operando1, double operando2) {
		try {
			return stubCliente.restar(operando1, operando2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0.0;
		}
	}

	@Override
	public double obtenerUltimoResultado() {
		try {
			return stubCliente.obtenerUltimoResultado();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0.0;
		}
	}
	@Override
	public void memoriaLimpiar() {
		try {
			stubCliente.memoriaLimpiar();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
