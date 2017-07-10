
public class TennisGame1 implements TennisGame {

    public static final String PLAYER_ONE = "player1";
    private int playerOneMatchScore = 0;
    private int playerTwoMatchScore = 0;

    public TennisGame1(String playerOneName, String playerTwoName) {
    }

    public void wonPoint(String playerName) {
        if (isPlayerOne(playerName))
            pointForPlayerOne();
        else
            pointForPlayerTwo();
    }

    public String getScore() {
        if (isDraw()) {
            return formatDrawScore();
        }

        if (anyPlayerScoredFour()) {
            return formatAdvantageOrWinScore();
        }

        return formatPlayersScore();
    }

    private String formatPlayersScore() {
        String score = "";
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = playerOneMatchScore;
            else { score+="-"; tempScore = playerTwoMatchScore;}
            switch(tempScore)
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }

    private String formatAdvantageOrWinScore() {
        String score;
        int minusResult = playerOneMatchScore - playerTwoMatchScore;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private boolean anyPlayerScoredFour() {
        return playerOneMatchScore >=4 || playerTwoMatchScore >=4;
    }

    private String formatDrawScore() {
        String score;

        switch (playerOneMatchScore)
        {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            default:
                    score = "Deuce";
                break;
        }

        return score;
    }

    private boolean isDraw() {
        return playerOneMatchScore == playerTwoMatchScore;
    }

    private boolean isPlayerOne(String playerName) {
        return playerName == PLAYER_ONE;
    }

    private void pointForPlayerTwo() {
        playerTwoMatchScore += 1;
    }

    private void pointForPlayerOne() {
        playerOneMatchScore += 1;
    }
}
