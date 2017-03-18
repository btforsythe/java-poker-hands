package io.btforsythe.pokerHands;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HandTest {

	@Test
	public void shouldFindTenAsHighestCard() {
		Hand deck = new Hand("T_", "2_", "3_", "4_", "5_");

		assertThat(deck.highCard(), is(new Card("T_")));
	}

	@Test
	public void shouldFindNineAsHighestCard() {
		Hand deck = new Hand("2_", "3_", "9_", "4_", "5_");

		assertThat(deck.highCard(), is(new Card("9_")));
	}
}
