package poker.hands;

public class RoyalFlush implements PokerHand{

    @Override
    public int getHandScore() {
        return 4000;
    }

    @Override
    public String getHandName() {
        return "Royal Flush";
    }
    
}
