package com.shahriyer;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.*;

public class MainGame {
 
 JFrame window;
 Container con;
 JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
 JLabel titleNameLabel, moneyLabel, moneyLabelNumber, timeLabel, timeLabelName;
 Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
 Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
 JButton startButton, choice1, choice2, choice3, choice4;
 JTextArea mainTextArea;
 int playerMONEY, monsterMONEY, silverRing;
 String time, position;
 
 TitleScreenHandler tsHandler = new TitleScreenHandler();
 ChoiceHandler choiceHandler = new ChoiceHandler();


 public static void main(String[] args) {

  new MainGame();
 }
 
 public MainGame(){
  
  window = new JFrame();
  window.setSize(800, 600);
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  window.getContentPane().setBackground(Color.black);
  window.setLayout(null);
  window.setVisible(true);
  con = window.getContentPane();
  
  titleNamePanel = new JPanel();
  titleNamePanel.setBounds(100, 100, 600, 150);
  titleNamePanel.setBackground(Color.black);
  ImageIcon image1 = new ImageIcon("logopix.jpg");
  titleNameLabel = new JLabel(image1);
  titleNameLabel.setForeground(Color.white);
  titleNameLabel.setFont(titleFont); 
  
  startButtonPanel = new JPanel();
  startButtonPanel.setBounds(300, 400, 200, 100);
  startButtonPanel.setBackground(Color.black);
  
  startButton = new JButton("START");
  startButton.setBackground(Color.black);
  startButton.setForeground(Color.white);
  startButton.setFont(normalFont);
  startButton.addActionListener(tsHandler);
  startButton.setFocusPainted(false);
  
  titleNamePanel.add(titleNameLabel);
  startButtonPanel.add(startButton);
  
  con.add(titleNamePanel);
  con.add(startButtonPanel);
 }
 
 public void createGameScreen(){
  
  titleNamePanel.setVisible(false);
  startButtonPanel.setVisible(false);
  
  mainTextPanel = new JPanel();
  mainTextPanel.setBounds(100, 100, 600, 250);
  mainTextPanel.setBackground(Color.black);
  con.add(mainTextPanel);
  
  mainTextArea = new JTextArea("This is the main text are. This game is going to be great. I'm sure of it!!!!!!!");
  mainTextArea.setBounds(100, 100, 600, 250);
  mainTextArea.setBackground(Color.black);
  mainTextArea.setForeground(Color.white);
  mainTextArea.setFont(normalFont);
  mainTextArea.setLineWrap(true);
  mainTextPanel.add(mainTextArea);
  
  choiceButtonPanel = new JPanel();
  choiceButtonPanel.setBounds(250, 350, 300, 150);
  choiceButtonPanel.setBackground(Color.black);
  choiceButtonPanel.setLayout(new GridLayout(4,1));
  con.add(choiceButtonPanel);
  
  choice1 = new JButton("Choice 1");
  choice1.setBackground(Color.black);
  choice1.setForeground(Color.white);
  choice1.setFont(normalFont);
  choice1.setFocusPainted(false);
  choice1.addActionListener(choiceHandler);
  choice1.setActionCommand("c1");
  choiceButtonPanel.add(choice1);
  choice2 = new JButton("Choice 2");
  choice2.setBackground(Color.black);
  choice2.setForeground(Color.white);
  choice2.setFont(normalFont);
  choice2.setFocusPainted(false);
  choice2.addActionListener(choiceHandler);
  choice2.setActionCommand("c2");
  choiceButtonPanel.add(choice2);
  choice3 = new JButton("Choice 3");
  choice3.setBackground(Color.black);
  choice3.setForeground(Color.white);
  choice3.setFont(normalFont);
  choice3.setFocusPainted(false);
  choice3.addActionListener(choiceHandler);
  choice3.setActionCommand("c3");
  choiceButtonPanel.add(choice3);
  choice4 = new JButton("Choice 4");
  choice4.setBackground(Color.black);
  choice4.setForeground(Color.white);
  choice4.setFont(normalFont);
  choice4.setFocusPainted(false);
  choice4.addActionListener(choiceHandler);
  choice4.setActionCommand("c4");
  choiceButtonPanel.add(choice4);
  
  playerPanel = new JPanel();
  playerPanel.setBounds(100, 15, 600, 50);
  playerPanel.setBackground(Color.black);
  playerPanel.setLayout(new GridLayout(1,4));
  con.add(playerPanel);
  moneyLabel = new JLabel("Money:");
  moneyLabel.setFont(normalFont);
  moneyLabel.setForeground(Color.white);
  playerPanel.add(moneyLabel);
  moneyLabelNumber = new JLabel();
  moneyLabelNumber.setFont(normalFont);
  moneyLabelNumber.setForeground(Color.white);
  playerPanel.add(moneyLabelNumber);
  timeLabel = new JLabel("Time:");
  timeLabel.setFont(normalFont);
  timeLabel.setForeground(Color.white);
  playerPanel.add(timeLabel);
  timeLabelName = new JLabel();
  timeLabelName.setFont(normalFont);
  timeLabelName.setForeground(Color.white);
  playerPanel.add(timeLabelName);

  playerSetup();

 }
 public void playerSetup(){
  playerMONEY = 600;
  monsterMONEY = 20;
  time = "morning";
  timeLabelName.setText(time);
  moneyLabelNumber.setText("" + playerMONEY + "TK");
  
  Dhanmondi();
 }
 public void Dhanmondi(){
  position = "Dhanmondi";
  mainTextArea.setText("You have to give 800 taka to Mohajon at the end of your day. \n\nWhat do you do?");  
  choice1.setText("CNG joma dei");
  choice2.setText("CNG niya bhaiga jai");
  choice3.setText("Kaaje jai");
  choice4.setText("");
 }
 public void talkMohajon(){
  position = "talkMohajon";
  mainTextArea.setText("Mohajon: 800 taka aanso? Ano nai?? \nTaile to joma nimu na.");
  choice1.setText(">");
  choice2.setText("");
  choice3.setText("");
  choice4.setText("");
 }
 public void escapeMohajon(){
  position = "escapeMohajon";
  mainTextArea.setText("Mohajon: Etto boro shahosh!\n\nJa taka chilo oikhan theke kisu niya nilo.\n(You lose some money)");
  playerMONEY = playerMONEY -200;
  moneyLabelNumber.setText(""+playerMONEY);
  choice1.setText(">");
  choice2.setText("");
  choice3.setText("");
  choice4.setText("");
 }
 public void Mohakhali(){
  position = "Mohakhali";
  mainTextArea.setText("You are at a crossroad.If you go south, you will go back to Mohajon's area. A passenger comes up and says 'Aay CNG! Jaba Gulshan? (Distance - 5km)'");
  choice1.setText("Go to Gulshan");
  choice2.setText("Say Jamu na. And travel to Badda");
  choice3.setText("Go back to Mohajon's area");
  choice4.setText("Say Jamu na. And travel to Mohammadpur");
 }
 public void north(){
  position = "Gulshan";
  mainTextArea.setText("There was some traffic. But the passenger was generous. \n\n(He gives you 300TK!)");
  playerMONEY = playerMONEY + 300;
  moneyLabelNumber.setText(""+playerMONEY);
  choice1.setText("Go back to Mohakhali");
  choice2.setText("");
  choice3.setText("");
  choice4.setText("");  
 }
 public void east(){
  position = "east";
  mainTextArea.setText("You walked into a forest and found a Long Sword!\n\n(You obtained a Long Sword)");
  time = "Long Sword";
  timeLabelName.setText(time);
  choice1.setText("Go west");
  choice2.setText("");
  choice3.setText("");
  choice4.setText("");
  
 }
 public void west(){
  position = "west";
  mainTextArea.setText("You encounter a goblin!");
  choice1.setText("Fight");
  choice2.setText("Run");
  choice3.setText("");
  choice4.setText("");
 }
 public void fight(){
  position = "fight";
  mainTextArea.setText("Monter MONEY: " + monsterMONEY + "\n\nWhat do you do?");
  choice1.setText("Attack");
  choice2.setText("Run");
  choice3.setText("");
  choice4.setText("");
 }
 public void playerAttack(){
  position = "playerAttack";
  
  int playerDamage = 0;
  
  if(time.equals("Knife")){
   playerDamage = new java.util.Random().nextInt(3);
  }
  else if(time.equals("Long Sword")){
   playerDamage = new java.util.Random().nextInt(12); 
  }
  
  mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
  
  monsterMONEY = monsterMONEY - playerDamage;
  
  choice1.setText(">");
  choice2.setText("");
  choice3.setText("");
  choice4.setText("");  
 }
 public void monsterAttack(){
  position = "monsterAttack";
  
  int monsterDamage = 0;
  
  monsterDamage = new java.util.Random().nextInt(6); 
  
  mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");
  
  playerMONEY = playerMONEY - monsterDamage;
  moneyLabelNumber.setText(""+playerMONEY);
  
  choice1.setText(">");
  choice2.setText("");
  choice3.setText("");
  choice4.setText(""); 
 }
 public void win(){
  position = "win";
  
  mainTextArea.setText("You defeated the monster!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)");
  
  silverRing = 1;
  
  choice1.setText("Go east");
  choice2.setText("");
  choice3.setText("");
  choice4.setText("");
  
 }
 public void lose(){
  position = "lose";
  
  mainTextArea.setText("You are dead!\n\n");
  
  choice1.setText("");
  choice2.setText("");
  choice3.setText("");
  choice4.setText("");
  choice1.setVisible(false);
  choice2.setVisible(false);
  choice3.setVisible(false);
  choice4.setVisible(false);
 }
 public void ending(){
  position = "ending";
  
  mainTextArea.setText("Guard: Oh you killed that goblin!?\nThank you so much. You are true hero!\nWelcome to our town!\n\n");
  
  choice1.setText("");
  choice2.setText("");
  choice3.setText("");
  choice4.setText("");
  choice1.setVisible(false);
  choice2.setVisible(false);
  choice3.setVisible(false);
  choice4.setVisible(false);
 }



 
 
 
  
 
 
 
 public class TitleScreenHandler implements ActionListener{
  
  public void actionPerformed(ActionEvent event){
   
   createGameScreen();
  }
 }
 public class ChoiceHandler implements ActionListener{
  
  public void actionPerformed(ActionEvent event){
   
   String yourChoice = event.getActionCommand();
   
   switch(position){
   case "Dhanmondi":
    switch(yourChoice){
    case "c1": 
     if(silverRing==1){
      ending();
     }
     else{
      talkMohajon();
     }
     break;
    case "c2": escapeMohajon();break;
    case "c3": Mohakhali();break;
    }
    break;
   case "talkMohajon":
    switch(yourChoice){
    case "c1": Dhanmondi(); break;
    }
    break;
   case "escapeMohajon":
    switch(yourChoice){
    case "c1": Dhanmondi(); break;
    }
    break;
   case "Mohakhali":
    switch(yourChoice){
    case "c1": north(); break;
    case "c2": east();break;
    case "c3": Dhanmondi(); break;
    case "c4": west();break;
    }
    break;
   case "north":
    switch(yourChoice){
    case "c1": Mohakhali(); break;
    }
    break;
   case "east":
    switch(yourChoice){
    case "c1": Mohakhali(); break;
    }
    break;
   case "west":
    switch(yourChoice){
    case "c1": fight(); break;
    case "c2": Mohakhali(); break;
    }
    break;
   case "fight":
    switch(yourChoice){
    case "c1": playerAttack();break;
    case "c2": Mohakhali(); break;
    }
    break;
   case "playerAttack":
    switch(yourChoice){
    case "c1": 
     if(monsterMONEY<1){
      win();
     }
     else{
      monsterAttack();
     }
     break;
    }
    break;
   case "monsterAttack":
    switch(yourChoice){
    case "c1": 
     if(playerMONEY<1){
      lose();
     }
     else{
      fight();
     }
     break;
    }
    break;
   case "win":
    switch(yourChoice){
    case "c1": Mohakhali();
    }
    break;
    
   }
   
   
  }
 }



}
