package guessgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuessGameFrame extends JFrame {
        
    private Random generator;
    private int randomGenerator;
    private int number;
    private int guessCount = 0;
    private JLabel message;
    private int lastDistance;
    public JTextField userInputJTextField;
    private JLabel prompt1JLabel;
    private JLabel prompt2JLabel;
    private JLabel messageJLabel;
    private JButton newGameJButton;
    private Color background;
    private String attempt =  null;
    public  String turnToString = null;
    public int userInput;
  
    public GuessGameFrame(){
        super("Guessing Game");
        setLayout(new FlowLayout());
        
       generator = new Random(); 
       randomGenerator = 1 + generator.nextInt(1000);
        
       prompt1JLabel = new JLabel();
       prompt2JLabel = new JLabel();
       message = new JLabel();
       messageJLabel = new JLabel();   
       userInputJTextField = new JTextField(5);
       userInputJTextField.setText("");
       //userInputJTextField.setEditable(true);
       newGameJButton = new JButton();
       getContentPane().setBackground(Color.MAGENTA);
   
       message.setText("Guessed Number(s): ");            
       prompt1JLabel.setText("I have a number between 1 and 1000.");
       messageJLabel.setText("Guess result appears here.");
       newGameJButton.setText( "New Game" );
               
       prompt1JLabel.setText("I have a number between 1 and 1000.");
        
        if (guessCount <= 1)
        {
            attempt = "first";
            prompt2JLabel.setText("Can you guess my number? Enter your "+attempt+" Guess:"); 
        }
        
        add(prompt1JLabel);
        add(prompt2JLabel);
        add(userInputJTextField);
        add(messageJLabel);
        add(newGameJButton);
 
        GuessGameFrameHandler handler = new GuessGameFrameHandler();
        userInputJTextField.addActionListener(handler);
    }
    public void numberChecker (int userInput){
        guessCount++;
        
        if (guessCount <= 1)
        {
            attempt = "first";
            prompt2JLabel.setText("Can you guess my number? Enter your "+attempt+" Guess:"); 
        }
        else if (guessCount == 2)
        {
            attempt = "nd";
            prompt2JLabel.setText("Can you guess my number? Enter your "+guessCount+attempt+" Guess:");
        }
        else if(guessCount == 3)
        {
            attempt = "rd";
            prompt2JLabel.setText("Can you guess my number? Enter your "+guessCount+attempt+" Guess:");
        }
        else if (guessCount >= 4)
        {
            attempt = "th";
            prompt2JLabel.setText("Can you guess my number? Enter your "+guessCount+attempt+" Guess:");
        }
        
        if (userInput < randomGenerator){
            getContentPane().setBackground(Color.ORANGE);
        }
        else if (userInput > randomGenerator){
            getContentPane().setBackground(Color.RED);
        }
        else if (userInput == randomGenerator){
            getContentPane().setBackground(Color.GREEN);
        }
            
        
    }
    
    private class GuessGameFrameHandler implements ActionListener {
        
        public void actionPerformed (ActionEvent event)
        {
            turnToString = userInputJTextField.getText();
            userInput = Integer.parseInt(turnToString);               
            numberChecker(userInput);
       
        }
    }
}
