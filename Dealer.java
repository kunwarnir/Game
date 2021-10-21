import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.Random;


public class Dealer{

  List<Card> hand;

  public Dealer(){
    hand = new ArrayList<Card>();    
  }

  public void addCard(Card card){
    hand.add(card);
  }

  public List<Card> getHand(){
    return hand;
  }

  public String toString(){
    String value = "";
    
    for (Card card: hand){
      if (value.isEmpty()){
        value = card.toString();
      }
      else {
        value += ", " + card.toString();
      }
    }

    return value;
  }

  public int getHandSum(){
    int sum = 0;
    
    for (Card card: hand){
      sum += card.getValue();
    }
    
    return sum;
  }
}