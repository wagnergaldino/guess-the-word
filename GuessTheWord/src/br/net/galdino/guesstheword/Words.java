package br.net.galdino.guesstheword;

import java.util.Random;

public class Words {
	
	public Words() {
		selectedWord = randomWords[random.nextInt(randomWords.length)];
		letters = new char[selectedWord.length()];
	}
	
	private String[] randomWords = {"animals", "happiness", "indefinite", "steady", 
			"birthday", "extreme", "rights", "properties", "ceremony", "independence", 
			"beneath", "information", "students", "employee"};
	
	private String selectedWord;
	
	private char[] letters;
	
	private Random random = new Random();
	
	public String toString() {
		StringBuilder word = new StringBuilder();
		
		for(char letter: letters) {			
			word.append(letter == '\u0000' ? '-' : letter); // '\u0000' == null in unicode
			word.append(' ');
		}
		
		return word.toString();
	}

	public boolean guess(char letter) {
		boolean guessedRight = false;
		
		for(int i=0; i < selectedWord.length(); i++) {
			if(letter == selectedWord.charAt(i)) {
				letters[i] = letter;
				guessedRight = true;
			}
		}
		
		return guessedRight;
	}
	
	public boolean isGuessedRight() {
		for(char letter: letters) {
			if(letter == '\u0000') {
				return false;
			}
		}
		return true;
	}

}
