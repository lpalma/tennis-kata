package com.codurance.tennisKata.gameOne.resultBoard;

import com.codurance.tennisKata.gameOne.player.Player;

public class RegularBoard implements ResultBoard {
    private Player playerOne;
    private Player playerTwo;

    public RegularBoard(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String print() {
        return playerOne.printScore() + "-" + playerTwo.printScore();
    }
}
