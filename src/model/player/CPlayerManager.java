package model.player;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import model.player.type.IPlayer;

public class CPlayerManager implements IPlayerManager {

	ArrayList<IPlayer> players;
	int current;
	int direction;
	boolean skipPlayer;

	public CPlayerManager(ArrayList<IPlayer> players) {
		this.players = players;
		current = ThreadLocalRandom.current().nextInt(0, players.size() - 1);
		direction = 1;
		skipPlayer = false;
	}

	@Override
	public IPlayer getCurrentPlayer() {
		return players.get(current);
	}

	@Override
	public ArrayList<IPlayer> getPlayers() {
		return players;
	}

	@Override
	public void invertDirection() {
		direction *= -1;

	}

	@Override
	public void startTurn() {
		current = nextPlayer();
		if (skipPlayer) {
			getCurrentPlayer().setSkiped();
			skipPlayer = false;
		} else
			getCurrentPlayer().setUnskiped();
	}

	@Override
	public void skipPlayer() {
		skipPlayer = true;
	}

	private int nextPlayer() {
		int nextp = direction + current;
		if (nextp < 0)
			nextp = players.size() - 1;
		else if (nextp == players.size())
			nextp = 0;
		return nextp;
	}
}
