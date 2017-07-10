
public class Scoreboard {
    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final String LOVE_ALL = "Love-All";
    public static final String FIFTEEN_ALL = "Fifteen-All";
    public static final String THIRTY_ALL = "Thirty-All";
    public static final String DEUCE = "Deuce";
    private Player playerOne;
    private Player playerTwo;

    public Scoreboard(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String printScore() {
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
        int score = playerOne.matchScore();

        if (score == LOVE) {
            return LOVE_ALL;
        }

        if (score == FIFTEEN) {
            return FIFTEEN_ALL;
        }

        if (score == THIRTY) {
            return THIRTY_ALL;
        }

        return DEUCE;
    }

    private boolean isDraw() {
        return playerOne.matchScore() == playerTwo.matchScore();
    }
}
