package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.card.CCardPileManager;
import model.card.ICardPilesManager;
import model.card.deck.CDeckStrategy;
import model.player.type.HumanPlayer;
import model.player.type.IPlayer;

public class IPlayerTest {

	@Test
	public void test() {
		IPlayer player1 = new HumanPlayer();
		
		ICardPilesManager cardPileManager = new CCardPileManager(new CDeckStrategy().createDeck());
		
		
		assertEquals(0, player1.getHandSize());
		assertTrue(player1.hasWon());
		player1.addToHand(cardPileManager.drawCards(1));
		assertTrue(player1.hasOneCard());
		
		player1.addToHand(cardPileManager.drawCards(10));
		
		assertNotNull(player1.getHand());
		assertEquals(11, player1.getHandSize());
		
		player1.setSaidUNO(true);
		assertTrue(player1.hasSaidUNO());
		
		player1.removeCardFromHand(player1.getCardFromHand(3));
		assertEquals(10, player1.getHandSize());
	}

}
