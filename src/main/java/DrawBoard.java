public class DrawBoard implements ResultBoard {
    public static final String LOVE_ALL = "Love-All";
    public static final String FIFTEEN_ALL = "Fifteen-All";
    public static final String THIRTY_ALL = "Thirty-All";
    public static final String DEUCE = "Deuce";
    private Player player;

    public DrawBoard(Player player) {
        this.player = player;
    }

    public String print() {
        return formatDrawScore();
    }

    private String formatDrawScore() {
        Score score = player.matchScore();

        if (score.isLove()) {
            return LOVE_ALL;
        }

        if (score.isFifteen()) {
            return FIFTEEN_ALL;
        }

        if (score.isThirty()) {
            return THIRTY_ALL;
        }

        return DEUCE;
    }
}
