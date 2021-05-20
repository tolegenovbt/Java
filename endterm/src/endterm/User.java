package endterm;

import java.util.Vector;

public class User extends Account implements Cloneable{
	
	private Vector<Review> reviews;
	
	public User(String id, String login, String password){
		super(String id, String login, String password);
	}
	
	//overloading
	public User(String id, String login)
	{
		this.id = id;
		this.login = login;
		this.password = "password";
	}
	
	public void addReview(Review review)
	{
		reviews.add(review);
	}
	public Vector<Review> getReviews()
	{
		return reviews;
	}
	@Override
	public String toString()
	{
		return id+" "+ login+"/n";
	}
	
	public int equals(User user)
	{
		return (this.id.equals(user.id) && this.login.equals(user.login));
	}
}
