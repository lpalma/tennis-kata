package com.codurance.tennisKata.gameOne.resultBoard;

import com.codurance.tennisKata.gameOne.player.Player;
import com.codurance.tennisKata.gameOne.score.Score;

public class DrawBoard implements ResultBoard {
    public static final String DEUCE = "Deuce";
    public static final String ALL = "All";
    private Player player;

    public DrawBoard(Player player) {
        this.player = player;
    }

    public String print() {
        return formatDrawScore();
    }

    private String formatDrawScore() {
        Score score = player.matchScore();

        if (score.isForty() || score.isGame()) {
            return DEUCE;
        }

        return score.print() + "-" + ALL;
    }
}
