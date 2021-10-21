import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.Random;


public class Dealer{

  List<Card> hand;
  int sum = 0;

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
        value += "\n" + card.toString();
      }
    }

    return value;
  }

  public int getHandSum(){
    
    for (Card card: hand){
      sum += card.getValue();
    }
    
    return sum;
  }

  public int distanceFrom21(){
    return 21 - sum;
  }
}