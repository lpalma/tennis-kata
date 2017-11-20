import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

public class TennisGame1 implements TennisGame {

    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String DEUCE = "Deuce";
    public static final String ALL = "-All";

    private Map<Integer, String> scores = unmodifiableMap(of(
            new SimpleEntry<>(0, LOVE),
            new SimpleEntry<>(1, FIFTEEN),
            new SimpleEntry<>(2, THIRTY),
            new SimpleEntry<>(3, FORTY)

    ).collect(toMap(Entry::getKey, Entry::getValue)));

    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    public String getScore() {
        if (isEvenScore()) {
            return evenScore();
        }
        if (isRunningScore()) {
            return runningScore();
        }
        if (playerOneHasAdvantage()) {
            return "Advantage player1";
        }
        if (playerTwoHasAdvantage()) {
            return "Advantage player2";
        }
        return finalScore();
    }

    private boolean isEvenScore() {
        return playerOneScore == playerTwoScore;
    }

    private String evenScore() {
        return playerOneScore >= 3
                ? DEUCE
                : scores.get(playerOneScore) + ALL;
    }

    private boolean isRunningScore() {
        return playerOneScore < 4 && playerTwoScore < 4;
    }

    private String runningScore() {
        return scores.get(playerOneScore) + "-" + scores.get(playerTwoScore);
    }

    private boolean playerOneHasAdvantage() {
        return getPlayerOneAdvantage() == 1;
    }

    private boolean playerTwoHasAdvantage() {
        return getPlayerOneAdvantage() == -1;
    }

    private String finalScore() {
        if (getPlayerOneAdvantage() >= 2) {
            return "Win for player1";
        }
        return "Win for player2";
    }

    private int getPlayerOneAdvantage() {
        return playerOneScore - playerTwoScore;
    }
}
