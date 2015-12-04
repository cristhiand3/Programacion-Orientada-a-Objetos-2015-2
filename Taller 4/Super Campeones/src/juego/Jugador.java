package juego;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable{
	public static ArrayList<Jugador> jugadores;
	public String nombre;
	public int edad;
	public int goles;
	
	public String posicion;
	public int velocidad;
	public String estado;
	
	Jugador(String nombre){
		this.nombre=nombre;
	}
	
	Jugador(String nombre,int edad){
		this.nombre=nombre;
		this.edad=edad;
		if(jugadores.size()==0)jugadores =new ArrayList<Jugador>();
		jugadores.add(this);
	}

}
