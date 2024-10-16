package poker.game;

import poker.PokerGame;

public class ScoringState implements GameState{

    @Override
    public void progressGame(PokerGame game) {
        game.printHand();
        game.scoreHand();

        
    }
    
}
