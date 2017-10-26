package model.card.deck;

import model.card.ICardPile;
import model.card.type.Color;
import model.card.type.Symbol;

public class NumericDeck extends CDeckStrategy {

	@Override
	public ICardPile createDeck() {
		addAllOfAColor(Color.BLUE);
		addAllOfAColor(Color.GREEN);
		addAllOfAColor(Color.RED);
		addAllOfAColor(Color.YELLOW);
		return deck;
	}

	@Override
	public void addAllOfAColor(Color color) {
		cardFactory.setColor(color);
		addOne(Symbol.ZERO);
		addTwo(Symbol.ONE);
		addTwo(Symbol.TWO);
		addTwo(Symbol.THREE);
		addTwo(Symbol.FOUR);
		addTwo(Symbol.FIVE);
		addTwo(Symbol.SIX);
		addTwo(Symbol.SEVEN);
		addTwo(Symbol.EIGHT);
		addTwo(Symbol.NINE);
	}
}
