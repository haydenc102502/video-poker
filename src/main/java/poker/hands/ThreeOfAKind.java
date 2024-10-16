package poker.hands;

public class ThreeOfAKind implements PokerHand{

    @Override
    public int getHandScore() {
        return 15;
    }

    @Override
    public String getHandName() {
        return "Three of a Kind";
    }
    
}
