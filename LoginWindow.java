import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame implements ActionListener{

  JButton btn;
  JLabel lblUsername;
  JLabel lblMoney;
  JPanel panel;
  JTextField txtUserName;
  JTextField txtMoney;

  public LoginWindow(){
    
    super("Login");

    panel = new JPanel();
    panel.setLayout(null);
    add(panel);

    lblUsername = new JLabel("Enter Your Username");
    lblUsername.setBounds(10, 20, 150, 25);
    panel.add(lblUsername);

    txtUserName = new JTextField(20);
    txtUserName.setBounds(10, 50, 165, 25);
    panel.add(txtUserName);

    lblMoney = new JLabel("Enter How Much Money You Want to Play With");
    lblMoney.setBounds(10, 75, 3000, 25);
    panel.add(lblMoney);

    txtMoney = new JTextField(20);
    txtMoney.setBounds(10, 100, 165, 25);
    panel.add(txtMoney);

    btn = new JButton("Login");
    btn.setBounds(10, 200, 80, 25);
    btn.setActionCommand("Login");
    btn.addActionListener(this);
    panel.add(btn);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
  }
}