package model.card.deck;

import model.card.CCardPile;
import model.card.CardFactory;
import model.card.ICardPile;
import model.card.type.Color;
import model.card.type.Symbol;

public class CDeckStrategy implements IDeckStrategy {
	
	protected CardFactory cardFactory = new CardFactory();
	protected ICardPile deck = new CCardPile();
	
	@Override
	public ICardPile createDeck() {
		addAllOfAColor(Color.BLUE);
		addAllOfAColor(Color.GREEN);
		addAllOfAColor(Color.RED);
		addAllOfAColor(Color.YELLOW);
		deck.pushCard(cardFactory.createWild());
		deck.pushCard(cardFactory.createWild());
		deck.pushCard(cardFactory.createWild());
		deck.pushCard(cardFactory.createWild());
		deck.pushCard(cardFactory.createWildAndDrawFour());
		deck.pushCard(cardFactory.createWildAndDrawFour());
		deck.pushCard(cardFactory.createWildAndDrawFour());
		deck.pushCard(cardFactory.createWildAndDrawFour());
		return deck;
	}
	
	public void addOne(Symbol symbol) {
		cardFactory.setSymbol(symbol);
		deck.pushCard(cardFactory.createCard());
		
	}
	
	public void addTwo(Symbol symbol) {
		cardFactory.setSymbol(symbol);
		deck.pushCard(cardFactory.createCard());
		deck.pushCard(cardFactory.createCard());
		
	}
	
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
		addTwo(Symbol.SKIP);
		addTwo(Symbol.INVERT);
		addTwo(Symbol.DRAW_TWO);	
	}

}
