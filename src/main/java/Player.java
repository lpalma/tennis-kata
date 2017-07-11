public class Player {
    public static final int FORTY = 4;
    private PlayerName name;
    private Score matchScore;

    public Player(PlayerName name, Score initialScore) {
        this.name = name;
        matchScore = initialScore;
    }

    public boolean hasName(PlayerName playerName) {
        return name.equals(playerName);
    }

    public void newPoint() {
        int newScore = matchScore.value() + 1;

        matchScore = new Score(newScore);
    }

    public Score matchScore() {
        return new Score(matchScore.value());
    }

    public boolean hasGamePoint() {
        return matchScore.value() >= FORTY;
    }

    public ScoreDifference compareAgainst(Player player) {
        int difference = matchScore().value() - player.matchScore().value();

        return new ScoreDifference(difference);
    }

    public String name() {
        return name.value();
    }

    public String printScore() { return matchScore.print(); }
}
