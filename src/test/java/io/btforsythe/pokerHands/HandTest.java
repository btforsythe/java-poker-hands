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
}
