
public class TestShapes {

	public static void main(String[] args) {
		IsoscelesTriangle tr =new IsoscelesTriangle(11,10);
		Parallelogram pr=new Parallelogram(2,5);
		Rectangle rc=new Rectangle(4,2);
		RectangleTriangle rt=new RectangleTriangle(3,4);
		
		System.out.println("Isosceles Triangle: \nArea: "+tr.calcularArea()+"\nPerimetro: "+tr.calcularPerimetro()+"\n\n");
		System.out.println("Parallelogram: \nArea: "+pr.calcularArea()+"\nPerimetro: "+pr.calcularPerimetro()+"\n\n");
		System.out.println("Rectangle: \nArea: "+rc.calcularArea()+"\nPerimetro: "+rc.calcularPerimetro()+"\n\n");
		System.out.println("Rectangle Triangle: \nArea: "+rc.calcularArea()+"\nPerimetro: "+rc.calcularPerimetro()+"\n\n");

	}

}
