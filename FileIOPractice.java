import java.io.*;

public class FileIOPractice {

  public void practice(){
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));

      bw.write("This is the new file");
      bw.close();
    } catch (Exception e){
      System.out.println(e);
    }
  }
}