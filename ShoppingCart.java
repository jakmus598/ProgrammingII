/**
 * @author Jake Musleh
 * Email: jmusleh@wisc.edu
 * Title: Shopping Cart
 * Description: This class mimics the functionality of a shopping cart. The user can modify
 * their cart by adding and removing items and can checkout once they have finalized
 * their cart.Per instruction, this program assumes that the user does not enter any invalid input
 * 		
 */

import java.util.Scanner;

public class ShoppingCart {
	private static final int CART_CAPACITY = 20; //Capacity of any cart
	private static final double TAX_RATE = 0.05; //Tax on each item purchased
	
	//Array of tbe items that can be added to the user's shopping cart and their prices
	public static final String[][] MARKET_ITEMS = new String[][] {{"Apple", "$1.59"},
		   {"Avocado", "$0.59"}, {"Banana", "$0.49"}, {"Beef", "$3.79"}, {"Blueberry", "$6.89"},
		   {"Broccoli", "$1.79"}, {"Butter", "$4.59"}, {"Carrot", "$1.19"}, {"Cereal", "$3.69"},
		   {"Cheese", "$3.49"}, {"Chicken", "$5.09"}, {"Chocolate", "$3.19"}, {"Cookie", "$9.5"},
		   {"Cucumber", "$0.79"}, {"Eggs", "$3.09"}, {"Grape", "$2.29"}, {"Ice Cream", "$5.39"},
		   {"Milk", "$2.09"}, {"Mushroom", "$1.79"}, {"Onion", "$0.79"}, {"Pepper", "$1.99"},
		   {"Pizza", "$11.5"}, {"Potato", "$0.69"}, {"Spinach", "$3.09"}, {"Tomato", "$1.79"}};
		   
		   
	/**
	 * Adds an item to the specified shopping cart
	 * @param index - The index of the item to be added in MARKET_ITEMS
	 * @param cart - The current shopping cart
	 * @param count - The total number of items currently in the cart
	 * @return - The total number of items in the cart after the attempted addition
	 */
	public static int add(int index, String[] cart, int count) 
	{
		if(count < cart.length)
		{
			cart[count] = MARKET_ITEMS[index][0];
			count++;
			return count;
		}
		else
		{
			System.out.println("Could not add item to cart");
			return count;
		}
	}
	
	/**
	 * Gets the total number of occurrences of an item in the specified shopping cart
	 * @param itemIndex - The index of the item in MARKET_ITEMS
	 * @param cart - The current shopping cart 
	 * @param count - The total number of items in the cart
	 * @return - The number of times specified item appears in the cart
	 */
	public static int occurrencesOf(int itemIndex, String[] cart, int count) 
	{
		int counter = 0;
		for(int i = 0; i < count; i++)
		{
			if(cart[i].equals(getItemDescription(itemIndex)))
			{
				counter++;
			}
		}
		return counter;
		
	}
	
	/**
	 * Removes an item from the specified shopping cart
	 * @param itemToRemove - The name of the item to remove
	 * @param cart - The current shopping cart
	 * @param count - The current number of items in the cart				
	 * @return - The number of items in the cart after the attempted removal
	 */
	public static int remove(String itemToRemove, String[] cart, int count)
	{
		int index = indexOf(itemToRemove, cart, count);
		if(index != -1)
		{
			cart[index] = cart[count - 1];
			cart[count - 1] = null;
			count--;
			return count;
		}
		else
		{
			System.out.println("Item not in cart");
			return count;
		}
			
	}
	
	/**
	 * Returns the subtotal price of all the items in the specified shopping cart
	 * @param cart - The specified shopping cart
	 * @param count - The total number of items in the cart
	 * @return - The subtotal price of the items in the cart
	 */
	public static double getSubtotalPrice(String[] cart, int count)
	{
		double subtotal = 0;
		for(int i = 0; i < count; i++)
		{
			subtotal += getItemPrice(cart[i]);
		}
		return subtotal;
	}
	
	
	/**
	 * Displays all the items available to purchase
	 */
	public static void printMarketCatalog() 
	{
		System.out.println("++++++++++++++++++++++++++++++\n" + "Item id" + "\t\t" + "Description" + "    \t" + "Price\n" + "++++++++++++++++++++++++++++++\n");
		for(int i = 0; i < MARKET_ITEMS.length; i++)
		{
			System.out.println(i + "\t\t" + MARKET_ITEMS[i][0] + "    \t" + MARKET_ITEMS[i][1]);
		}
		System.out.println("++++++++++++++++++++++++++++++\n");
	}
	
	
	/**
	 * Displays the contents of the specified shopping cart
	 * @param cart - The specified shopping cart
	 * @param count - The total number of items in the cart
	 */
	public static void displayCartContent(String[] cart, int count)
	{
		System.out.println("Cart content: ");
		for(int i = 0; i < count; i++)
		{
			System.out.println(cart[i] + ", ");
		}
		
	}
	
	/**
	 * Gets the description of a specified item
	 * @param itemIndex - The index of the item in MARKET_ITEMS
	 * @return - The description of said item 
	 */
	private static String getItemDescription(int itemIndex)
	{
		return MARKET_ITEMS[itemIndex][0];
	}
	
	/**
	 * Gets the price of an item in the specified shopping cart
	 * @param itemDescription - The description of said item
	 * @return - The price represented as a Double
	 */
	private static Double getItemPrice(String itemDescription)
	{
		for(int i = 0; i < MARKET_ITEMS.length; i++)
		{
			if(MARKET_ITEMS[i][0].equals(itemDescription))
			{
				return Double.parseDouble(MARKET_ITEMS[i][1].substring(1)); //Eliminates $ sign
			}
		}
		return -1.0;
		
	}
	
	/**
	 * Returns the index of an item in MARKET_ITEMS
	 * @param itemDescription - The description of the item
	 * @param cart - The shopping cart in which the item resides
	 * @param count - The total number of items in said shopping cart
	 * @return - The index of the specified item or -1 if the item is not in the cart
	 */
	private static int indexOf(String itemDescription, String[] cart, int count)
	{
		for(int i = 0; i < count; i++)
		{
			if(cart[i].equals(itemDescription))
			{
				return i;
			}
		}
		return -1;
	}

	/**
	 * Displays the list of commands that a user can call
	 */
	public static void displayCommandMenu()
	{
		System.out.println("[P] print the market catalog");
		System.out.println("[A <index>] add one occurrence of an item to the cart given its identifier");
		System.out.println("[C] checkout");
		System.out.println("[O <index>] number of occurrences of an item in the cart given its identifier");
		System.out.println("[R <index>] remove one occurrence of an item from the cart given its identifier");
		System.out.println("[Q]uit the application");
	}
	
	
	/**
	 * This method allows a user to interact with this program. It responds to user-entered
	 * commands according to the list of commands in displayCommandMenu().
	 * @param args - Command line arguments can be ignored by this method
	 */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String[] cart = new String[CART_CAPACITY];
		displayCommandMenu();
		String input = scanner.nextLine();
		int count = 0;
		while(input.charAt(0) != 'q' && input.charAt(0) != 'Q')
		{
			if(input.charAt(0) == 'p' || input.charAt(0) == 'P')
			{
				printMarketCatalog();
			}
			else if(input.charAt(0) == 'a' || input.charAt(0) == 'A')
			{
				String[] noWhitespace = input.split(" ");
				count = add(Integer.parseInt(noWhitespace[1]), cart, count);
				//count = add(5, cart, count);
			}
			else if(input.charAt(0) == 'c' || input.charAt(0) == 'C')
			{
				displayCartContent(cart, count);
				double subtotal = getSubtotalPrice(cart, count);
				System.out.println("Subtotal: " + subtotal);
				System.out.println("Total: " + (subtotal + TAX_RATE*subtotal));
			}
			
			else if(input.charAt(0) == 'o' || input.charAt(0) == 'O')
			{
				String[] noWhitespace = input.split(" ");
				System.out.println(occurrencesOf(Integer.parseInt(noWhitespace[1]), cart, count));
							
			}
			else if(input.charAt(0) == 'r' || input.charAt(0) == 'R')
			{
				String[] noWhitespace = input.split(" ");
				count = remove(MARKET_ITEMS[Integer.parseInt(noWhitespace[1])][0], cart, count);
			}
			
			else
			{
				System.out.println("Please enter a valid input");
			}
		
			displayCommandMenu();
			input = scanner.nextLine();
		}
		
	}
}
			   
	
	
