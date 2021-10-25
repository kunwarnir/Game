import java.util.*;

abstract class Person {
  
  public List<Card> hand;
  public int sum = 0;

  public List<Card> getHand(){
    return hand;
  }

  public String handToString(){
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
    sum = 0;
    for (Card card: hand){
      sum += card.getValue();
    }
    
    return sum;
  }

  public void clearSum(){
    sum = 0;
  }

  public int distanceFrom(int length){
    return length - sum;
  }

  public void clearHand(){
    hand.clear();
  }

  public void addCard(Card card){
    hand.add(card);
  }
}