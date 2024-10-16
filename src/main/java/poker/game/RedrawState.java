package poker.game;


import poker.PokerGame;

/**
 * Concrete State for the redrawing phase. The user selects up to their entire hand to keep and the rest to redraw.
 * 
 * @author Hayden Cabral
 */
public class RedrawState implements GameState{

    @Override
    public void progressGame(PokerGame game) {
        game.printHand();
        System.out.println("Select Cards to keep: (y/n)");
        String card1 = "";
        String card2 = "";
        String card3 = "";
        String card4 = "";
        String card5 = "";

        while(!(card1.equalsIgnoreCase("y") || card1.equalsIgnoreCase("n"))) {
            System.out.print("Card 1: ");
            card1 = game.getScanner().nextLine();
        }

        while(!(card2.equalsIgnoreCase("y") || card2.equalsIgnoreCase("n"))) {
            System.out.print("Card 2: ");
            card2 = game.getScanner().nextLine();
        }

        while(!(card3.equalsIgnoreCase("y") || card3.equalsIgnoreCase("n"))) {
            System.out.print("Card 3: ");
            card3 = game.getScanner().nextLine();
        }

        while(!(card4.equalsIgnoreCase("y") || card4.equalsIgnoreCase("n"))) {
            System.out.print("Card 4: ");
            card4 = game.getScanner().nextLine();
        }

        while(!(card5.equalsIgnoreCase("y") || card5.equalsIgnoreCase("n"))) {
            System.out.print("Card 5: ");
            card5 = game.getScanner().nextLine();
        }

        String[] cards = {card1, card2, card3, card4, card5};
        game.redraw(cards);
        game.setState(new ScoringState());




        
        

        
    }
    
}
