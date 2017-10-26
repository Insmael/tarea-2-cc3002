package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.card.CCardPile;
import model.card.CardFactory;
import model.card.ICardPile;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.Symbol;

public class ICardPileTest {

	@Test
	public void CardPileTest() {
		CardFactory cardFactory = new CardFactory();
		cardFactory.setColor(Color.RED);
		cardFactory.setSymbol(Symbol.ONE);
		ICard redOne = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.DRAW_TWO);
		ICard redplus2 = cardFactory.createCard();
		cardFactory.setColor(Color.GREEN);
		cardFactory.setSymbol(Symbol.SKIP);
		ICard greenSkip = cardFactory.createCard();

		ICardPile cardPile = new CCardPile();

		assertTrue(cardPile.isEmpty());

		cardPile.pushCard(redOne);

		assertEquals(1, cardPile.getSize());

		assertEquals(redOne, cardPile.peekCard());

		cardPile.popCard();

		assertTrue(cardPile.isEmpty());

		cardPile.pushCard(redOne);
		cardPile.pushCard(redplus2);
		cardPile.pushCard(greenSkip);

		assertEquals(3, cardPile.getSize());
		assertEquals(greenSkip, cardPile.peekCard());
	}

	/*
	 * el siguiente test debe fallar alrededor de una cada 7 veces, ya que revuelve
	 * aleatoriamente, por lo que no se asegura que la ultima carta sea
	 * efectivamente diferente respecto a la que había en esa posición antes de
	 * revolver el mazo.
	 */
	@Test
	public void ShuffleTest() {
		CardFactory cardFactory = new CardFactory();
		cardFactory.setColor(Color.RED);
		cardFactory.setSymbol(Symbol.ONE);
		ICard c1 = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.DRAW_TWO);
		ICard c2 = cardFactory.createCard();
		cardFactory.setColor(Color.GREEN);
		cardFactory.setSymbol(Symbol.SKIP);
		ICard c3 = cardFactory.createCard();
		cardFactory.setColor(Color.BLUE);
		cardFactory.setSymbol(Symbol.SIX);
		ICard c4 = cardFactory.createCard();
		cardFactory.setColor(Color.NONE);
		cardFactory.setSymbol(Symbol.WILD);
		ICard c5 = cardFactory.createCard();
		cardFactory.setColor(Color.GREEN);
		cardFactory.setSymbol(Symbol.NINE);
		ICard c6 = cardFactory.createCard();
		cardFactory.setColor(Color.RED);
		cardFactory.setSymbol(Symbol.FIVE);
		ICard c7 = cardFactory.createCard();

		ICardPile pile = new CCardPile();

		pile.pushCard(c1);
		pile.pushCard(c2);
		pile.pushCard(c3);
		pile.pushCard(c4);
		pile.pushCard(c5);
		pile.pushCard(c6);
		pile.pushCard(c7);

		assertEquals(7, pile.getSize());

		pile.shuffle();

		assertNotEquals(c7, pile.peekCard());
	}

	@Test
	public void pushCardsTest() {
		CardFactory cardFactory = new CardFactory();
		cardFactory.setColor(Color.RED);
		cardFactory.setSymbol(Symbol.ONE);
		ICard c1 = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.DRAW_TWO);
		ICard c2 = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.SKIP);
		ICard c3 = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.SIX);
		ICard c4 = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.WILD);
		ICard c5 = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.NINE);
		ICard c6 = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.FIVE);
		ICard c7 = cardFactory.createCard();

		ICardPile pile1 = new CCardPile();

		pile1.pushCard(c1);
		pile1.pushCard(c2);
		pile1.pushCard(c3);
		pile1.pushCard(c4);
		pile1.pushCard(c5);
		pile1.pushCard(c6);
		pile1.pushCard(c7);

		cardFactory.setColor(Color.BLUE);
		cardFactory.setSymbol(Symbol.ONE);
		ICard d1 = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.DRAW_TWO);
		ICard d2 = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.SKIP);
		ICard d3 = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.SIX);
		ICard d4 = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.WILD);
		ICard d5 = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.NINE);
		ICard d6 = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.FIVE);
		ICard d7 = cardFactory.createCard();

		ICardPile pile2 = new CCardPile();

		pile2.pushCard(d1);
		pile2.pushCard(d2);
		pile2.pushCard(d3);
		pile2.pushCard(d4);
		pile2.pushCard(d5);
		pile2.pushCard(d6);
		pile2.pushCard(d7);

		assertEquals(7, pile1.getSize());
		assertEquals(7, pile2.getSize());

		pile1.pushCards(pile2);

		assertEquals(14, pile1.getSize());
		assertTrue(pile2.isEmpty());
	}
}
