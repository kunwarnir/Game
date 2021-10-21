import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
  JLabel lblBet;
  JLabel lblBetError;

  JTextField txtBet;

  JButton btnBegin;
  JButton btnPeak;
  JButton btnHit;
  JButton btnStand;

  JTextArea txtDealerCards;
  String dealerCards = "";
  JTextArea txtYourCards;
  String yourCards = "";
  String betError = "Please enter a valid number!";

  double moneyBet;

  boolean win;

  // static Player player = LoginWindow.player;
  static Player player = new Player("Kunwar", 555);
  static String username = player.getUsername();

  static Dealer dealer = new Dealer();

  public static Random randomNumber = new Random();
  public DeckOfCards deck = new DeckOfCards();

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

    lblBet = new JLabel("Enter How Much Money You Want to bet");
    lblBet.setBounds(120, 115, 3000, 25);
    pnlInitial.add(lblBet);

    lblBetError = new JLabel("   ");
    lblBetError.setBounds(120, 175, 3000, 25);
    pnlInitial.add(lblBetError);

    txtBet = new JTextField(20);
    txtBet.setBounds(200, 150, 165, 25);
    pnlInitial.add(txtBet);

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

    txtDealerCards = new JTextArea("The Dealers Cards will appear here");
    txtDealerCards.setBounds(10, 50, 150, 150);
    pnlGame.add(txtDealerCards);

    lblYourCards = new JLabel("Your cards are: ");
    lblYourCards.setBounds(200, 15, 200, 50);
    pnlGame.add(lblYourCards);

    txtYourCards = new JTextArea("Your cards will appear here");
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
        try {
          moneyBet = Double.parseDouble(txtBet.getText());
          layout.show(base, "game");
          beginGame();
        }catch (NumberFormatException ex) {
          lblBetError.setText(betError);
        }
        break;
      case "Hit":
        hit();
        break;
      case "Stand":
        stand();
        break;
      case "Peak":
        PeakWindow myFrame = new PeakWindow();

        myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myFrame.setSize(300, 100); // set frame size
        myFrame.setVisible(true); // display frame
        break;
    }
  }

  public boolean isWin(){
    
    boolean win = false;
    
    if (player.distanceFrom21() < 0 && dealer.distanceFrom21() > 0){
      win = false;
    }
    else if (dealer.distanceFrom21() < 0 && player.distanceFrom21() > 0){
      win = true;
    }
    else if (player.distanceFrom21() < dealer.distanceFrom21()){
      win = true;
    }
    else {
      win = false;
    }

    return win;
    
  }

  public void beginGame(){
    
    deck.shuffleDeck();

    dealer.addCard(deck.pullTop());
    player.addCard(deck.pullTop());
    dealer.addCard(deck.pullTop());

    dealerCards = dealer.toString();
    yourCards = player.toString();

    txtDealerCards.setText(dealerCards);
    txtYourCards.setText(yourCards);    

  }

  public void hit(){
    player.addCard(deck.pullTop());
    yourCards = player.toString();
    txtYourCards.setText(yourCards);
  }

  public void stand(){
    dealer.addCard(deck.pullTop());
    dealerCards = dealer.toString();
    txtDealerCards.setText(dealerCards);
  }

}