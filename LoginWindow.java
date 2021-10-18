import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.util.concurrent.TimeUnit; 
import java.util.Scanner; 
import java.text.DecimalFormat;
class Gui extends JFrame{

  JButton btn;
  JFrame frame;
  JLabel label;

  public Gui(){
    
    super("Casino");
    label = new JLabel(testtr.message(), SwingConstants.CENTER);

    add(label);
    btn = new JButton();

    btn.setText(testtr.message());
    btn.setSize(20, 40);
    btn.setLocation(25, 150);
    btn.setBackground(Color.GRAY);
    btn.setActionCommand("UserManual");
 

    add(btn);

  }
}