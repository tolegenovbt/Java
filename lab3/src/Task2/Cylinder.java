package Task2;


public class Cylinder extends Shapes{
    private double R;
    private double H;
    
    public Cylinder(double R, double H) {
		this.R = R;
		this.H = H;
	}
    
    public double volume() {
    	return PI*R*R*H;
    }
    
    public double surfaceArea() {
    	return 2*PI*R*(R+H);
    }
    
    public String getInfo() {
        return "Volume: " + volume() + "\nSurface Area: " + surfaceArea();
    }
}
