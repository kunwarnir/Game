import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame implements ActionListener{

  JButton btn;
  JLabel lblUsername;
  JLabel lblMoney;
  JLabel lblBetError;
  JPanel panel;
  JTextField txtUserName;
  JTextField txtMoney;

  String betError;

  public static Player player;

  public LoginWindow(){
    
    super("Casino Login");

    panel = new JPanel();
    panel.setLayout(null);
    add(panel);

    lblUsername = new JLabel("Enter Your Username");
    lblUsername.setBounds(200, 30, 150, 25);
    panel.add(lblUsername);

    txtUserName = new JTextField(20);
    txtUserName.setBounds(200, 75, 165, 25);
    panel.add(txtUserName);

    lblMoney = new JLabel("Enter How Much Money You Want to Play With");
    lblMoney.setBounds(120, 115, 3000, 25);
    panel.add(lblMoney);

    lblBetError = new JLabel("   ");
    lblBetError.setBounds(120, 175, 3000, 25);
    panel.add(lblBetError);

    txtMoney = new JTextField(20);
    txtMoney.setBounds(200, 150, 165, 25);
    panel.add(txtMoney);

    

    btn = new JButton("Login");
    btn.setBounds(250, 200, 80, 25);
    btn.setActionCommand("Login");
    btn.addActionListener(this);
    panel.add(btn);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()){
      case "Login":

        try {
          player = new Player(txtUserName.getText(), Double.parseDouble(txtMoney.getText()));
          GameWindow myFrame = new GameWindow();

          myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          myFrame.setSize(600, 500); // set frame size
          myFrame.setVisible(true); // display frame

        this.dispose();
        }catch (NumberFormatException ex) {
          lblBetError.setText(betError);
          System.out.println(ex);
        }
        

        
    }
  }
}