package com.packt.datastructuresandalg.lesson3.activity.project.test.bonus;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.packt.datastructuresandalg.lesson3.activity.project.MemberAccountNew;
import com.packt.datastructuresandalg.lesson3.activity.project.MemberDataNew;
import com.packt.datastructuresandalg.lesson3.activity.project.SimilarMember;
import com.packt.datastructuresandalg.lesson3.activity.project.bonus.SimilarVideo;

class SimilarVideoTest {

	public static String[] emailList2;
	public static MemberDataNew testSetNew2;
	public static long[][] watchedVideoMatrix;
	public static Random r;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		emailList2 = new String[10_000];
		r = new Random();
		
		for (int i = 0; i < emailList2.length; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("built2blowup");
			sb.append(i);
			sb.append("@mail.com");
			
			emailList2[i] = sb.toString();
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
			MemberAccountNew accountNew = testSetNew2.getAccount(email);
			
			for (int j = 0; j < watchedVideoMatrix[i].length; j++) {
				accountNew.addWatchedVideo(watchedVideoMatrix[i][j]);
			}
			
		}
				
		for (int i = 6; i < emailList2.length; i++) {
			String email = emailList2[i];
			testSetNew2.getAccount(email).addWatchedVideo(13l);
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emailList2 = null;
		testSetNew2 = null;
		watchedVideoMatrix = null;
		r = null;
	}

	@Test
	void testGetSimilarVideos() {
		
		ArrayList<Long> videoList = SimilarVideo.getSimilarVideos(testSetNew2, 1017l);
		
		//should not contain
		assertFalse(videoList.contains(13l),"Should not contain #13");
		assertFalse(videoList.contains(1018l), "Should not contain #1018");
		assertFalse(videoList.contains(1017l), "Should not contain #1017; itself");
		
		//check size
		assertTrue(videoList.size()==10);
		
		//should contain in the following order
		assertTrue(videoList.get(0)==1020l);
		
		boolean inOrder = false;
		
		for (int i = 1; i < 4; i++) {
			
			long video = videoList.get(i);
			
			if ( video == 1013l || video == 1016l ||  video == 1021) {
				inOrder = true;
			} else {
				inOrder = false;
				break;
			}
		}
		
		assertTrue(inOrder);
		
		for (int i = 4; i < 10; i++) {
			
			long video = videoList.get(i);
			
			if (video == 1010l || video == 1011l || video == 1014l 
					|| video == 1015l ||video == 1019l || video == 1012l) {
				inOrder = true;
			} else {
				inOrder = false;
				break;
			}
		}
		
		assertTrue(inOrder);
	}

}
