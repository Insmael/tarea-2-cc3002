import controller.ConsoleController;
import model.CGameLogic;
import model.IGameLogic;
import model.player.CPlayerListBuilder;
import model.player.IPlayerListBuilder;
import model.player.type.HumanPlayer;
import model.player.type.RandomPlayer;
import view.ConsoleView;

/**
 * Main class of UNO Game
 * 
 * It instantiates model, view and controller and makes the turn loop
 * while the game hasn't ended.
 * @author eriveros
 *
 */
public class Main {

  public static void main(String[] args) {
    IPlayerListBuilder playerBuilder = new CPlayerListBuilder();
    playerBuilder.addPlayer(new HumanPlayer());
    playerBuilder.addPlayer(new RandomPlayer());
    playerBuilder.addPlayer(new RandomPlayer());
    playerBuilder.addPlayer(new RandomPlayer());
    IGameLogic game = new CGameLogic(playerBuilder.buildPlayerList());
    ConsoleView view = new ConsoleView(game);
    ConsoleController ctrl = new ConsoleController(game, view);
    while (!game.hasEnded()) {
      ctrl.playTurn();
    }
    game.announceWinner(ctrl);
  }
}
