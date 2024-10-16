package poker.game;

import poker.PokerGame;

/**
 * Concrete state for dealing the intitial 5 card hand.
 * 
 * @author Hayden Cabral
 */
public class DealingState implements GameState{

    @Override
    public void progressGame(PokerGame game) {
        String response = "default";
        while(!((response.equals("") || response.equalsIgnoreCase("q")))) {
            System.err.print("Press ENTER to bet 5 Credits or 'q' to quit: ");
            response = game.getScanner().nextLine();
        }
        if(response.equalsIgnoreCase("q")) {
            System.exit(0);
        }
        
        System.out.println("Score: $" + game.getScore());
        game.deal();
        game.setState(new RedrawState());
    }
}
