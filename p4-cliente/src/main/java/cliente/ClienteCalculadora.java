package cliente;

import CalculadoraGUI.CalculadoraGUI;

/** Esta es la clase que contiene el método main() de la aplicación de la calculadora y de la aplicación cleinte de la calculadora.
 * 
 */
public class ClienteCalculadora {

	/** Este es el método inicial de la aplicación. En él basta con instanciar CalculadoraGUI
	 * pasándole una instancia nueva de una clase que implementa OperacionesCalculadoraGUI.
	 * @param args Argumentos del método main()
	 */
	public static void main(String[] args) {
		
		new CalculadoraGUI(new AdaptadorOperacionesCalculadoraGUI());
		
	}

}
