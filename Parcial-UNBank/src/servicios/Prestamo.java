package servicios;

import java.io.*;
import entidades.*;

public class Prestamo implements Serializable{
	public Cliente deudor;
	public String tipoPrestamo;
	public int deuda;			//valor del prestamo
	protected int multa=0;
	public String planPago;		//plan de pagos mensual, quincenal...
	public String plazo;		//plazo de pago
	public int cuota;			//valor de las cuotas
	public String estado="Activo";  		//activo o inactivo
	

	public Prestamo(Cliente prst) {
		try {
			deudor = prst;
		}
		catch (java.lang.NullPointerException e){
			System.out.printf("Error:Cliente no encontrado\n");
		}		
	}
	public Prestamo setTipoPrst(String tipoPrestamo){
		this.tipoPrestamo=tipoPrestamo;
		deudor.setTipoPrst(tipoPrestamo);
		return this;
	}
	public Prestamo setMonto(int monto){
		deudor.miCuenta.consignar(monto);
		deudor.miDeuda.add(this);
		this.deuda=monto;
		return this;
	}
	public void pagar(int monto){
		deudor.miCuenta.retirar(monto);
		this.deuda-=monto;
		if(this.deuda<=0)estado="Inactivo";
	}
	public void cobro(int monto){
		if(monto>deudor.miCuenta.saldo)this.deuda+=multa;
		else{
			deudor.miCuenta.retirar(monto);
			this.deuda-=monto;
			System.out.println("Se realizo el cobro a "+deudor.nombre);
			return;
		}
		System.out.println("No realizo el cobro a "+deudor.nombre+"(Aplica Multa de $" +multa+")");
	}

}