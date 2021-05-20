package Task1.Interface;

public class Cylinder implements Shapes, HasFloorArea{
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
        return "Cylinder:\n" + "Volume: " + volume() + "\nSurface Area: " + surfaceArea()+ "\nFloor Area: " + FloorArea();
    }
    public double FloorArea()
    {
    	return PI*R*R;
    }
}