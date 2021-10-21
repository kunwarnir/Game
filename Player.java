import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.Random;

public class Player{

  private String username;
  private double initialValue;
  private double currentValue;
  private static ArrayList<Double> historyValues = new ArrayList<>();
  List<Card> hand;
  int sum = 0;

  public Player(String username, double money){
    this.username = username;
    initialValue = money;
    currentValue = money;
    historyValues.add(money);
    hand = new ArrayList<Card>();
    
  }

  public Player (String username){
    this.username = username;
  }
  
  public String getUsername(){
    return username;
  }

  public double getInitValue(){
    return initialValue;
  }

  public double getCurrentValue(){
    return currentValue;
  }

  public static ArrayList<Double> getHistoryValues() {
    return historyValues;
  }

  public void addValue(double bet, boolean won){

    if (won){
        currentValue += bet;
    }
    else {
        currentValue -= bet;
    }

    historyValues.add(currentValue);
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