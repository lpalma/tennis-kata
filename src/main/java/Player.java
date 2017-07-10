public class Player {
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
}
