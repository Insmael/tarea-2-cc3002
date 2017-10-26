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
	
	ICardPilesManager cpm;
	
	@Before
	public void setUp() {
		cpm = new CCardPileManager(new CDeckStrategy().createDeck());
		
	}

	@Test
	public void test() {
		assertEquals(4+8*13-1, cpm.getDrawableCardsNumber());
	}
	
	@Test
	public void testDrawingCards() {
		cpm.drawCard();
		assertEquals(4+8*13-1 - 1 , cpm.getDrawableCardsNumber());
		cpm.drawCards(50);
		assertEquals(4+8*13-1 - 51 , cpm.getDrawableCardsNumber());
	}
	
	@Test
	public void testDiscardPile() {
		assertEquals(Color.NONE,cpm.getCurrentPlayedCard().getColor());
		assertEquals(Symbol.NONE,cpm.getCurrentPlayedCard().getSymbol());
		ICard card = cpm.drawCard();
		cpm.discard(card);
		assertEquals(4+8*13-1, cpm.getDrawableCardsNumber());
		assertEquals(card, cpm.getCurrentPlayedCard());
		assertEquals(card, cpm.getCurrentPlayedCard());
		cpm.discard(cpm.drawCard());
		cpm.discard(cpm.drawCard());
		cpm.discard(cpm.drawCard());
		cpm.discard(cpm.drawCard());
		cpm.rebuildDeck();
		assertEquals(Color.NONE,cpm.getCurrentPlayedCard().getColor());
		assertEquals(Symbol.WILD, cpm.getCurrentPlayedCard().getSymbol());
	}
	
	@Test
	public void testaddCardsToPlayer() {
		// TODO
		fail("implementar");
	}

}
