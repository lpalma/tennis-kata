public class TennisGame1 implements TennisGame {

    private final String playerOne;
    private final String playerTwo;
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private static final String DEUCE = "Deuce";
    private static final String ALL = "All";
    private static final String ADVANTAGE_FOR = "Advantage";
    private static final String WIN_FOR = "Win for";

    public TennisGame1(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(playerOne)) {
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
            return advantageFor(playerOne);
        }

        if (playerTwoHasAdvantage()) {
            return advantageFor(playerTwo);
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

    private String advantageFor(String player) {
        return ADVANTAGE_FOR + " " + player;
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
                ? WIN_FOR + " " + playerOne
                : WIN_FOR + " " + playerTwo;
    }
}
