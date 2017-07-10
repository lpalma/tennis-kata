public class Player {
    private PlayerName name;
    private int matchScore = 0;

    public Player(PlayerName name) {
        this.name = name;
    }

    public boolean hasName(PlayerName playerName) {
        return name.equals(playerName);
    }

    public void newPoint() {
        ++matchScore;
    }

    public int matchScore() {
        return matchScore;
    }
}