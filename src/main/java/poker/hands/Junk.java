package poker.hands;

public class Junk implements PokerHand{

    @Override
    public int getHandScore() {
        return 0;
    }

    @Override
    public String getHandName() {
        return "Junk";
    }
    
}
