package deck;

import java.util.*;

public class Deck{
public final static int NUM_CARDS = 52;

private final Random generator = new Random();

private ArrayList<PlayingCard> deck;

public Deck(){
    

    System.out.println(this.NUM_CARDS);
}

public Deck(int seed){
    this.generator.setSeed(seed);
}

public void intialize(){
    
}

public void shuffleDeck(){

}

public PlayingCard getCard(int index){   
    return deck.get(index);
}

@Override
public String toString(){

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < NUM_CARDS; i++) {
        sb.append(String.format("%s of %s\n", getCard(i), getCard(i)));
        
    }

    //this is not quite it but i'm sure it's not awful.
    return sb.toString();
}



}
