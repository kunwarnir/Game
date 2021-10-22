import java.io.*;

public class FileIOPractice {

  public static void practice(){
    try {

      File file = new File("file.txt");
      FileWriter fw = new FileWriter(file, true);

      fw.write("wow appended line");
      fw.close();
    } catch (Exception e){
      System.out.println(e);
    }
  }
}