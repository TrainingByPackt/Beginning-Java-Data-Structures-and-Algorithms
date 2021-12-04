package com.packt.datastructuresandalg.lesson5.activity.project.bonus;

import java.util.ArrayList;
import java.util.List;

public class SentenceSearchSolution {
	
	public static ArrayList<String> searchForSentences(String searchWord, String fileContent) {
		
		//define return
		ArrayList<String> sentences = new ArrayList<>();
		
		//get indexes of matches
		
		List<Integer> indices = match(searchWord, fileContent);				
		
		//for each match
		for (int i = 0; i < indices.size(); i++) {
			
			int start = indices.get(i);
			int end = start + searchWord.length()-1;
			
			if (start>0) {
				
				char previousChar = fileContent.charAt(start -1);
				
				//find starting point of sentence 
				while (start > 0 && previousChar != '.'&& previousChar != '\r'
						&& previousChar != '?'&& previousChar != '!'&&previousChar != '\n') {
					start--;
					//if not index 0
					if (start!=0) {
						previousChar = fileContent.charAt(start -1);
					}					
				}
			}
			
			if (end < fileContent.length()-1) {
				
				char nextChar = fileContent.charAt(end+1);
				//find ending point of sentence or . ? ! \n				
				while (end < fileContent.length() && nextChar != '.'&&nextChar != '\r'
						&&nextChar != '?'&&nextChar != '!'&&nextChar != '\n') {
					
					end++;

					nextChar = fileContent.charAt(end + 1);
				}
				
				end++;
			}
			
			//remove space if has at the first char
			if (fileContent.charAt(start)==' ') {
				start++;
			}
			
			//add sentence to the return list
			String sentence = fileContent.substring(start, end+1);
			sentences.add(sentence);
		}

		
		return sentences;		
	}
	
	public static List<Integer> match(String searchWord, String text) {
        int n = text.length();
        int m = searchWord.length();
        int i = m, j = m + 1;
        int[] f = new int[m + 1];
        int[] s = new int[m + 1];
        f[i] = j;
        while (i > 0) {
            while (j <= m && searchWord.charAt(i - 1) != searchWord.charAt(j - 1)) {
                if (s[j] == 0)
                    s[j] = j - i;
                j = f[j];
            }
            i--; j--;
            f[i] = j;
        }

        j = f[0];
        for (i = 0; i <= m; i++) {
            if (s[i] == 0)
                s[i] = j;
            if (i == j)
                j = f[j];
        }

        List<Integer> shifts = new ArrayList<>();
        int skip;
        for (i = 0; i < n - m + 1; i += skip) {
            boolean hasMatch = true;
            skip = 0;
            for (j = m - 1; j >= 0; j--) {
                if (searchWord.charAt(j) != text.charAt(i + j)) {
                    skip = s[j + 1];
                    hasMatch = false;
                    break;
                }
            }
            if (hasMatch) {
                shifts.add(i);
                skip = s[0];
            }
        }
        return shifts;
	}
	
}
