import java.math.*;

public class RectangleTriangle {
	private int base=1 ,heigth=1;
	
	public RectangleTriangle(int base, int height){
		this.base=base;
		this.heigth=height;
	}
	
	public int calcularArea(){ return (base*heigth)/2;}
	public double calcularPerimetro(){ return (base+heigth)+(Math.sqrt(Math.pow(base,2)*Math.pow(heigth,2)));}
	
	public int getBase(){ return this.base;}
	public int getHeigth(){ return this.heigth;}
	
	public void setBase(int v){ this.base=v; }
	public void setHeigth(int v){ this.heigth=v; }

}
