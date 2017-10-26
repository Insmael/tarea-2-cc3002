package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.card.ICardPile;
import model.card.deck.CDeckStrategy;
import model.card.deck.IDeckStrategy;

public class IDeckStrategyTest {

	@Test
	public void testCreateDeck() {
		IDeckStrategy deckStrategy = new CDeckStrategy();
		ICardPile cardPile = deckStrategy.createDeck();

		assertEquals(4 + 8 * 13, cardPile.getSize());
	}

}
