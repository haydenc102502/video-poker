package poker.game;

import poker.PokerGame;

/**
 * Interface to define the behavior of a game state.
 */
public interface GameState {
    void progressGame(PokerGame game);
}
