package model.player.type;

import java.util.concurrent.ThreadLocalRandom;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;

public class RandomPlayer extends CPlayer {

	static int num = 1;
	int myNum;

	public RandomPlayer() {
		super();
		myNum = num;
		num++;
	}

	@Override
	public ICard getCardToPlay(IGameLogic game, IController ctrl) {
		return state.getCardToPlay(this, game, ctrl);
	}

	@Override
	public Color selectColor(IGameLogic game, IController ctrl) {
		int i = ThreadLocalRandom.current().nextInt(0, 3);
		return Color.getColors()[i];
	}

	@Override
	public String toString() {
		return "jugador virtual numero " + myNum + ".";
	}

}
