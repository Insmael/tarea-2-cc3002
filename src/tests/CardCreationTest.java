package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.card.CardFactory;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.Symbol;

public class CardCreationTest {

	@Test
	public void cardColorInstantiationtest() {
		CardFactory cardFactory = new CardFactory();
		cardFactory.setColor(Color.RED);
		cardFactory.setSymbol(Symbol.ONE);
		ICard redCard = cardFactory.createCard();
		cardFactory.setColor(Color.BLUE);
		cardFactory.setSymbol(Symbol.ONE);
		ICard blueCard = cardFactory.createCard();
		cardFactory.setColor(Color.GREEN);
		cardFactory.setSymbol(Symbol.ONE);
		ICard greenCard = cardFactory.createCard();
		cardFactory.setColor(Color.YELLOW);
		cardFactory.setSymbol(Symbol.ONE);
		ICard yellowCard = cardFactory.createCard();
		cardFactory.setColor(Color.NONE);
		cardFactory.setSymbol(Symbol.ONE);
		ICard blackCard = cardFactory.createCard();

		assertEquals(Color.RED, redCard.getColor());
		assertEquals(Color.BLUE, blueCard.getColor());
		assertEquals(Color.YELLOW, yellowCard.getColor());
		assertEquals(Color.GREEN, greenCard.getColor());
		assertEquals(Color.NONE, blackCard.getColor());
	}

	@Test
	public void cardSymbolInstantiationtest() {
		CardFactory cardFactory = new CardFactory();
		cardFactory.setColor(Color.GREEN);
		cardFactory.setSymbol(Symbol.ONE);
		ICard uno = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.TWO);
		ICard dos = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.THREE);
		ICard tres = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.FOUR);
		ICard cuatro = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.FIVE);
		ICard cinco = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.SIX);
		ICard seis = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.SEVEN);
		ICard siete = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.EIGHT);
		ICard ocho = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.NINE);
		ICard nueve = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.ZERO);
		ICard cero = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.DRAW_TWO);
		ICard masdos = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.INVERT);
		ICard invert = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.NONE);
		ICard none = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.SKIP);
		ICard skip = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.WILD);
		ICard comodin = cardFactory.createCard();
		cardFactory.setSymbol(Symbol.WILD_DRAW_FOUR);
		ICard mascuatro = cardFactory.createCard();
		assertEquals(Symbol.ZERO, cero.getSymbol());
		assertEquals(Symbol.ONE, uno.getSymbol());
		assertEquals(Symbol.TWO, dos.getSymbol());
		assertEquals(Symbol.THREE, tres.getSymbol());
		assertEquals(Symbol.FOUR, cuatro.getSymbol());
		assertEquals(Symbol.FIVE, cinco.getSymbol());
		assertEquals(Symbol.SIX, seis.getSymbol());
		assertEquals(Symbol.SEVEN, siete.getSymbol());
		assertEquals(Symbol.EIGHT, ocho.getSymbol());
		assertEquals(Symbol.NINE, nueve.getSymbol());
		assertEquals(Symbol.DRAW_TWO, masdos.getSymbol());
		assertEquals(Symbol.INVERT, invert.getSymbol());
		assertEquals(Symbol.NONE, none.getSymbol());
		assertEquals(Symbol.SKIP, skip.getSymbol());
		assertEquals(Symbol.WILD, comodin.getSymbol());
		assertEquals(Symbol.WILD_DRAW_FOUR, mascuatro.getSymbol());

	}

}
