package rectangulo;

import java.util.Random;

public class Implementacion {
	public static void main(String[] args) {
		float minX=0.0f,maxX=20.0f;
		Random rand = new Random();
		Rectangulo figura[] = new Rectangulo[10];
		//Creacion del objeto usando constructor por defecto
		figura[0]=new Rectangulo();
		//Inicializacion del Array
		for(int i=1;i<10;i++) 
			figura[i]=new Rectangulo (/*largo*/(rand.nextFloat()*(maxX - minX)+ minX),
									  /*Ancho*/(rand.nextFloat()*(maxX - minX)+ minX));
		//Impresion de la informacion
		System.out.println("Figura \t\t Perimetro \t Area ");
		for(int i=0;i<10;i++)
		{
			System.out.println ("rectangulo"+i+": \t"
								+figura[i].perimetro()+", \t"
								+figura[i].area()
							   );
			
		}

	}

}
