package model.card;

import java.util.ArrayList;

import model.card.type.ICard;
import model.player.type.IPlayer;

public class CCardPileManager implements ICardPilesManager {

	private ICardPile deck;
	private ICardPile discards;

	public CCardPileManager(ICardPile deck) {
		this.deck = deck;
		discards = new CCardPile();
		deck.shuffle();
		discard(drawCard());
		while (!getCurrentPlayedCard().isFirstPlayable()) {
			rebuildDeck();
			discard(drawCard());
		}
	}

	@Override
	public void rebuildDeck() {
		ICard lastCard = discards.popCard();
		deck.pushCards(discards);
		discards.pushCard(lastCard);
		deck.shuffle();

	}

	@Override
	public ICard drawCard() {
		if (deck.isEmpty()) {
			rebuildDeck();
		}
		return deck.popCard();
	}

	@Override
	public int getDrawableCardsNumber() {
		return deck.getSize() + discards.getSize() - 1;
	}

	@Override
	public ArrayList<ICard> drawCards(int cardsNumber) {
		ArrayList<ICard> drawedCards = new ArrayList<ICard>();
		while (!deck.isEmpty() && 0 < cardsNumber && cardsNumber <= getDrawableCardsNumber()) {
			drawedCards.add(deck.popCard());
			cardsNumber--;
		}
		if (0 < cardsNumber && cardsNumber <= getDrawableCardsNumber()) {
			rebuildDeck();
			// TODO verificar que efectivamente se puede usar el metodo addAll
			drawedCards.addAll(drawCards(cardsNumber));
		}
		return drawedCards;
	}

	@Override
	public ICard getCurrentPlayedCard() {
		return discards.peekCard();
	}

	@Override
	public void discard(ICard newCard) {
		discards.pushCard(newCard);

	}

	@Override
	public ArrayList<ICard> addCardsToPlayer(IPlayer player, int number) {
		ArrayList<ICard> drawedCards = drawCards(number);
		player.addToHand(drawedCards);
		return drawedCards;
	}

}
