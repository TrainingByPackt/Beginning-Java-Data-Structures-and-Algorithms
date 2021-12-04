package com.packt.datastructuresandalg.lesson1.activity.project.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.packt.datastructuresandalg.lesson1.activity.project.Product;
import com.packt.datastructuresandalg.lesson1.activity.project.SimilarCustomer;
import com.packt.datastructuresandalg.lesson1.activity.project.SuggestionFrames;

public class SuggestionFramesTest {

	private static ArrayList<Product> productList;
	private static double[][] customerBehaviorMatrixBig;
	private static SimilarCustomer similarCustomer = new SimilarCustomer();
	private static SuggestionFrames suggestionFrames = new SuggestionFrames();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		customerBehaviorMatrixBig = new double [][]{
			 {1, 32, 2, 3, 0, 0, 0, 2, 0, 1, 2, 0, 3, 0, 0, 0, 0, 0, 2, 3, 0, 2, 0, 0, 0, 0},
			 {2, 21, 2, 5, 0, 0, 1, 2, 1, 2, 0, 3, 0, 2, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0, 0},
			 {3, 56, 3, 3, 0, 0, 0, 2, 3, 1, 2, 0, 3, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0},
			 {1, 18, 2, 3, 0, 0, 0, 2, 5, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
			 {2, 45, 4, 4, 0, 0, 0, 2, 3, 5, 1, 2, 0, 3, 3, 0, 1, 2, 0, 0, 1, 0, 0, 0, 0, 0},
			 {1, 27, 2, 3, 0, 0, 1, 2, 7, 6, 0, 0, 3, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0, 0, 0}};
		
		productList = new ArrayList<>();
		
		productList.add(new Product("Atletic Shoe", 4.54, 01, 11));
		productList.add(new Product("Pencil", 1.00, 02, 12));
		productList.add(new Product("Note Book", 13.51, 02, 13));
		productList.add(new Product("Shoe", 16.79, 01, 14));
		productList.add(new Product("Sport Shoe", 34.24, 01, 15));
		productList.add(new Product("Card Holder", 5.99, 02, 16));
		productList.add(new Product("Sandal", 14.05, 01, 17));
		productList.add(new Product("Running Shoe", 117.30, 01, 18));
		productList.add(new Product("Card Organizer", 8.99, 02, 19));
		productList.add(new Product("Yoga Socks", 11.88, 01, 20));
		productList.add(new Product("Book Bag", 8.50, 02, 21));
		productList.add(new Product("Daypack", 26.99, 02, 22));
		productList.add(new Product("Leather Shoe", 145, 01, 23));
		productList.add(new Product("Motorcycle Shoe", 71.25, 01, 24));
		productList.add(new Product("Ladies Leather Backpack", 23.99, 02, 25));
		productList.add(new Product("Suitcase", 89.99, 02, 26));

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		similarCustomer = null;
		customerBehaviorMatrixBig = null;
		productList = null;
	}

	@Test
	void otherProductsOfTheSellerListTest() {
		int currentCustomerIndex = 0;
		int similarCustomerIndex = 3;
		
		ArrayList<Product> suggestedList = suggestionFrames.
				otherProductsOfTheSellerList(11, currentCustomerIndex, customerBehaviorMatrixBig, productList);
		
		//should not contain product of visited web page, which is product #11
		assertFalse(suggestedList.contains(productList.get(0)),
				"Suggested Product List should not contain product of visited web page, which is product #11");
		
		//should not be empty
		assertFalse(suggestedList.isEmpty(),
				"Suggested Product List should not be empty");
		
		//should contain "Yoga Socks"
		assertTrue(suggestedList.contains(productList.get(20-11)),
				"Suggested Product List should contain Yoga Socks");
		
		//should have 5 products
		assertTrue(suggestedList.size() == 5,
				"Suggested Product List should have exactly 5 products");
		
		for (Iterator iterator = suggestedList.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			assertTrue(product.getManufacturerCode() == productList.get(0).getManufacturerCode());
		}
		
		currentCustomerIndex = 0;
		similarCustomerIndex = 3;
		
		suggestedList = suggestionFrames.
				otherProductsOfTheSellerList(19, currentCustomerIndex, customerBehaviorMatrixBig, productList);
		
		//should not contain product of visited web page, which is product #19
		assertFalse(suggestedList.contains(productList.get(19-11)),
				"Suggested Product List should not contain product of visited web page, which is product #19");

		//should not be empty
		assertFalse(suggestedList.isEmpty(),
				"Suggested Product List should not be empty");
		
		//should contain "Pencil"
		assertTrue(suggestedList.contains(productList.get(12-11)),
				"Suggested Product List should contain Pencil");
		
		//should have 5 products
		assertTrue(suggestedList.size() == 5,
				"Suggested Product List should have exactly 5 products");
		
		for (Iterator iterator = suggestedList.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			assertTrue(product.getManufacturerCode() == productList.get(19-11).getManufacturerCode());
		}
		
		currentCustomerIndex = 4;
		similarCustomerIndex = 1;
		
		suggestedList = suggestionFrames.
				otherProductsOfTheSellerList(21, currentCustomerIndex, customerBehaviorMatrixBig, productList);
		
		//should not contain product of visited web page, which is product #21
		assertFalse(suggestedList.contains(productList.get(21-11)),
				"Suggested Product List should not contain product of visited web page, which is product #21");
		
		//should not be empty
		assertFalse(suggestedList.isEmpty(),
				"Suggested Product List should not be empty");
		
		//should contain "Daypack"
				assertTrue(suggestedList.contains(productList.get(22-11)),
						"Suggested Product List should contain Daypack");
		
		//should have 5 products
		assertTrue(suggestedList.size() == 5,
				"Suggested Product List should have exactly 5 products");
		
		for (Iterator iterator = suggestedList.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			assertTrue(product.getManufacturerCode() == productList.get(21-11).getManufacturerCode());
		}
		
		currentCustomerIndex = 5;
		similarCustomerIndex = 3;
		
		suggestedList = suggestionFrames.
				otherProductsOfTheSellerList(15, currentCustomerIndex, customerBehaviorMatrixBig, productList);
		
		//should not contain product of visited web page, which is product #15
		assertFalse(suggestedList.contains(productList.get(15-11)),
				"Suggested Product List should not contain product of visited web page, which is product #15");
		
		//should not be empty
				assertFalse(suggestedList.isEmpty(),
						"Suggested Product List should not be empty");
		
		//should have 5 products
		assertTrue(suggestedList.size() == 5,
				"Suggested Product List should have exactly 5 products");
		
		for (Iterator iterator = suggestedList.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			assertTrue(product.getManufacturerCode() == productList.get(15-11).getManufacturerCode());
		}
		
		currentCustomerIndex = 1;
		similarCustomerIndex = 4;
		
		suggestedList = suggestionFrames.
				otherProductsOfTheSellerList(15, currentCustomerIndex, customerBehaviorMatrixBig, productList);
		
		//should not contain product of visited web page, which is product #15
		assertFalse(suggestedList.contains(productList.get(15-11)),
				"Suggested Product List should not contain product of visited web page, which is product #15");
		
		//should not be empty
				assertFalse(suggestedList.isEmpty(),
						"Suggested Product List should not be empty");
		
		//should have 5 products
		assertTrue(suggestedList.size() == 5,
				"Suggested Product List should have exactly 5 products");
		
		for (Iterator iterator = suggestedList.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			assertTrue(product.getManufacturerCode() == productList.get(15-11).getManufacturerCode());
		}
	}
	
	@Test
	void interestedProductsSuggestionListTest() {
		int currentCustomerIndex = 0;
		int similarCustomerIndex = 3;
		
		ArrayList<Product> suggestedList = suggestionFrames.
				interestedProductsSuggestionList(11, currentCustomerIndex, customerBehaviorMatrixBig, productList);
		
		//should not contain product of visited web page, which is product #11
		assertFalse(suggestedList.contains(productList.get(11-11)),
				"Suggested Product List should not contain product of visited web page, which is product #11");
		
		//should not be empty
				assertFalse(suggestedList.isEmpty(),
						"Suggested Product List should not be empty");
		
		//should have 5 products
		assertTrue(suggestedList.size() == 5,
				"Suggested Product List should have exactly 5 products");
		
		currentCustomerIndex = 0;
		similarCustomerIndex = 3;
		
		suggestedList = suggestionFrames.
				interestedProductsSuggestionList(19, currentCustomerIndex, customerBehaviorMatrixBig, productList);
		
		//should not contain product of visited web page, which is product #19
				assertFalse(suggestedList.contains(productList.get(19-11)),
						"Suggested Product List should not contain product of visited web page, which is product #19");
		
		//should not be empty
		assertFalse(suggestedList.isEmpty(),
				"Suggested Product List should not be empty");

		//should have 5 products
		assertTrue(suggestedList.size() == 5,
				"Suggested Product List should have exactly 5 products");
		
		currentCustomerIndex = 4;
		similarCustomerIndex = 1;
		
		suggestedList = suggestionFrames.
				interestedProductsSuggestionList(21, currentCustomerIndex, customerBehaviorMatrixBig, productList);
		
		//should not contain product of visited web page, which is product #21
				assertFalse(suggestedList.contains(productList.get(21-11)),
						"Suggested Product List should not contain product of visited web page, which is product #21");
		
		//should not be empty
		assertFalse(suggestedList.isEmpty(),
				"Suggested Product List should not be empty");

		//should have 5 products
		assertTrue(suggestedList.size() == 5,
				"Suggested Product List should have exactly 5 products");
		
		currentCustomerIndex = 5;
		similarCustomerIndex = 3;
		
		suggestedList = suggestionFrames.
				interestedProductsSuggestionList(15, currentCustomerIndex, customerBehaviorMatrixBig, productList);
		
		//should not contain product of visited web page, which is product #15
				assertFalse(suggestedList.contains(productList.get(15-11)),
						"Suggested Product List should not contain product of visited web page, which is product #15");
		
		//should not be empty
		assertFalse(suggestedList.isEmpty(),
				"Suggested Product List should not be empty");

		//should have 5 products
		assertTrue(suggestedList.size() == 5,
				"Suggested Product List should have exactly 5 products");
		
		currentCustomerIndex = 1;
		similarCustomerIndex = 4;
		
		suggestedList = suggestionFrames.
				interestedProductsSuggestionList(15, currentCustomerIndex, customerBehaviorMatrixBig, productList);
		
		//should not contain product of visited web page, which is product #15
				assertFalse(suggestedList.contains(productList.get(15-11)),
						"Suggested Product List should not contain product of visited web page, which is product #15");
		
		//should not be empty
		assertFalse(suggestedList.isEmpty(),
				"Suggested Product List should not be empty");

		//should have 5 products
		assertTrue(suggestedList.size() == 5,
				"Suggested Product List should have exactly 5 products");
		
		//should not contain product of visited web page, which is product #11 and #17
		assertTrue(suggestedList.contains(productList.get(11-11)),
				"Suggested Product List should contain product of visited web page, which is product #11");
		
		assertTrue(suggestedList.contains(productList.get(17-11)),
				"Suggested Product List should contain product of visited web page, which is product #17");
	}
}
