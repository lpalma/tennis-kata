
public class TennisGame1 implements TennisGame {

    private Player playerOne;
    private Player playerTwo;

    public TennisGame1(String playerOneName, String playerTwoName) {
        playerOne = new Player(new PlayerName(playerOneName));
        playerTwo = new Player(new PlayerName(playerTwoName));
    }

    public void wonPoint(String playerName) {
        getPlayer(playerName).newPoint();
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

    private Player getPlayer(String playerName) {
        PlayerName name = new PlayerName(playerName);

        if (playerOne.hasName(name)) {
            return playerOne;
        }

        return playerTwo;
    }

    private String formatPlayersScore() {
        String score = "";
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = playerOne.matchScore();
            else { score+="-"; tempScore = playerTwo.matchScore();}
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
        int minusResult = playerOne.matchScore() - playerTwo.matchScore();
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private boolean anyPlayerScoredFour() {
        return playerOne.matchScore() >=4 || playerTwo.matchScore() >=4;
    }

    private String formatDrawScore() {
        String score;

        switch (playerOne.matchScore())
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
        return playerOne.matchScore() == playerTwo.matchScore();
    }
}
