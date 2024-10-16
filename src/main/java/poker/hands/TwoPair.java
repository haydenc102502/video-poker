package poker.hands;

public class TwoPair implements PokerHand{

    @Override
    public int getHandScore() {
        return 10;
    }

    @Override
    public String getHandName() {
        return "Two Pair";
    }
    
}
