public class Card {
  
  public enum Suits {
    SPADES, HEARTS, CLUBS, DIAMONDS;
  }

  public enum Ranks {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
  }

  private Suits suit;
  private Ranks rank;

  public Card(Suits suit, Ranks rank){
    this.suit = suit;
    this.rank = rank;
  }

  public Suits getSuit(){
    return suit;
  }

  public Ranks getRank() {
    return rank;
  }

  @Override
  public String toString() {
    return rank + " of " + suit;
  }
}