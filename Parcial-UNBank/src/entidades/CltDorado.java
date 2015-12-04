package entidades;
import java.io.*;

public class CltDorado extends Cliente implements Serializable {
	
	public CltDorado(String nombre,String documento) {
		super(nombre,documento);
		this.TipoClt="Dorado";
	}
}
