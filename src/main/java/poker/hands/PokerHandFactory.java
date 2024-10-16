package poker.hands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import poker.cards.Card;
import poker.cards.Suit;

/**
 * Factory class to create poker hand objects. Logic for evaluating a hand is contained within the factory. Creates concrete hand types based on the evaluations
 * 
 * @author Hayden Cabral
 */
public class PokerHandFactory {
    public static PokerHand createHand(List<Card> cards) {
        if (isFlush(cards)) {
            return new Flush();
        } else if (isStraight(cards)) {
            return new Straight();
        } else if (isStraightFlush(cards)) {
            return new StraightFlush();
        } else if (isRoyalFlush(cards)) {
            return new RoyalFlush();
        } else if (isJacksOrBetter(cards)) {
            return new JacksOrBetter();
        } else if (isThreeOfAKind(cards)) {
            return new ThreeOfAKind();
        } else if (isFourOfAKind(cards)) {
            return new FourOfAKind();
        } else if (isFullHouse(cards)) {
            return new FullHouse();
        } else if (isStraight(cards)) {
            return new Straight();
        } else {
            return new Junk(); // Default to high card
        }
    }

    private static Map<Integer, Long> countRanks(List<Card> hand) {
        return hand.stream().collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));
    }

    private static boolean isFlush(List<Card> cards) {
        Suit suit = cards.get(0).getSuit();
        for(int i = 1; i < cards.size(); i++) {
            if(!(cards.get(i).getSuit()).equals(suit)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isJacksOrBetter(List<Card> cards) {
        Map<Integer, Long> ranks = countRanks(cards);
        for(int i = 11; i < 15; i++) {
            if(ranks.keySet().contains(i) && ranks.get(i) >= 2) {
                return true;
            }
        }
        return false;
    }

    private static boolean isThreeOfAKind(List<Card> cards) {
        Map<Integer, Long> ranks = countRanks(cards);
        return ranks.containsValue((long)3);
    }

    private static boolean isFourOfAKind(List<Card> cards) {
        Map<Integer, Long> ranks = countRanks(cards);
        return ranks.containsValue((long)4);
    }

    private static boolean isFullHouse(List<Card> cards) {
        Map<Integer, Long> ranks = countRanks(cards);
        return ranks.containsValue((long)3) && ranks.containsValue((long)2);
    }

    private static boolean isStraight(List<Card> cards) {
        ArrayList<Integer> ranks = new ArrayList<>();

        for(Card card : cards) {
            ranks.add(card.getRank());
        }
        Collections.sort(ranks);

        for (int i = 0; i < ranks.size() - 1; i++) {
            if (ranks.get(i) + 1 != ranks.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isStraightFlush(List<Card> cards) {
        return(isFlush(cards) && isStraight(cards));
    }

    private static boolean isRoyalFlush(List<Card> cards) {
        if(isStraightFlush(cards)) {
            ArrayList<Integer> ranks = new ArrayList<>();

            for(Card card : cards) {
                ranks.add(card.getRank());
            }
            if(ranks.get(0) == 10) {
                return true;
            }
        }
        return false;
    }
}
