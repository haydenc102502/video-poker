package poker;

import java.util.Scanner;

/**
 * Main class for running the poker game.
 * 5 card draw video poker. Wager is always 5 Credits, user starts with 100. Game will continue until the user runs out of money.
 * 
 * @author Hayden Cabral
 */
public class PokerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PokerGame game = new PokerGame(scanner);
        while(game.getScore() >= 0) {
            game.progressGame();
        }
        scanner.close();
    }
}
