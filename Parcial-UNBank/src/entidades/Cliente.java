package entidades;
import java.io.*;
import java.util.*;
import servicios.*;

public class Cliente implements Serializable{
	
	public String nombre;					//Nombre del cliente
	public String documento;				//Documento del cliente
	public String[] contacto;				//Contacto [Nombre, tel]
	public String TipoClt;					//Tipo de Cilente
	
	public Cuenta miCuenta;					//Cuenta del Cliente
	public ArrayList <Prestamo> miDeuda=new ArrayList<Prestamo>();	//Prestamos al cliente
	
	public Cliente (String nombre,String documento) {
		this.nombre=nombre;
		this.documento=documento;
	}
	public Cliente setTipoCta(String tipoCuenta){
		if ("corriente".equals(tipoCuenta)) miCuenta=new CtaCorriente();
		else if ("joven".equals(tipoCuenta)) miCuenta=new CtaJoven();
		else {System.out.println("Error: Tipo de cuenta invalida");return null;}
		miCuenta.TipoCuenta=tipoCuenta;
		return this;
	}
	
	public void setTipoPrst(String tipoPrestamo){
		if ("Hipoteca".equals(tipoPrestamo)) miDeuda.add(new PrstHipoteca(this));
		if ("Estudio".equals(tipoPrestamo)) miDeuda.add(new PrstEstudio(this));
	}
}







