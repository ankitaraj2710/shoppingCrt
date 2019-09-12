import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

// HOW TO MAKE JUNIT TEST CASES
// ------------------------------
// 1. make 1 function per test case
// 2. put the @Test decorator on 
// 		top of the test case
// 3. write code for your test case
// 4. call assertEquals() in 
// 		your test case
// 5. Run the program
// 6. look at results!

public class ShoppingCartTest {

	ShoppingCart cart;
	Product phone;
	
	@Before
	public void setUp() throws Exception {
		// Make a new cart object that all test cases can use
		cart = new ShoppingCart();
		
		// Make a phone product that all test cases can use
		phone = new Product("iphone", 1500);
		
		// You can also put repeated "setup tests" in here, like this:
		// Recall that many of our test cases start by confirming that the 
		// 		num items in a brand new cart = 0
		// assertEquals(0,cart.getItemCount());
	}
	
	// ------------------------
	// R1: Create a new cart
	// ------------------------
	@Test
	public void testCreateCart() {
		// 2. check number of itmes in cart
		int a = cart.getItemCount();
		
		// 3. do the assert
		assertEquals(0, a);
		
	}
	
	// -----------------------------
	// R2: Empty carts have 0 items
	// -----------------------------
	@Test
	public void testEmptyTheCart() {
		// 1. Make a new cart
		// 			- done in the setup() function
		
		// 2. Add an item to the cart
		// - made a phone globally, also below, we make a hamburger for fun
		Product hamburger = new Product("burger", 10);
		cart.addItem(phone);
		cart.addItem(hamburger);
		
		// 3.Get rid of all items in the cart
		cart.empty();
		
		// 4. Check num items in cart === E = 0
		assertEquals(0, cart.getItemCount());
	}
	
	// -------------------------------
	// R3: Adding items to cart
	// -------------------------------
	@Test
	public void testAddProductToCart() {
		// EO1: When a new product is added, 
		// 		the number of items must be incremented  
		// EO2: When a new product is added, 
		// 		the new balance must be the 
		// 		sum of the previous balance plus 
		// 		the cost of the new product
		// ----------------------------
		// 	   1.  MAKE A SHOPPING CART!
		// 			- done in the setup() function
		
		//    2.  MAKE A PRODUCT
		// 			- done in the setup() function
		
		//    3.  CHECK BALANCE IN CART BEFORE ADDING PRODUCT
		//    			- PREV BAL
		double startBalance = cart.getBalance();
		assertEquals(0, startBalance, 0.01);

		//    4.  CHECK NUM ITEMS IN CART BEFORE ADDING PRODUCT
		//   		    - PREV NUM ITEMS
		int startingNumItems = cart.getItemCount();
		assertEquals(0, startingNumItems);
		
		//    5.  ADD THE PRODUCT TO THE CART 
		cart.addItem(phone);
		
		 //    6.  CHECK THE UPDATED NUMBER OF ITEMS IN CART 
		 //    		-- EO: PREV NUM ITEMS + 1
		// OPTION 1: A resuable, maintabale, great solution
		assertEquals(startingNumItems + 1, cart.getItemCount());
		// OPTION 2: Okay, but not very resuable (ok but not ok)
		// assertEquals(1, cart.getItemCount());
		
		 //    -----------------------
		 //    7.  CHECK THE UPDATED BALANCE OF THE CART
		 //   		-- EO: PREVIOUS BALANCE + PRICE OF PRODUCT
		double expectedBalance = startBalance + phone.getPrice();
		assertEquals(expectedBalance, cart.getBalance(), 0.01);
		
	}
	
}
