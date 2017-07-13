package com.codurance.tennisKata.gameOne.resultBoard;

import com.codurance.tennisKata.gameOne.player.Player;

public class AdvantageBoard implements ResultBoard {
    private Player player;

    public AdvantageBoard(Player player) {
        this.player = player;
    }

    public String print() {
        return "Advantage " + player.name();
    }
}
