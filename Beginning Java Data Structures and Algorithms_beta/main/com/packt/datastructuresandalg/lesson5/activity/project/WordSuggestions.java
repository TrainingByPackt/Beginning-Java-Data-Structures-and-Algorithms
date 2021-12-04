package com.packt.datastructuresandalg.lesson5.activity.project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class WordSuggestions {
	
	/**
	 * 
	 * @return 
	 * 
	 * @throws IOException
	 */
	public ArrayList<WordCounter> getWordFrequencies() throws IOException {
		
		//TODO getWordFrequencies()
		
		//Choose Files

		//Read words in Files
				       
		//Count		
				
		//sort		
		
		return null;		
	}
	
	/**
	 * 
	 * @param wordCountList 
	 * 
	 * @return 
	 * 
	 * @throws IOException
	 */
	public ArrayList<String[]> getSuggestions(ArrayList<WordCounter> wordCountList) throws IOException {
		
		//TODO getSuggestions()
		
		return null;		
	}


	/**
	 * 
	 * @param wordList 
	 * 
	 * @return 
	 */
	public ArrayList<WordCounter> countWords(ArrayList<String> wordList) {
		
		//TODO countWords()
		
		return null;
	}

	/**
	 * 
	 * @param fileArray 
	 * 
	 * @return 
	 * 
	 * @throws IOException
	 */
	public ArrayList<String> getWordList(File[] fileArray) throws IOException {

		//TODO getWordList()
		
		return null;
	}

	/**
	 * 
	 * @return  
	 */
	public File[] getFiles() {
		        
		//TODO getFiles()
		
		return null;
	}
		 
	/**This method checks if P exists in T
	 * 
	 * @param P Pattern to match
	 * @param T Text to search
	 * 
	 * @return true if P exists in T
	 */
	public boolean badCharacterRuleMatch(String P, String T) {
        
		int n = T.length();        
		int m = P.length();

        
		 int e = 256;
		 int left[][] = new int[m][e];
        
		 for (int i = 0; i < m; i++)            
			 for (int j = 0; j < e; j++)                
				 left[i][j] = -1;
        
		 for (int i = 0; i < m; i++) {            
			 if (i != 0)                
				 for (int j = 0; j < e; j++)                    
					 left[i][j] = left[i - 1][j];            
			 left[i][P.charAt(i)] = i;        
		 }

        
		 boolean hasMatch = false;
		 
		 int skip;       
		 for (int i = 0; i < n - m + 1; i += skip) {            
			 skip = 0;            
			 for (int j = m - 1; j >= 0; j--) {                
				 if (P.charAt(j) != T.charAt(i + j)) {                    
					 skip = Math.max(1, j - left[j][T.charAt(i + j)]);                    
					 break;                
				 }            
			 }
            
			 if (skip == 0) {               
				 hasMatch = true;               
				 break;    
			 }        
		 }        
		 return hasMatch;
	 }	 
}
