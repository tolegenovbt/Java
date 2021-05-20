package Task3;

public interface MyCollection {
		public void add(Object o);
		public Object at(int index);
		public int find(Object o);
		public boolean remove(Object o);
		public boolean remove(int index);
		public int size();
}