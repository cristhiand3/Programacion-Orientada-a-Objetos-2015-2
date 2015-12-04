package servicios;
import java.io.*;

import entidades.*;

public class PrstHipoteca extends Prestamo implements Serializable{

	public PrstHipoteca(Cliente prst) {
		super(prst);
		this.multa=10000;
	}

}
