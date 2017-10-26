package model.card.type;

import controller.IController;
import model.IGameLogic;

public class WildCard extends CCard {

	public WildCard(Color color, Symbol symbol) {
		super(color, symbol);
	}

	@Override
	public boolean isPlayableOver(ICard otherCard) {
		return true;
	}

	@Override
	public boolean isFirstPlayable() {
		return false;
	}

	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		setColor(game.getCurrentPlayer().selectColor(game, ctrl));
	}

}
