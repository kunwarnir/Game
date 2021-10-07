import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Hello world");
    frame.setSize(375, 375);
    frame.setLocation(100, 100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel label = new JLabel(test.message(), SwingConstants.CENTER);
    frame.add(label);

    frame.show();
  }
}

// https://onlinegdb.com/Fs_S7CaY7I

