import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoginWindow extends JFrame implements ActionListener{

  private JButton btn;
  private JLabel lblUsername;
  private JLabel lblUsernameError;
  private JLabel lblMoney;
  private JLabel lblBetError;
  private JPanel panel;
  private JTextField txtUserName;
  private JTextField txtMoney;

  private String betError = "Please enter a valid number (cannot leave empty)";

  public static Player player = Player.getInstance();

  public LoginWindow(){
    
    super("Casino Login");

    panel = new JPanel();
    panel.setLayout(null);
    add(panel);

    lblUsername = new JLabel("Enter Your Username");
    lblUsername.setBounds(223, 30, 150, 25);
    panel.add(lblUsername);

    lblUsernameError = new JLabel("   ");
    lblUsernameError.setBounds(215, 100, 3000, 25);
    lblUsernameError.setFont(new Font("Serif", Font.PLAIN, 12));
    lblUsernameError.setForeground(Color.RED);
    panel.add(lblUsernameError);

    txtUserName = new JTextField(20);
    txtUserName.setBounds(225, 75, 150, 25);
    panel.add(txtUserName);

    lblMoney = new JLabel("Enter How Much Money You Want to Play With");
    lblMoney.setBounds(140, 150, 3000, 25);
    panel.add(lblMoney);

    lblBetError = new JLabel("   ");
    lblBetError.setBounds(145, 215, 3000, 25);
    lblBetError.setFont(new Font("Serif", Font.PLAIN, 12));
    lblBetError.setForeground(Color.RED);
    panel.add(lblBetError);

    txtMoney = new JTextField(20);
    txtMoney.setBounds(225, 185, 150, 25);
    panel.add(txtMoney);

    btn = new JButton("Login");
    btn.setBounds(260, 350, 80, 50);
    btn.setActionCommand("Login");
    btn.addActionListener(this);
    panel.add(btn);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()){
      case "Login":
          if (txtUserName.getText().isEmpty()){
            lblUsernameError.setText("Username cannot be empty!");
          }
          else {
            player.setUsername(txtUserName.getText());
          }
        try {
          player.setMoney(Double.parseDouble(txtMoney.getText()));

          GameWindow myFrame = new GameWindow();

          myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          myFrame.setSize(600, 500); // set frame size
          myFrame.setVisible(true); // display frame

          this.dispose();

      } catch (NumberFormatException ex) {
          lblBetError.setText(betError);
          System.out.println(ex);
      }
    }
  }
}