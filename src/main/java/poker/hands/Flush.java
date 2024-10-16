package poker.hands;

public class Flush implements PokerHand{

    @Override
    public int getHandScore() {
        return 30;
    }

    @Override
    public String getHandName() {
        return "Flush";
    }
    
}
