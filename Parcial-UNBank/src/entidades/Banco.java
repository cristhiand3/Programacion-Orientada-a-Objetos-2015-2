package entidades;
import java.util.*;
import java.io.*;
import entidades.*;
import servicios.*;

public class Banco implements Serializable{
	public HashMap <String, Cliente> clientes=new HashMap <String, Cliente>();
	public HashMap <String, Prestamo> deudores=new HashMap <String, Prestamo>();
	
	public Banco() {
		// TODO Auto-generated constructor stub
	}

}
