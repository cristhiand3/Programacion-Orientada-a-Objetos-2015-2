package servicios;
import java.io.*;

public class CtaCorriente extends Cuenta implements Serializable{
	
	public CtaCorriente(){
		this.cobroMin=1000000;
		this.costoTransaccion=10000;
	}
	
	public boolean transaccion(int monto, String op){
		if(monto>cobroMin)
			saldo +=("consignar".equals(op)) ? monto-costoTransaccion : -monto-costoTransaccion;
		else saldo +=("consignar".equals(op)) ? monto : -monto;
		return true;
	}

}