package servidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmiCalculadora.ICalculadoraRMI;

public class ServidorCalculadora {

	public static void main(String[] args) {
		
		try {
			ICalculadoraRMI operaciones = new AdaptadorOperacionesCalculadoraRMI();
			ICalculadoraRMI remoteStub = (ICalculadoraRMI)UnicastRemoteObject.exportObject(operaciones, 0);
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("Calculadora", remoteStub);
			System.out.println("El servidor RMI está atendiento... ");
		} catch (RemoteException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
