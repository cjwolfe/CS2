package deck;

public class PlayingCard {

    private Suit suit;
    private Rank rank;

    public PlayingCard(Rank rank, Suit suit) {
        this.setRank(rank);
        this.setSuit(suit);
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return this.getRank() + " of " + this.getSuit();
    }
}
