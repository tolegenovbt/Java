package Task1;

public class Resistor extends Circuit {
    private double resistance;
    private double potentialDifference;
    
    public Resistor(double resistance) {
		this.resistance = resistance;
	}
    
    public void setResistance(double resistance) {
		this.resistance = resistance;
	}
	
	@Override
	public double getResistance() {
		return resistance;
	}

	@Override
	public double getPotentialDiff() {
		return potentialDifference;
	}

	@Override
	public void applyPotentialDiff(double v) {
		potentialDifference = v;
		
	}
	
}
