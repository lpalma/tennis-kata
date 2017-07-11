
public class Scoreboard {
    public static final int ADVANTAGE_PLAYER_ONE = 1;
    public static final int ADVANTAGE_PLAYER_TWO = -1;
    public static final int WIN_PLAYER_ONE = 2;
    public static final int DRAW = 0;
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
        int scoreDifference = playerOne.compareAgainst(playerTwo);

        if (scoreDifference == DRAW) {
            return new DrawBoard(playerOne);
        }

        if (scoreDifference == ADVANTAGE_PLAYER_ONE) {
            return new AdvantageBoard(playerOne);
        }

        if (scoreDifference == ADVANTAGE_PLAYER_TWO) {
            return new AdvantageBoard(playerTwo);
        }

        if (scoreDifference >= WIN_PLAYER_ONE) {
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
