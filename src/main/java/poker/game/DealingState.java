package poker.game;

import poker.PokerGame;

/**
 * Concrete state for dealing the intitial 5 card hand.
 * 
 * @author Hayden Cabral
 */
public class DealingState implements GameState{

    @Override
    public void progressGame(PokerGame game) {
        System.out.println("Score: $" + game.getScore());
        System.out.println("Dealing...");
        game.deal();
        System.out.println("Score: $" + game.getScore());
        game.setState(new RedrawState());
    }
}
