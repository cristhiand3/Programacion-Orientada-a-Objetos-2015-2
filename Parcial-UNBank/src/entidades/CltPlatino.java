package entidades;
import java.io.*;

public class CltPlatino  extends Cliente implements Serializable{
	
		public CltPlatino(String nombre,String documento) {
			super(nombre,documento);
			this.TipoClt="Platino";
		}
}
