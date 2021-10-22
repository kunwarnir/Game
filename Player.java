import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.Random;

public class Player{

  private static final Player INSTANCE = new Player();

  private String username;
  private double initialValue;
  private double currentValue;
  private static ArrayList<Double> historyValues = new ArrayList<>();
  public static ArrayList<Boolean> historyGames = new ArrayList<>();
  List<Card> hand;
  int sum = 0;
  int lives;

  private Player(){
    hand = new ArrayList<Card>();
    lives = 2;
  }

  public void setUsername(String username){
    this.username = username;
  }

  public void setMoney(double money){
    initialValue = money;
    currentValue = money;
    historyValues.add(money);
    historyGames.add(null);
  }

  public static Player getInstance(){
    return INSTANCE;
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

  public void addGame(double bet, boolean won){

    if (won){
        currentValue += bet;
    }
    else {
        currentValue -= bet;
    }

    historyValues.add(currentValue);
    historyGames.add(won);
  }

  public String getGameStats(){
    String games = "";

    for (int i =1; i < historyGames.size(); i++){
      if (historyGames.get(i)){
        games+= "Game " + i + ": Won\n";
      }
      else {
        games+= "Game " + i + ": Lost\n";
      }
    }

    return " You played " + (historyGames.size()-1) + " games\n" + games;
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

  public String getFileMessage(){
    String message = "*********************\n" + username + 
        getGameStats() + "You started with: " + initialValue +
        "\nYou ended with: " + currentValue + "\n*********************\n";

    return message;
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

  public int distanceFrom21(){
    return 21 - sum;
  }

  public void clearHand(){
    hand.clear();
  }

  public void loseLife(){
    if (lives <= 0){
      System.out.println("No More lives!!");
    }
    else {
      lives--;
    }
  }

  public int getLives(){
    return lives;
  }
  
}