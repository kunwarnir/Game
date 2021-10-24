import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressWindow extends JFrame implements ActionListener{

  JPanel panel;
  JLabel lblInfo;
  JButton btnDownload;
  JButton btnPlayAgain;
  
  String fileMessage;
  File file = new File("progress.txt");

  Player player = Player.getInstance();

  public ProgressWindow(){

    super("ProgressWindow");

    panel = new JPanel();
    panel.setLayout(null);
    add(panel);

    lblInfo = new JLabel("This is your progress");
    lblInfo.setBounds(200, 30, 300, 25);
    panel.add(lblInfo);

    btnPlayAgain = new JButton("Play");
    btnPlayAgain.setBounds(66, 400 , 200, 50);
    btnPlayAgain.setActionCommand("Play");
    btnPlayAgain.addActionListener(this);
    panel.add(btnPlayAgain);

    btnDownload = new JButton("Download");
    btnDownload.setBounds(332, 400, 200, 50);
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