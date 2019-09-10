/**
 * @author Jake Musleh
 * Email: jmusleh@wisc.edu
 * Title: Book.java
 * Description: A class that stores information about a singular book.
 */
public class Book {
	
	private static int nextId = 1; //Represents the identifier of the next book
	private final int ID; //The unique ID attributed to the specific book
	private String author; //The author of the book
	private String title; //The title of the book
	private Integer borrowerCardBarCode; //The bar code of the library card of the borrower of the book (null if book is available)
	
	/**
	 * Creates a new Book
	 * @param title - The title of the book
	 * @param author - The author of the book
	 */
	public Book(String title, String author)
	{
		this.author = author;
		this.title = title;
		ID = nextId;
		nextId++;
		borrowerCardBarCode = null;
	}
	
	
	/**
	 * Allows a user to check out a book (if book is not available, method does not nothing)
	 * @param borrowerCardBarCode - The bar code of the library card of the borrower
	 */
	public void borrowBook(Integer borrowerCardBarCode)
	{
		if(isAvailable())
		{
		this.borrowerCardBarCode = borrowerCardBarCode;
		}
	}
	
	
	/**
	 * Gets the author of the book
	 * @return - The author
	 */
	public String getAuthor()
	{
		return author;
	}
	
	
	/**
	 * Gets the bar code of the library card of the borrower
	 * @return - The bar code or null if book is available
	 */
	public Integer getBorrowerCardBarCode()
	{
		return borrowerCardBarCode;
	}
	
	
	/**
	 * Gets the ID of the book
	 * @return - The ID
	 */
	public int getID()
	{
		return ID;
	}
	
	
	/**
	 * Gets the title of the book
	 * @return - The title
	 */
	public String getTitle()
	{
		return title;
	}
	
	
	/**
	 * Checks whether or not book is available
	 * @return - True if book is available, false otherwise
	 */
	public boolean isAvailable()
	{
		if(this.borrowerCardBarCode == null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Resets borrowerCardBarCode to null, simulating the book being returned
	 */
	public void returnBook()
	{
		borrowerCardBarCode = null;
	}
}


