import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;

public class PeakWindow extends JFrame implements ActionListener{

  Container base;
  
  JPanel pnlSuccess;
  JPanel pnlFail;

  JPanel success;
  JPanel fail;

  JLabel lblSuccess;
  JLabel lblFail;

  CardLayout layout = new CardLayout();
  Random random;

  public PeakWindow(){
    super("Black Jack");

    random = new Random();

    base = getContentPane();
    base.setLayout(layout);

    success = successPanel();
    fail = failPanel();

    base.add(success, "success");
    base.add(fail, "fail");


    if (random.nextBoolean()){
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
    add(pnlSuccess);

    lblSuccess = new JLabel("Your peak was successful, the dealers next card is: ");
    lblSuccess.setBounds(0, 15, 300, 25);
    pnlSuccess.add(lblSuccess);

    return pnlSuccess;
  }

  public JPanel failPanel(){
    pnlFail = new JPanel();
    pnlFail.setLayout(null);
    add(pnlFail);

    lblFail = new JLabel("Your peak was unsuccessful, [some punishment]");
    lblFail.setBounds(0, 15, 300, 25);
    pnlFail.add(lblFail);
    
    return pnlFail;
  }

}