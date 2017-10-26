package model.player.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.ICard;
import model.card.type.NullCard;

public class SkipedState implements IState {

	@Override
	public ICard getCardToPlay(HumanPlayer cPlayer, IGameLogic game, IController ctrl) {
		return playNull();
	}

	@Override
	public ICard getCardToPlay(RandomPlayer cPlayer, IGameLogic game, IController ctrl) {
		return playNull();

	}

	public ICard playNull() {
		return new NullCard();

	}

}
