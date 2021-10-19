import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;

public class GameWindow extends JFrame implements ActionListener{

  Container base;
  
  JPanel pnlInitial;
  JPanel pnlGame;
  JPanel game;
  JPanel initial;

  JLabel lblWelcome;
  JLabel lblWelcome2;
  JLabel lblDealerCards;
  JLabel lblYourCards;

  JButton btnBegin;
  JButton btnPeak;
  JButton btnHit;
  JButton btnStand;

  JTextArea txtDealerCards;
  String dealerCards = "";
  JTextArea txtYourCards;
  String yourCards = "";

  static Player player = LoginWindow.player;
  static String username = player.getUsername();

  public static Random randomNumber = new Random();
  public static DeckOfCards deck = new DeckOfCards();

  CardLayout layout = new CardLayout();
  

  public GameWindow(){
    super("Black Jack");

    base = getContentPane();
    base.setLayout(layout);

    initial = initialPanel();
    game = gamePanel();

    base.add(initial, "initial");
    base.add(game, "game");

    layout.show(base, "initial");
  }

  public JPanel initialPanel(){

    pnlInitial = new JPanel();
    pnlInitial.setLayout(null);
    add(pnlInitial);

    lblWelcome = new JLabel("Welcome to the game " + username + "! You will be playing black jack.");
    lblWelcome.setBounds(100, 20, 600, 50);
    pnlInitial.add(lblWelcome);

    lblWelcome2 = new JLabel("You have " + player.getCurrentValue() + " $, click 'begin' to start");
    lblWelcome2.setBounds(150, 50, 600, 50);
    pnlInitial.add(lblWelcome2);

    btnBegin = new JButton("Begin");
    btnBegin.setBounds(250, 237 , 100, 25);
    btnBegin.setActionCommand("Begin");
    btnBegin.addActionListener(this);
    pnlInitial.add(btnBegin);

    return pnlInitial;

  }

  public JPanel gamePanel(){
    pnlGame = new JPanel();
    pnlGame.setLayout(null);
    add(pnlGame);

    lblDealerCards = new JLabel("The dealers cards are: ");
    lblDealerCards.setBounds(10, 15, 200, 50);
    pnlGame.add(lblDealerCards);

    txtDealerCards = new JTextArea(dealerCards);
    txtDealerCards.setBounds(10, 50, 150, 150);
    pnlGame.add(txtDealerCards);

    lblYourCards = new JLabel("Your cards are: ");
    lblYourCards.setBounds(200, 15, 200, 50);
    pnlGame.add(lblYourCards);

    txtYourCards = new JTextArea(yourCards);
    txtYourCards.setBounds(200, 50, 150, 200);
    pnlGame.add(txtYourCards);

    btnHit = new JButton("Hit");
    btnHit.setBounds(450, 125 , 100, 25);
    btnHit.setActionCommand("Hit");
    btnHit.addActionListener(this);
    pnlGame.add(btnHit);

    btnStand = new JButton("Stand");
    btnStand.setBounds(450, 175 , 100, 25);
    btnStand.setActionCommand("Stand");
    btnStand.addActionListener(this);
    pnlGame.add(btnStand);

    btnPeak = new JButton("Peak (50/50)");
    btnPeak.setBounds(400, 50 , 200, 25);
    btnPeak.setActionCommand("Peak");
    btnPeak.addActionListener(this);
    pnlGame.add(btnPeak);

    return pnlGame;
    }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()){
      case "Begin":
        layout.show(base, "game");
        break;
      case "Hit":
        Card pulledCard = deck.pullRandom();
        yourCards = " TEXT";
        this.txtYourCards.setText(yourCards);
        break;
      case "Stand":
        break;
      case "Peak":
        PeakWindow myFrame = new PeakWindow();

        myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myFrame.setSize(300, 100); // set frame size
        myFrame.setVisible(true); // display frame
        break;
    }
  }
}