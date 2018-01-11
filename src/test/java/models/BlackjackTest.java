package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Guest on 1/10/18.
 */
public class BlackjackTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void Blackjack_pickRandomCardFromDeck() {
        Blackjack blackjack = new Blackjack("J♠", 0);
        ArrayList<Blackjack> deck = new ArrayList<>();
        Blackjack jack = new Blackjack("J♠", 10);
        deck.add(jack);
        assertEquals(jack, blackjack.pickRandomCard(deck));
    }

    @Test
    public void Blackjack_checkIfUnder21() {
        ArrayList<Blackjack> deck = new ArrayList<>();
        Blackjack jack = new Blackjack("J♠", 10);
        deck.add(jack);
        assertEquals("alive", jack.checkBust(deck));
    }
    @Test
    public void Blackjack_checkDeckSize() {
        Blackjack blackjack = new Blackjack("J♠", 10);
        ArrayList<Blackjack> deck = new ArrayList<>();
        Blackjack jack10 = new Blackjack("J♠", 10);
        Blackjack heart10 = new Blackjack("10♥", 10);
        Blackjack heart3 = new Blackjack("3♥", 3);
        deck.add(jack10);
        deck.add(heart3);
        deck.add(heart10);

        assertEquals(3, blackjack.checkDeckSize(deck));
    }
    @Test
    public void Blackjack_checkIfOver21() {
        Blackjack blackjack = new Blackjack("J♠", 10);
        ArrayList<Blackjack> deck = new ArrayList<>();
        Blackjack jack10 = new Blackjack("J♠", 10);
        Blackjack heart10 = new Blackjack("10♥", 10);
        Blackjack heart3 = new Blackjack("3♥", 3);
        deck.add(jack10);
        deck.add(heart3);
        deck.add(heart10);

        assertEquals("bust", blackjack.checkBust(deck));
    }
}