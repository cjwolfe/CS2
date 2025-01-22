package deck;

import java.util.*;

public class Deck{
public final static int NUM_CARDS = 52;

private final Random generator = new Random();

private ArrayList<PlayingCard> deck;

public Deck(){
    this.generator.setSeed(new Random().nextLong());
    
    initialize();
    //System.out.println(this.NUM_CARDS);
}

public Deck(int seed){
    this.generator.setSeed(seed);
    initialize();
}

public void initialize(){
    //should put all the suits and ranks into the card slots
    deck = new ArrayList<>(NUM_CARDS);

    int rankCounter = 0;
    int suitCounter = 0;

    for (int i = 0; i < NUM_CARDS; i++) {
        //deck.set(i,);


        

        
    }
    
}

public void shuffleDeck(){
    //uses the random seed to shuffle the deck
}

public PlayingCard getCard(int index){   
    return deck.get(index);
}

@Override
public String toString(){

    //returns all of the cards in the order they are in

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < NUM_CARDS; i++) {
        sb.append(String.format("%s of\n", getCard(i)));
        
    }

    //this is not quite it but i'm sure it's not awful.
    return sb.toString();
}



}
