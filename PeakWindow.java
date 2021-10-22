import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;

public class PeakWindow extends JFrame implements ActionListener{

  Container base;
  
  JPanel pnlSuccess;
  JPanel pnlFail;

  JPanel success;
  JPanel fail;

  JLabel lblSuccess;
  JLabel lblNextCard;
  JLabel lblFail;
  JLabel lblLoseLife;

  CardLayout layout = new CardLayout();
  Random random;

  Player player = Player.getInstance();

  DeckOfCards deck = GameWindow.deck;

  public PeakWindow(){
    super("Peak Window");

    random = new Random();

    base = getContentPane();
    base.setLayout(layout);

    success = successPanel();
    fail = failPanel();

    base.add(success, "success");
    base.add(fail, "fail");


    if (isSuccessful()){
      layout.show(base, "success");
    }
    else {
      
      layout.show(base, "fail");
    }
    
  }

  @Override
  public void actionPerformed(ActionEvent e) {
  }

  public JPanel successPanel(){

    pnlSuccess = new JPanel();
    pnlSuccess.setLayout(null);
    pnlSuccess.setBackground(Color.GREEN); 
    add(pnlSuccess);

    lblSuccess = new JLabel("Your peak was successful, the dealers next card is: ");
    lblSuccess.setBounds(0, 15, 500, 25);
    lblSuccess.setForeground(Color.BLACK);
    pnlSuccess.add(lblSuccess);

    lblNextCard = new JLabel(deck.seeTop().toString());
    lblNextCard.setBounds(0, 50, 300, 25);
    pnlSuccess.add(lblNextCard);

    return pnlSuccess;
  }

  public JPanel failPanel(){
    pnlFail = new JPanel();
    pnlFail.setLayout(null);
    pnlFail.setBackground(Color.RED);
    add(pnlFail);

    lblFail = new JLabel("Your peak was unsuccessful, you lost a life");
    lblFail.setBounds(0, 15, 500, 25);
    pnlFail.add(lblFail);

    lblLoseLife = new JLabel("You have " + player.getLives() + " lives left!");
    lblLoseLife.setBounds(0, 50, 500, 25);
    pnlFail.add(lblLoseLife);
    
    return pnlFail;
  }

  public boolean isSuccessful(){
    if (random.nextBoolean()){
      return true;
    }
    else {
      player.loseLife();
      return false;
    }
  }

}