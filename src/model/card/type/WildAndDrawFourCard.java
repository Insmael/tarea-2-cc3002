package model.card.type;

import controller.IController;
import model.IGameLogic;

public class WildAndDrawFourCard extends WildCard {

	public WildAndDrawFourCard(Color color, Symbol symbol) {
		super(color, symbol);
	}

	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		game.addToDrawWell(4);
		game.skipPlayer();
		ctrl.showMessage("el siguiente jugador pierde su turno y roba 4 cartas.");
		super.executeAction(game, ctrl);
	}
}
