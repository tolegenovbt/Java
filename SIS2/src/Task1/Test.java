package Task1;

public class Test {
public static void main(String[] args) {
	Circuit a = new Resistor(3.0); 
	Circuit b = new Resistor(3.0); 
	Circuit c = new Resistor(6.0);
	Circuit d = new Resistor(3.0);
	Circuit e = new Resistor(2.0); 
	Circuit f = new Series(a, b); 
	Circuit g = new Parallel(c, d);
	Circuit h = new Series(g, e); 
	Circuit circuit = new Parallel(h, f);
	double R = circuit.getResistance();
	
	// 6||3 => 6 * 3 / (6 + 3) = 2
	// 2 + 2 = 4
	// 3 + 3 = 6
	// 4||6 => 4 * 6 / (4 + 6) = 2.4
	
	System.out.println(R);
}
}
