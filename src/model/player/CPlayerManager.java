package model.player;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import model.player.type.IPlayer;

public class CPlayerManager implements IPlayerManager {
	
	ArrayList<IPlayer> players;
	int current;
	Direction direction;
	boolean skipPlayer;
	
	
	public CPlayerManager(ArrayList<IPlayer> players) {
		this.players = players;
		current = ThreadLocalRandom.current().nextInt(0, players.size()-1);;
		direction = Direction.COUNTERCLOCKWISE;
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
		if (direction == Direction.CLOCKWISE)
			direction = Direction.COUNTERCLOCKWISE;
		else
			direction = Direction.CLOCKWISE;

	}

	@Override
	public void startTurn() {
		current = nextPlayer();
	}

	@Override
	public void skipPlayer() {
		skipPlayer = true;
	}
	
	private int nextPlayer() {
		int nextp = direction.getValue() + current;
		if (nextp < 0)
			nextp = players.size() - 1;
		else if (nextp == players.size())
			nextp = 0;
		return nextp;
	}
}
