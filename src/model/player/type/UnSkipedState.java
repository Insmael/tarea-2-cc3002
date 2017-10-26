package model.player.type;

import java.util.concurrent.ThreadLocalRandom;

import controller.IController;
import model.IGameLogic;
import model.card.type.ICard;
import model.card.type.NullCard;

public class UnSkipedState implements IState {

	@Override
	public ICard getCardToPlay(HumanPlayer cPlayer, IGameLogic game, IController ctrl) {
		int i = ctrl.AskForCardFromHand(cPlayer);
		if (i == cPlayer.getHandSize()) {
			game.drawOneCard(cPlayer);
		}
		return cPlayer.getCardFromHand(i);

	}

	@Override
	public ICard getCardToPlay(RandomPlayer cPlayer, IGameLogic game, IController ctrl) {
		if (cPlayer.needsToDrawCard(game.getCurrentPlayedCard())) {
			game.drawOneCard(cPlayer);
		}
		int i = ThreadLocalRandom.current().nextInt(0, cPlayer.getHandSize());
		while (!cPlayer.hand.get(i).isPlayableOver(game.getCurrentPlayedCard()))
			i = ThreadLocalRandom.current().nextInt(0, cPlayer.getHandSize());
		return cPlayer.hand.get(i);
	}

}
