package com.packt.datastructuresandalg.lesson3.activity.project;

import java.util.Map;

public class SimilarMemberSolution {

	/**This method gets the user email and accounts data and finds the most similar other member.
	 * Similarity is calculated by a counter instead of Euclidean distance since it is binary 
	 * (watched or not). 
	 * 
	 * @param accounts Account list of all registered users
	 * @param loginEmail login email that the user gives while login process
	 * 
	 * @return The most similar other registered member account
	 */
	public static MemberAccountNew getSimilarMember(MemberDataNew accounts, String loginEmail) {
		
		//find the account
		MemberAccountNew account = accounts.getAccount(loginEmail);
		
		return getSimilarMember(accounts, account);
	}

	/**This method gets a member account and finds the most similar other member account 
	 * from all registered members data. 	 
	 * Similarity is calculated by a counter instead of Euclidean distance since it is binary 
	 * (watched or not). 
	 * 
	 * @param accounts Account list of all registered users
	 * @param account member account which will be used to search the most similar account
	 * 
	 * @return The most similar other registered member account
	 */
	public static MemberAccountNew getSimilarMember(MemberDataNew accounts, MemberAccountNew account) {

		//define return with the first member
		MemberAccountNew similarMember = accounts.getAccounts().firstEntry().getValue();
		
		//define max similarity index
		int similarity = findSimilarityIndex(account, similarMember);
		
		//for each member
		for (Map.Entry<String, MemberAccountNew> entry : accounts.getAccounts().entrySet()) {


			//get other member
			MemberAccountNew account2check = entry.getValue();
			
			//if itself or the first one skip
			if (account2check.equals(similarMember)||account2check.equals(account)) {
				continue;
			}
			
			//calculate similarity index 
			int similarityIndex2Check = findSimilarityIndex(account, account2check); 
			
			//if more similar than similarMember
			if (similarityIndex2Check > similarity) {
				
				//change to this member and this similarity
				similarMember = account2check;
				similarity = similarityIndex2Check;
			}
		}
				
		return similarMember;
	}

	/**This method finds similarity between given two accounts. Similarity is 
	 * calculated by a counter since it is binary (watched or not). This method
	 * counts the videos watched by both of them and returns as a similarity index.
	 * 
	 * @param account1 first member account to calculate the similarity
	 * @param account2 second member account to calculate the similarity
	 * 
	 * @return similarity index based on the number of the videos watched by both of them
	 */
	private static int findSimilarityIndex(MemberAccountNew account1, MemberAccountNew account2) {

		//define return 
		int indexCounter = 0;
		
		//for each video watched by first member
		for (Map.Entry<Long, Long> entry : account1.getWatchedList().entrySet()) {
			
			//get the video ID
			long videoID = entry.getKey();
			
			//check if the second member watched it
			if (account2.getWatchedList().containsKey(videoID)) {
				indexCounter++;
			}
		}
		
		return indexCounter;
	}
}
