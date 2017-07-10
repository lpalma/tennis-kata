public class WinBoard implements ResultBoard {
    private Player player;

    public WinBoard(Player player) {
        this.player = player;
    }

    public String print() {
        return "Win for " + player.name();
    }
}
