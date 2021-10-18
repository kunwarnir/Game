public class Card {
  private static Suits suit;
  private static Ranks rank;

  public enum Suits {
      SPADES, HEARTS, DIAMONDS, CLUBS;
  }

  public enum Ranks {
      ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
  }

  public Card(Suits suit, Ranks rank){
      this.suit = suit;
      this.rank = rank;
  }

  public static Suits getSuit(){
      return suit;
  }

  public static Ranks getRank() {
      return rank;
  }

  @Override
  public String toString() {
      return rank + " of " + suit;
  }
}