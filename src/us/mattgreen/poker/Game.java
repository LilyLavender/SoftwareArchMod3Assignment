package us.mattgreen.poker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is a utility class consisting of static methods to determine if a hand matches a specific
 * @author  Dr. Green
 * @version 1.0
 */
public class Game {
    /**
     *
     * @param hand An Array of Cards
     * @return True if there are two of a kind and false if not
     */
    public static boolean twoOfAKind(Card[] hand) {
        Arrays.sort(hand, (a, b) -> a.getFace().compareTo(b.getFace()));
        int numberOFmatches = 0;
        for(int i=0;i < hand.length-1; i++) {
            if (hand[i].getFace().equals(hand[i+1].getFace())) return true;
        }
        return false;
    }

    /**
     *
     * @param hand An Array of Cards
     * @return True if there are three of a kind and false if not
     */
    public static boolean threeOfAKind(Card[] hand) {
        Arrays.sort(hand, (a, b) -> a.getFace().compareTo(b.getFace()));
        int numberOFmatches = 0;
        for(int i=0;i < hand.length-1; i++) {
            if (hand[i].getFace().equals(hand[i+1].getFace())) numberOFmatches++;
        }
        if (numberOFmatches == 2) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param hand An Array of Cards
     * @return True if there are four of a kind and false if not
     */
    public static boolean fourOfAKind(Card[] hand) {
        Arrays.sort(hand, (a, b) -> a.getFace().compareTo(b.getFace()));
        int numberOFmatches = 0;
        for(int i=0;i < hand.length-1; i++) {
            if (hand[i].getFace().equals(hand[i+1].getFace())) numberOFmatches++;
        }
        if (numberOFmatches == 3) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param hand An Array of Cards
     * @return True if there is a flush and false if not
     */
    public static boolean flush(Card[] hand) {
        Suit firstSuit = hand[0].getSuit();
        if (Arrays.stream(hand).allMatch(c -> c.getSuit() == firstSuit)) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param hand An Array of Cards
     * @return True if there is a full house and false if not
     */
    public static boolean fullHouse(Card[] hand) {
        Arrays.sort(hand, (a, b) -> a.getFace().compareTo(b.getFace()));
        Face[] faces = new Face[]{hand[0].getFace(),hand[1].getFace(),hand[2].getFace(),hand[3].getFace(),hand[4].getFace()};

        if (faces[2] == faces[0] && faces[2] == faces[1]) {
            if (faces[3] == faces[4]) return true;
        } else if (faces[2] == faces[3] && faces[2] == faces[4]) {
            if (faces[0] == faces[1]) return true;
        }
        return false;
    }


}
