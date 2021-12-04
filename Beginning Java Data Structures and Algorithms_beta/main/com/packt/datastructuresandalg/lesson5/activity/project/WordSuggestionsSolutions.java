package com.packt.datastructuresandalg.lesson5.activity.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class WordSuggestionsSolutions {
	
	/**This method chooses txt files and counts the words within them
	 * 
	 * @return frequencies of words in chosen txt files
	 * 
	 * @throws IOException
	 */
	public ArrayList<WordCounter> getWordFrequencies() throws IOException {
		//Choose Files
		File[] chosenDirectory = getFiles();

		//Read words in Files
		ArrayList<String>	wordList = getWordList(chosenDirectory);
				       
		//Count
		ArrayList<WordCounter> wordCountList = countWords(wordList);		
				
		//sort		
		Collections.sort(wordCountList, (a,b) -> a.getCounter() < b.getCounter() ? 1 :
			a.getCounter() == b.getCounter() ? 0: -1);
		
		return wordCountList;		
	}
	
	/**This files takes word and frequencies and finds all possible word pairs
	 * using bad character rule for string match
	 * 
	 * @param wordCountList list of words and frequencies
	 * 
	 * @return list of word pair that they may be similar 
	 * 
	 * @throws IOException
	 */
	public ArrayList<String[]> getSuggestions(ArrayList<WordCounter> wordCountList) throws IOException {
		
		//Define return list 
		ArrayList<String[]> wordPairSuggestions = new ArrayList<>();		
		
		//for every word 
		for (int i = 0; i < wordCountList.size(); i++) {
			
			//every other word - avoid same pairs
			for (int j = i+1; j < wordCountList.size(); j++) {
				
				String firstWord = wordCountList.get(i).getWord();
				String secondWord = wordCountList.get(j).getWord();
				
				//first string is pattern so it must be smaller
				if (secondWord.length() < firstWord.length()) {
					firstWord = wordCountList.get(j).getWord();
					secondWord = wordCountList.get(i).getWord();
				}				
				
				//check using bad character rule
				if (badCharacterRuleMatch(firstWord, secondWord)) {
					String[] pairToAdd = new String[] {firstWord, secondWord};
					wordPairSuggestions.add(pairToAdd);
				}
				
			}
		}		
		return wordPairSuggestions;		
	}


	/**This method gets words as a list and counts them. 
	 * (Counts the duplicate strings)
	 * 
	 * @param wordList list of words to count
	 * 
	 * @return list of words with a counter showing number of repetitions
	 */
	public ArrayList<WordCounter> countWords(ArrayList<String> wordList) {
		
		//define a data structure to count
		HashMap<String, Integer> wordCount = new HashMap<>();
		
		//for every word in the list
		for (Iterator iterator = wordList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			
			//check if the word is already created 
			if (wordCount.containsKey(string)) {
				
				//get counter
				int counter = wordCount.get(string);
				
				//increase the counter
				wordCount.put(string, ++counter);
				
			} else {
				//insert the word to counter data
				wordCount.put(string, 1);
			}
			
		}
		
		//define return type
		ArrayList<WordCounter> wordCountList = new ArrayList<>();
		
		//add all entries to return list
		for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {

			String word = entry.getKey();
			int counter  = entry.getValue();
			
			wordCountList.add(new WordCounter(word, counter));
		}
		
		return wordCountList;
	}

	/**This method gets the files as array an reads them and returns words 
	 * contained in them as a list
	 * 
	 * @param fileArray array of files to read
	 * 
	 * @return words in the read files
	 * 
	 * @throws IOException
	 */
	public ArrayList<String> getWordList(File[] fileArray) throws IOException {
		
		//define return
		ArrayList<String>	wordList = new ArrayList<>();
		
		//for each file
		for (int i = 0; i < fileArray.length; i++) {
			
			//read file
			BufferedReader reader = new BufferedReader(new FileReader(fileArray[i]));
						
			String line = null;
			
			//read line by line
			while ((line = reader.readLine())!=null) {
				
                StringTokenizer tokenizer = new StringTokenizer(line);
                
                while (tokenizer.hasMoreTokens()) { 
                   
                	String word = tokenizer.nextToken();
                	
                	//clear words
                	word = word.toLowerCase();
                	
                	StringBuilder sb = new StringBuilder();
                	
                	for (int j = 0; j < word.length(); j++) {
                		
                		//only alphabet chars, remove others
						if ( ((int)word.charAt(j))>=97
								&&((int)word.charAt(j))<=122) {
							
							sb.append(word.charAt(j));
						}						
					}                	
                	
                	word = sb.toString();
                	
                	if (word.length()>3) {
                		
						wordList.add(word);
					}                	
                }
            } 			
		}
		return wordList;
	}

	/**This method chooses text files to read and returns them as
	 * an array
	 * 
	 * @return array of chosen files 
	 */
	public File[] getFiles() {
		
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.getDragEnabled();
        fileChooser.setMultiSelectionEnabled(Boolean.FALSE);
        
        int result = fileChooser.showOpenDialog(new JFrame());
        
        if (result==JFileChooser.CANCEL_OPTION) 
            System.exit(1);
        
        File[] chosenDirectory = fileChooser.getSelectedFile().listFiles();
        
		return chosenDirectory;
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
