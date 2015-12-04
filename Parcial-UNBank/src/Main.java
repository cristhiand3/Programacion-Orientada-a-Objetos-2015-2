import java.util.*;
import java.io.*;
import entidades.*;
import servicios.*;

public class Main {
	static Scanner in = new Scanner (System.in);	//Entrada por teclado
	private static Banco miBanco=new Banco();		//se crea una variable banco (sucursal)
	static Cliente current;
	
	static Cliente NuevoCliente(String[] arg){
		Cliente aux =null;
		if ("platino".equals(arg[3])) aux=new CltPlatino(arg[0],arg[1]).setTipoCta(arg[4]);
		else if ("dorado".equals(arg[3])) aux=new CltDorado(arg[0],arg[1]).setTipoCta(arg[4]);
		else{ salida("Tipo de Cliente no encontado");return null;}
		miBanco.clientes.put(arg[0], aux);
		return aux;}
	static Prestamo NuevoPrestamo(String[] arg){
		current = miBanco.clientes.get(arg[0]);
		Prestamo aux=new Prestamo(current).setTipoPrst(arg[1]).setMonto(Integer.parseInt(arg[5]));
		aux.planPago=arg[4];
		aux.plazo=arg[2]+" "+arg[3];
		int a=0,b=0;
		if("d".equals(arg[3])) b=1;
		else if ("s".equals(arg[3])) b=7;	else if ("q".equals(arg[3])) b=15;
		else if ("m".equals(arg[3])) b=30;	else if ("a".equals(arg[3])) b=360;
		else System.out.println("Error: Plan de pagos (dias-D semanas-S meses-M)");
		if("d".equals(arg[3])) a=1;
		else if ("s".equals(arg[3])) a=7;	else if ("q".equals(arg[3])) a=15;
		else if ("m".equals(arg[3])) a=30;	else if ("a".equals(arg[3])) a=360;
		else System.out.println("Error: Plan de pagos (dias-D semanas-S meses-M)");
		aux.cuota=( (Integer.parseInt(arg[5])/ (b*Integer.parseInt(arg[2]))) *a);
		miBanco.deudores.put(arg[0], aux);
		return aux;}
	static void salida(String s){System.out.printf(s);}
	static void salida(int s){System.out.printf("%d",s);}
	static String entrada(){return in.next().toLowerCase();}
	

	public static void main(String[] args) {
		// Asigacion de rol
		System.out.printf("ingrese como: \t Cliente \t Cajero \t Gerente\n->");
		switch (entrada()){
		case "gerente" : OpcionesGerente();	break;
		case "cajero" : OpcionesCajero();	break;
		case "cliente": OpcionesCliente();	break;
		case "sesiones": salida("Cargar o Guardar una sesion: ");
						 if("cargar".equals(entrada()))desserializar(miBanco);
						 else serializar(miBanco);
						 main(args);break;
		default: 		salida("Error:Rol desconocido\n");main(args); break;}
	}
	
	static void OpcionesCliente(){
		System.out.printf("Ingrese su Nombre:");
		try {
			current = miBanco.clientes.get(entrada());
			salida("Que operacion desea realizar \n Consignar \t Retirar \t  Saldo \t  Deudas \t CancelarCta\n");
			sesionCliente();
		}
		catch (java.lang.NullPointerException e){
			salida("Error:Cliente no encontrado\n");OpcionesCliente();
		}		
	}
	static void sesionCliente(){
		salida("Clt \""+current.nombre+"\"->");
		switch (entrada()){
		case "saldo"	: salida(current.miCuenta.saldo()+"\n");	break;
		case "consignar": salida(" \tIngrese el monto:\t");current.miCuenta.consignar(Integer.parseInt(entrada()));break;
		case "retirar"	: salida(" \tIngrese el monto:\t");current.miCuenta.retirar(Integer.parseInt(entrada()));	break;
		case "deudas"	: deudas();
		case "cancelarcta": miBanco.clientes.remove(current.nombre);salida("Cuenta Eliminada");
		case "exit"	:	String[] a=null;main(a); break;
		default			: salida("Error ");OpcionesCliente(); break;}
		sesionCliente();		
	}
	static void deudas(){
		salida("Consultar \t Pagar\nClt \""+current.nombre+"\"->");
		switch (entrada()){
		case "consultar"	: 
			for(int i=0;i<current.miDeuda.size();i++)
				System.out.println("\t"+current.miDeuda.get(i).tipoPrestamo+" - "+current.miDeuda.get(i).deuda);
			break;
		case "pagar": salida("Seleccione el prestamo e ingrese el pago:\n");
			for(int i=0;i<current.miDeuda.size();i++)
				salida("\t("+i+") "+current.miDeuda.get(i).tipoPrestamo+" - "+current.miDeuda.get(i).deuda);
			current.miDeuda.get(Integer.parseInt(entrada())).pagar(Integer.parseInt(entrada()));
		break;
		case "exit"	:	String[] a=null;main(a); break;
		default			: salida("Error");OpcionesCliente(); break;}
		deudas();
	}
			
	static void OpcionesCajero(){
		salida("Crear \t nuevo-cliente \t nuevo-prestamo \nCajero->");
		String[] a=new String[6];
		switch (entrada()){
		case "nuevo-cliente"	: 
			salida(" \tNombre del cliente: \t");a[0]=entrada();
			salida(" \tDocumento del clte: \t");a[1]=entrada();
			salida(" \tContacto (Nombre #):\t");a[2]=entrada();a[3]=entrada();
			salida(" \tIng tipo de Cliente:\t");a[3]=entrada();
			salida(" \tIng tipo de cuenta: \t");a[4]=entrada();
			Cliente aux=NuevoCliente(a);
			if (aux != null){
				salida("Se creo el cliente \""+aux.nombre+"\"\n");OpcionesCajero();}
			else {salida("No se creo el cliente\n");OpcionesCajero();}
			break;
		case "nuevo-prestamo"	: 
			salida("\tNombre del cliente:\t");a[0]=entrada();
			salida("\tTipo  de  prestamo:\t");a[1]=entrada();
			salida("\tPlazo  del  prestamo:\t");a[2]=entrada();a[3]=entrada();
			salida("\tPlan de pagos (D M Q):\t");a[4]=entrada();
			salida("\tMonto del prestamo:\t");a[5]=entrada();
			Prestamo aul =NuevoPrestamo(a);
			if (aul != null){
				salida("Se realizo el prestamo a \""+aul.deudor.nombre+"\"\n");OpcionesCajero();}
			else {salida("No se creo el prestamo\n");OpcionesCajero();}
			break;
		case "exit"	:	main(a); break;
		default					: salida("Error\n");OpcionesCajero(); break;}
	}
	
	static void OpcionesGerente(){
		salida("Consultar \t Cobrar \nGerente->");
		String[] y=new String[0];
		switch (entrada()){
		case "consultar"	:
			salida("Prestamos \t Cuentas \t Clientes \nGerente->");
			String a=entrada();
			if("prestamos".equals(a)){
				Iterator it = miBanco.clientes.keySet().iterator();
				salida("\n Nombre \t TipoPrestamo \t Valor \t Estado\n");
				salida("***************************************************\n");
				while(it.hasNext()){
					String key = (String)it.next();
					for(int i=0;i<miBanco.clientes.get(key).miDeuda.size();i++)
						System.out.printf("* %5s \t %6s \t %6d \t %6s\n",
								key,
								miBanco.clientes.get(key).miDeuda.get(i).tipoPrestamo,
								miBanco.clientes.get(key).miDeuda.get(i).deuda,
								miBanco.clientes.get(key).miDeuda.get(i).estado
								);
				}
				salida("***************************************************\n");
			}
			else if("cuentas".equals(a)){
				Iterator it = miBanco.clientes.keySet().iterator();
				salida("\n Nombre \t TipoCta \t Saldo \n");
				salida("**********************************************\n");
				while(it.hasNext()){
					String key = (String)it.next();
					System.out.printf("* %5s \t %6s \t %6d \n",
							key,
							miBanco.clientes.get(key).miCuenta.TipoCuenta,
							miBanco.clientes.get(key).miCuenta.saldo());
				}
				salida("**********************************************\n");
			}
			else if("clientes".equals(a)){
				Iterator it = miBanco.clientes.keySet().iterator();
				salida("\n Nombre \t Tipo \t\t TipoCta \t Saldo \t\t Deudas\n");
				salida("********************************************************************************\n");
				while(it.hasNext()){
					
					String key = (String)it.next();
					System.out.printf("* %5s \t %5s \t %6s \t %6d ",
							key,
							miBanco.clientes.get(key).TipoClt,
							miBanco.clientes.get(key).miCuenta.TipoCuenta,
							miBanco.clientes.get(key).miCuenta.saldo());
					for(int i=0;i<miBanco.clientes.get(key).miDeuda.size();i++)	
						   salida( "\t"+miBanco.clientes.get(key).miDeuda.get(i).tipoPrestamo
						   + ": "+ miBanco.clientes.get(key).miDeuda.get(i).deuda 
						   +" -> "+miBanco.clientes.get(key).miDeuda.get(i).estado);
				salida("\n");
				}
				salida("********************************************************************************\n");
			}			
			else salida("Opcion no valida\n");
		break;
		case "cobrar"	: 
			ArrayList <Prestamo> deudores=new ArrayList<Prestamo>();
			ArrayList <String> seleccion=new ArrayList<String>();
			Iterator it = miBanco.deudores.keySet().iterator();
			int x=0;
			salida("\n id \t Nombre \t TipoPrestamo \t Valor \n");
			salida("**********************************************\n");
			while(it.hasNext()){
				String key = (String)it.next();
				for(int i=0;i<miBanco.deudores.get(key).deudor.miDeuda.size();i++){
					System.out.printf("* %3d \t %6s \t %6s \t %6d \n",
							x,
							key,
							miBanco.deudores.get(key).deudor.miDeuda.get(i).tipoPrestamo,
							miBanco.deudores.get(key).deudor.miDeuda.get(i).deuda);
					deudores.add(miBanco.deudores.get(key).deudor.miDeuda.get(i));
					x++;}
			}
			salida("**********************************************\n");
			salida("\tSeleccione los prestamos (P* ID ID c*|todos):\t");
			String l=entrada();
			if("todos".equals(l)){
				salida("\tIngrese el monto (|Cuota): \t");
				l=entrada();
				if(l.equals("cuota"))
					for(int i=0;i<deudores.size();i++)
						deudores.get(i).cobro(deudores.get(i).cuota);
				else
					for(int i=0;i<deudores.size();i++)
						deudores.get(i).cobro(Integer.parseInt(l));
			}else if("exit".equals(l))OpcionesGerente();
			else{
				String d="";
				while(in.hasNext()){
					d=entrada();
					if("c".equals(d))break;	//c para terminar la seleccion
					seleccion.add(d);
				}
				salida("\tIngrese el monto (|Cuota): \t");
				String monto=entrada();
				for(int b=0;b<seleccion.size();b++)
					deudores.get(Integer.parseInt(seleccion.get(b))).cobro(Integer.parseInt(monto));				
			}
		break;
		case "exit"	:	main(y); break;
		default					: salida("Error\n");OpcionesGerente(); break;
		}
		OpcionesGerente();
	}
	private static void serializar(Banco v) {
		salida("Guardando datos ...");
		try{
            FileOutputStream fos = new FileOutputStream("Emp.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(v);
            System.out.println(" Datos Guardados..!\n");
            oos.close();
            fos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }		
	}
	private static void desserializar(Banco v){
		salida("Cargando datos ...");
		try{             
            FileInputStream fis = new FileInputStream("Emp.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            miBanco = (Banco)ois.readObject();
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
