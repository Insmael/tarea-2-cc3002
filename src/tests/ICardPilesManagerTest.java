package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.card.CCardPileManager;
import model.card.ICardPilesManager;
import model.card.deck.CDeckStrategy;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.Symbol;

public class ICardPilesManagerTest {

	ICardPilesManager cardPileManager;

	@Before
	public void setUp() {
		cardPileManager = new CCardPileManager(new CDeckStrategy().createDeck());

	}

	@Test
	public void test() {
		assertEquals(4 + 8 * 13 - 1, cardPileManager.getDrawableCardsNumber());
	}

	@Test
	public void testDrawingCards() {
		cardPileManager.drawCard();
		assertEquals(4 + 8 * 13 - 1 - 1, cardPileManager.getDrawableCardsNumber());
		cardPileManager.drawCards(50);
		assertEquals(4 + 8 * 13 - 1 - 51, cardPileManager.getDrawableCardsNumber());
	}

	@Test
	public void testDiscardPile() {
		assertEquals(Color.NONE, cardPileManager.getCurrentPlayedCard().getColor());
		assertEquals(Symbol.NONE, cardPileManager.getCurrentPlayedCard().getSymbol());
		ICard card = cardPileManager.drawCard();
		cardPileManager.discard(card);
		assertEquals(4 + 8 * 13 - 1, cardPileManager.getDrawableCardsNumber());
		assertEquals(card, cardPileManager.getCurrentPlayedCard());
		assertEquals(card, cardPileManager.getCurrentPlayedCard());
		cardPileManager.discard(cardPileManager.drawCard());
		cardPileManager.discard(cardPileManager.drawCard());
		cardPileManager.discard(cardPileManager.drawCard());
		cardPileManager.discard(cardPileManager.drawCard());
		cardPileManager.rebuildDeck();
		assertEquals(Color.NONE, cardPileManager.getCurrentPlayedCard().getColor());
		assertEquals(Symbol.WILD, cardPileManager.getCurrentPlayedCard().getSymbol());
	}

	@Test
	public void testaddCardsToPlayer() {
		// TODO
		fail("implementar");
	}

}
