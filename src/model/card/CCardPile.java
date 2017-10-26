package model.card;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;

import model.card.type.CCard;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.Symbol;

public class CCardPile implements ICardPile {

	List<ICard> pile;
	
	public CCardPile() {
		pile = new ArrayList<ICard>();
	}
	
	@Override
	public int getSize() {
		return pile.size();
	}

	@Override
	public ICard pushCard(ICard newCard) {
		pile.add(newCard);
		return pile.get(getSize()-1);
	}

	@Override
	public ICard popCard() {
		if (!isEmpty())
			return pile.remove(getSize()-1);
		else
			return new CCard(Color.NONE, Symbol.NONE);
	}

	@Override
	public ICard peekCard() {
		if (!isEmpty())
			return pile.get(getSize()-1);
		else
			return new CCard(Color.NONE, Symbol.NONE);
	}

	@Override
	public void shuffle() {
		List<ICard> newPile = new ArrayList<ICard>();
		int j;
		for (int i = getSize(); i>0;i--) {
			j = ThreadLocalRandom.current().nextInt(0, i);
			newPile.add(pile.remove(j));
		}
		pile = newPile;
	}

	@Override
	public boolean isEmpty() {
		return pile.isEmpty();
	}

	@Override
	public void pushCards(ICardPile otherPile) {
		int n = otherPile.getSize();
		for(int i = 0; i < n; i++) {
			pushCard(otherPile.popCard());
		}
	}

}
