import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.Random;

public class Hand{
  
  private List<Card> dealerHand;
  private List<Card> playerHand;

  public Hand(){

    dealerHand = new ArrayList<Card>();
    playerHand = new ArrayList<Card>();

  }

  public void addDealerCard(Card card){
    dealerHand.add(card);
  }

  public void addPlayerCard(Card card){
    playerHand.add(card);
  }

  public List<Card> getDealerHand(){
    return dealerHand;
  }

  public List<Card> getPlayerHand(){
    return playerHand;
  }

  public String toString(List<Card> list){
    String value = "";
    
    for (Card card: list){
      if (value.isEmpty()){
        value = card.toString();
      }
      else {
        value += ", " + card.toString();
      }
    }

    return value;
  }

}