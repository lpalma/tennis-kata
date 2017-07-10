
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
        Scoreboard scoreboard = new Scoreboard(playerOne, playerTwo);

        return scoreboard.printScore();
    }

    private Player getPlayer(String playerName) {
        PlayerName name = new PlayerName(playerName);

        if (playerOne.hasName(name)) {
            return playerOne;
        }

        return playerTwo;
    }
}
