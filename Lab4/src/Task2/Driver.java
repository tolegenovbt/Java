package Task2;

import java.io.*;
import java.util.*;

public class Driver {
	
		static void wr() throws IOException {
			Course.save(new Vector<Course>());
			Instructor.save(new Vector<Instructor>());
			Textbook.save(new Vector<Textbook>());
	}
		static void writeLog(String message)
	    {
			
	        try(BufferedWriter bw = new BufferedWriter(new FileWriter("admin.txt", true)))
	        {
	            bw.write(message);
	            bw.close();
	        }
	        catch(IOException ex){
                  System.out.println("Can't read from from file");
	            //System.out.println(ex.getMessage());
	        }
	    }
		
		
		
		
		public static void userMode() throws ClassNotFoundException, IOException {
			//wr();
			
			Vector<Course> courses = Course.get();
			Vector<Instructor> instructors = Instructor.get();
			Vector<Textbook> textbooks = Textbook.get();
			
			Scanner in = new Scanner(System.in);
			int choice;
			System.out.println("You've logged as User!");
			point1: while(true) 
			{
				System.out.println("1 - Show courses");
				System.out.println("2 - Show instructors");
				System.out.println("3 - Show textbooks");
				System.out.println("4 - Go back");
				choice = in.nextInt();
				int i;
			    switch(choice)
			    {
			    case 1: 
			    	System.out.println("\nExisting courses: " + courses.size());
			    	i = 1;
			    	for(Course c: courses) {
			    		System.out.println("\n[" + i++ + "]  " + c.toString());
			    	}
			    	break;
			    case 2: 
			    	System.out.println("\nExisting instructors: " + instructors.size());
			    	i = 1;
			    	for(Instructor ins : instructors) {
			    		System.out.println("\n[" + i++ + "]  " + ins.toString());
			    	}
			    	break;
			    case 3: 
			    	System.out.println("\nExisting books: " + textbooks.size());
			    	i = 1;
			    	for(Textbook t: textbooks) {
			    		System.out.println("[" + i++ + "] - " + t.toString());
			    	}
			    	break;
			    case 4:
			    	return;
			    default:
			    	continue point1;
			    	
			    }
			    
			    System.out.println();
			  
			}
			
		}
		
		
		static void adminMode(String username, String password) throws IOException, ClassNotFoundException {
			//wr();
			
			BufferedReader br = new BufferedReader(new FileReader("admin.txt"));
			
			
			username = "Username: " + username;
			password = "Password: " + Objects.hash(password);
			
			String fileUsername;
			String filePassword;
			fileUsername = br.readLine();
			filePassword = br.readLine();
			br.close();
			
			if(!(fileUsername.equals(username) && filePassword.contentEquals(password))) {
				System.out.println("Wrong username or password \n");
				return;
			}
			
			Vector<Course> courses = Course.get();
	        Vector<Instructor> instructors = Instructor.get();
	        Vector<Textbook> textbooks = Textbook.get();
	        
	        System.out.println("\n-----------------------------");
	        System.out.println("You've logged in, Dear admin!");
	        System.out.println("-----------------------------\n");
			
	        writeLog(String.format("%s admin logged into a system\n",new Date().toString()));
	        Scanner in = new Scanner(System.in);
	        int choice;
	        
	        
	        point1: while(true) {
	        	
	        	System.out.println("[1] - Show courses");
	            System.out.println("[2] - Show instructors");
	            System.out.println("[3] - Show textbooks");
	            System.out.println("[4] - Add course");
	            System.out.println("[5] - Add instructor");
	            System.out.println("[6] - Add textbook");
	            System.out.println("[7] - Go back");
	            
	            choice = in.nextInt();
	            int i;
	            switch (choice)
	            {
	            case 1: 
			    	System.out.println("\nExisting courses: " + courses.size());
			    	i = 1;
			    	for(Course c: courses) {
			    		System.out.println("\n[" + i++ + "]  " + c.toString());
			    	}
			    	break;
			    case 2: 
			    	System.out.println("\nExisting instructors: " + instructors.size());
			    	i = 1;
			    	for(Instructor ins : instructors) {
			    		System.out.println("\n[" + i++ + "] - " + ins.toString());
			    	}
			    	break;
			    case 3: 
			    	System.out.println("\nExisting books: " + textbooks.size());
			    	i = 1;
			    	for(Textbook t: textbooks) {
			    		System.out.println("\n[" + i++ + "] - " + t.toString());
			    	}
			    	break;
			    case 4:
                    Course course = null;
                    String courseTitle;
                    Instructor instructor = null;
                    Textbook textbook = null;

                    System.out.println("Write down course's title, instructor and textbook:");
                    System.out.print("Course title: ");
                    courseTitle = in.next();


                    System.out.println("Now you need to add instructor:");
                    if(instructors.size() > 0) {
                    System.out.println("[1] - Choose one from existing.");
                    System.out.println("[2] - Create a new instructor.");
                    choice = in.nextInt();
                    }
                    else {
                    	System.out.println("Existing instructors: " + instructors.size());
                    	choice = 2;
                    }
                    
                    switch(choice){
                        case 1:
                            System.out.println("Existing instructors: " + instructors.size());
                            i=1;
                            for(Instructor ins: instructors)
                            {
                                System.out.println("[" + i++ + "] - " + ins.toString());
                            }
                            if(instructors.size() > 0 ) {
                            System.out.print("Enter index of existing instructor: ");
                            choice = in.nextInt();
                            instructor = instructors.elementAt(choice - 1);
                            writeLog(String.format("%s admin added new instructor \"%s\"\n", new Date().toString(), instructor));
                            System.out.println(String.format("\"%s\" instructor is chosen.", instructor));
                            }
                            break;
                        case 2:
                            System.out.println("Write down instructor's first name, last name, department and email: ");
                            String firstName = in.next();
                            String lastName = in.next();
                            String department = in.next();
                            String email = in.next();

                            instructor = new Instructor(firstName, lastName, department, email);
                            instructors.add(instructor);
                            Instructor.save(instructors);

                            writeLog(String.format("%s admin added new instructor \"%s\"\n", new Date().toString(), instructor));
                            break;
                        default:
                            System.out.println("Wrong input format!");
                            break;

                    }

                    System.out.println("Now you need to add textbook:");
                    if(textbooks.size() > 0) {
                    System.out.println("[1] - Choose one from existing.");
                    System.out.println("[2] - Create a new textbook.");
                    choice = in.nextInt();
                    }
                    else {
                    	System.out.println("Existing textbooks: " + textbooks.size());
                    	choice = 2;
                    }

                    switch(choice){
                        case 1:
                            System.out.println("Existing textbooks: " + instructors.size());
                            i=1;
                            for(Textbook t: textbooks)
                            {
                                System.out.println("[" + i++ + "] - " + t.toString());
                            }
                            
                            System.out.print("Enter index of existing textbook: ");
                            choice = in.nextInt();
                            textbook = textbooks.elementAt(choice - 1);
                            writeLog(String.format("%s admin added new textbook \"%s\"\n", new Date().toString(), textbook));
                            System.out.println(String.format("\"%s\" textbook is chosen.", textbook));
                            break;
                        case 2:
                            System.out.println("Write down textbook's title, author and isbn: ");
                            String title = in.next();
                            String author = in.next();
                            String isbn = in.next();

                            textbook = new Textbook(title, author, isbn);
                            textbooks.add(textbook);

                            writeLog(String.format("%s admin added new textbook \"%s\"\n", new Date().toString(), textbook));
                            break;
                        default:
                            System.out.println("Wrong input format!");
                            break;
                    }

                    course = new Course(courseTitle, textbook, instructor);
                    courses.add(course);
                    

                    writeLog(String.format("%s admin added new course \"%s\"\n", new Date().toString(), course));
                    break;

                case 5:
                    System.out.println("Write down instructor's first name, last name, department and email: ");
                    String firstName = in.next();
                    String lastName = in.next();
                    String department = in.next();
                    String email = in.next();

                    instructor = new Instructor(firstName, lastName, department, email);
                    instructors.add(instructor);
                    Instructor.save(instructors);

                    writeLog(String.format("%s admin added new instructor \"%s\"\n", new Date().toString(), instructor));
                    break;
                case 6:
                    System.out.println("Write down textbook's title, author and isbn: ");
                    String title = in.next();
                    String author = in.next();
                    String isbn = in.next();

                    textbook = new Textbook(title, author, isbn);
                    textbooks.add(textbook);
                    Textbook.save(textbooks);

                    writeLog(String.format("%s admin added new textbook \"%s\"\n", new Date().toString(), textbook));
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Wrong input format!");
                    continue point1;
            }
	       
	            
            Course.save(courses);
            Instructor.save(instructors);
            Textbook.save(textbooks);
            System.out.println("-------------------------------");
	            	
				
	        }
		}
		
		 public static void main(String[] args) throws IOException, ClassNotFoundException {
			    Scanner in = new Scanner(System.in);
		        String log;
		        String username;
		        String password;
		        while(true)
		        {
		            System.out.println("Log in as Admin - write <admin>");
		            System.out.println("Log in as User  - write <user>");
		            System.out.println("Quit the system - write <quit>");
		            log = in.next();
		            switch (log)
		            {
		                case "admin":
		                    System.out.println("Please, write your username:");
		                    username = in.next();
		                    System.out.println("Please, write your password:");
		                    password = in.next();
		                    adminMode(username, password);
		                    break;
		                case "user":
		                    userMode();
		                    break;
		                case "quit":
		                    System.exit(0);
		                default:
		                    System.out.println("Wrong input format!");
		                    break;
		            }
		            	
		        }
		    }
}
