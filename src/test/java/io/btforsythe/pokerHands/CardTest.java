package io.btforsythe.pokerHands;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CardTest {

	@Test
	public void aceShouldBeatFive() {
		Card ace = new Card("AH");
		Card five = new Card("5H");
		
		assertThat(ace.beats(five), is(true));
	}
	
	@Test
	public void eightShouldNotBeatAce() {
		Card eight = new Card("8H");
		Card ace = new Card("AH");

		assertThat(eight.beats(ace), is(false));
	}
}
