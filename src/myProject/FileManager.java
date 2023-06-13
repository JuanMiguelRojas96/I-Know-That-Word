package myProject;

import java.io.*;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * La clase FileManager se utiliza para leer y escribir archivos.
 */
public class FileManager {
  private static FileReader fileReader;
  private static BufferedReader input;
  private FileWriter fileWriter;
  private BufferedWriter output;

  /**
   * Lee el contenido del archivo "Users.txt" y lo devuelve como un String.
   *
   * @return El contenido del archivo "Users.txt" como un String.
   */
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
  /**
   * Escribe una línea de texto en el archivo "Users.txt".
   *
   * @param line La línea de texto que se va a escribir en el archivo.
   */
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
  /**
   * Lee una lista de palabras desde el archivo "Palabras.txt".
   *
   * @return Una lista de palabras aleatorias.
   */
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
  /**
   * Borra el contenido del archivo "Users.txt".
   */
  public void deleteFileContent() {
    try {
      fileWriter = new FileWriter("src/resources/Users.txt");
      fileWriter.write(""); // Escribe una cadena vacía para borrar el contenido
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        fileWriter.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
