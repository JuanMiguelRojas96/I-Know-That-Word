package myProject;

import java.io.*;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileManager {
  private static FileReader fileReader;
  private static BufferedReader input;
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
  public static List<String> readWords() {
   List<String> randomWords = new ArrayList<>();
   Random random = new Random();
   try{
     fileReader = new FileReader("src/resources/Palabras.txt");
     input = new BufferedReader(fileReader);
     String line = input.readLine();
     int lineCount = 0;

     while (line != null){
       lineCount++;
       if(random.nextInt(lineCount) < 200){
         randomWords.add(line);
         if (randomWords.size() >= 200){
           break;
         }
       }
       line = input.readLine();
     }
   } catch (FileNotFoundException e) {
     e.printStackTrace();
   } catch (IOException e) {
     e.printStackTrace();
   }finally{
     try{
       input.close();
     }catch (IOException e){
       e.printStackTrace();
     }
   }
   return randomWords;
  }
}
