/**
 * @author Jake Musleh
 * Email: jmusleh@wisc.edu
 * Title: Shopping Cart Tests
 * Description: A class that provides unit tests for ShoppingCart
 *
 */

public class ShoppingCartTests {
	
	
	/**
	 * Attempts to add an item to the cart and then check if occurrencesOf returns 1
	 * @return - True if successful, false if either add or occurrencesOf is false
	 */
	public static boolean testAddAndOccurrencesForOnlyOneItem()
	{
		boolean testPassed = true;
		
		String[] cart = new String[20]; //Creates an empty cart with capacity = 20
		int count = 0; //The number of items in the cart
		
		//Attempts to add an item to the cart
		count = ShoppingCart.add(4, cart , count);
		if(count != 1) //Checks that count was incremented
		{
			testPassed = false;
		}
		
		//Attempts to obtain the number of occurrences of the item just added to the cart
		int numberOfOccurrences = ShoppingCart.occurrencesOf(4, cart, count);
		if(numberOfOccurrences != 1) //Checks that numberOfOccurrences is correct
		{
			testPassed = false;
		}
		
		return testPassed;
	}
	
	/**
	 * Checks to make sure the number of items in the cart was correctly updated after adding an item
	 * @return - True if count is correctly updated, false otherwise
	 */
	public static boolean testCountIncrementedAfterAddingOnlyOneItem()
	{
		String[] cart = new String[20]; //Creates an empty cart with capacity = 20
		int count = 0; //The number of items in the cart
		
		//Attempts to add an item to the cart
		count = ShoppingCart.add(3, cart, count);
		if(count != 1) //Checks that the count was incremented
		{
			return false;
		}
		return true;
	}
	
	
	/**
	 * Attempts to remove an item from the cart
	 * @return - Whether or not the number of items in the cart returns to zero after the removal
	 */
	public static boolean testRemoveOnlyOneOccurrenceOfItem()
	{
		boolean testPassed = false;
		String[] cart = new String[20]; //Creates an empty cart with capacity = 20
		int count = 0; //The number of items in the cart
		
		count = ShoppingCart.add(1, cart, count);
		count = ShoppingCart.remove("Avocado", cart, count);
		if(count == 0)
		{
			testPassed = true;
		}
		return testPassed;
	}
	
	
	/**
	 * Attempts to remove an item that is not currently in the cart
	 * @return - True if the removal is unsuccessful, false otherwise
	 */
	public static boolean testRemoveItemNotFoundInCart()
	{
		boolean testPassed = true;
		String[] cart = new String[20]; //Creates an empty cart with capacity = 20
		int count = 0; //The number of items in the cart
		ShoppingCart.add(1, cart, count);
		count = ShoppingCart.remove("grape", cart, count);
		if(count == -1)
		{
			testPassed = true;
		}
		return testPassed;
	}
	
	
	/**
	 * Checks whether the subtotal of the items in the cart is correctly calculated
	 * @return - True if it is correct, false otherwise
	 */
	public static boolean testGetSubtotal()
	{
		boolean testPassed = true;
		String[] cart = new String[20]; //Creates an empty cart with capacity = 20
		int count = 0; //The number of items in the cart
		ShoppingCart.add(3,  cart, count);
		double subtotal = ShoppingCart.getSubtotalPrice(cart, count);
		if(subtotal != 3.79)
		{
			testPassed = false;
		}
		return testPassed;
		
	}
	
	/**
	 * Attempts to add an item to an already full cart
	 * @return - True if the addition was unsuccessful, false otherwise
	 */
	public static boolean testAddFullCart()
	{
		boolean testPassed = false;
		String[] cart = new String[20]; //Creates an empty cart with capacity = 20
		int count = 20; //The number of items in the cart
		if(ShoppingCart.add(3, cart, count) != count)
		{
			return testPassed;
		}
		testPassed = true;
		return testPassed;
	}
	
	/**
	 * Prints out the results of each test
	 * @param args - Unused
	 */
	public static void main(String[] args)
	{
		System.out.println("testAddAndOccurrencesForOnlyOneItem(): " + 
						  testAddAndOccurrencesForOnlyOneItem() + "\ntestCountIncrementedAfterAddingOnlyOneItem(): "
				          + testCountIncrementedAfterAddingOnlyOneItem() +"\ntestRemoveOnlyOneOccurrenceOfItem(): " +
				          testRemoveOnlyOneOccurrenceOfItem() + "\ntestRemoveItemNotFoundInCart(): " +
				          testRemoveItemNotFoundInCart() + "\ntestAddFullCart(): " + testAddFullCart());
		
	}

}
