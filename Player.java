import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.Random;

public class Player extends Person{

  private static final Player INSTANCE = new Player();

  private String username;
  private double initialValue;
  private double currentValue;
  private static ArrayList<Double> historyValues;
  private static ArrayList<Boolean> historyGames;
  private int lives;

  private Player(){
    hand = new ArrayList<Card>();
    historyValues = new ArrayList<>();
    historyGames = new ArrayList<>();
    lives = 2;
    sum = 0;
  }

  public static Player getInstance(){
    return INSTANCE;
  }

  public void setUsername(String username){
    this.username = username;
  }

  public String getUsername(){
    return username;
  }

  public void setMoney(double money){
    initialValue = money;
    currentValue = money;
    historyValues.add(money);
    historyGames.add(false);
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
        historyGames.add(true);
    }
    else {
        currentValue -= bet;
        historyGames.add(false);
    }

    historyValues.add(currentValue);
    
    
  }

  public String getGameStats(){
    String games = "";

    for (int i = 0; i < historyGames.size(); i++){
      if (i == 0){
        games = "";
      }
      else if (historyGames.get(i)){
        games+= "Game " + i + ": Won\n";
      }
      else {
        games+= "Game " + i + ": Lost\n";
      }
    }

    return "You played " + (historyGames.size()-1) + " games\n" + games;
  }

  public String getFileMessage(){
    String message = "*********************\n" + "Your username: : " + username + "\n" + getGameStats() + "\nYou started with: " + initialValue +
        "$\nYou ended with: " + currentValue + "$\n*********************\n";

    return message;
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