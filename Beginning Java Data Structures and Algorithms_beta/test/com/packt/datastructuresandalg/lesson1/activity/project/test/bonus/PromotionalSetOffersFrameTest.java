package com.packt.datastructuresandalg.lesson1.activity.project.test.bonus;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.packt.datastructuresandalg.lesson1.activity.project.Product;
import com.packt.datastructuresandalg.lesson1.activity.project.bonus.PromotionalSetOffersFrame;

public class PromotionalSetOffersFrameTest {

	private static ArrayList<Product> orderedProductList;
	private static double[][] customerBehaviorMatrixBig;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		customerBehaviorMatrixBig = new double [][]{
			 {1, 32, 2, 3, 0, 0, 0, 2, 0, 1, 2, 0, 3, 0, 0, 0, 0, 0, 2, 3, 0, 2, 0, 0, 0, 0},
			 {2, 21, 2, 5, 0, 0, 1, 2, 1, 2, 0, 3, 0, 2, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0, 0},
			 {3, 56, 3, 3, 0, 0, 0, 2, 3, 1, 2, 0, 3, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0},
			 {1, 18, 2, 3, 0, 0, 0, 2, 5, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
			 {2, 45, 4, 4, 0, 0, 0, 2, 3, 5, 1, 2, 0, 3, 3, 0, 1, 2, 0, 0, 1, 0, 0, 0, 0, 0},
			 {1, 27, 2, 3, 0, 0, 1, 2, 7, 6, 0, 0, 3, 0, 0, 0, 2, 0, 0, 1, 1, 0, 0, 0, 0, 0}};
		
		orderedProductList = new ArrayList<>();
		
		orderedProductList.add(new Product("Atletic Shoe", 4.54, 01, 11));
		orderedProductList.add(new Product("Pencil", 1.00, 02, 12));
		orderedProductList.add(new Product("Note Book", 13.51, 02, 13));
		orderedProductList.add(new Product("Shoe", 16.79, 01, 14));
		orderedProductList.add(new Product("Sport Shoe", 34.24, 01, 15));
		orderedProductList.add(new Product("Card Holder", 5.99, 02, 16));
		orderedProductList.add(new Product("Sandal", 14.05, 01, 17));
		orderedProductList.add(new Product("Running Shoe", 117.30, 01, 18));
		orderedProductList.add(new Product("Card Organizer", 8.99, 02, 19));
		orderedProductList.add(new Product("Yoga Socks", 11.88, 01, 20));
		orderedProductList.add(new Product("Book Bag", 8.50, 02, 21));
		orderedProductList.add(new Product("Daypack", 26.99, 02, 22));
		orderedProductList.add(new Product("Leather Shoe", 145, 01, 23));
		orderedProductList.add(new Product("Motorcycle Shoe", 71.25, 01, 24));
		orderedProductList.add(new Product("Ladies Leather Backpack", 23.99, 02, 25));
		orderedProductList.add(new Product("Suitcase", 89.99, 02, 26));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		customerBehaviorMatrixBig = null;
		orderedProductList = null;
	}

	@Test
	void promotionalSetOfferTest() {
		int currentProdcutIndex = 11;
		Product currentProduct = orderedProductList.get(currentProdcutIndex-11);
		
		ArrayList<Product> expectedOfferList = new ArrayList<>();
		expectedOfferList.add(currentProduct);
		
		//should contain #13 and #20
		expectedOfferList.add(orderedProductList.get(13-11));
		expectedOfferList.add(orderedProductList.get(20-11));
		
		ArrayList<Product> offerList = PromotionalSetOffersFrame.promotionalSetOffer(
				currentProdcutIndex, customerBehaviorMatrixBig, orderedProductList);
		
		assertEquals(expectedOfferList, offerList);

		currentProdcutIndex = 19;
		currentProduct = orderedProductList.get(currentProdcutIndex-11);
		
		expectedOfferList = new ArrayList<>();
		expectedOfferList.add(currentProduct);
		
		//should contain #20 and #13
		expectedOfferList.add(orderedProductList.get(20-11));
		expectedOfferList.add(orderedProductList.get(13-11));
		
		offerList = PromotionalSetOffersFrame.promotionalSetOffer(
				currentProdcutIndex, customerBehaviorMatrixBig, orderedProductList);
		
		assertEquals(expectedOfferList, offerList);
		
		currentProdcutIndex = 24;
		currentProduct = orderedProductList.get(currentProdcutIndex-11);
		
		expectedOfferList = new ArrayList<>();
		expectedOfferList.add(currentProduct);
		
		//should contain #13 and #20
		expectedOfferList.add(orderedProductList.get(13-11));
		expectedOfferList.add(orderedProductList.get(20-11));
		
		offerList = PromotionalSetOffersFrame.promotionalSetOffer(
				currentProdcutIndex, customerBehaviorMatrixBig, orderedProductList);
		
		assertEquals(expectedOfferList, offerList);
	}

}
