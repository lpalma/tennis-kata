
public class TennisGame1 implements TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    public String getScore() {
        if (isEvenScore()) {
            return evenScore();
        }
        if (isRunningScore()) {
            return runningScore();
        }
        if (playerOneHasAdvantage()) {
            return "Advantage player1";
        }
        if (playerTwoHasAdvantage()) {
            return "Advantage player2";
        }
        return finalScore();
    }

    private boolean isEvenScore() {
        return playerOneScore == playerTwoScore;
    }

    private String evenScore() {
        switch (playerOneScore) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private boolean isRunningScore() {
        return playerOneScore < 4 && playerTwoScore < 4;
    }

    private String runningScore() {
        return getPlayerScore(playerOneScore) + "-" + getPlayerScore(playerTwoScore);
    }

    private String getPlayerScore(int playerScore) {
        switch (playerScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private boolean playerOneHasAdvantage() {
        return getPlayerOneAdvantage() == 1;
    }

    private boolean playerTwoHasAdvantage() {
        return getPlayerOneAdvantage() == -1;
    }

    private String finalScore() {
        if (getPlayerOneAdvantage() >= 2) {
            return "Win for player1";
        }
        return "Win for player2";
    }

    private int getPlayerOneAdvantage() {
        return playerOneScore - playerTwoScore;
    }
}
