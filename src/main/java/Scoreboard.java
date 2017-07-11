
public class Scoreboard {
    private Player playerOne;
    private Player playerTwo;

    public Scoreboard(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String printScore() {
        if (isDraw() || anyPlayerScoredFour()) {
            return resultBoard().print();
        }

        return formatPlayersScore();
    }

    private String formatPlayersScore() {
        return playerOne.printScore() + "-" + playerTwo.printScore();
    }

    private ResultBoard resultBoard() {
        ScoreDifference scoreDifference = playerOne.compareAgainst(playerTwo);

        if (scoreDifference.isDraw()) {
            return new DrawBoard(playerOne);
        }

        if (scoreDifference.isInAdvantage()) {
            return new AdvantageBoard(playerOne);
        }

        if (scoreDifference.isInDisadvantage()) {
            return new AdvantageBoard(playerTwo);
        }

        if (scoreDifference.isWin()) {
            return new WinBoard(playerOne);
        }

        return new WinBoard(playerTwo);
    }

    private boolean anyPlayerScoredFour() {
        return playerOne.hasGamePoint() || playerTwo.hasGamePoint();
    }

    private boolean isDraw() {
        return playerOne.matchScore()
                .equals(playerTwo.matchScore());
    }
}
