package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.player.CPlayerListBuilder;
import model.player.IPlayerListBuilder;
import model.player.type.CPlayer;
import model.player.type.HumanPlayer;
import model.player.type.IPlayer;
import model.player.type.RandomPlayer;

public class IPlayerListBuilderTest {

	@Test
	public void testPlayerListBuilder() {
		IPlayerListBuilder playerListBuilder = new CPlayerListBuilder();
		ArrayList<IPlayer> players;
		playerListBuilder.addPlayer(new HumanPlayer());
		for (int i = 0; i < 10; i++) {
			playerListBuilder.addPlayer(new RandomPlayer());
		}
		players = playerListBuilder.buildPlayerList();

		assertEquals(11, players.size());
	}

}
