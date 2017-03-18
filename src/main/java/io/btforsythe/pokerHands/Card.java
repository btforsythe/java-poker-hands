package io.btforsythe.pokerHands;

import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;

import java.util.HashMap;
import java.util.Map;

public class Card {

	private static Map<Character, Integer> faceCardValues = new HashMap<>();
	static {
		faceCardValues.put('T', 10);
		faceCardValues.put('J', 11);
		faceCardValues.put('K', 13);
		faceCardValues.put('A', 14);
	}

	private int value;

	public Card(String asString) {
		char[] asChars = asString.toCharArray();
		
		this.value = valueOf(asChars[0]);
	}

	private int valueOf(char valueChar) {
		if (isDigit(valueChar)) {
			return parseInt("" + valueChar);
		} else {
			return faceCardValues.get(valueChar);
		}
	}
	
	public boolean beats(Card other) {
		return value > other.value;
	}

}
