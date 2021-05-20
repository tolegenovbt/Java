package Task1.Interface;


public class TestShapes {
	  public static void main(String[] args) {
		  Cylinder cylinder = new Cylinder(2, 5);
	      Sphere sphere = new Sphere(8);
	      Cube cube = new Cube(6);

	      System.out.println(cylinder.getInfo() + "\n");
	      System.out.println(sphere.getInfo() + "\n");
	      System.out.println(cube.getInfo());
	}
	}
