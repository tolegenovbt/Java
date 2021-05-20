package week5;

public class Test {
	
	public static void main(String[] args)
	{
		Circle c1 = new Circle(Color.Red);
		Circle c2 = new Circle(Color.Black);
		Square s1 = new Square(Color.Red);
		Square s2 = new Square(Color.Black);
		AbstractShape[] shapes = new AbstractShape[4];
		shapes[0] = c1;
		shapes[1] = s1;
		shapes[2] = c2;
		shapes[3] = s2;
		
		for(int i=0;i<4;i++)
		{
			shapes[i].draw(); 
		}
		
	}
}
