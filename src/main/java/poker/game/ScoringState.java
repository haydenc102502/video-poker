package poker.game;

import poker.PokerGame;

/**
 * Concrete state for scoring the game. Scores the hand and resets the hand and shoe.
 */
public class ScoringState implements GameState{

    @Override
    public void progressGame(PokerGame game) {
        game.printHand();
        game.scoreHand();
        game.setState(new DealingState());

        
    }
    
}
