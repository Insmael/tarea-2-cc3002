package model.player.type;

import java.util.ArrayList;
import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NullCard;

public abstract class CPlayer implements IPlayer {

	protected ArrayList<ICard> hand;
	protected boolean saidUnoStatus;
	public IState state;

	public CPlayer() {
		hand = new ArrayList<ICard>();
		saidUnoStatus = false;
		state = new UnSkipedState();
	}

	@Override
	public void addToHand(ArrayList<ICard> hand) {
		for (ICard card : hand) {
			this.hand.add(card);
		}
	}

	@Override
	public boolean hasWon() {
		return hand.isEmpty();
	}

	@Override
	public abstract ICard getCardToPlay(IGameLogic game, IController ctrl);

	@Override
	public abstract Color selectColor(IGameLogic game, IController ctrl);

	@Override
	public int getHandSize() {
		return hand.size();
	}

	@Override
	public boolean hasOneCard() {
		return getHandSize() == 1;
	}

	@Override
	public ArrayList<ICard> getHand() {
		return hand;
	}

	@Override
	public void setSaidUNO(boolean status) {
		saidUnoStatus = status;

	}

	@Override
	public boolean hasSaidUNO() {
		return saidUnoStatus;
	}

	@Override
	public void removeCardFromHand(ICard card) {
		hand.remove(card);
	}

	@Override
	public boolean needsToDrawCard(ICard currentCard) {
		boolean needs = true;
		for (ICard card : hand) {
			if (card.isPlayableOver(currentCard)) {
				needs = false;
				break;
			}
		}
		return needs;
	}

	@Override
	public ICard getCardFromHand(int number) {
		ICard card = new NullCard();
		if (number < getHandSize() && number >= 0) {
			card = hand.get(number);
		}
		return card;
	}

	public void setSkiped() {
		state = new SkipedState();

	}

	public void setUnskiped() {
		state = new UnSkipedState();
	}
}
