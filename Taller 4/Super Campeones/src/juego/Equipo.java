package juego;
import java.io.Serializable;
import java.util.*;

public class Equipo implements Serializable{
	public static ArrayList<Equipo> equipos;
	public String nombre;
	public ArrayList<Jugador> integrantes =new ArrayList<Jugador>();
	public ArrayList<Jugador> jugadores =new ArrayList<Jugador>();
	public HashMap <String, Integer> goles=new HashMap <String, Integer>();
	public HashMap <String, Integer> golesContra=new HashMap <String, Integer>();
	public HashMap <String, Integer> patidosJugados=new HashMap <String, Integer>();
	public HashMap <String, Integer> patidosGanados=new HashMap <String, Integer>();
	public HashMap <String, Integer> partidosEmpatados=new HashMap <String, Integer>();
	public HashMap <String, Integer> puntos=new HashMap <String, Integer>();

	public Equipo(String nombre) {
		this.nombre=nombre;
		if(equipos==null)equipos =new ArrayList<Equipo>();
		equipos.add(this);
	}
	public void inscribir(String torneo){
		goles.put(torneo, 0);
		golesContra.put(torneo, 0);
		patidosJugados.put(torneo, 0);
		patidosGanados.put(torneo, 0);
		partidosEmpatados.put(torneo, 0);
		puntos.put(torneo, 0);
	}

	public boolean reemplazar(Jugador in,Jugador out){
		integrantes.add(integrantes.indexOf(out), in);
		return true;
	}
	
	public boolean contratar(Jugador in){
		integrantes.add(in);
		return true;
	}
	public boolean despedir(Jugador out){
		integrantes.remove(out);
		return true;
	}
	public boolean seleccionarJugadores(){
		System.out.println("Selecione los jugadores con los que el equipo "+ nombre +" va a jugar el torneo");
		for(int i=0; i<=integrantes.size();i++){
			System.out.printf(integrantes.get(i).nombre+"\t");
			if (i%3==0) System.out.printf("\n");
		}
		
		return true;
	}

}
