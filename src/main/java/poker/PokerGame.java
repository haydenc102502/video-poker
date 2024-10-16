package poker;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import poker.cards.Card;
import poker.game.DealingState;
import poker.game.GameState;
import poker.hands.PokerHand;
import poker.hands.PokerHandFactory;

/**
 * Primary class for performing game based actions. Will execute different behavior based on the game state.
 * 
 * @author Hayden Cabral
 */
public class PokerGame {
    private GameState state;
    private List<Card> hand;
    private int score;
    private ArrayList<Card> shoe;
    private Scanner scanner;

    public PokerGame(Scanner scanner) {
        this.state = new DealingState();
        this.hand = new ArrayList<Card>();
        this.score = 100;
        this.scanner = scanner;

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
            if(cards[i].equalsIgnoreCase("n")) {
                Card drawnCard = shoe.remove(i);
                hand.set(i, drawnCard);
            }
        }
    }

    public void scoreHand() {
        PokerHand pHand = PokerHandFactory.createHand(this.hand);
        System.out.println(pHand.getHandName());
        this.score += pHand.getHandScore();
        System.out.println("Win: " + pHand.getHandScore());

        this.hand = new ArrayList<Card>();
        this.shoe = Card.makeShoe();
        Collections.shuffle(shoe);
    }

    public void printHand() {
        System.out.println(hand.toString());
        System.out.println("[1^, 2^, 3^, 4^, 5^]");
    }

    public int getScore() {
        return this.score;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
