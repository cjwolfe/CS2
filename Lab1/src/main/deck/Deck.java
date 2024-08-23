package deck;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

// import Lab1.Suit.java;
// import Lab1.Rank.java;

public class Deck {
    public static final int NUM_CARDS = 52;
    private Random generator;
    private ArrayList<PlayingCard> deck = new ArrayList<>();

    public Deck() {
        this.generator = new Random();
        this.initialize();
    }

    public Deck(int seed) {
        this.generator = new Random(seed);
        this.initialize();
    }

    /**
     * help me
     */
    public void initialize() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new PlayingCard(rank, suit));

            }

        }

    }

    // wth am I to do here?
    public void shuffleDeck() {

        for (int i = this.deck.size() - 1; i >= 0; i--) {
            int location = generator.nextInt(NUM_CARDS);
            Collections.swap(this.deck, i, location);
        }

    }

    public PlayingCard getCard(int index) {
        return deck.get(index);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlayingCard card : deck) {
            sb.append(card.toString()).append("\n");
        }

        return sb.toString();
    }
}