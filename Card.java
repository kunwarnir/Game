public class Card {
  
  public enum Suits {
    SPADES, HEARTS, CLUBS, DIAMONDS;
  }

  public enum Ranks {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
  }

  private final Suits suit;
  private final Ranks rank;

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

  public int getValue(){
     
    int value = 0;
    
    switch (rank){
      case ACE:
        value = 1;
        break;
      case TWO:
        value = 2;
        break;
      case THREE:
        value = 3;
        break;
      case FOUR:
        value = 4;
        break;
      case FIVE:
        value = 5;
        break;
      case SIX:
        value = 6;
        break;
      case SEVEN:
        value = 7;
        break;
      case EIGHT:
        value = 8;
        break;
      case NINE:
        value = 9;
        break;
      case TEN:
        value = 10;
        break;
      case JACK:
        value = 11;
        break;
      case QUEEN:
        value = 12;
        break;
      case KING:
        value = 13;
        break;
    }
    return value;
  }

  @Override
  public String toString() {
    return rank + " of " + suit;
  }
}