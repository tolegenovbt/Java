package Task1;

public class Temperature {
	private double degree;
	private char scale;
	public Temperature(double temp)
	{
		this.degree =temp;
		this.scale = 'C';  
	}
	public Temperature(char scale)
	{
		this.degree = 0;
		this.scale = scale;
	}
	public Temperature(double temp, char scale)
	{
		this.degree = temp;
		this.scale = scale;
	}
	public Temperature()
	{
		this.degree = 0;
		this.scale = 'C';
	}
	public double toCelsius()
	{
		if(scale=='F')
			return 9*(degree/5)+32;
		else 
			return degree;
	}
	public double toFahrenheit()
	{
		if(scale == 'C')
			return 5*(degree-32)/9;
		else
			return degree;
	}
	public void setData(double temp)
	{
		this.degree = temp;
	}
	public void setData(char scale)
	{
		if(scale=='F' || scale == 'C')
		this.scale = scale;
	}
	public void setData(double temp, char scale)
	{
		if(scale=='F' || scale == 'C')
		{
			this.degree = temp;
			this.scale = scale;
		}
	}
	public char getScale()
	{
		return scale;
	}
}