
public class TennisGame1 implements TennisGame {

    public static final String PLAYER_ONE = "player1";
    private int m_score1 = 0;
    private int m_score2 = 0;

    public TennisGame1(String player1Name, String player2Name) {
    }

    public void wonPoint(String playerName) {
        if (isPlayerOne(playerName))
            pointForPlayerOne();
        else
            pointForPlayerTwo();
    }

    public String getScore() {
        String score = "";
        int tempScore=0;

        if (isDraw()) {
            return formatDrawScore();
        }

        if (anyPlayerScoredFour()) {
            return formatAdvantageOrWinScore();
        }
        
        for (int i=1; i<3; i++)
        {
            if (i==1) tempScore = m_score1;
            else { score+="-"; tempScore = m_score2;}
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
        int minusResult = m_score1-m_score2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private boolean anyPlayerScoredFour() {
        return m_score1>=4 || m_score2>=4;
    }

    private String formatDrawScore() {
        String score;

        switch (m_score1)
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
        return m_score1==m_score2;
    }

    private boolean isPlayerOne(String playerName) {
        return playerName == PLAYER_ONE;
    }

    private void pointForPlayerTwo() {
        m_score2 += 1;
    }

    private void pointForPlayerOne() {
        m_score1 += 1;
    }
}
