package com.codurance.tennisKata.gameTwo;

import com.codurance.tennisKata.TennisGame;

public class TennisGame2 implements TennisGame
{
    public static final String DEUCE = "Deuce";
    public static final String ADVANTAGE_PLAYER1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER2 = "Advantage player2";
    public static final String WIN_FOR_PLAYER1 = "Win for player1";
    public static final String WIN_FOR_PLAYER2 = "Win for player2";
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";

    public TennisGame2(String player1Name, String player2Name) {
    }

    public String getScore(){
        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2) {
            return WIN_FOR_PLAYER1;
        }

        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2) {
            return WIN_FOR_PLAYER2;
        }

        if (P1point > P2point && P2point >= 3) {
            return ADVANTAGE_PLAYER1;
        }

        if (P2point > P1point && P1point >= 3) {
            return ADVANTAGE_PLAYER2;
        }

        if (gameIsDrawn() && P1point>=3) {
            return DEUCE;
        }

        if (gameIsDrawn() && P1point < 4) {
            return getDrawnScore();
        }

        if (P1point > 0 && P2point==0) {
            return getScoreWhenPlayerTwoHasLovePoint();
        }

        if (P2point > 0 && P1point==0) {
            return getScoreWhenPlayerOneHasLovePoint();
        }

        if (P1point>P2point && P1point < 4) {
            return getScoreWhenPlayerOneIsAheadWithLessThanFortyPoints();
        }

        return getScoreWhenPlayerTwoIsHeadWithLessThanFortyPoints();
    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }

    private String getScoreWhenPlayerTwoIsHeadWithLessThanFortyPoints() {
        String score;
        if (P2point==2)
            P2res="Thirty";
        if (P2point==3)
            P2res="Forty";
        if (P1point==1)
            P1res="Fifteen";
        if (P1point==2)
            P1res="Thirty";
        score = P1res + "-" + P2res;
        return score;
    }

    private String getScoreWhenPlayerOneIsAheadWithLessThanFortyPoints() {
        String score;
        if (P1point==2)
            P1res="Thirty";
        if (P1point==3)
            P1res="Forty";
        if (P2point==1)
            P2res="Fifteen";
        if (P2point==2)
            P2res="Thirty";
        score = P1res + "-" + P2res;
        return score;
    }

    private String getScoreWhenPlayerOneHasLovePoint() {
        String score;
        if (P2point==1)
            P2res = "Fifteen";
        if (P2point==2)
            P2res = "Thirty";
        if (P2point==3)
            P2res = "Forty";

        P1res = "Love";
        score = P1res + "-" + P2res;
        return score;
    }

    private String getScoreWhenPlayerTwoHasLovePoint() {
        String score;
        if (P1point==1)
            P1res = "Fifteen";
        if (P1point==2)
            P1res = "Thirty";
        if (P1point==3)
            P1res = "Forty";

        P2res = "Love";
        score = P1res + "-" + P2res;
        return score;
    }

    private String getDrawnScore() {
        String score = "";
        if (P1point==0)
            score = "Love";
        if (P1point==1)
            score = "Fifteen";
        if (P1point==2)
            score = "Thirty";
        score += "-All";
        return score;
    }

    private boolean gameIsDrawn() {
        return P1point == P2point;
    }
}
