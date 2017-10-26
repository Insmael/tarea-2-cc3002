package model.card.type;

import controller.IController;
import model.IGameLogic;

public class NullCard implements ICard {

	@Override
	public boolean isPlayableOver(ICard otherCard) {
		return true;
	}

	@Override
	public boolean isFirstPlayable() {
		return false;
	}

	@Override
	public Color getColor() {
		return Color.NONE;
	}

	@Override
	public Symbol getSymbol() {
		return Symbol.NONE;
	}

	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
	}

	@Override
	public boolean isDiscardable() {
		return false;
	}

}
