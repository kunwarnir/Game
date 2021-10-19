import java.util.ArrayList;

public class Player{

  private String username;
  private double initialValue;
  private double currentValue;
  private static ArrayList<Double> historyValues = new ArrayList<>();

  public Player(String username, double money){
    this.username = username;
    initialValue = money;
    currentValue = money;
    historyValues.add(money);
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
}