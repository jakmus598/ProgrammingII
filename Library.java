/**
 * @author Jake Musleh
 * Title: Library.java
 * Email: jmusleh@wisc.edu
 * Simulates a library, allowing subscribers to check out and return books from the available titles
 */

import java.util.ArrayList; //Used to store all the books the library has and all of their subscribers
import java.util.Scanner; //Used for user input

public class Library {
	
	private String address; //The address of the library
	private Librarian librarian; //The librarian (each library has only one)
	private ArrayList<Book> books; //The books that belong to the library
	private ArrayList<Subscriber> subscribers; //The subscribers
	
	/**
	 * Creates a new instance of Library and initalizes its fields
	 * @param address - The address of the library
	 * @param librarianUsername - The librarian's username
	 * @param librarianPassword - The librarian's password
	 */
	public Library(String address, String librarianUsername, String librarianPassword)
	{
		this.address = address;
		librarian = new Librarian(librarianUsername, librarianPassword);
		books = new ArrayList<Book>();
		subscribers = new ArrayList<Subscriber>();
	}
	
	/**
	 * Adds a book to books
	 * @param title - The title of the book
	 * @param author - The author of the book
	 */
	public void addBook(String title, String author)
	{
		Book b0 = new Book(title, author);
		books.add(b0);
		System.out.println("Book with title " + title + " is successfully added to library");
	}
	
	/**
	 * Adds a new subscriber to subscribers
	 * @param name - The name of the subscriber
	 * @param pin - Their PIN
	 * @param address - Their address 
	 * @param phoneNumber - Their phone number
	 */
	public void addSubscriber(String name, int pin, String address, String phoneNumber)
	{
		Subscriber s0 = new Subscriber(name, pin, address, phoneNumber);
		subscribers.add(s0);
		System.out.println("Library card with bar code " + s0.getCARD_BAR_CODE() + " is successfully issued to the new subscriber " + s0.getName());
	}
	
	/**
	 * Checks to see if a given book ID belongs to the library
	 * @param bookID - The ID of the given book
	 * @return - The book itself or null if it does not belong to the library
	 */
	public Book findBook(int bookID)
	{
		for(int i = 0; i < books.size(); i++)
		{
			if(books.get(i).getID() == bookID)
			{
				return books.get(i);
			}
		}
		System.out.println("Error: this book identifier didn't match up with any of our book identifiers");
		return null;
	}
	
	/**
	 * Checks to see if there is a subscriber that belongs to the library with the given card bar code
	 * @param cardBarCode - The given card bar code
	 * @return - The Subscriber with the given card bar code (or null if one does not exist)
	 */
	public Subscriber findSubscriber(int cardBarCode)
	{
		for(int i = 0; i < subscribers.size(); i++)
		{
			if(subscribers.get(i).getCARD_BAR_CODE() == cardBarCode)
			{
				return subscribers.get(i);
			}
		}
		System.out.println("Error: this card bar code didn't match any of ours");
		return null;
	}
	
	/**
	 * Finds all books written by a specific author
	 * @param author - The given author
	 * @return - An ArrayList of the books written by said author
	 */
	public ArrayList<Book> findBookByAuthor(String author)
	{
		ArrayList<Book> authorsBooks = new ArrayList<Book>();
		for(int i = 0; i < books.size(); i++)
		{
			if(books.get(i).getAuthor().equals(author))
			{
				authorsBooks.add(books.get(i));
			}
		}
		return authorsBooks;
	}
	
	/**
	 * Finds all the books with a given title
	 * @param title - The given title
	 * @return - An ArrayList of all the books with said title
	 */
	public ArrayList<Book> findBookByTitle(String title)
	{
		ArrayList<Book> booksWithGivenTitle = new ArrayList<Book>();
		for(int i = 0; i < books.size(); i++)
		{
			if(books.get(i).getTitle().equals(title))
			{
				booksWithGivenTitle.add(books.get(i));
			}
		}
		return booksWithGivenTitle;
	}
	
	/**
	 * Gets the address of the library
	 * @return - The address
	 */
	public String getAddress()
	{
		return address;
	}
	
	/**
	 * Gets the librarian of the library
	 * @return - The librarian
	 */
	public Librarian getLibrarian()
	{
		return librarian;
	}
	
	/**
	 * Removes the book from the library with the given ID
	 * @param ID - The given ID
	 * @return - The book removed
	 */
	public Book removeBook(int ID)
	{
		books.remove(findBook(ID));
		return findBook(ID);
	}
	
	/**
	 * Displays a list of all the books in the given ArrayList
	 * @param books - The given ArrayList
	 */
	public static void displayBooks(ArrayList<Book> books) {
	    for (int i = 0; i < books.size(); i++) {
	      System.out.print("<Book ID>: " + books.get(i).getID() + " ");
	      System.out.print("<Title>: " + books.get(i).getTitle() + " ");
	      System.out.print("<Author>: " + books.get(i).getAuthor() + " ");
	      System.out.println("<Is Available>: " + books.get(i).isAvailable());
	    }
	}
	
	/**
	 * Displays a menu that describes the valid inputs any user can enter
	 */
	private static void displayMainMenu()
	{
		 	System.out.println("\n--------------------------------------------------------");
		    System.out.println("     Welcome to our Book Library Management System");
		    System.out.println("--------------------------------------------------------");
		    System.out.println("Enter one of the following options:");
		    System.out.println("[1 <password>] Login as a librarian");
		    System.out.println("[2 <card bar code> <4-digits pin>] Login as a Subscriber");
		    System.out.println("[3] Exit"); // Exit the application
		    System.out.println("--------------------------------------------------------");
		 
	}
	
	/**
	 * Displays a menu that describes the valid inputs any subscriber can enter
	 */
	 private static void displaySubscriberMenu() {
		    System.out.println("\n--------------------------------------------------------");
		    System.out.println("    Welcome to Subscriber's Space");
		    System.out.println("--------------------------------------------------------");
		    System.out.println("Enter one of the following options:");
		    System.out.println("[1 <book ID>] Check out a book");
		    System.out.println("[2 <book ID>] Return a book");
		    System.out.println("[3 <title>] Search a Book by title");
		    System.out.println("[4 <author>] Search a Book by author");
		    System.out.println("[5] Print list of books checked out");
		    System.out.println("[6] Print history of returned books");
		    System.out.println("[7 <address>] Update address");
		    System.out.println("[8 <phone number>] Update phone number");
		    System.out.println("[9] Logout");
		    System.out.println("--------------------------------------------------------");
		  }
	 
	 /**
	  * Describes a menu that describes the valid inputs any librarian can enter
	  */
	 private static void displayLibrarianMenu() {
		    System.out.println("\n--------------------------------------------------------");
		    System.out.println("    Welcome to Librarian's Space");
		    System.out.println("--------------------------------------------------------");
		    System.out.println("Enter one of the following options:");
		    System.out.println("[1 <title> <author>] Add new Book");
		    System.out.println("[2 <name> <pin> <address> <phone number>] Add new subscriber");
		    System.out.println("[3 <card bar code> <book ID>] Check out a Book");
		    System.out.println("[4 <card bar code> <book ID>] Return a Book for a subscriber");
		    System.out.println("[5 <card bar code>] Display Personal Info of a Subscriber");
		    System.out.println("[6 <card bar code>] Display Books Checked out by a Subscriber");
		    System.out.println("[7] Display All Books");
		    System.out.println("[8 <book ID>] Remove a Book");
		    System.out.println("[9] Logout");
		    System.out.println("--------------------------------------------------------");
		  }
	 
	 /**
	  * Displays the goodbye message when the user wants to exit the program
	  */
	 private static void displayGoodByeLogoutMessage() {
		    System.out.println("\n--------------------------------------------------------");
		    System.out.println("       Thanks for Using our Book Library App!!!!");
		    System.out.println("--------------------------------------------------------");
	 }
	 
	 /**
	  * Accepts input from the user and executes their desired function
	  * @param scanner - The Scanner that reads input from the keyboard
	  */
	 public void readProcessUserCommand(Scanner scanner)
	 {
		 final String promptCommandLine = "ENTER COMMAND: ";
		 displayMainMenu(); //Displays the options the user can choose from
		 System.out.println(promptCommandLine);
		 String command = scanner.nextLine();
		 String[] commands = command.trim().split(" "); //Removes any leading or trailing whitespace from the input
		 while(commands[0].trim().charAt(0) != '3') //Exits the application
		 {
			 switch(commands[0].trim().charAt(0))
			 {
				 case '1': 
					 if(this.librarian.checkPassword(commands[1]))
					 {
						 readProcessLibrarianCommand(scanner);
					 }
					 else
					 {
						 System.out.println("Password incorrect");
					 }
					 break;
					 
				 case '2':
					 Subscriber s0 = this.findSubscriber(Integer.parseInt(commands[1]));
					 if(s0 != null)
					 {
						 if(s0.getPIN() == Integer.parseInt(commands[2]))
						 {
							 readProcessSubscriberCommand(s0, scanner);
						 }
						 else
						 {
							 System.out.println("Incorrect Pin");
						 }
					 }
					 else
					 {
						 System.out.println("Subscriber not found");
					 }
					 break;
					 
			 }
			 //Allows user to enter another input
			 displayMainMenu();
			 System.out.print(promptCommandLine);
			 command = scanner.nextLine();
			 commands = command.trim().split(" ");
		 }
		 
	 }
	 /**
	  * Accepts input and uses it to execute commands based off of the librarian menu
	  * @param scanner - The Scanner used to accept input
	  */
	 private void readProcessLibrarianCommand(Scanner scanner)
	 {
		 final String promptCommandLine = "ENTER COMMAND: ";
		 displayLibrarianMenu();
		 System.out.println(promptCommandLine);
		 String command = scanner.nextLine();
		 String[] commands = command.trim().split(" ");
		 while(commands[0].trim().charAt(0) != '9')
		 {
			 switch(commands[0].trim().charAt(0))
			 {
			 	case '1':
		          //Adds a new book to the library
		          String title = commands[1];
		          String author = commands[2];
		          addBook(title, author);
		          break;
		          
		        case '2':
		          //Adds a new subscriber to the library
		          String name = commands[1];
		          int pin = Integer.parseInt(commands[2]);
		          String address = commands[3];
		          String phoneNumber = commands[4];
		          addSubscriber(name, pin, address, phoneNumber);
		          break;
		          
		        case '3':
		          //Allows a librarian to check out a book for a subscriber
		          int cardBarCode = Integer.parseInt(commands[1]);
		          int bookID = Integer.parseInt(commands[2]);
		          Subscriber s = findSubscriber(cardBarCode);
		          Book b = findBook(bookID);
		          s.checkoutBook(b);
		          break;
		          
		        case '4':
		          //Allows a librarian to return a book for a subscriber
		          cardBarCode = Integer.parseInt(commands[1]);
		          bookID = Integer.parseInt(commands[2]);
		          s = findSubscriber(cardBarCode);
		          b = findBook(bookID);
		          s.returnBook(b);
		          break;
		          
		        case '5':
		          //Prints out the personal information associated with a given subscriber
		          cardBarCode = Integer.parseInt(commands[1]);
		          s = findSubscriber(cardBarCode);
		          s.displayPersonalInfo();
		          break;
		          
		        case '6':
		          //Prints out the books checked out by a given subscriber
		          cardBarCode = Integer.parseInt(commands[1]);
		          s = findSubscriber(cardBarCode);
		          s.displayBooksCheckedOut();
		          break;
		          
		        case '7':
		          //Prints out all the books in the library
		          displayBooks(books);
		          break;
		          
		        case '8':
		          //Removes a book from the library
		          bookID = Integer.parseInt(commands[1]);
		          removeBook(bookID);
		          break;
		          
		      }
			 
			 displayLibrarianMenu();
			 System.out.println(promptCommandLine);
			 command = scanner.nextLine();
			 commands = command.trim().split(" "); 
		 }
		 
	 }
	 
	 /**
	  * Accepts input and uses it to execute commands based off of the subscriber menu
	  * @param subscriber - The subscriber who wants to execute the commands
	  * @param scanner - The scanner that accepts keyboard input
	  */
	 private void readProcessSubscriberCommand(Subscriber subscriber, Scanner scanner)
	 {
		 final String promptCommandLine = "ENTER COMMAND: ";
		 displaySubscriberMenu();
		 System.out.println(promptCommandLine);
		 String command = scanner.nextLine(); //The command
		 String[] commands = command.trim().split(" "); //Trims the leading and trailing whitespace from command
		 while(commands[0].trim().charAt(0) != '9')
		 {
			 switch(commands[0].trim().charAt(0))
			 {
			 case '1':
				 //Check out a book
				 String bookID = commands[1];
				 Book b = this.findBook(Integer.parseInt(bookID));
				 subscriber.checkoutBook(b);
				 break;
				 
			 case '2':
				 //Return a book
				 b = this.findBook(Integer.parseInt(commands[1]));
		         subscriber.returnBook(b);
			     break;
			     
			 case '3':
				 //Find a book by title
				  String title = commands[1];
		          ArrayList<Book> books = findBookByTitle(title);
		          displayBooks(books);
		          break;
		          
		        case '4':
		          //Find a book by its author
		          String author = commands[1];
		          books = findBookByAuthor(author);
		          displayBooks(books);
		          break;
		          
		        case '5':
		          //Displays the list of books that have been checked out
		          subscriber.displayBooksCheckedOut();
		          break;
		          
		        case '6':
		          //Prints out all the books that have been returned
		          subscriber.displayHistoryBooksReturned();
		          break;
		          
		        case '7':
		          //Updates the subscriber's address
		          String address = commands[1];
		          subscriber.setAddress(address);
		          break;
		          
		        case '8':
		          //Updates the subscriber's phone number
		          String phoneNumber = commands[1];
		          subscriber.setPhoneNumber(phoneNumber);
		          break;
				 
			 }
			 displaySubscriberMenu();
			 System.out.println(promptCommandLine);
			 command = scanner.nextLine();
			 commands = command.trim().split(" ");
		 }
			 
	 }
	 
	 /**
	   * 
	   * Runs the application
	   * @param args - Unused
	   */
	  public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in); 
	    
	    //  a new library object
	    Library wisconsinLibrary = new Library("Madison, WI", "Josh", "wisclibrary");
	    
	    //Processes the user input
	    wisconsinLibrary.readProcessUserCommand(scanner);
	    displayGoodByeLogoutMessage();
	    scanner.close();
	  }
}
	
	


