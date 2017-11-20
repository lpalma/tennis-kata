
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
        String score = "";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = playerOneScore;
            } else {
                score += "-";
                tempScore = playerTwoScore;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
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
