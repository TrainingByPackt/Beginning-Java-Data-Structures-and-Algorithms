package com.packt.datastructuresandalg.lesson3.activity.project.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.packt.datastructuresandalg.lesson3.activity.project.MemberAccountNew;
import com.packt.datastructuresandalg.lesson3.activity.project.MemberAccountOld;
import com.packt.datastructuresandalg.lesson3.activity.project.MemberDataNew;
import com.packt.datastructuresandalg.lesson3.activity.project.MemberDataOld;

class MemberDataTest {
	
	public static String[] emailList1;
	public static String[] emailList2;
	public static String alphabet;
	public static Random r;
	public static String alphanumeric;
	public static MemberDataOld testSetOld1;
	public static MemberDataOld testSetOld2; 
	public static MemberDataNew testSetNew1;
	public static MemberDataNew testSetNew2;
	public static long[][] watchedVideoMatrix;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emailList1 = new String[10_000];
		emailList2 = new String[10_000];
		
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		
		alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
		
		for (int i = 0; i < emailList1.length; i++) {
			StringBuilder sb = new StringBuilder();
			
			r = new Random();

			for (int j = 0; j < r.nextInt(10); j++) {
				
				sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
				
			}
			
			sb.append("@mail.com");
			emailList1[i] = sb.toString();
		}
		
		for (int i = 0; i < emailList2.length; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("built2blowup");
			sb.append(i);
			sb.append("@mail.com");
			
			emailList2[i] = sb.toString();
		}
		
		testSetOld1 = new MemberDataOld();

		for (int i = 0; i < emailList1.length; i++) {
			
			String email = emailList1[i];
			int passLength = r.nextInt(5);
			StringBuilder pass = new StringBuilder();
			
			for (int j = 0; j < passLength; j++) {
				pass.append(alphanumeric.charAt(r.nextInt(alphanumeric.length())));
			}
			
			
			
			MemberAccountOld accountOld = new MemberAccountOld(email, pass.toString(), i );
			
			testSetOld1.addAccount(accountOld);
		}
		
		testSetOld2 = new MemberDataOld();

		for (int i = 0; i < emailList2.length; i++) {
			
			String email = emailList2[i];
			int passLength = r.nextInt(5);
			StringBuilder pass = new StringBuilder();
			
			for (int j = 0; j < passLength; j++) {
				pass.append(alphanumeric.charAt(r.nextInt(alphanumeric.length())));
			}
			
			
			
			MemberAccountOld accountOld = new MemberAccountOld(email, pass.toString(), i );
			
			testSetOld2.addAccount(accountOld);
		}
		
		testSetNew1 = new MemberDataNew();
		
		for (int i = 0; i < emailList1.length; i++) {
			testSetNew1.addAccount(new MemberAccountNew(emailList1[i], Integer.toString(r.nextInt(10)), i ));
		}
		
		testSetNew2 = new MemberDataNew();
		
		for (int i = 0; i < emailList2.length; i++) {
			testSetNew2.addAccount(new MemberAccountNew(emailList2[i], Integer.toString(r.nextInt(10)), i ));
		}
		
		watchedVideoMatrix = new long[][] {
			{1010, 1012, 1018, 1019, 1021},
			{1013, 1017, 1020, 1021},
			{1012, 1019},
			{1011},
			{1010, 1013, 1014, 1016, 1017, 1020},
			{1011, 1012, 1015, 1016, 1017, 1019, 1020, 1021}};
			
		for (int i = 0; i < watchedVideoMatrix.length; i++) {
			String email = emailList2[i];
			MemberAccountOld accountOld = testSetOld2.getAccount(email);
			MemberAccountNew accountNew = testSetNew2.getAccount(email);
			
			for (int j = 0; j < watchedVideoMatrix[i].length; j++) {
				accountOld.addWatchedVideo(watchedVideoMatrix[i][j]);
				accountNew.addWatchedVideo(watchedVideoMatrix[i][j]);
			}
			
		}
				
		for (int i = 6; i < emailList2.length; i++) {
			String email = emailList2[i];
			testSetOld2.getAccount(email).addWatchedVideo(13l);
			testSetNew2.getAccount(email).addWatchedVideo(13l);
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emailList1 = null;
		emailList2 = null;
		alphabet = null;
		alphanumeric = null;
		testSetOld1 = null;
		testSetOld2 = null; 
		testSetNew1 = null;
		testSetNew2 = null;
		watchedVideoMatrix = null;
	}

	@Test
	void testPerformance1() {
		
		System.out.println("\tPerformance Test 1");
		
		long startTimeOld;
		long endTimeOld;
		long durationOld;
		
		startTimeOld = System.nanoTime();

		for (int i = 0; i < emailList1.length; i++) {
			String email = emailList1[i];
			MemberAccountOld accountOld = testSetOld1.getAccount(email);
			accountOld.getPassword();
		}
		
		endTimeOld = System.nanoTime();
		
		durationOld = endTimeOld - startTimeOld;
		System.out.println(String.format("Old Data Structure : %,20d",durationOld));
			
		long startTimeNew;
		long endTimeNew;
		long durationNew;
		
		startTimeNew = System.nanoTime();

		for (int i = 0; i < emailList1.length; i++) {
			String email = emailList1[i];
			testSetNew1.getAccount(email).getPassword();
		}
		
		endTimeNew = System.nanoTime();
		
		durationNew = endTimeNew - startTimeNew;
		System.out.println(String.format("New Data Structure : %,20d\n\n",durationNew));
		
		//ten times faster
		assertTrue(durationOld/10>durationNew);
		
	}
	
	@Test
	void testPerformance2() {
		
		System.out.println("\tPerformance Test 2");
		
		long startTimeOld;
		long endTimeOld;
		long durationOld;
		
		startTimeOld = System.nanoTime();

		for (int i = 0; i < emailList2.length; i++) {
			String email = emailList2[i];
			MemberAccountOld accountOld = testSetOld2.getAccount(email);
			accountOld.getPassword();
		}
		
		endTimeOld = System.nanoTime();
		
		durationOld = endTimeOld - startTimeOld;
		System.out.println(String.format("Old Data Structure : %,20d",durationOld));

		
		long startTimeNew;
		long endTimeNew;
		long durationNew;
		
		startTimeNew = System.nanoTime();

		for (int i = 0; i < emailList2.length; i++) {
			String email = emailList2[i];
			testSetNew2.getAccount(email).getPassword();
		}
		
		endTimeNew = System.nanoTime();
		
		durationNew = endTimeNew - startTimeNew;
		System.out.println(String.format("New Data Structure : %,20d\n",durationNew));

		//ten times faster
		assertTrue(durationOld/10>durationNew);
				
	}
}
