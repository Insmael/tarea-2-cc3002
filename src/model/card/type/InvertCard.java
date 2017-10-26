package model.card.type;

import controller.IController;
import model.IGameLogic;

public class InvertCard extends CCard {

	public InvertCard(Color color, Symbol symbol) {
		super(color, symbol);
	}
	
	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		if (game.getNumOfPlayers() == 2) {
			game.skipPlayer();
			ctrl.showMessage("el siguiente jugador pierde su turno.");
		}
		else {
			game.invertDirection();
			ctrl.showMessage("el sentido del juego se invierte.");
		}
	}
	
	

}
