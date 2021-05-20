package Task4;

public class Sort {

	static <E> void swap(E [] array,int i, int j) {
		E tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	static <E extends Comparable<E>> void shellSort(E [] array) { 
		int gap = array.length / 2;
		while (gap >= 1) {
		    for (int right = 0; right < array.length; right++) {
		       for (int c = right - gap; c >= 0; c -= gap) {
		           if (array[c].compareTo(array[c + gap]) > 0) {
		               swap(array, c, c + gap);
//		               E tmp = array[i];
//		       		array[i] = array[j];
//		       		array[j] = tmp;
		           }
		        }
		    }
		    gap = gap / 2;
		}
	}
	static <E extends Comparable<E>> void bubbleSort(E [] array) {
		boolean needIteration = true;
			while (needIteration) {
				needIteration = false;
				for (int i = 1; i < array.length; i++) {
					if (array[i].compareTo(array[i - 1]) < 0) {
						swap(array, i, i-1);
						needIteration = true;
					}
				}
			}
	}
}
