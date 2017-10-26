package model.card;

import model.card.type.CCard;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.Symbol;
import model.card.type.WildAndDrawFourCard;
import model.card.type.WildCard;

/**
 * Class for creating UNO Cards.
 * 
 * @author tverdugo
 *
 */
public class CardFactory {

	private Color color;
	private Symbol symbol;

	public CardFactory() {

	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;

	}

	public ICard createCard() {
		return new CCard(color, symbol);
	}

	public ICard createWild() {
		return new WildCard(Color.NONE, Symbol.WILD);
	}

	public ICard createWildAndDrawFour() {
		return new WildAndDrawFourCard(Color.NONE, Symbol.WILD_DRAW_FOUR);
	}

}
