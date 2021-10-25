import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressWindow extends JFrame implements ActionListener{

  private JPanel panel;
  private JLabel lblInfo;
  private JLabel lblTitle;
  private JButton btnDownload;
  private JButton btnPlayAgain;
  private JTextArea txtYourStats;
  
  private String fileMessage;
  private File file = new File("stats.txt");

  Player player = Player.getInstance();

  public ProgressWindow(){

    super("Progress Window");

    panel = new JPanel();
    panel.setLayout(null);
    add(panel);

    lblTitle = new JLabel("Your Progress");
    lblTitle.setBounds(225, 15, 150, 25);
    lblTitle.setFont(new Font("Helvetica", Font.BOLD, 16));
    panel.add(lblTitle);

    lblInfo = new JLabel("These are your stats:");
    lblInfo.setBounds(66, 75, 300, 25);
    panel.add(lblInfo);

    txtYourStats = new JTextArea(player.getFileMessage());
    txtYourStats.setBounds(66, 100, 200, 225);
    panel.add(txtYourStats);

    btnPlayAgain = new JButton("Play Again");
    btnPlayAgain.setBounds(332, 400 , 200, 50);
    btnPlayAgain.setActionCommand("Play");
    btnPlayAgain.addActionListener(this);
    panel.add(btnPlayAgain);

    btnDownload = new JButton("Download");
    btnDownload.setBounds(332, 200, 200, 50);
    btnDownload.setActionCommand("Download");
    btnDownload.addActionListener(this);
    panel.add(btnDownload);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()){
      case "Download":
        fileMessage = player.getFileMessage();
        try {
          write(fileMessage, file);
        } catch (IOException ex){
          System.out.println("IOException: " + ex);
        }
        break;
      case "Play":
        LoginWindow myFrame = new LoginWindow(); // create LabelFrame
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600, 500); // set frame size
        myFrame.setVisible(true); // display frame
        break;
      default:
        break;        
    }
  }

  public static void write(String message, File file) throws IOException{

    FileWriter fw = new FileWriter(file, true);

    fw.write(message);
    fw.close();

  }
}