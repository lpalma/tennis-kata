package com.codurance.tennisKata.gameOne.score;

import com.codurance.tennisKata.gameOne.player.Player;
import com.codurance.tennisKata.gameOne.resultBoard.*;

public class Scoreboard {
    private Player playerOne;
    private Player playerTwo;

    public Scoreboard(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public ResultBoard getResultBoard() {
        return resultBoard();
    }

    private ResultBoard resultBoard() {
        ScoreDifference scoreDifference = playerOne.compareAgainst(playerTwo);

        if (scoreDifference.isDraw()) {
            return new DrawBoard(playerOne);
        }

        if (anyPlayerHasGamePoint()) {
            return resultForGamePoint(scoreDifference);
        }

        return new RegularBoard(playerOne, playerTwo);
    }

    private ResultBoard resultForGamePoint(ScoreDifference scoreDifference) {
        if (scoreDifference.isInAdvantage()) {
            return new AdvantageBoard(playerOne);
        }

        if (scoreDifference.isInDisadvantage()) {
            return new AdvantageBoard(playerTwo);
        }

        if (scoreDifference.isWin()) {
            return new WinBoard(playerOne);
        }

        return new WinBoard(playerTwo);
    }

    private boolean anyPlayerHasGamePoint() {
        return playerOne.hasGamePoint() || playerTwo.hasGamePoint();
    }
}
