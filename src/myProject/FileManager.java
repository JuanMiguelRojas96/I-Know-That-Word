package myProject;

import java.io.*;
import java.net.SocketTimeoutException;

public class FileManager {
  private FileReader fileReader;
  private BufferedReader input;
  private FileWriter fileWriter;
  private BufferedWriter output;

  public String reader(){
    String text = "";

    try {
      fileReader = new FileReader("src/resources/Users.txt");
      input = new BufferedReader(fileReader);
      String line = input.readLine();
      while(line != null){
        text += line;
        text += "\n";
        line = input.readLine();
      }
    }catch (FileNotFoundException e){
      e.printStackTrace();
    }catch (IOException e){
      e.printStackTrace();
    }finally {
      try{
        input.close();
      } catch (IOException e) {
        e.printStackTrace();
      } catch (NullPointerException e){
        e.printStackTrace();
      }
    }
    return text;
  }

  public void writer(String line){
    try{
      String text = reader();
      text += line + "\n";
      fileWriter = new FileWriter("src/resources/Users.txt");
      output = new BufferedWriter(fileWriter);
      output.write(text);
    }catch (IOException e){
      e.printStackTrace();
    }finally {
      try{
        output.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
