
public class Quadrilateral {
	protected Punto x1,x2,y1,y2;
	
	public Quadrilateral(Punto w,Punto x,Punto y,Punto z){
		this.x1=w;
		this.x2=x;
		this.y1=y;
		this.y2=y;
	}
	
	public double getWidth(){return x1.x-x2.x;}
	public double getHeight(){return x1.x-y1.x;}
	public double getArea(){return (x1.x-x2.x)*(x2.x-y2.x);}
	
	public void printDimensions(){System.out.println("Width is: "+getWidth()+"\nHeight is: "+getHeight());}
	public void printArea(){System.out.println("Area is: "+getArea());}
	
	
	public String toString(){return "Coordinates of "+this.getClass().getName()+" are:\n"+"("+x1+"),("+x2+"),("+y1+"),("+y2+")";}
}
