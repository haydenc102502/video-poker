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
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[36m";
    public static final String ORANGE = "\033[38;5;205m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m"; 

    private GameState state;
    private List<Card> hand;
    private int score;
    private List<Card> shoe;
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
        System.out.println("Dealing...");
        this.score -= 5;
        System.out.println("Score: $" + this.getScore());
        for(int i = 0; i < 5; i++) {
            Card drawnCard = shoe.remove(0);
            hand.add(drawnCard);
        }
        PokerHand pHand = PokerHandFactory.createHand(this.hand);
        System.out.println(YELLOW + "--" + pHand.getHandName() + "--" + ANSI_RESET);
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
        System.out.println(YELLOW + "--" + pHand.getHandName() + "--" + ANSI_RESET);
        this.score += pHand.getHandScore();
        System.out.println(GREEN + "Win: " + pHand.getHandScore() + ANSI_RESET);
        System.out.println("---------------------------------------------");
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
