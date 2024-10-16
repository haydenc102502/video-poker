package poker.hands;

public class JacksOrBetter implements PokerHand{

    @Override
    public int getHandScore() {
        return 5;
    }
    @Override
    public String getHandName() {
        return "Jacks or Better";
    }
    
}
