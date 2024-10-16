package poker.hands;

/**
 * interface to define the behavior for a poker hand. Each hand prints a score and a name.
 * 
 * @author Hayden Cabral
 */
public interface PokerHand {
    int getHandScore();
    String getHandName();
}
