public class PlayerName {
    private String name;

    public PlayerName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerName that = (PlayerName) o;

        return name.equals(that.name);
    }

    public String value() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
