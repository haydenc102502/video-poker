package poker.hands;

public class StraightFlush implements PokerHand{

    @Override
    public int getHandScore() {
        return 250;
    }

    @Override
    public String getHandName() {
        return "Straight Flush";
    }
    
}
