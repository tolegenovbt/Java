package Task4;



public class Test {
		
	public static void main(String[] args) {
		
		Chocolate twix = new Chocolate(180.0, "twix");
		Chocolate snickers = new Chocolate(150.0, "snickers");
		Chocolate kitkat = new Chocolate(170.0, "kitkat");
		
		Time tus = new Time(4, 11, 6);
		Time tus1 = new Time(5,12,56);
		Time tus2 = new Time(2,8,23);
		
		Time[] times = {tus,tus1,tus2};
		Chocolate [] chocolates = {twix,kitkat,snickers};

		
////////Bubble Sort Test
		System.out.println("----Bubble Sort Test----\n");
		Sort.bubbleSort(chocolates);
		
		for(Chocolate m: chocolates) {
			System.out.println(m.toString());
		}
        
		Sort.bubbleSort(times);
		for(Time t: times) {
			System.out.println(t.toStandard());
		}
			
////////Shell Sort Test	
		System.out.println("\n----Shell Sort Test----\n");
		Sort.bubbleSort(chocolates);
		
		for(Chocolate m: chocolates) {
			System.out.println(m.toString());
		}
        
		Sort.bubbleSort(times);
		for(Time t: times) {
			System.out.println(t.toStandard());
		}
		
	}
}
