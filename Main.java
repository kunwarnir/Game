import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Hello world");
    frame.setSize(300, 300);
    frame.setLocation(100, 100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel label = new JLabel("Hello world", SwingConstants.CENTER);
    frame.add(label);

    frame.show();
  }
}

// https://onlinegdb.com/Fs_S7CaY7I

