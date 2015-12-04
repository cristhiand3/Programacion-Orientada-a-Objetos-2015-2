package servicios;
import java.io.*;

import entidades.*;

public class PrstEstudio extends Prestamo implements Serializable{

	public PrstEstudio(Cliente prst) {
		super(prst);
		this.multa=5000;
	}

}
