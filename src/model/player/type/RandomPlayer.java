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
		if (needsToDrawCard(game.getCurrentPlayedCard())) {
			game.drawOneCard(this);
			alredyDraw = true;
		}
		int i = ThreadLocalRandom.current().nextInt(0, getHandSize());
		while (!hand.get(i).isPlayableOver(game.getCurrentPlayedCard()))
			i = ThreadLocalRandom.current().nextInt(0, getHandSize());
		return hand.get(i);
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
