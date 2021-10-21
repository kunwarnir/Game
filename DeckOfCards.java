import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DeckOfCards {

  private ArrayList<Card> deck;
  private ArrayList<Card> pulled;
  private ArrayList<Card> remaining;
  private Random randomNumber;

  

  public DeckOfCards(){

    this.deck = new ArrayList<>();
    this.remaining = new ArrayList<>();

    deck.clear();

    for (Card.Suits suit: Card.Suits.values()){
      for (Card.Ranks rank: Card.Ranks.values()){
        // System.out.println(suit + " , " + rank);
        Card newCard = new Card(suit, rank);
        this.deck.add(newCard);
      }
    }
    remaining = deck;

  }

  public DeckOfCards(Card favourite){

    Card newCard;

    this.deck = new ArrayList<>();
    this.remaining = new ArrayList<>();

    deck.clear();

    for (Card.Suits suit: Card.Suits.values()){
      for (Card.Ranks rank: Card.Ranks.values()){
        // System.out.println(suit + " , " + rank);
        newCard = new Card(suit, rank);
        this.deck.add(newCard);
      }
    }

    remaining = deck;
    for (int i = 0; i < deck.size(); i++){
      System.out.println(deck.get(i));
    }

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

    randomNumber = new Random();
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

  public ArrayList<Card> getPulled(){
    return pulled;
  }

  public void print(){

  }
}