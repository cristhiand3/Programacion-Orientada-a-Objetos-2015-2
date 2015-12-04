package juego;
import java.io.Serializable;
import java.util.*;

public class Campeonato implements Serializable{
	public static ArrayList<Campeonato> campeonatos;
	public ArrayList<List<Equipo>> etapas=new ArrayList<List<Equipo>>();
	public ArrayList<Equipo> equipos=new ArrayList<Equipo>();
	public String nombre;
	Equipo[] aux;
	List<Equipo> o;
	
	Campeonato(String nombre){
		this.nombre=nombre;
		if(campeonatos==null)campeonatos =new ArrayList<Campeonato>();
		campeonatos.add(this);
	}	
	
	
	public void tablaPosiciones(){
		// Odeno el arrayList de mayor a menor
		Collections.sort(equipos, new Comparator<Equipo>() {
			@Override
			public int compare(Equipo p1, Equipo p2) {
				return new Integer(p2.puntos.get(nombre)).compareTo(new Integer(p1.puntos.get(nombre)));
			}
		});
		/*Ordenar datos
		Equipo aux;
		for(int i=0;i<Equipo.equipos.size()-1;i++)
			for(int j=0;j<Equipo.equipos.size()-i-1;j++)
				if(Equipo.equipos.get(j+1).puntos.get(this.nombre)<Equipo.equipos.get(j).puntos.get(this.nombre)){
					aux=Equipo.equipos.get(j+1);
					Equipo.equipos.add(j+1,Equipo.equipos.get(j));
					Equipo.equipos.add(j,aux);
				}*/
		
		System.out.printf("Pos \tEquipo\t\tPJ\tPG\tPE\tPP\tGF\tGC\tDG\tPTS\n");
		System.out.printf("*************************************************************************\n");
		for(int p=0;p<this.equipos.size();p++){
			Equipo auxE =this.equipos.get(p);
			System.out.printf("(%2d) %-15s \t%2d\t%2d\t%2d\t%2d\t%2d\t%2d\t%2d\t%2d\t\n",
					p,
					auxE.nombre,
					auxE.patidosJugados.get(this.nombre),
					auxE.patidosGanados.get(this.nombre),
					auxE.partidosEmpatados.get(this.nombre),
					auxE.patidosJugados.get(this.nombre)-auxE.patidosGanados.get(this.nombre)-auxE.partidosEmpatados.get(this.nombre),
					auxE.goles.get(this.nombre),
					auxE.golesContra.get(this.nombre),
					auxE.goles.get(this.nombre)-auxE.golesContra.get(this.nombre),
					auxE.puntos.get(this.nombre)
					);
		}
	}
	
	public void sorteo(){
	    int n=equipos.size();  //numeros aleatorios
	    int k=n;  //auxiliar;
	    int[] numeros=new int[n];
        int[] resultado=new int[n];
        Random rnd=new Random();
        int res;

        //se rellena una matriz ordenada del 1 a n
        for(int i=0;i<n;i++){
            numeros[i]=i+1;
        }
	        
        for(int i=0;i<n;i++){
            res=rnd.nextInt(k);            
            resultado[i]=numeros[res];
            numeros[res]=numeros[k-1];
            k--;
        }
         /*se imprime el resultado;
        System.out.println("El resultado de la matriz es:");
        for(int i=0;i<n;i++){
        System.out.println(resultado[i]);
        }*/
        
		aux=new Equipo[this.equipos.size()];
		equipos.get(7);
		for(int j=0;j<this.equipos.size();j++){
			aux[resultado[j]-1]=this.equipos.get(j);
		}
		etapas.add(Arrays.asList(aux));
	}
        
	public void setResultados(){
		Scanner in =new Scanner (System.in);
		int a=etapas.get(0).size(),b=2;
		while (a!=2){
			a/=2;b++;
		}
		int ax=b;
		for(int et=0;et<(b-1);et++){
			System.out.printf("**************************");
			switch(this.equipos.size()/((int)Math.pow(2, et))){
			case 16:System.out.printf(" Octavos"); break;
			case 8: System.out.printf(" Cuartos"); break;
			case 4: System.out.printf(" SemiFinal ");  break;
			case 2: System.out.printf(" Final ");  break;
			default: System.out.printf(" Etapa"+(ax-4)); break;
			}
			System.out.printf(" *********************************\n");
			int eq=0;
			aux=new Equipo[(this.equipos.size()/((int)Math.pow(2, et+1)))];
			for(int i=0;i<etapas.get(et).size();i+=2){
				System.out.printf("\t"+etapas.get(et).get(i).nombre+" vs "+etapas.get(et).get(i+1).nombre+":\t");
				int m=in.nextInt(),n=in.nextInt();
				etapas.get(et).get(i).goles.put(this.nombre,etapas.get(et).get(i).goles.get(this.nombre)+m);
				etapas.get(et).get(i+1).goles.put(this.nombre,etapas.get(et).get(i+1).goles.get(this.nombre)+n);
				etapas.get(et).get(i).golesContra.put(this.nombre,etapas.get(et).get(i).golesContra.get(this.nombre)+n);
				etapas.get(et).get(i+1).golesContra.put(this.nombre,etapas.get(et).get(i+1).golesContra.get(this.nombre)+m);
				etapas.get(et).get(i).patidosJugados.put(this.nombre,etapas.get(et).get(i).patidosJugados.get(this.nombre)+1);
				etapas.get(et).get(i+1).patidosJugados.put(this.nombre,etapas.get(et).get(i+1).patidosJugados.get(this.nombre)+1);
				
				if(m>n){
					etapas.get(et).get(i).patidosGanados.put(this.nombre, etapas.get(et).get(i).patidosGanados.get(this.nombre)+1);
					etapas.get(et).get(i).puntos.put(this.nombre, etapas.get(et).get(i).puntos.get(this.nombre)+3);
				}
				else if(m==n){
					etapas.get(et).get(i).puntos.put(this.nombre, etapas.get(et).get(i).puntos.get(this.nombre)+1);
					etapas.get(et).get(i).partidosEmpatados.put(this.nombre, etapas.get(et).get(i).partidosEmpatados.get(this.nombre)+1);
					etapas.get(et).get(i+1).puntos.put(this.nombre, etapas.get(et).get(i+1).puntos.get(this.nombre)+1);
					etapas.get(et).get(i+1).partidosEmpatados.put(this.nombre, etapas.get(et).get(i+1).partidosEmpatados.get(this.nombre)+1);
				}
				else {
					etapas.get(et).get(i+1).patidosGanados.put(this.nombre, etapas.get(et).get(i+1).patidosGanados.get(this.nombre)+1);
					etapas.get(et).get(i+1).puntos.put(this.nombre, etapas.get(et).get(i+1).puntos.get(this.nombre)+3);
				}
				
				aux[eq]=(etapas.get(et).get(i).goles.get(this.nombre) < etapas.get(et).get(i+1).goles.get(this.nombre))?etapas.get(et).get(i+1):etapas.get(et).get(i);
				eq++;
			}
			etapas.add(Arrays.asList(aux));
			ax--;
		}
	}
}
