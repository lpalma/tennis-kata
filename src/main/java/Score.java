import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Optional;

public enum Score {
    LOVE(0, "Love"),
    FIFTEEN(1, "Fifteen"),
    THIRTY(2, "Thirty"),
    FORTY(3, "Forty");

    private final int value;
    private final String name;

    Score(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int value() {
        return value;
    }

    public static String fromValue(int value) {
        Optional<Score> score = Arrays.stream(values())
                .filter(score1 -> score1.value == value)
                .findFirst();

        if (!score.isPresent()) {
            throw new InvalidParameterException();
        }

        return score.get().name;
    }
}
