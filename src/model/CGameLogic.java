package model;

import java.util.ArrayList;

import controller.IController;
import model.card.CCardPileManager;
import model.card.ICardPilesManager;
import model.card.deck.CDeckStrategy;
import model.card.type.ICard;
import model.player.CPlayerManager;
import model.player.IPlayerManager;
import model.player.type.IPlayer;

public class CGameLogic implements IGameLogic {

	ICardPilesManager cardPileManager;
	IPlayerManager playerManager;
	ArrayList<ICard> drawWell;

	public CGameLogic(ArrayList<IPlayer> players) {
		cardPileManager = new CCardPileManager(new CDeckStrategy().createDeck());
		playerManager = new CPlayerManager(players);
		drawWell = new ArrayList<ICard>();
		for (IPlayer player : playerManager.getPlayers()) {
			cardPileManager.addCardsToPlayer(player, 7);
		}
	}

	@Override
	public boolean hasEnded() {
		for (IPlayer p : playerManager.getPlayers())
			if (p.hasWon()) {
				return true;
			}
		return false;
	}

	@Override
	public IPlayer getCurrentPlayer() {
		return playerManager.getCurrentPlayer();
	}

	@Override
	public ICard getCurrentPlayedCard() {
		return cardPileManager.getCurrentPlayedCard();
	}

	@Override
	public void autoShoutUNO(IController ctrl) {
		getCurrentPlayer().setSaidUNO(true);
		ctrl.showMessage("UNO!");
	}

	@Override
	public void startTurn(IController ctrl) {
		if (!getCurrentPlayer().hasOneCard()) {
			getCurrentPlayer().setSaidUNO(false);
		}
		if (getCurrentPlayer().hasOneCard() && !getCurrentPlayer().hasSaidUNO())
			autoShoutUNO(ctrl);
		playerManager.startTurn();
		drawCardsFromWell(getCurrentPlayer(), ctrl);

	}

	@Override
	public void skipPlayer() {
		playerManager.skipPlayer();
	}

	@Override
	public void addToDrawWell(int number) {
		drawWell.addAll(cardPileManager.drawCards(number));

	}

	@Override
	public void resetDrawWell() {
		drawWell.clear();

	}

	@Override
	public boolean isDrawWellEmpty() {
		return drawWell.isEmpty();
	}

	@Override
	public void drawCardsFromWell(IPlayer player, IController ctrl) {
		if (!isDrawWellEmpty()) {
			player.addToHand(drawWell);
			ctrl.showMessage("el jugador roba " + drawWell + " cartas.");
			resetDrawWell();
		}
	}

	@Override
	public void invertDirection() {
		playerManager.invertDirection();

	}

	@Override
	public boolean playCard(ICard playedCard, IController ctrl) {
		if (playedCard.isPlayableOver(cardPileManager.getCurrentPlayedCard())) {
			playedCard.executeAction(this, ctrl);
			getCurrentPlayer().removeCardFromHand(playedCard);
			if (playedCard.isDiscardable())
				cardPileManager.discard(playedCard);
			return true;
		}
		return false;
	}

	@Override
	public ICard drawOneCard(IPlayer player) {
		ICard card = cardPileManager.drawCard();
		ArrayList<ICard> cardAsList = new ArrayList<ICard>();
		cardAsList.add(card);
		player.addToHand(cardAsList);
		if (!getCurrentPlayer().hasOneCard()) {
			getCurrentPlayer().setSaidUNO(false);
		}
		return card;
	}

	@Override
	public void announceWinner(IController ctrl) {
		for (IPlayer p : playerManager.getPlayers())
			if (p.hasWon()) {
				ctrl.showMessage("el ganador es " + p + "!");
				break;
			}

	}

	@Override
	public int getNumOfPlayers() {
		return playerManager.getPlayers().size();
	}
}
