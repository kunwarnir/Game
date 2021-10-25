import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DeckOfCards {

  public static ArrayList<Card> deck;
  private ArrayList<Card> pulled;
  private ArrayList<Card> remaining;

  public DeckOfCards(){

    this.deck = new ArrayList<>();
    this.remaining = new ArrayList<>();

    deck.clear();
    setDeck();   

  }

  public void setDeck(){
    for (Card.Suits suit: Card.Suits.values()){
      for (Card.Ranks rank: Card.Ranks.values()){
        // System.out.println(suit + " , " + rank);
        Card newCard = new Card(suit, rank);
        this.deck.add(newCard);
      }
    }
    remaining = deck;
  }

  public Card cardAtIndex(int index){
    return deck.get(index);
  }

  public void shuffleDeck(){
    Collections.shuffle(deck);
  }

  public void shuffleRemaining(){
    Collections.shuffle(remaining);
  }

  public int numRemaining(){
    return remaining.size();
  }

  public Card pullTop(){
    pulled = new ArrayList<>();
    Card pulledCard;

    if (remaining.isEmpty()){
      return null;
    }
    else {
      pulledCard = remaining.get(remaining.size()-1);
      pulled.add(pulledCard);
      remaining.remove(remaining.size()-1);

      return pulledCard;
    }

  }

  public Card seeTop(){
    Card top;

    if (remaining.isEmpty()){
      return null;
    }
    else {
      top = remaining.get(remaining.size()-1);

      return top;
    }

  }

  public ArrayList<Card> getPulled(){
    return pulled;
  }
}