package servicios;
import java.io.*;

public class Cuenta implements Serializable{
	protected int saldo=0;
	public String TipoCuenta;
	protected int cobroMin =0;			//no cobrar por taransacciones menores a
	protected int costoTransaccion=0;	//valor de la transaccion
	public boolean consignar(int monto)	{return transaccion(monto,"consignar");}
	public boolean retirar(int monto)	{return transaccion(monto,"retirar");}
	public boolean transaccion(int monto,String op)	{return false;}
	public int saldo()					{return saldo;}
}