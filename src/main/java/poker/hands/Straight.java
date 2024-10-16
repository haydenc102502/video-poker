package poker.hands;

public class Straight implements PokerHand{

    @Override
    public int getHandScore() {
        return 20;
    }

    @Override
    public String getHandName() {
        return "Straight";
    }
    
}
