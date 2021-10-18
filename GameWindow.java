import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements ActionListener{

  JPanel pnlGame;
  JPanel pnlInitial;

  JLabel lblWelcome;

  JButton btnBegin;
  
  static Player player = LoginWindow.player;

  static String username = player.getUsername();

  

  public GameWindow(){
    super("Black Jack");
    add(initialWindow());
  }

  public JPanel initialWindow(){

    pnlInitial = new JPanel();
    pnlInitial.setLayout(null);
    add(pnlInitial);

    lblWelcome = new JLabel("Welcome to the game " + username + "! You will be playing black jack, and you have" + player.getCurrentValue() + " dollars, click 'begin' to start the game");
    lblWelcome.setBounds(100, 20, 400, 50);
    pnlInitial.add(lblWelcome);

    btnBegin = new JButton("Begin");
    btnBegin.setBounds(250, 237 , 100, 25);
    btnBegin.setActionCommand("Begin");
    btnBegin.addActionListener(this);
    pnlInitial.add(btnBegin);

    return pnlInitial;

  }


  @Override
  public void actionPerformed(ActionEvent e) {
  }
}