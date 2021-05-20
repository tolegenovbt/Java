package week5;

public class Circle extends AbstractShape {
	public String shape;
	Circle(Color color)
	{
		shape = "()";
		super.color = color;
	}
	@Override
	public void draw()
	{
		if(color == Color.Red)
			{	
				System.err.println(shape);
			}
			else
			{
				System.out.println(shape);
			}
	}
}
