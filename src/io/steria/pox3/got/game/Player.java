package io.steria.pox3.got.game;

import io.steria.pox3.got.objectives.ObjectiveCard;
import io.steria.pox3.got.story.House;
import io.steria.pox3.got.war.Direction;

public class Player {

	String name;
	
	//Bidirection, argh
	House house;
	ObjectiveCard card;
	PlayerState state = PlayerState.PLAYING;
	RoundState roundState = RoundState.WAITING;
	
	// Bidirection, argh
	Game game;
	Round currentRound;
	
	public int moves = 3;
	
	
	public Player(String name, House house) {
		this.name = name;
		this.house = house;
		//argh, bidirectionnel handling
		this.house.setPlayer(this);
		//but this link never moves. Not so bad
	}

	boolean chooseName(String pName) {

		this.name = pName;
		return true;
	}

	boolean chooseHouse(House pHouse) {

		this.house = pHouse;
		return true;
	}

	ObjectiveCard selectCard() {
		return null;
	}
	
	
	public void decreaseMoves() {
		if (this.roundState == RoundState.WAITING){
			throw new PlayerRoundEndedException();
	}
		this.moves --;
	}
}
