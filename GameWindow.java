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
  JPanel pnlEnd;
  JPanel pnlAgain;
  JPanel pnlPeekFail;
  JPanel game;
  JPanel initial;
  JPanel end;
  JPanel again;
  JPanel peekFail;

  JLabel lblWelcome;
  JLabel lblWelcome2;
  JLabel lblDealerCards;
  JLabel lblYourCards;
  JLabel lblBet;
  JLabel lblBetAgain;
  JLabel lblBetError;
  JLabel lblBetError2;
  JLabel lblGameLength;
  JLabel lblLengthDefault;
  JLabel lblDeckSize;
  JLabel lblDeckSize2;
  JLabel lblDeckDefault;
  JLabel lblLengthError;
  JLabel lblDeckError;
  JLabel lblDealerTotal;
  JLabel lblYourTotal;
  JLabel lblGameInfo;
  JLabel lblBank;
  JLabel lblYourBet;
  JLabel lblPeekFail;

  JLabel lblEndInfo;
  JLabel lblCurrentMoneyInfo;
  JLabel lblCurrentMoneyValues;
  JLabel lblYourHandInfo;
  JTextArea txtYourHandValues;
  
  JTextField txtBet;
  JTextField txtbetAgain;
  JTextField txtGamelength;
  JTextField txtDeckSize;

  JButton btnBegin;
  JButton btnBeginAgain;
  JButton btnBack;
  JButton btnPeak;
  JButton btnHit;
  JButton btnStand;
  JButton btnPlayAgain;
  JButton btnViewProgress;

  JTextArea txtDealerCards;
  String dealerCards = "";
  JTextArea txtYourCards;
  String yourCards = "";
  String betError;

  double moneyBet;
  //default game length
  int gameLength= 21;
  int deckSize = 1;
  boolean win = false;

  // same as the player in the other class because of singleton design pattern
  static Player player = Player.getInstance();
  static Dealer dealer = new Dealer();

  public static Random randomNumber = new Random();
  public static DeckOfCards deck;

  CardLayout layout = new CardLayout();

  Font titleFont = new Font("Helvetica", Font.BOLD, 16);
  Font font2 = new Font("Serif", Font.PLAIN, 12);

  public GameWindow(){
    super("Black Jack");

    base = getContentPane();
    base.setLayout(layout);

    initial = initialPanel();
    game = gamePanel();
    end = endPanel();
    again = againPanel();
    peekFail = peekFailPanel();

    base.add(initial, "initial");
    base.add(game, "game");
    base.add(end, "end");
    base.add(again, "again");
    base.add(peekFail, "peekFail");


    layout.show(base, "initial");
  }

  public JPanel initialPanel(){

    pnlInitial = new JPanel();
    pnlInitial.setLayout(null);
    add(pnlInitial);

    lblWelcome = new JLabel("Welcome to the game " + player.getUsername() + "! You will be playing black jack.");
    lblWelcome.setBounds(100, 20, 600, 50);
    pnlInitial.add(lblWelcome);

    lblWelcome2 = new JLabel("You have " + player.getCurrentValue() + " $, click 'begin' to start");
    lblWelcome2.setBounds(155, 45, 600, 50);
    pnlInitial.add(lblWelcome2);

    lblBet = new JLabel("Enter How Much Money You Want to bet");
    lblBet.setBounds(150, 100, 3000, 25);
    pnlInitial.add(lblBet);

    lblBetError2 = new JLabel("   ");
    lblBetError2.setBounds(175, 160, 3000, 25);
    lblBetError2.setFont(font2);
    lblBetError2.setForeground(Color.RED);
    pnlInitial.add(lblBetError2);

    txtBet = new JTextField(20);
    txtBet.setBounds(250, 135, 100, 25);
    pnlInitial.add(txtBet);

    lblGameLength = new JLabel("Enter desired game length");
    lblGameLength.setBounds(50, 200, 190, 25);
    pnlInitial.add(lblGameLength);

    txtGamelength = new JTextField(50);
    txtGamelength.setBounds(95, 225, 100, 25);
    pnlInitial.add(txtGamelength);

    lblLengthDefault = new JLabel("(default is 21)");
    lblLengthDefault.setFont(font2);
    lblLengthDefault.setBounds(97, 250, 100, 25);
    pnlInitial.add(lblLengthDefault);

    lblLengthError = new JLabel("   ");
    lblLengthError.setBounds(97, 275, 3000, 25);
    lblLengthError.setFont(font2);
    lblLengthError.setForeground(Color.RED);
    pnlInitial.add(lblLengthError);

    lblDeckSize = new JLabel("Enter how many decks");
    lblDeckSize.setBounds(375, 185, 300, 25);
    pnlInitial.add(lblDeckSize);

    lblDeckSize2 = new JLabel("you want to play with");
    lblDeckSize2.setBounds(375, 200, 300, 25);
    pnlInitial.add(lblDeckSize2);

    txtDeckSize = new JTextField(50);
    txtDeckSize.setBounds(400, 225, 100, 25);
    pnlInitial.add(txtDeckSize);

    lblDeckDefault = new JLabel("(default is one deck)");
    lblDeckDefault.setFont(font2);
    lblDeckDefault.setBounds(385, 250, 150, 25);
    pnlInitial.add(lblDeckDefault);

    lblDeckError = new JLabel("   ");
    lblDeckError.setBounds(385, 275, 3000, 25);
    lblDeckError.setFont(font2);
    lblDeckError.setForeground(Color.RED);
    pnlInitial.add(lblDeckError);
    
    btnBegin = new JButton("Begin");
    btnBegin.setBounds(400, 400, 100, 50);
    btnBegin.setActionCommand("Begin");
    btnBegin.addActionListener(this);
    pnlInitial.add(btnBegin);

    btnBack = new JButton("Back");
    btnBack.setBounds(100, 400, 100, 50);
    btnBack.setActionCommand("Back");
    btnBack.addActionListener(this);
    pnlInitial.add(btnBack);

    return pnlInitial;

  }

  public JPanel gamePanel(){
    
    pnlGame = new JPanel();
    pnlGame.setLayout(null);
    add(pnlGame);

    lblGameInfo = new JLabel("Black Jack");
    lblGameInfo.setFont(titleFont);
    lblGameInfo.setBounds(250, 15, 600, 50);
    pnlGame.add(lblGameInfo);

    lblDealerCards = new JLabel("The dealers cards are: ");
    lblDealerCards.setBounds(10, 50, 200, 50);
    pnlGame.add(lblDealerCards);

    txtDealerCards = new JTextArea("The Dealers Cards will appear here");
    txtDealerCards.setBounds(10, 85, 175, 225);
    pnlGame.add(txtDealerCards);

    lblYourCards = new JLabel("Your cards are: ");
    lblYourCards.setBounds(215, 50, 200, 50);
    pnlGame.add(lblYourCards);

    txtYourCards = new JTextArea("Your cards will appear here");
    txtYourCards.setBounds(215, 85, 175, 225);
    pnlGame.add(txtYourCards);

    lblDealerTotal = new JLabel("The dealers total is: " + dealer.getHandSum());
    lblDealerTotal.setBounds(10, 300, 200, 50);
    pnlGame.add(lblDealerTotal);

    lblYourTotal = new JLabel("Your total is: " + player.getHandSum());
    lblYourTotal.setBounds(215, 300, 200, 50);
    pnlGame.add(lblYourTotal);

    lblBank = new JLabel("You have a total of: " + player.getCurrentValue() + "$");
    lblBank.setBounds(400, 85, 200, 50);
    pnlGame.add(lblBank);

    lblYourBet = new JLabel("Your bet is: " + moneyBet + "$");
    lblYourBet.setBounds(400, 105, 200, 50);
    pnlGame.add(lblYourBet);

    btnHit = new JButton("HIT");
    btnHit.setBounds(445, 165, 100, 50);
    btnHit.setActionCommand("Hit");
    btnHit.addActionListener(this);
    pnlGame.add(btnHit);

    btnStand = new JButton("STAND");
    btnStand.setBounds(445, 240, 100, 50);
    btnStand.setActionCommand("Stand");
    btnStand.addActionListener(this);
    pnlGame.add(btnStand);

    btnPeak = new JButton("Peek (50/50)");
    btnPeak.setBounds(225, 400 , 150, 50);
    btnPeak.setActionCommand("Peek");
    btnPeak.addActionListener(this);
    pnlGame.add(btnPeak);

    return pnlGame;
  }

  public JPanel endPanel(){
  
  pnlEnd = new JPanel();
  pnlEnd.setLayout(null);
  add(pnlEnd);

  lblEndInfo = new JLabel();
  lblEndInfo.setFont(titleFont);
  lblEndInfo.setBounds(200, 10, 400, 50);
  pnlEnd.add(lblEndInfo);

  lblCurrentMoneyInfo = new JLabel("The amount of money you currently have is:");
  lblCurrentMoneyInfo.setBounds(10, 50, 400, 50);
  pnlEnd.add(lblCurrentMoneyInfo);

  lblCurrentMoneyValues = new JLabel(String.valueOf(player.getCurrentValue()));
  lblCurrentMoneyValues.setBounds(10, 50, 150, 150);
  pnlEnd.add(lblCurrentMoneyValues);

  lblYourHandInfo = new JLabel("You had a score of");
  lblYourHandInfo.setBounds(400, 50, 200, 50);
  pnlEnd.add(lblYourHandInfo);

  txtYourHandValues = new JTextArea(" ");
  txtYourHandValues.setBounds(400, 100, 150, 200);
  pnlEnd.add(txtYourHandValues);

  btnPlayAgain = new JButton("Play Again");
  btnPlayAgain.setBounds(25, 300 , 200, 25);
  btnPlayAgain.setActionCommand("Again");
  btnPlayAgain.addActionListener(this);
  pnlEnd.add(btnPlayAgain);

  btnViewProgress = new JButton("View Progress");
  btnViewProgress.setBounds(300, 300 , 200, 25);
  btnViewProgress.setActionCommand("Progress");
  btnViewProgress.addActionListener(this);
  pnlEnd.add(btnViewProgress);

  return pnlEnd;
  }
  
  public JPanel againPanel(){

    pnlAgain = new JPanel();
    pnlAgain.setLayout(null);
    add(pnlAgain);

    lblWelcome = new JLabel("Welcome back to the game " + player.getUsername() + "! You will be playing with the same settings");
    lblWelcome.setBounds(80, 20, 600, 50);
    pnlAgain.add(lblWelcome);

    lblWelcome2 = new JLabel("You have " + player.getCurrentValue() + " $, click 'begin' to start");
    lblWelcome2.setBounds(155, 45, 600, 50);
    pnlAgain.add(lblWelcome2);

    lblBetAgain = new JLabel("Enter How Much Money You Want to bet");
    lblBetAgain.setBounds(150, 100, 3000, 25);
    pnlAgain.add(lblBetAgain);

    lblBetError = new JLabel("   ");
    lblBetError.setBounds(200, 160, 3000, 25);
    pnlAgain.add(lblBetError);

    txtbetAgain = new JTextField(20);
    txtbetAgain.setBounds(250, 135, 100, 25);
    pnlAgain.add(txtbetAgain);

    lblGameLength = new JLabel("Game Length: " + gameLength);
    lblGameLength.setBounds(50, 200, 190, 25);
    pnlAgain.add(lblGameLength);

    lblDeckSize = new JLabel("Deck Size: " + deckSize);
    lblDeckSize.setBounds(375, 200, 300, 25);
    pnlAgain.add(lblDeckSize);

    btnBeginAgain = new JButton("Begin");
    btnBeginAgain.setBounds(250, 400, 100, 50);
    btnBeginAgain.setActionCommand("BeginAgain");
    btnBeginAgain.addActionListener(this);
    pnlAgain.add(btnBeginAgain);

    return pnlAgain;

  }

  public JPanel peekFailPanel(){

    pnlPeekFail = new JPanel();
    pnlPeekFail.setLayout(null);
    add(pnlPeekFail);

    lblPeekFail = new JLabel("You failed 2 peeks, you will be forced to quit the game!");
    lblPeekFail.setFont(titleFont);
    lblPeekFail.setBounds(80, 20, 600, 50);
    pnlPeekFail.add(lblPeekFail);

    pnlPeekFail.add(btnViewProgress);

    return pnlPeekFail;

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()){
      case "Begin":
        
        if (txtGamelength.getText().isEmpty()){
          gameLength = 21;
        }
        else {
          try {
            gameLength = Integer.parseInt(txtGamelength.getText());
          } catch (NumberFormatException ex){
            lblLengthError.setText("Please enter a valid number!");
            System.out.println(ex + " Game Length");
          }
        }

        if (txtDeckSize.getText().isEmpty()){
          deck = new DeckOfCards();
        }
        else {
          try {
            deckSize = Integer.parseInt(txtDeckSize.getText());
            deck = new SpecialDeck(deckSize);
          } catch (NumberFormatException ex){
            lblDeckError.setText("Please enter a valid number!");
            System.out.println(ex + " Deck Size");
          }
        }
        
        try {
          moneyBet = Double.parseDouble(txtBet.getText());
          if (moneyBet > player.getCurrentValue()){
            betError = "You cannot bet more money than you have!";
            lblBetError2.setText(betError);
          }
          else {
            beginGame();
            layout.show(base, "game");
            // 
          }
        }catch (NumberFormatException ex) {
          betError = "Please enter a valid number!";
          lblBetError.setText(betError);
          System.out.println(ex + " betting");
        }
        break;
      case "BeginAgain":
        try {
          moneyBet = Double.parseDouble(txtbetAgain.getText());
          if (moneyBet > player.getCurrentValue()){
            betError = "You cannot bet more money than you have!";
            lblBetError.setText(betError);
          }
          else {
            layout.show(base, "game");
            beginGame();
          }
        }catch (NumberFormatException ex) {
          betError = "Please enter a valid number!";
          lblBetError.setText(betError);
          System.out.println(ex + " betting");
        }
        break;
      case "Hit":
        hit();
        if (!keepPlaying(gameLength)){
          endGame();
        }

        break;
      case "Stand":
        stand();
        break;
      case "Peek":
        PeekWindow myFrame = new PeekWindow();

        myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myFrame.setSize(500, 100); // set frame size
        myFrame.setVisible(true); // display frame

        if (player.getLives() == 0){
          player.addGame(moneyBet, false);
          layout.show(base, "peekFail");
          
        }
        wait(2000);

        break;
      case "Again":
        layout.show(base, "again");
        break;
      case "Progress":
        ProgressWindow progressFrame = new ProgressWindow();

        progressFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        progressFrame.setSize(600, 500); // set frame size
        progressFrame.setVisible(true); // display frame
        break;
      case "Back":
        LoginWindow loginFrame = new LoginWindow(); // create LabelFrame
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(600, 500); // set frame size
        loginFrame.setVisible(true); // display frame
        break;
      default:
        break;
        
    }
  }

  public boolean isWin(){
    
    boolean win = false;
    
    if (player.distanceFrom(gameLength) < 0 && dealer.distanceFrom(gameLength) > 0){
      win = false;
    }
    else if (dealer.distanceFrom(gameLength) < 0 && player.distanceFrom(gameLength) > 0){
      win = true;
    }
    else if (player.distanceFrom(gameLength) < dealer.distanceFrom(gameLength)){
      win = true;
    }
    else {
      win = false;
    }

    return win;
    
  }

  public void wait(int time){
    try {
      Thread.sleep(time);
    } catch (Exception ex){
      System.out.println(ex);
    }
  }

  public boolean keepPlaying(int length){
    if (player.getHandSum() >= length || dealer.getHandSum() >= length){
      return false;
    }
    else {
      return true;
    }
  }

  public void beginGame(){
    
    deck.shuffleDeck();

    dealer.addCard(deck.pullTop());
    player.addCard(deck.pullTop());

    dealerCards = dealer.handToString();
    yourCards = player.handToString();

    txtDealerCards.setText(dealerCards); 
    txtYourCards.setText(yourCards);

    lblBank.setText("You have a total of: " + player.getCurrentValue() + "$");
    lblYourBet.setText("Your bet is: " + moneyBet + "$");

    lblWelcome2.setText("You have " + player.getCurrentValue() + " $, click 'begin' to start");

    lblDealerTotal.setText("The dealers total is: " + dealer.getHandSum());
    lblYourTotal.setText("Your total is: " + player.getHandSum());  

  }

  public void endGame(){
    
    if (isWin()){
      lblEndInfo.setText("Great Job! You won the game");
    }
    else {
      lblEndInfo.setText("Better luck next time");
    }
    
    // layout.show(base, "end");

    player.addGame(moneyBet, isWin());

    lblCurrentMoneyValues.setText(String.valueOf(player.getCurrentValue()));
    lblYourHandInfo.setText("You had a score of: " + player.getHandSum());
    txtYourHandValues.setText(player.handToString());

    player.clearSum();
    dealer.clearSum();

    player.clearHand();
    dealer.clearHand();
  }

  public void hit(){
    player.addCard(deck.pullTop());
    yourCards = player.handToString();
    txtYourCards.setText(yourCards);
    lblYourTotal.setText("Your total is: " + player.getHandSum()); 
  }

  public void stand(){
    do {
      dealer.addCard(deck.pullTop());
      dealerCards = dealer.handToString();
      txtDealerCards.setText(dealerCards);
      lblDealerTotal.setText("The dealers total is: " + dealer.getHandSum());
    }
    while (dealer.distanceFrom(gameLength) > player.distanceFrom(gameLength));

    endGame();
  }

}