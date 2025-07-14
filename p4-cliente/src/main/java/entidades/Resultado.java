package entidades;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Resultado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double result;
	
	public Resultado() {}
	
	public Resultado(double resultado) {
		result = resultado;
	}
	@XmlElement
	public double getResult() {
		return result;
	}
	public void setResult(double resultado) {
		result = resultado;
	}
}
