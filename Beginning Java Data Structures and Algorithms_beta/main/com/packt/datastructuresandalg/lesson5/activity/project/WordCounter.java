package com.packt.datastructuresandalg.lesson5.activity.project;

public class WordCounter {

	private String word;
	private int counter;
	
	public WordCounter(String word) {
		super();
		this.word = word;
		counter = 1;
	}
	
	public WordCounter(String word, int counter) {
		super();
		this.word = word;
		this.counter = counter;
	}

	public String getWord() {
		return word;
	}

	public int getCounter() {
		return counter;
	}
	
	public void count() {
		counter++;
	}
}
