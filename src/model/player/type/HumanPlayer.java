package model.player.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;

public class HumanPlayer extends CPlayer {

	@Override
	public ICard getCardToPlay(IGameLogic game, IController ctrl) {
		int i = ctrl.AskForCardFromHand(this);
		if (i == getHandSize()) 
			game.drawOneCard(this);
		return getCardFromHand(i);
	}

	@Override
	public Color selectColor(IGameLogic game, IController ctrl) {
		return ctrl.askForColor();
	}
	
	@Override
	public String toString() {
		return "jugador humano.";
	}

}
