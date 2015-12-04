import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ahorcado {
	public Ahorcado(){
	
	}
	public Ahorcado(int x){
		System.out.print("x");
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Scanner entrada = new Scanner(System.in);				//Entrada por teclado
		Random rnd = new Random();								//Generar RandomNumber
		
		System.out.print("Numero de errores permitidos =");
		int ErroresPermitidos=entrada.nextInt();
		
		String[] palabras = LeerPalabras("");					//Lista de palabra para jugar	
		String Palabra = palabras[rnd.nextInt(9)];				//Palabra seleccionada para jugar
			
		char[] aCaracteres = Palabra.toCharArray();
		char[] ingresos = new char [aCaracteres.length+ErroresPermitidos];
		
	
		System.out.print("\n");
		
		for (int i=0;i<aCaracteres.length;i++)
			System.out.print(" _");
		System.out.print(" {");
		for (int i=0;i<ingresos.length;i++)
			System.out.print(" "+ingresos[i]);
		System.out.print(" } Err=0 \t ->");
		
		int x=0,Underline=0,Errores=0,FlagWin=0,ierr=0;
		String aux;	char[] v;
		while (x!=(aCaracteres.length+ErroresPermitidos)){
			aux=entrada.next();		//Captura la letra Ingresada
			v=aux.toCharArray();	//Letra ingresada a char[]
			ingresos[x] = v[0];		//Guarda la letra ingresada
			x++;/**//*#Errores*/
			FlagWin=0;ierr=0;
			for (int i=0;i<aCaracteres.length;i++){
				for (int j=0;j<x; j++){
					if(aCaracteres[i]==ingresos[j]){		//Coincidencia de una letra ingresada
						Underline=0;
						System.out.print(" "+ingresos[j]);  //Imprime la letra coincidente
						if(j==(x-1))ierr++;
						FlagWin++; break;
					}
					else Underline++;
				}
				if(Underline!=0){
					//System.err.print(Underline+" ->-> "+aCaracteres[i]+" i;"+i);
					System.out.print(" _");
				}
			}
			if(ierr==0)Errores++;
			System.out.print(" {");
			//Imprimer finales de linea
			for (int i=0;i<ingresos.length;i++)
				System.out.print(" "+ingresos[i]);
			System.out.print(" } Err="+Errores+"\t ->");
			//Si numero de coincidencias == Numero caracteres palabra
			if(FlagWin==aCaracteres.length){
				System.out.print("\n Felicitaciones! Ganaste");
				Errores=0;
				break;
			}
		}
		if(Errores==ErroresPermitidos){
			System.out.print("\n Perdiste, la palabra era \""+Palabra+"\"");
		}
		entrada.close();
	}

	 public static String[] LeerPalabras(String archivo) throws FileNotFoundException, IOException {
		 
		 /*String cadena;	
		 FileReader f = new FileReader(archivo);
		 BufferedReader b = new BufferedReader(f);
		 
		 int i=0;while((cadena = b.readLine())!=null)i++;*/
		 String [] palabras = new String [10];//i
		 /*
		 i=0;
		 while((cadena = b.readLine())!=null) {
			 palabras[i]=cadena;
			 i++;
		 }
		 b.close();*/
		 
		 palabras[0]="hola";
		 palabras[1]="esta";
		 palabras[2]="es";
		 palabras[3]="una";
		 palabras[4]="prueba";
		 palabras[5]="del";
		 palabras[6]="codigo";
		 palabras[7]="programa";
		 palabras[8]="ahorcado";
		 palabras[9]="programacion";
		 
		 return palabras;
     }
	
}
