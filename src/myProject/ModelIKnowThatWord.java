package myProject;

import javax.swing.*;
import javax.xml.transform.Source;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModelIKnowThatWord {
private FileManager fileManager;
private ArrayList<String> words;
private int index;


  public ModelIKnowThatWord(){
    fileManager = new FileManager();
    words = new ArrayList<>();
    words =(ArrayList<String>) fileManager.readWords();
  }

  public List<String> levelWords(int level){
    List<String> wordsLevel = new ArrayList<>();
    List<String> wordsCopy = new ArrayList<>();
    List<String> wordsToShow = new ArrayList<>();
    Random random = new Random();
    switch (level){
      case 1:
        while(wordsLevel.size() < 20){
          int index = random.nextInt(200);
          wordsLevel.add(words.get(index));
          wordsCopy.add(words.get(index));
        }
        while(wordsToShow.size() < 10){
          int index = random.nextInt(wordsCopy.size());
          wordsToShow.add(wordsCopy.get(index));
          wordsCopy.remove(wordsCopy.get(index));
        }
        break;
      case 2:
        while(wordsLevel.size() < 40) {
          int index = random.nextInt(200);
          wordsLevel.add(words.get(index));
          wordsCopy.add(words.get(index));
        }
        while(wordsToShow.size() < 20){
          int index = random.nextInt(wordsCopy.size());
          wordsToShow.add(wordsCopy.get(index));
          wordsCopy.remove(wordsCopy.get(index));
        }
        break;
      case 3:
        while(wordsLevel.size() < 50){
          int index = random.nextInt(200);
          wordsLevel.add(words.get(index));
          wordsCopy.add(words.get(index));
        }
        while(wordsToShow.size() < 25){
          int index = random.nextInt(wordsCopy.size());
          wordsToShow.add(wordsCopy.get(index));
          wordsCopy.remove(wordsCopy.get(index));
        }
        break;
      case 4:
        while(wordsLevel.size() < 60){
          int index = random.nextInt(200);
          wordsLevel.add(words.get(index));
          wordsCopy.add(words.get(index));
        }
        while(wordsToShow.size() < 30){
          int index = random.nextInt(wordsCopy.size());
          wordsToShow.add(wordsCopy.get(index));
          wordsCopy.remove(wordsCopy.get(index));
        }
        break;
      case 5:
        while(wordsLevel.size() < 70){
          int index = random.nextInt(200);
          wordsLevel.add(words.get(index));
          wordsCopy.add(words.get(index));
        }
        while(wordsToShow.size() < 35){
          int index = random.nextInt(wordsCopy.size());
          wordsToShow.add(wordsCopy.get(index));
          wordsCopy.remove(wordsCopy.get(index));
        }
        break;
      case 6:
        while(wordsLevel.size() < 80){
          int index = random.nextInt(200);
          wordsLevel.add(words.get(index));
          wordsCopy.add(words.get(index));
        }
        while(wordsToShow.size() < 40){
          int index = random.nextInt(wordsCopy.size());
          wordsToShow.add(wordsCopy.get(index));
          wordsCopy.remove(wordsCopy.get(index));
        }
        break;
      case 7:
        while(wordsLevel.size() < 100){
          int index = random.nextInt(200);
          wordsLevel.add(words.get(index));
          wordsCopy.add(words.get(index));
        }
        while(wordsToShow.size() < 50){
          int index = random.nextInt(wordsCopy.size());
          wordsToShow.add(wordsCopy.get(index));
          wordsCopy.remove(wordsCopy.get(index));
        }
        break;
      case 8:
        while(wordsLevel.size() < 120){
          int index = random.nextInt(200);
          wordsLevel.add(words.get(index));
          wordsCopy.add(words.get(index));
        }
        while(wordsToShow.size() < 60){
          int index = random.nextInt(wordsCopy.size());
          wordsToShow.add(wordsCopy.get(index));
          wordsCopy.remove(wordsCopy.get(index));
        }
        break;
      case 9:
        while(wordsLevel.size() < 140){
          int index = random.nextInt(200);
          wordsLevel.add(words.get(index));
          wordsCopy.add(words.get(index));
        }
        while(wordsToShow.size() < 70){
          int index = random.nextInt(wordsCopy.size());
          wordsToShow.add(wordsCopy.get(index));
          wordsCopy.remove(wordsCopy.get(index));
        }
        break;
      case 10:
        while(wordsLevel.size() < 200){
          int index = random.nextInt(200);
          wordsLevel.add(words.get(index));
          wordsCopy.add(words.get(index));
        }
        while(wordsToShow.size() < 100){
          int index = random.nextInt(wordsCopy.size());
          wordsToShow.add(wordsCopy.get(index));
          wordsCopy.remove(wordsCopy.get(index));
        }
        break;

    }
    return wordsToShow;
  }

  public void showWords(int level){
    List<String> wordsToShow = levelWords(level);
    Timer timer = new Timer(7000,null);
    timer.start();
    System.out.println(wordsToShow);
    ActionListener escucha = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(index < wordsToShow.size()){
          String word = wordsToShow.get(index);
          System.out.println(word);
          index++;
        }else{
          ((Timer) e.getSource()).stop();
        }
      }
    };
    timer.addActionListener(escucha);
  }
}
