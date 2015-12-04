package servicios;
import java.io.*;

public class CtaJoven extends Cuenta implements Serializable{
	
	public CtaJoven(){
		this.cobroMin=700000;
		this.costoTransaccion=7000;
	}
	
	public boolean transaccion(int monto, String op){
		if(monto>cobroMin)
			saldo +=("consignar".equals(op)) ? monto-costoTransaccion : -monto-costoTransaccion;
		else saldo +=("consignar".equals(op)) ? monto : -monto;
		return true;
	}
}
