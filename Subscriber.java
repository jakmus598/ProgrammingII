/**
 * @author Jake Musleh
 * Title: Subscriber
 * Email: jmusleh@wisc.edu
 * Description: Models a subscriber to a library. This class stores personal information about the subscriber in addition to the 
 * books they checked out and returned.
 */

import java.util.ArrayList; //Used to store the books checked out and the books returned

public class Subscriber {
private final static int MAX_BOOKS_CHECKED_OUT = 10; //The maximum number of books that can be checked out at once
private static int nextCardBarCode = 2019000001; //The bar code of the next Subscriber

private int pin; //4 digit PIN used to identify the Subscriber
private final Integer CARD_BAR_CODE; //The subscriber's card bar code
private String name; //The subscriber's name
private String address; //Their address
private String phoneNumber; //The phone number

private ArrayList<Book> booksCheckedOut; //The books that they have checked out
private ArrayList<Book> booksReturned; //The books that they have returned

/**
 * Creates a new Subscriber and initializes its data fields
 * @param name - Their name
 * @param pin - Their PIN
 * @param address - Their address
 * @param phoneNumber - Their phone number
 */
public Subscriber(String name, int pin, String address, String phoneNumber)
{
	this.name = name;
	this.pin = pin;
	this.address = address;
	this.phoneNumber = phoneNumber;
	CARD_BAR_CODE = nextCardBarCode;
	nextCardBarCode++;
	booksCheckedOut = new ArrayList<Book>();
	booksReturned = new ArrayList<Book>();
}

/**
 * Adds a book to booksCheckedOut
 * @param b - The book to be added
 */
public void checkoutBook(Book b)
{
	if(booksCheckedOut.size() == 10)
	{
		System.out.println("Checkout failed: You cannot check out more than " + MAX_BOOKS_CHECKED_OUT + " books.");
	}
	else if(isBookInBooksCheckedOut(b))
	{
		System.out.println("You have already checked out " + b.getTitle());
	}
	else if(!b.isAvailable())
	{
		System.out.println("Sorry, this book is not currently available.");
	}
	else
	{
		b.borrowBook(CARD_BAR_CODE);
		booksCheckedOut.add(b);
	}
}

/**
 * Displays information about all of the books currently residing in booksCheckedOut
 */
public void displayBooksCheckedOut()
{
	if(booksCheckedOut.isEmpty())
	{
		System.out.println("No books checked out by this subscriber");
	}
	else
	{
		for(int i = 0; i < booksCheckedOut.size(); i++)
		{
		System.out.print("Book ID: " + booksCheckedOut.get(i).getID() + " ");
        System.out.print("Title: " + booksCheckedOut.get(i).getTitle() + " ");
        System.out.println("Author: " + booksCheckedOut.get(i).getAuthor());
		}
	}
}

/**
 * Displays information about all of the books currently residing in booksReturned
 */
public void displayHistoryBooksReturned()
{
	if (booksReturned.isEmpty())
	{
	      System.out.println("No books returned by this subscriber");
	}
	    else
	    {
	        for (int i = 0; i < booksReturned.size(); i++) {
	        System.out.print("Book ID: " + booksReturned.get(i).getID() + " ");
	        System.out.print("Title: " + booksReturned.get(i).getTitle() + " ");
	        System.out.println("Author: " + booksReturned.get(i).getAuthor());
	      }
	  }
	 
}
/**
 * Displays personal information about the subscriber
 */
public void displayPersonalInfo() {
    System.out.println("Personal information of the subscriber: " + CARD_BAR_CODE);
    System.out.println("  Name: " + name);
    System.out.println("  Address: " + address);
    System.out.println("  Phone number: " + phoneNumber);
}

/**
 * Gets the address of the subscriber
 * @return - The address
 */
public String getAddress()
{
	return address;
}

/**
 * Gets the bar code of the card that belongs to the subscriber
 * @return - The card bar code
 */
public Integer getCARD_BAR_CODE()
{
	return CARD_BAR_CODE;
}

/**
 * Gets the name of the subscriber
 * @return - The name
 */
public String getName()
{
	return name;
}

/**
 * Gets the phone number of the subscriber
 * @return - The phone number
 */
public String getPhoneNumber()
{
	return phoneNumber;
}


/**
 * Gets the subscriber's PIN
 * @return - Their PIN
 */
public int getPIN()
{
	return pin;
}

/**
 * Checks if a book is currently checked out by the subscriber
 * @param b - The book to check
 * @return - True if the book is currently checked out, false otherwise
 */
public boolean isBookInBooksCheckedOut(Book b)
{
	return booksCheckedOut.contains(b);
}


/**
 * Checks if a book has been returned by the subscriber
 * @param b - The book to check
 * @return - True if it has been returned, false otherwise
 */
public boolean isBookInBooksReturned(Book b)
{
	return booksReturned.contains(b);
}


/**
 * Removes a book from booksCheckedOut
 * @param b - The book to check
 */
public void returnBook(Book b)
{
	b.returnBook();
	booksReturned.add(b);
}


/**
 * Sets the address of the subscriber
 * @param address - Their address
 */
public void setAddress(String address)
{
	this.address = address;
}


/**
 * Sets the phone number of the subscriber
 * @param phoneNumber - Their phone number
 */
public void setPhoneNumber(String phoneNumber)
{
	this.phoneNumber = phoneNumber;
}

	

}
