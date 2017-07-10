public class AdvantageBoard implements ResultBoard {
    private Player player;

    public AdvantageBoard(Player player) {
        this.player = player;
    }

    public String print() {
        return "Advantage " + player.name();
    }
}
