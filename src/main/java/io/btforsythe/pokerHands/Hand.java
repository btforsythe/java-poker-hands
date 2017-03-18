package io.btforsythe.pokerHands;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

public class Hand {

	private Collection<Card> cards = new HashSet<>();

	public Hand(String... cards) {
		asList(cards).forEach(this::addCard);
	}

	private boolean addCard(String card) {
		return cards.add(new Card(card));
	}

	public Card highCard() {
		return cards.stream().reduce(this::higherOf).get();
	}

	private Card higherOf(Card firstCard, Card secondCard) {
		return firstCard.beats(secondCard)? firstCard: secondCard;
	}

}
