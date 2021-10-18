import java.util.ArrayList;

public class Player{

  String username;
  double initialValue;
  double currentValue;
  public static ArrayList<Double> historyValues = new ArrayList<>();

  public Player(String username, double money){
    this.username = username;
    initialValue = money;
    currentValue = money;
    historyValues.add(money);
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
}