import java.io.*;

public class ProgressWindow{

  String fileMessage;
  File file = new File("progress.txt");

  public ProgressWindow(){

  }

  public static void write(String message, File file) throws IOException{

    FileWriter fw = new FileWriter(file, true);

    fw.write(message);
    fw.close();

  }
}