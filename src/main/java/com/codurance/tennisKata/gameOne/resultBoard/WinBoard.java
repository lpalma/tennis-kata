package com.codurance.tennisKata.gameOne.resultBoard;

import com.codurance.tennisKata.gameOne.player.Player;

public class WinBoard implements ResultBoard {
    private Player player;

    public WinBoard(Player player) {
        this.player = player;
    }

    public String print() {
        return "Win for " + player.name();
    }
}
