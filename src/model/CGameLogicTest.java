package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.ConsoleController;
import model.player.CPlayerListBuilder;
import model.player.IPlayerListBuilder;
import model.player.type.HumanPlayer;
import model.player.type.RandomPlayer;
import view.ConsoleView;

public class CGameLogicTest {

	IPlayerListBuilder playerBuilder;
	IGameLogic game;
	ConsoleView view;
	ConsoleController ctrl;

	@Before
	public void setUp() {
		playerBuilder = new CPlayerListBuilder();
		playerBuilder.addPlayer(new HumanPlayer());
		playerBuilder.addPlayer(new RandomPlayer());
		playerBuilder.addPlayer(new RandomPlayer());
		playerBuilder.addPlayer(new RandomPlayer());
		game = new CGameLogic(playerBuilder.buildPlayerList());
		view = new ConsoleView(game);
		ctrl = new ConsoleController(game, view);
	}

	@Test
	public void testWeell() {

		assertTrue(game.isDrawWellEmpty());
		game.addToDrawWell(5);
		assertFalse(game.isDrawWellEmpty());
		game.drawCardsFromWell(null, ctrl);
		assertTrue(game.isDrawWellEmpty());
	}

	@Test
	public void testSkipPlayer() {
		game.skipPlayer();
		game.startTurn(ctrl);

	}

}
