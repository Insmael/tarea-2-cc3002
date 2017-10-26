package model.card.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.Symbol;

/**
 * Class for UNO Cards.
 * 
 * @author tverdugo
 *
 */
public class CCard implements ICard {

	private Color color;
	private Symbol symbol;

	public CCard(Color color, Symbol symbol) {
		this.color = color;
		this.symbol = symbol;
	}

	@Override
	public boolean isPlayableOver(ICard otherCard) {
		return this.color == otherCard.getColor() || this.symbol == otherCard.getSymbol();
	}

	@Override
	public boolean isFirstPlayable() {
		return this.color != Color.NONE;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public Symbol getSymbol() {
		return symbol;
	}

	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
	}

	@Override
	public boolean isDiscardable() {
		return true;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		String strRep = this.getSymbol().getName() + " " + this.getColor().getName() + ".";
		return strRep;
	}

}
