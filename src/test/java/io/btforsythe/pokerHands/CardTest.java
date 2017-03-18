package io.btforsythe.pokerHands;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

public class CardTest {

	private Card five = new Card("5_");
	private Card eight = new Card("8_");
	private Card ten = new Card("T_");
	private Card jack = new Card("J_");
	private Card queen = new Card("Q_");
	private Card king = new Card("K_");
	private Card ace = new Card("A_");

	@Test
	public void aceShouldBeatFive() {
		assertThat(ace, is(higherThan(five)));
	}
	
	@Test
	public void eightShouldNotBeatAce() {
		assertThat(eight, is(not(higherThan(ace))));
	}
	
	@Test
	public void jackShouldNotBeatAce() {
		assertThat(jack.beats(ace), is(false));
	}
	
	@Test
	public void jackShouldBeatTen() {
		assertThat(jack, is(higherThan(ten)));
	}
	
	@Test
	public void tenShouldNotBeatKing() {
		assertThat(ten, is(not(higherThan(king))));
	}
	
	@Test
	public void queenShouldBeatJack() {
		assertThat(queen, is(higherThan(jack)));
	}

	private Matcher<Card> higherThan(Card other) {
		return new TypeSafeMatcher<Card>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("is higher than " + other);
			}
			@Override
			protected boolean matchesSafely(Card higherCard) {
				return higherCard.beats(other) && !other.beats(higherCard);
			}
		};
	}
}
