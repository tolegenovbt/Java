package Task4;

public class MinMax {

	static class Values{
		private int x, y;
		public Values() {}
		
		Values(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return x + " " + y;
		}
	}
	
	static Values minmax(int values[]) {
		int max = -2147483646;
        int min = 2147483646;
        
        for(int i : values) {
        	max = Math.max(max, i);
        	min = Math.min(min, i);
        }
        
		return new Values(min,max);
	}

}
