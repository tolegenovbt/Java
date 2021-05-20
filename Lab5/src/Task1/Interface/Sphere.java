package Task1.Interface;


public class Sphere implements Shapes{
    private double R;
    
    public Sphere(double R) {
		this.R = R;
	}
    
    public double volume() {
    	 return 4/3*PI*R*R*R;
    }
    
    public double surfaceArea() {
    	 return 4*PI*R*R;
    }
    
    public String getInfo() {
        return "Sphere:\n" + "Volume: " + volume() + "\nSurface Area: " + surfaceArea();
    }
    
   
}