package model.card.type;

import controller.IController;
import model.IGameLogic;

public class DrawCard extends CCard {

	public DrawCard(Color color, Symbol symbol) {
		super(color, symbol);
	}

	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		game.addToDrawWell(2);
		game.skipPlayer();
		ctrl.showMessage("el siguiente jugador pierde su turno y roba 2 cartas.");
	}
}
