
public class TennisGame1 implements TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    public String getScore() {
        if (playerOneScore == playerTwoScore) {
            return evenScore();
        }

        if (playerOneScore < 4 && playerTwoScore < 4) {
            return temporaryScore();
        }

        int playerOneAdvantage = playerOneScore - playerTwoScore;

        if (playerOneAdvantage == 1) {
            return "Advantage player1";
        }

        if (playerOneAdvantage == -1) {
            return "Advantage player2";
        }

        return finalScore(playerOneAdvantage);

    }

    private String finalScore(int playerOneAdvantage) {
        if (playerOneAdvantage >= 2) {
            return "Win for player1";
        }
        return "Win for player2";
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

    private String temporaryScore() {
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
}
