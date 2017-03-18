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
		faceCardValues.put('Q', 12);
		faceCardValues.put('K', 13);
		faceCardValues.put('A', 14);
	}

	private String stringRepresentation;

	private int value;
	private char suit;

	public Card(String stringRepresentation) {
		this.stringRepresentation = stringRepresentation;
		char[] asChars = stringRepresentation.toCharArray();
		
		this.value = valueOf(asChars[0]);
		this.suit = asChars[1];
	}

	private int valueOf(char valueChar) {
		if (isDigit(valueChar)) {
			return parseInt("" + valueChar);
		}
		return faceCardValues.get(valueChar);
	}
	
	public boolean beats(Card other) {
		return value > other.value;
	}

	@Override
	public String toString() {
		return stringRepresentation;
	}

	public boolean sharesSuitWith(Card other) {
		return suit == other.suit;
	}
}
