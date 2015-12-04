
public class Main {

	public static void main(String[] args) {
		Punto coordenadas1,coordenadas2,coordenadas3,coordenadas4;
		
		coordenadas1=new Punto(1.1,1.2);
		coordenadas2=new Punto(6.6,2.8);
		coordenadas3=new Punto(6.2,9.9);
		coordenadas4=new Punto(2.2,7.4);
		Quadrilateral qa=new Quadrilateral(coordenadas1,coordenadas2,coordenadas3,coordenadas4);
		coordenadas1=new Punto(0.0,0.0);
		coordenadas2=new Punto(10.0,0.0);
		coordenadas3=new Punto(8.0,5.0);
		coordenadas4=new Punto(3.3,5.0);
		Trapezoid tr=new Trapezoid(coordenadas1,coordenadas2,coordenadas3,coordenadas4);
		coordenadas1=new Punto(5.0,5.0);
		coordenadas2=new Punto(11.0,5.0);
		coordenadas3=new Punto(12.0,20.0);
		coordenadas4=new Punto(6.0,20.0);
		Parallelogram pr=new Parallelogram(coordenadas1,coordenadas2,coordenadas3,coordenadas4);
		coordenadas1=new Punto(17.0,14.0);
		coordenadas2=new Punto(30.0,14.0);
		coordenadas3=new Punto(30.0,28.0);
		coordenadas4=new Punto(17.0,28.0);
		Rectangle re=new Rectangle(coordenadas1,coordenadas2,coordenadas3,coordenadas4);
		coordenadas1=new Punto(4.0,0.0);
		coordenadas2=new Punto(8.0,0.0);
		coordenadas3=new Punto(8.0,4.0);
		coordenadas4=new Punto(4.0,4.0);
		Square sq=new Square(coordenadas1,coordenadas2,coordenadas3,coordenadas4);
		
		System.out.println(qa+"\n");
		System.out.println(tr);
		tr.printDimensions();tr.printArea();
		System.out.println("\n");
		System.out.println(pr);
		pr.printDimensions();pr.printArea();
		System.out.println("\n");
		System.out.println(re);
		re.printDimensions();re.printArea();
		System.out.println("\n");
		System.out.println(sq);
		sq.printDimensions();sq.printArea();
		

	}

}
