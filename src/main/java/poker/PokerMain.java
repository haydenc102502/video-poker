package poker;

public class PokerMain {
    public static void main(String[] args) {
        PokerGame game = new PokerGame();
        while(game.getScore() > 0) {
            game.progressGame();
        }
    }
}
