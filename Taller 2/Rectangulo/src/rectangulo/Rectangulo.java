/**
 * 
 */
package rectangulo;

public class Rectangulo {
	private float ancho, largo;

	//	Constructor
	public Rectangulo() {
		ancho=10.0f;
		largo=15.0f;
	}
	public Rectangulo(float largo,float ancho) {
		set("largo",largo);
		set("ancho",ancho);
	}
	public void set(String variable, float valor)
	{	
		if(valor %1 !=0 &&(0.0f<=valor&&valor<20.0f)){
			if(variable=="ancho")		ancho=(float)valor;
			else if (variable=="largo")	largo=(float)valor;
		}
		
	}
	public float get(String variable)
	{
		if(variable=="ancho")		return ancho;
		else if (variable=="largo")	return largo;
		return 0.0f;
	}
	public float perimetro()
	{
		return (2*ancho+ 2*largo);
	}
	public float area()
	{
		return (ancho*largo);
	}
}
