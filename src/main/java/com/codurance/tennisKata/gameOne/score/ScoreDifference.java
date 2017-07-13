package com.codurance.tennisKata.gameOne.score;

public class ScoreDifference {
    public static final int IN_ADVANTAGE = 1;
    public static final int IN_DISADVANTAGE = -1;
    public static final int WIN = 2;
    public static final int DRAW = 0;
    private int value;

    public ScoreDifference(int value) {
        this.value = value;
    }

    public boolean isDraw() {
        return value == DRAW;
    }

    public boolean isInAdvantage() {
        return value == IN_ADVANTAGE;
    }

    public boolean isInDisadvantage() {
        return value == IN_DISADVANTAGE;
    }

    public boolean isWin() {
        return value >= WIN;
    }
}
