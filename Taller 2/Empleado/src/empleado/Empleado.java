/**
 * 
 */
package empleado;

public class Empleado {
	public String nombre,apellido;
	private double salarioMensual;
	
	public Empleado(String nombre, String apellido) {
		this.nombre		=nombre;
		this.apellido	=apellido;
	}
	public Empleado(String nombre, String apellido, double salario) {
		this(nombre,apellido);
		setSalario(salario);
	}
	public void setSalario(double valor)
	{	
		if(valor>0) salarioMensual =(double)valor;
		
	}
	public double getSalarioAnual()
	{	
		return salarioMensual*12;
		
	}

}
