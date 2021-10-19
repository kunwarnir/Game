import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;

public class GameWindow extends JFrame implements ActionListener{

  JPanel pnlInitial;
  JPanel pnlGame;
  Container base;
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
    lblWelcome.setBounds(0, 20, 600, 50);
    pnlInitial.add(lblWelcome);

    lblWelcome2 = new JLabel("You have " + player.getCurrentValue() + " $, click 'begin' to start");
    lblWelcome2.setBounds(0, 50, 600, 50);
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
    lblDealerCards.setBounds(10, 30, 100, 50);
    pnlGame.add(lblDealerCards);

    lblYourCards = new JLabel("Your cards are: ");
    lblYourCards.setBounds(300, 30, 100, 50);
    pnlGame.add(lblYourCards);

    btnHit = new JButton("Hit");
    btnHit.setBounds(10, 237 , 100, 25);
    btnHit.setActionCommand("Hit");
    btnHit.addActionListener(this);
    pnlGame.add(btnHit);

    btnStand = new JButton("Stand");
    btnStand.setBounds(150, 237 , 100, 25);
    btnStand.setActionCommand("Stand");
    btnStand.addActionListener(this);
    pnlGame.add(btnStand);

    btnPeak = new JButton("Peak");
    btnPeak.setBounds(400, 237 , 100, 25);
    btnPeak.setActionCommand("Peak");
    btnPeak.addActionListener(this);
    pnlGame.add(btnPeak);

    return pnlGame;
    }


  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()){
      case "Begin":
        layout.show(base, "game");;
    }
  }
}