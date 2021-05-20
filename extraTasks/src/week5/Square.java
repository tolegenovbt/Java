package week5;

public class Square extends AbstractShape{
	
	private String shape;
	Square(Color color)
	{
		shape="[]";
		super.color = color;
	}
	@Override
	public void draw() {
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
