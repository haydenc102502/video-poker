package poker.cards;

import java.util.ArrayList;

/**
 * Class to encapsulate a card object. Cards have a suit, rank, and shorthand for printing.
 * 
 * @author Hayden Cabral
 */
public class Card {
    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[36m";
    private static final String ORANGE = "\033[38;5;205m";
    private static final String ANSI_RESET = "\u001B[0m"; 


    private int rank;
    private Suit suit;
    private String shorthand;


    public Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;

        String suitShort = suit.getShorthand();

        if(this.rank <= 10) {
            this.shorthand = Integer.toString(rank) + suitShort;
        } else {
            if(this.rank == 11) {
                this.shorthand = "J" + suitShort;
            } else if(this.rank == 12) {
                this.shorthand = "Q" + suitShort;
            } else if(this.rank == 13) {
                this.shorthand = "K" + suitShort;
            } else {
                this.shorthand = "A" + suitShort;
            }
        }  
    }

    @Override
    public String toString() {
        if(this.suit.equals(Suit.SPADES)) {
            return BLACK + this.shorthand + ANSI_RESET;
        }
        if(this.suit.equals(Suit.CLUBS)) {
            return BLUE + this.shorthand + ANSI_RESET;
        }
        if(this.suit.equals(Suit.HEARTS)) {
            return RED + this.shorthand + ANSI_RESET;
        }
        return ORANGE + this.shorthand + ANSI_RESET;
    }

    public static ArrayList<Card> makeShoe() {
        ArrayList<Card> shoe = new ArrayList<>();

        for(int i = 2; i < 15; i++) {
            shoe.add(new Card(i, Suit.CLUBS));
        }

        for(int i = 2; i < 15; i++) {
            shoe.add(new Card(i, Suit.SPADES));
        }

        for(int i = 2; i < 15; i++) {
            shoe.add(new Card(i, Suit.HEARTS));
        }

        for(int i = 2; i < 15; i++) {
            shoe.add(new Card(i, Suit.DIAMONDS));
        }

        return shoe;
    }

    public static void main(String[] args) {
        System.out.println(makeShoe().toString());
    }

    public Suit getSuit() {
        return this.suit;
    }

    public int getRank() {
        return this.rank;
    }

    
}
