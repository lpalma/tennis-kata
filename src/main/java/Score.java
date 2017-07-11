public class Score {
    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final String LOVE_TEXT = "Love";
    public static final String FIFTEEN_TEXT = "Fifteen";
    public static final String THIRTY_TEXT = "Thirty";
    public static final String FORTY_TEXT = "Forty";
    private int value;

    public Score(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public boolean isLove() {
        return value() == LOVE;
    }

    public boolean isFifteen() {
        return value() == FIFTEEN;
    }

    public boolean isThirty() {
        return value() == THIRTY;
    }

    public String print() {
        if (isLove()) {
            return LOVE_TEXT;
        }

        if (isFifteen()) {
            return FIFTEEN_TEXT;
        }

        if (isThirty()) {
            return THIRTY_TEXT;
        }

        return FORTY_TEXT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        return value == score.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
