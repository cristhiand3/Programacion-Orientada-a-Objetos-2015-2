package empleado;
import java.text.DecimalFormat;

public class EmpleadoTest {

	public static void main(String[] args) {
		Empleado emp[] = new Empleado[6];
		
		//Inicializacion del Array
		emp[0]=new Empleado("Juan","Avila",700000f);
		emp[1]=new Empleado("Daniel","Murcia",900000f);
		emp[2]=new Empleado("rafael","Muños",1200000f);
		emp[3]=new Empleado("Andres","Toro",1500000f);
		emp[4]=new Empleado("Lyda","Torres",2000000f);
		
		//Impresion de la informacion
		for(int j=1;j<6;j++)
		{
			System.out.println("\n\n # \t Nombre Apellido \t Salario Anual (Año "+j+")");
			for(int i=0;i<5;i++)
			{
				emp[i].setSalario((emp[i].getSalarioAnual()+(emp[i].getSalarioAnual()*0.1))/12);
				System.out.printf ("Empleado"+(i+1)+" "+emp[i].nombre+" "+emp[i].apellido+"\t\t"
								   +"%,.0f %n",emp[i].getSalarioAnual());
			}

		}
			
		}
		

}
