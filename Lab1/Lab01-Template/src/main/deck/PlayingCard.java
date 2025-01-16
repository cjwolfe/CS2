package deck;

import java.lang.*;

public class PlayingCard{
private Suit suit;
private Rank rank;

public PlayingCard(Rank rank, Suit suit){
    this.rank = rank;
    this.suit = suit;
}

public Rank getRank(){
    return this.rank;
}

public Suit getSuit(){
    return this.suit;
}

public void setRank(Rank rank){
   this.rank = rank; 
}

public void setSuit(Suit suit){
    this.suit = suit; 
}

public String toString(){

    StringBuilder sb = new StringBuilder();
    for (int index = 0; index < 52; index++) {
        sb.append(this.rank);
        sb.append(" of ");
        sb.append(this.suit);
        // sb.append(this.deck.getCard(index));
        sb.append("\n");
        index++;
    }


    return sb.toString();
}

}