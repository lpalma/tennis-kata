package com.codurance.tennisKata.gameOne;

import com.codurance.tennisKata.TennisGame;
import com.codurance.tennisKata.gameOne.player.Player;
import com.codurance.tennisKata.gameOne.player.PlayerName;
import com.codurance.tennisKata.gameOne.resultBoard.ResultBoard;
import com.codurance.tennisKata.gameOne.score.Score;
import com.codurance.tennisKata.gameOne.score.Scoreboard;

public class TennisGame1 implements TennisGame {

    public static final int INITIAL_SCORE = 0;
    private Player playerOne;
    private Player playerTwo;

    public TennisGame1(String playerOneName, String playerTwoName) {
        playerOne = new Player(new PlayerName(playerOneName), new Score(INITIAL_SCORE));
        playerTwo = new Player(new PlayerName(playerTwoName), new Score(INITIAL_SCORE));
    }

    public void wonPoint(String playerName) {
        getPlayer(playerName).newPoint();
    }

    public String getScore() {
        ResultBoard resultBoard = resultBoard();

        return resultBoard.print();
    }

    private ResultBoard resultBoard() {
        Scoreboard scoreboard = new Scoreboard(playerOne, playerTwo);

        return scoreboard.getResultBoard();
    }

    private Player getPlayer(String playerName) {
        PlayerName name = new PlayerName(playerName);

        if (playerOne.hasName(name)) {
            return playerOne;
        }

        return playerTwo;
    }
}
