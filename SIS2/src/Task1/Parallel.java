package Task1;

public class Parallel extends Circuit{
private Circuit R1, R2;
    
    public Parallel(Circuit R1, Circuit R2) {
		this.R1 = R1;
		this.R2 = R2;
	}
    
    public Circuit getR1() {
    	return R1;
    }
    
    public Circuit getR2() {
    	return R2;
    }
    
    public void setR1(Circuit R1) {
    	this.R1 = R1;
    }
    
    public void setR2(Circuit R2) {
    	this.R2 = R2;
    }
    
	
	@Override
	public double getResistance() {	
		return (R1.getResistance()*R2.getResistance())/(R1.getResistance()+R2.getResistance());
	}

	@Override
	public double getPotentialDiff() {
		return R1.getPotentialDiff();
	}

	@Override
	public void applyPotentialDiff(double v) {
		R1.applyPotentialDiff(v);
		R2.applyPotentialDiff(v);
	}
    
}
