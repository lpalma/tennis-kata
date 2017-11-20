public class TennisGame1 implements TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private static final String DEUCE = "Deuce";
    private static final String ALL = "All";
    private static final String PLAYER_ONE = "player1";
    private static final String PLAYER_TWO = "player2";
    private static final String ADVANTAGE_FOR = "Advantage";
    private static final String WIN_FOR = "Win for";

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER_ONE)) {
            playerOneScore += 1;
        } else
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
            return ADVANTAGE_FOR + " " + PLAYER_ONE;
        }
        if (playerTwoHasAdvantage()) {
            return ADVANTAGE_FOR + " " + PLAYER_TWO;
        }
        return finalScore();
    }

    private boolean isEvenScore() {
        return playerOneScore == playerTwoScore;
    }

    private String evenScore() {
        return playerOneScore >= Score.FORTY.value()
                ? DEUCE
                : Score.fromValue(playerOneScore) + "-" + ALL;
    }

    private boolean isRunningScore() {
        int forty = Score.FORTY.value();

        return playerOneScore <= forty && playerTwoScore <= forty;
    }

    private String runningScore() {
        return Score.fromValue(playerOneScore)
                + "-"
                + Score.fromValue(playerTwoScore);
    }

    private boolean playerOneHasAdvantage() {
        return getPlayerOneAdvantage() == 1;
    }

    private boolean playerTwoHasAdvantage() {
        return getPlayerOneAdvantage() == -1;
    }

    private int getPlayerOneAdvantage() {
        return playerOneScore - playerTwoScore;
    }

    private String finalScore() {
        return getPlayerOneAdvantage() >= Score.THIRTY.value()
                ? WIN_FOR + " " + PLAYER_ONE
                : WIN_FOR + " " + PLAYER_TWO;
    }
}
