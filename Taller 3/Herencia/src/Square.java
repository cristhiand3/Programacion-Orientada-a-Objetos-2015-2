
public class Square extends Quadrilateral{
	
	public Square(Punto w,Punto x,Punto y,Punto z){
		super (w,x,y,z);
	}
	
	public double getWidth(){return x1.x-x2.x;}
	public double getHeight(){return getWidth();}
	public double getArea(){return getWidth()*getWidth();}
	
	public void printDimensions(){System.out.println("side is: "+getWidth());}
}
