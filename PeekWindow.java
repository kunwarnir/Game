import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;

public class PeekWindow extends JFrame implements ActionListener{

  private Container base;
  
  private JPanel pnlSuccess;
  private JPanel pnlFail;

  private JPanel success;
  private JPanel fail;

  private JLabel lblSuccess;
  private JLabel lblNextCard;
  private JLabel lblFail;
  private JLabel lblLoseLife;

  private CardLayout layout = new CardLayout();
  Random random;

  Player player = Player.getInstance();

  DeckOfCards deck = GameWindow.deck;

  public PeekWindow(){
    super("Peek Window");

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
    lblSuccess.setFont(new Font("Helvetica", Font.BOLD, 14));
    lblSuccess.setBounds(35, 15, 500, 25);
    pnlSuccess.add(lblSuccess);

    lblNextCard = new JLabel(deck.seeTop().toString());
    lblNextCard.setBounds(175, 50, 300, 25);
    pnlSuccess.add(lblNextCard);

    return pnlSuccess;
  }

  public JPanel failPanel(){
    pnlFail = new JPanel();
    pnlFail.setLayout(null);
    pnlFail.setBackground(Color.decode("#FD1A1A"));
    add(pnlFail);

    lblFail = new JLabel("Your peak was unsuccessful, you lost a life");
    lblFail.setFont(new Font("Arial", Font.BOLD, 14));
    lblFail.setBounds(75, 15, 500, 25);
    pnlFail.add(lblFail);

    lblLoseLife = new JLabel("You have " + (player.getLives() -1) + " lives left!");
    lblLoseLife.setBounds(175, 50, 500, 25);
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