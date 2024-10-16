package poker.game;

import poker.PokerGame;

public class DealingState implements GameState{

    @Override
    public void progressGame(PokerGame game) {
        System.out.println("Dealing...");
        game.deal();
        game.setState(new RedrawState());
    }
}
