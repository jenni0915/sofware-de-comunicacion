package rmiCalculadora;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculadoraRMI extends Remote {
	
	public double sumar(double o1, double o2)throws RemoteException;
	public double restar(double o1, double o2)throws RemoteException;
	public double multiplicar(double o1, double o2)throws RemoteException;
	public double dividir(double dividendo, double divisor)throws RemoteException, CalculadoraException;
	public double obtenerUltimoResultado()throws RemoteException;
	public void memoriaLimpiar()throws RemoteException;
	public void memoriaAniadir()throws RemoteException;
	public double memoriaObtener()throws RemoteException;
	public double elevarAlCuadrado(double o)throws RemoteException;

}
