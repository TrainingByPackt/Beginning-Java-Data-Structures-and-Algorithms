package com.packt.datastructuresandalg.lesson5.activity.project.test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.packt.datastructuresandalg.lesson5.activity.project.WordCounter;
import com.packt.datastructuresandalg.lesson5.activity.project.WordSuggestions;

class WordSuggestionsTest {
	
	public static WordSuggestions ws;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 
		ws = new WordSuggestions();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		ws = null;
	}

	@Test
	void testGetWordFrequencies() throws IOException {
		
		ArrayList<WordCounter> wordCounts = ws.getWordFrequencies();
		
		assertEquals(6267, wordCounts.size());
		assertEquals(836, wordCounts.get(0).getCounter());
	}

	@Test
	void testGetSuggestions() throws IOException {
		
		ArrayList<String[]> suggestions = ws.getSuggestions(ws.getWordFrequencies());
		
		assertEquals(4194, suggestions.size());
	}

	@Test
	void testCountWords() {
		
		ArrayList<String> wordList = new ArrayList<>();
		
		wordList.add("joe");
		wordList.add("joe");
		wordList.add("jane");
		wordList.add("joe");
		wordList.add("jane");
		wordList.add("mary");
		
		ArrayList<WordCounter> counters = ws.countWords(wordList);
		
		assertEquals(3, counters.size());
		
		for (int i = 0; i < counters.size(); i++) {
			
			switch (counters.get(i).getWord()) {
			case "joe":
				assertEquals(3, counters.get(i).getCounter());
				break;
			case "jane":
				assertEquals(2, counters.get(i).getCounter());
				break;
			case "mary":
				assertEquals(1, counters.get(i).getCounter());
				break;
			}
		}
	}

	@Test
	void testGetWordList() throws IOException {
		
		ArrayList<String> words = ws.getWordList(ws.getFiles());
		
		assertEquals(25919, words.size());
	}

	@Test
	void testGetFiles() {
				
		File[] fileArray = ws.getFiles();
		
		assertEquals(2, fileArray.length);
		
		assertTrue(fileArray[0].getAbsolutePath().contains("London.txt"));
		assertTrue(fileArray[1].getAbsolutePath().contains("Rome.txt"));
	}

	@Test
	void testBadCharacterRuleMatch() {
		assertTrue(ws.badCharacterRuleMatch("asd", "klasdfgju"));
		assertFalse(ws.badCharacterRuleMatch("asd", "not here sd"));
	}

}
