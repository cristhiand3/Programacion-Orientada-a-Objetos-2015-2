package juego;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Main implements Serializable{
	static Scanner in =new Scanner(System.in);
	static ArrayList<ArrayList> datos=new ArrayList<ArrayList>();
	static String a;
	
	private static Jugador auxJ;
	private static Equipo auxE;
	private static Campeonato auxC;
	
	
	private static void salida(String s){System.out.printf(s);}
	private static String entrada(){ return in.next();}

	public static void main(String[] args) {
		
		salida("Campeonatos \t Equipos \t Jugadores\n");
		switch (entrada()){
		case "campeonatos":
			menuCampeonatos();
			break;
		case "equipos":
			menuEquipos();
			break;
		case "jugadores":
			menuJugadores();
			break;
		case "sesiones":
			switch (entrada()){
			case "cargar":
				desserializar();
				Jugador.jugadores=datos.get(0);
	            Equipo.equipos=datos.get(1);
	            Campeonato.campeonatos=datos.get(2);
				break;
			case "guardar":
				datos.add(0,Jugador.jugadores);
				datos.add(1,Equipo.equipos);
				datos.add(2,Campeonato.campeonatos);
				serializar(datos);
				break;
			default:salida("ERROR: Opcion no valida\n");main(args);
			break;	
			}
			break;
		case "exit":
			return;
		default:salida("ERROR: Opcion no valida\n");main(args);
		break;	
		}
		main(args);
	}
	
	/*
	 * 
	 * */
	public static void menuCampeonatos(){
		salida("Nuevo \t Seleccionar\n");
		switch (entrada()){
		case "nuevo":
			salida("\tIngrese el nombre: \t");
			new Campeonato(entrada());
			break;
		case "seleccionar":
			for(int i=1;i<=Campeonato.campeonatos.size();i++){
				System.out.printf("(%2s) %-15s \t",
						i-1,Campeonato.campeonatos.get(i-1).nombre);
				if(i%3==0)salida("\n");
			}
			salida("\n\tSeleccion:\t");
			auxC=Campeonato.campeonatos.get(in.nextInt());
			if(auxC==null)salida("null");
			salida("Tabla \t Partidos \t Equipos \n");
			switch (entrada()){
			case "tabla":
				auxC.tablaPosiciones();
				break;
			case "partidos":
				salida("Setear Resultados:\n");
				auxC.sorteo();
				auxC.setResultados();
				break;
			case "equipos":
				salida("Agregar\t Eliminar \n");
				switch (entrada()){
				case "agregar":
					listarEquipos();
					salida("\n\tSeleccione los equipos:\t");
					String a="";
					while(true){
						auxE=null;
						a=in.next();
						if(!a.equals("t")){
							auxE=Equipo.equipos.get(Integer.parseInt(a));
							auxE.inscribir(auxC.nombre);
							salida("\nSe Inscribio al equipo "+auxE.nombre+" en el campeonato "+auxC.nombre);
							auxC.equipos.add(auxE);
						}else break;
					}
					salida("\n");
					
					break;
				case "eliminar":
					for (int i=1;i<=auxC.equipos.size();i++){
						salida("("+(i-1)+") "+auxC.equipos.get(i-1).nombre+"\t");
						if(i%3==0)salida("\n");
					}
					a=auxC.nombre;
					while(true){
						a=in.next();
						if("t".equals(a))break;
						if("todos".equals(a)){auxC.equipos.clear();break;}
						auxC.equipos.remove(Integer.parseInt(a));
					}
					break;
				case "exit":
					String arg[]=null;
					main(arg);
					break;
				default:salida("ERROR: Opcion no valida\n");menuCampeonatos();
					break;				
				}
				break;
			}
			break;
		case "exit":
			String arg[]=null;
			main(arg);
			break;
		default:salida("ERROR: Opcion no valida\n");menuCampeonatos();
		break;				
		}		
		menuCampeonatos();
	}
	/*
	 * 
	 * */
	public static void menuEquipos(){
		salida("Nuevo \t Seleccionar\n");
		switch (entrada()){
		case"nuevo":
			salida("\tIngrese el nombre:\t");
			new Equipo(entrada());
			break;
		case "seleccionar":
			listarEquipos();
			salida("\n\tSeleccion:\t");
			auxE=Equipo.equipos.get(in.nextInt());
			salida("Contratar\t Reemplazar\t Despedir\n");
			switch(entrada()){
			case"contratar":
				listarJugadores();
				while(in.hasNext()){
					a=in.next();
					if("t".equals(a))break;
					auxE.contratar(Jugador.jugadores.get(Integer.parseInt(a)));
				}
				break;
			case"reemplazar":
				for(int i=1;i<=auxE.jugadores.size();i++){
					System.out.printf("(%2s) %-15s \t",
							i-1,auxE.jugadores.get(i-1).nombre);
					if(i%3==0)salida("\n");
				}
				salida("\n---------------------------------------------\n");
				listarJugadores();
				salida("\n\tJugador entrante, Jugador Saliente :\t");
				auxE.reemplazar(Jugador.jugadores.get(in.nextInt()),auxE.jugadores.get(in.nextInt()));
				break;
			case"despedir":
				for(int i=1;i<=auxE.jugadores.size();i++){
					System.out.printf("(%2s) %-15s \t",
							i-1,auxE.jugadores.get(i-1).nombre);
					if(i%3==0)salida("\n");
				}
				while(in.hasNext()){
					a=in.next();
					if("t".equals(a))break;
					auxE.despedir(auxE.jugadores.get(Integer.parseInt(a)));
				}
				break;
			default:salida("ERROR: Opcion no valida\n");menuEquipos();
			break;				
			}		
			
			break;
		case "exit":
			String arg[]=null;
			main(arg);
			break;
		default:salida("ERROR: Opcion no valida\n");menuEquipos();
		break;	
		}
		menuEquipos();
	}
	public static void menuJugadores(){
		salida("Nuevo \t Eliminar\n");
		switch (entrada()){
		case"nuevo":
			salida("\tIngrese el nombre:\t");
			new Jugador(entrada());
			break;
		case "eliminar":
			listarJugadores();
			while(in.hasNext()){
				a=in.next();
				if("t".equals(a))break;
				Jugador.jugadores.remove(Integer.parseInt(a));
			}
			break;			
		case "exit":
			return;	
		default:salida("ERROR: Opcion no valida\n");menuJugadores();
		break;	
		}
		menuJugadores();		
	}
	
	static void listarEquipos(){
		for(int i=1;i<=Equipo.equipos.size();i++){
			System.out.printf("(%2s) %-15s \t",
					i-1,Equipo.equipos.get(i-1).nombre);
			if(i%3==0)salida("\n");
		}
	}
	static void listarJugadores(){
		for(int i=1;i<=Jugador.jugadores.size();i++){
			System.out.printf("(%2s) %-15s \t",
					i-1,Jugador.jugadores.get(i-1).nombre);
			if(i%3==0)salida("\n");
		}
	}
	
	//t debe ser una lista serializable con elemnetos serializables
	public static <T extends List<? extends Serializable> & Serializable> void serializar(T t) {
		salida("Guardando datos ...");
		try{
            FileOutputStream fos = new FileOutputStream("Emp.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);
            System.out.println(" Datos Guardados..!\n");
            oos.close();
            fos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }		
	}	
	
	private static void desserializar(){
		salida("Cargando datos ...");
		try{             
            FileInputStream fis = new FileInputStream("Emp.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            datos=(ArrayList<ArrayList>)ois.readObject();
            System.out.println(" Datos cargados..!\n");
            ois.close();
            fis.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
	}

}
