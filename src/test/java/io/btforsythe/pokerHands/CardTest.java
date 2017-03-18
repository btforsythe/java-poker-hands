package io.btforsythe.pokerHands;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CardTest {

	private Card five = new Card("5_");
	private Card eight = new Card("8_");
	private Card ten = new Card("T_");
	private Card jack = new Card("J_");
	private Card ace = new Card("A_");

	@Test
	public void aceShouldBeatFive() {
		assertThat(ace.beats(five), is(true));
	}
	
	@Test
	public void eightShouldNotBeatAce() {
		assertThat(eight.beats(ace), is(false));
	}
	
	@Test
	public void jackShouldNotBeatAce() {
		assertThat(jack.beats(ace), is(false));
	}
	
	@Test
	public void jackShouldBeatTen() {
		assertThat(jack.beats(ten), is(true));
	}
}
