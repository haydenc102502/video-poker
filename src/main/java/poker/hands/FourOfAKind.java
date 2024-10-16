package poker.hands;

public class FourOfAKind implements PokerHand{

    @Override
    public int getHandScore() {
        return 125;
    }

    @Override
    public String getHandName() {
        return "Four of a Kind";
    }
    
}
