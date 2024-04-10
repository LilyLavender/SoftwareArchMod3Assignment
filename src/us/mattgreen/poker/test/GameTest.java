package us.mattgreen.poker.test;

import org.junit.Before;
import org.junit.Test;
import us.mattgreen.poker.Card;
import us.mattgreen.poker.Game;

import static org.junit.Assert.assertTrue;
import static us.mattgreen.poker.Face.*;
import static us.mattgreen.poker.Suit.*;

public class GameTest {
    private Card[] hand;

    /*@Before
    public void setUp() {
        hand = new Card[]{new Card(JACK,CLUBS, 11), new Card(FIVE,CLUBS, 5), new Card(JACK,SPADES, 11)};
    }*/

    @Test
    public void twoOfAKindTest() {
        hand = new Card[]{
                new Card(JACK,CLUBS, 11),
                new Card(FIVE,CLUBS, 5),
                new Card(JACK,SPADES, 11)
        };
        assertTrue("Two of a kind should have matched",Game.twoOfAKind(hand));
    }

    @Test
    public void threeOfAKindTest() {
        hand = new Card[]{
                new Card(JACK,CLUBS, 11),
                new Card(FIVE,CLUBS, 5),
                new Card(JACK,SPADES, 11),
                new Card(FOUR,DIAMONDS,4),
                new Card(JACK,DIAMONDS,11)
        };
        assertTrue("Three of a kind should have matched",Game.threeOfAKind(hand));
    }

    @Test
    public void fourOfAKindTest() {
        hand = new Card[]{
                new Card(JACK,CLUBS, 11),
                new Card(FIVE,CLUBS, 5),
                new Card(JACK,SPADES, 11),
                new Card(JACK,HEARTS,11),
                new Card(JACK,DIAMONDS,11)
        };
        assertTrue("Four of a kind should have matched",Game.fourOfAKind(hand));
    }

    @Test
    public void flushTest() {
        hand = new Card[]{
                new Card(FOUR,DIAMONDS, 4),
                new Card(FIVE,DIAMONDS, 5),
                new Card(JACK,DIAMONDS, 11),
                new Card(KING,DIAMONDS,13),
                new Card(SEVEN,DIAMONDS,7)
        };
        assertTrue("The hand should be a flush",Game.flush(hand));
    }

    @Test
    public void fullHouseTest() {
        hand = new Card[]{
                new Card(JACK,CLUBS, 11),
                new Card(FIVE,CLUBS, 5),
                new Card(JACK,SPADES, 11),
                new Card(FIVE,DIAMONDS,5),
                new Card(JACK,DIAMONDS,11)
        };
        assertTrue("The hand should be a full house",Game.fullHouse(hand));
    }
}
