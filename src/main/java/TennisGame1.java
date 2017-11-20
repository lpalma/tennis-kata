import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

public class TennisGame1 implements TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";
    private static final String DEUCE = "Deuce";
    private static final String ALL = "-All";
    private static final String PLAYER_ONE = "player1";
    private static final String PLAYER_TWO = "player2";
    private static final String ADVANTAGE_FOR = "Advantage ";
    private static final String WIN_FOR = "Win for ";

    private Map<Integer, String> scores = unmodifiableMap(of(
            new SimpleEntry<>(0, LOVE),
            new SimpleEntry<>(1, FIFTEEN),
            new SimpleEntry<>(2, THIRTY),
            new SimpleEntry<>(3, FORTY)
    ).collect(toMap(Entry::getKey, Entry::getValue)));

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER_ONE))
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
            return ADVANTAGE_FOR + PLAYER_ONE;
        }
        if (playerTwoHasAdvantage()) {
            return ADVANTAGE_FOR + PLAYER_TWO;
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

    private int getPlayerOneAdvantage() {
        return playerOneScore - playerTwoScore;
    }

    private String finalScore() {
        return getPlayerOneAdvantage() >= 2
                ? WIN_FOR + PLAYER_ONE
                : WIN_FOR + PLAYER_TWO;
    }
}
