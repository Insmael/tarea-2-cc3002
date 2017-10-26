package model.player.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.ICard;

public interface IState {

	ICard getCardToPlay(HumanPlayer cPlayer, IGameLogic game, IController ctrl);

	ICard getCardToPlay(RandomPlayer cPlayer, IGameLogic game, IController ctrl);

}
