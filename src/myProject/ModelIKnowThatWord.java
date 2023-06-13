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
private ArrayList<String> words,wordsLevel,wordsToShow;
private int index,secondsPassed,correct,error;
private float promedio;
private String word;


  public ModelIKnowThatWord(){
    fileManager = new FileManager();
    words = new ArrayList<>();
    words =(ArrayList<String>) fileManager.readWords();
    wordsLevel = new ArrayList<>();
    wordsToShow = new ArrayList<>();
    correct = 0;
    error = 0;
    promedio = 0;
  }

  private List<String> levelWords(int level){
    List<String> wordsCopy = new ArrayList<>();
    List<String> wordsToShow = new ArrayList<>();
    Random random = new Random();
    switch (level){
      case 1:
        wordsLevel.clear();
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
        wordsLevel.clear();
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
        wordsLevel.clear();
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
        wordsLevel.clear();
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
        wordsLevel.clear();
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
        wordsLevel.clear();
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
        wordsLevel.clear();
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
        wordsLevel.clear();
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
        wordsLevel.clear();
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
        wordsLevel.clear();
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

  public void showWords(int level, JLabel labelWord,JLabel labelSeconds, JButton optionSi, JButton optionNo){
    wordsToShow = (ArrayList<String>) levelWords(level);
    Timer timer = new Timer(3000,null); //cambie eran 5000
    Timer seconds = new Timer(1000,null);
    timer.setInitialDelay(0);
    timer.start();
    seconds.setInitialDelay(0);
    seconds.start();
    ActionListener wordListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(index < wordsToShow.size()){
          word = wordsToShow.get(index).toUpperCase();
          labelWord.setVisible(true);
          labelWord.setText(word);
          labelWord.repaint();
          index++;
        }else{
          timer.stop();
        }
      }
    };
    ActionListener secondsListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(timer.isRunning()==true){
          secondsPassed++;
          if (secondsPassed > 3){  //cambio eran 5
            secondsPassed = 1;
          }
          labelSeconds.setVisible(true);
          labelSeconds.setText("Tiempo: "+ secondsPassed);
          labelSeconds.repaint();
        }else{
          seconds.stop();
          labelSeconds.setVisible(false);
          labelWord.setText("¡PREPARATE!");
          showLevelWords(wordsLevel,wordsToShow,labelWord,labelSeconds,optionSi,optionNo);
        }
      }
    };
    timer.addActionListener(wordListener);
    seconds.addActionListener(secondsListener);
  }
  public void showLevelWords(ArrayList<String> wordsLevel,ArrayList<String> wordsToShow,JLabel labelWord,JLabel labelSeconds, JButton optionSi, JButton optionNo) {
    System.out.println(wordsLevel);
    System.out.println(wordsToShow);
    Timer timer = new Timer(3000,null); //cambio eran 7000
    Timer seconds = new Timer(1000,null);
    timer.setInitialDelay(3000);
    timer.start();
    seconds.setInitialDelay(3000);
    seconds.start();
    index = 0;
    secondsPassed = 0;
    ActionListener wordListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer){
          if(index < wordsLevel.size()){
            word = wordsLevel.get(index).toUpperCase();
            optionSi.setVisible(true);
            optionNo.setVisible(true);
            labelWord.setForeground(new Color(255, 255, 255));
            labelWord.setVisible(true);
            labelWord.setText(word);
            labelWord.repaint();
            index++;
          }
          else{
            timer.stop();
          }
        }
        if(e.getSource()== optionSi){
          optionSi.setVisible(false);
          optionNo.setVisible(false);
          if (wordsToShow.contains(word.toLowerCase())){
            correct += 1;
            labelWord.setForeground(new Color(64, 222, 19));
            labelWord.setText("¡CORRECTO!");
          }else{
            error += 1;
            labelWord.setForeground(new Color(255, 0, 0));
            labelWord.setText("¡ERROR!");
          }
        }
        if (e.getSource()==optionNo){
          optionSi.setVisible(false);
          optionNo.setVisible(false);
          if (!wordsToShow.contains((word.toLowerCase()))){
            correct += 1;
            labelWord.setForeground(new Color(64, 222, 19));
            labelWord.setText("¡CORRECTO!");
          }else{
            error += 1;
            labelWord.setForeground(new Color(255, 0, 0));
            labelWord.setText("¡ERROR!");
          }
        }
      }
    };
    ActionListener secondsListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(timer.isRunning()==true){
          secondsPassed++;
          if (secondsPassed > 3){
            secondsPassed = 1;
          }
          labelSeconds.setVisible(true);
          labelSeconds.setText("Tiempo: "+ secondsPassed);
          labelSeconds.repaint();
          promedio = ((float) correct/wordsLevel.size())*100;
          System.out.println(correct);
          System.out.println(wordsLevel.size());
          System.out.println((int)promedio);
        }else{
          seconds.stop();
          labelWord.setForeground(new Color(255, 255, 255));
          labelSeconds.setVisible(false);
          labelWord.setText("Porcentaje Correctas: " + (int)promedio +"%");
          optionSi.setVisible(false);
          optionNo.setVisible(false);
        }
      }
    };
    timer.addActionListener(wordListener);
    optionSi.addActionListener(wordListener);
    optionNo.addActionListener(wordListener);
    seconds.addActionListener(secondsListener);
  }
}



