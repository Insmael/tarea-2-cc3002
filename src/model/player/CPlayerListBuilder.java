package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;

public class CPlayerListBuilder implements IPlayerListBuilder {

	ArrayList<IPlayer> players;
	
	public CPlayerListBuilder() {
		players = new ArrayList<IPlayer>();
	}
	
	@Override
	public void addPlayer(IPlayer player) {
		players.add(player);

	}

	@Override
	public ArrayList<IPlayer> buildPlayerList() {
		ArrayList<IPlayer> playerList = new ArrayList<IPlayer>(players);
		players = new ArrayList<IPlayer>();
		return playerList;
	}

}
