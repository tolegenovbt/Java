package Task1.Abstract;

public class Cube extends Shapes{
    private double x;
    
    public Cube(double x) {
		this.x = x;
	}
    
    public double volume() {
    	 return x*x*x;
    }
    
    public double surfaceArea() {
    	 return 6*x*x;
    }
    
    public String getInfo() {
        return "Cube:\n" + "Volume: " + volume() + "\nSurface Area: " + surfaceArea();
    }
}