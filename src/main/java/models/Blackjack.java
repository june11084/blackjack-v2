package models;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Guest on 1/10/18.
 */
public class Blackjack {

    private String face;
    private int value;
    private static ArrayList<Blackjack> deck;
    private static ArrayList<Blackjack> player;
    private static ArrayList<Blackjack> dealer;

    public Blackjack (String face, int value) {
        this.face = face;
        this.value = value;
    }

    public static ArrayList<Blackjack> createDeck() {
        String[] suits = {"♠️", "♥", "♣", "♦"};
        String[] number = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        ArrayList<Blackjack> deck = new ArrayList<>();

        for(int suit = 0; suit < suits.length; suit++) {
            for(int cardNumber = 0; cardNumber < number.length; cardNumber++) {
                Blackjack individualCard = new Blackjack(number[cardNumber]+ suits[suit], value[cardNumber]);
                deck.add(individualCard);
            }
        }
        return deck;
    }

    public Blackjack pickRandomCard(ArrayList<Blackjack> deck) {
        Random randomNumber = new Random();
        Blackjack card = deck.get(randomNumber.nextInt(deck.size()));
        deck.remove(randomNumber.nextInt(deck.size()));
        return card;
    }

    public String checkBust(ArrayList<Blackjack> playerDeck) {
        int totalValue = 0;
        for(int i = 0; i < playerDeck.size(); i++) {
            totalValue += getValue(playerDeck.get(i));
        }
        if(totalValue <= 21) {
            return "alive";
        } else {
            return "bust";
        }
    }

    public int checkDeckSize(ArrayList<Blackjack> playerDeck){
        return playerDeck.size();
    }

    public String getFace(Blackjack card){
        String face = card.face;
        return face;
    }

    public int getValue(Blackjack card) {
        int points = card.value;
        return points;
    }

    public void startGame(){
        player.clear();
        dealer.clear();

        deck = createDeck();

        player.add(pickRandomCard(deck));
        player.add(pickRandomCard(deck));

        dealer.add(pickRandomCard(deck));
        dealer.add(pickRandomCard(deck));
    }

    public String checkWin(ArrayList<Blackjack> playerDeck,ArrayList<Blackjack> dealerDeck){
        if(checkBust(playerDeck).equals("alive")&&checkBust(dealerDeck).equals("alive")){
            if(playerDeck.getValue())
        }
    }

}
