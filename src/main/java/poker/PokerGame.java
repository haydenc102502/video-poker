package poker;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import poker.cards.Card;
import poker.game.DealingState;
import poker.game.GameState;
import poker.hands.PokerHand;
import poker.hands.PokerHandFactory;

public class PokerGame {
    private GameState state;
    private List<Card> hand;
    private int score;
    private ArrayList<Card> shoe;

    public PokerGame() {
        this.state = new DealingState();
        this.hand = new ArrayList<Card>();
        this.score = 100;

        this.shoe = Card.makeShoe();
        Collections.shuffle(shoe);
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void progressGame() {
        this.state.progressGame(this);
    }

    public void deal() {
        this.score -= 5;
        for(int i = 0; i < 5; i++) {
            Card drawnCard = shoe.remove(0);
            hand.add(drawnCard);
        }
    }

    public void redraw(String[] cards) {
        for(int i = 0; i < 5; i++) {
            if(cards[i].equalsIgnoreCase("y")) {
                Card drawnCard = shoe.remove(i);
                hand.set(i, drawnCard);
            }
        }
    }

    public void scoreHand() {
        PokerHand pHand = PokerHandFactory.createHand(this.hand);
        System.out.println(pHand.getHandName());
        this.score += pHand.getHandScore();
    }

    public void printHand() {
        System.out.println(hand.toString());
    }

    public int getScore() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getScore'");
    }
}
