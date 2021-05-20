package Task2;

import java.io.*;
import java.util.*;

public class Textbook implements Serializable {
    private String isbn;	
    private String title;
    private String author;
    
	public Textbook(String isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}
	
	public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
	
	@Override
	public String toString() {
		return title + " " + author + " " + isbn;
	}
	
	public boolean equals(Object object) {
		if(object == this ) return true;
		if(object instanceof Textbook) {
			Textbook t = (Textbook)object;
			return (this.isbn.equals(t.isbn) &&
					this.title.equals(t.title) &&
					this.author.equals(t.author));
		}
		return false;
	}
	
	 public static void save(Vector<Textbook> textbooks) throws IOException{
	        ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream("Textbooks.out"));
	        oos.writeObject(textbooks);
	        oos.close();
	    }

	    public static Vector<Textbook> get() throws IOException, ClassNotFoundException{
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Textbooks.out"));
	        Vector<Textbook> textbooks = (Vector<Textbook>) ois.readObject();
	        ois.close();
	        return textbooks;
	    }

}
