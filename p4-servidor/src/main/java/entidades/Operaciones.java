package entidades;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Operaciones {
	private String[] result;

	public Operaciones() {
	}

	public Operaciones(String[] resultado) {
			result = resultado;
		}

	@XmlElement
	public String[] getResult() {
		return result;
	}

	public void setResult(String[] resultado) {
		result = resultado;
	}

}