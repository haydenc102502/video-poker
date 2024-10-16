package poker.hands;

public class FullHouse implements PokerHand{

    @Override
    public int getHandScore() {
        return 45;
    }

    @Override
    public String getHandName() {
        return "Full House";
    }
    
}
