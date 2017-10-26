package model.card.type;

import controller.IController;
import model.IGameLogic;

public class SkipCard extends CCard {

	public SkipCard(Color color, Symbol symbol) {
		super(color, symbol);
	}

	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		game.skipPlayer();
		ctrl.showMessage("el siguiente jugador pierde su turno.");
	}

}
