
public class Rectangle {
	private int length=1 ,width=1;
	
	public Rectangle(int base, int height){
		this.length=base;
		this.width=height;
	}
	
	public int calcularArea(){ return (length*width);}
	public int calcularPerimetro(){ return (length+width);}
	
	public int getLength(){ return this.length;}
	public int getWidth(){ return this.width;}
	
	public void setLength(int v){ this.length=v; }
	public void setWidth(int v){ this.width=v; }

}
