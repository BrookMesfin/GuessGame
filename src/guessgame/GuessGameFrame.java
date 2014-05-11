package guessgame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GuessGameFrame extends JFrame {
        
    private Random generator;
    private int randomGenerator;
    private int guessCount = 1;
    private int userInput;
    private int currentDistance;
    private int lastDistance;
    private List<Integer> guessedNumbers = new ArrayList<>();
    private JTextField userInputJTextField;
    private JLabel prompt1JLabel;
    private JLabel prompt2JLabel;
    private JLabel messageJLabel;
    private JButton newGameJButton;
    private String attempt =  null;
    public  String turnToString = null;
  
    public GuessGameFrame(){
        super("Guessing Game");
        setLayout(new FlowLayout());
        
       generator = new Random(); 
       randomGenerator = 1 + generator.nextInt(1000);
        
       prompt1JLabel = new JLabel();
       prompt2JLabel = new JLabel();
       messageJLabel = new JLabel();   
       userInputJTextField = new JTextField(5);
       userInputJTextField.setEditable(true);
       newGameJButton = new JButton();
       getContentPane().setBackground(Color.MAGENTA);
             
       prompt1JLabel.setText("I have a number between 1 and 1000.");
       messageJLabel.setText("Guess result appears here.");
       newGameJButton.setText( "New Game" );
         
        if (guessCount <= 1)
        {
            attempt = "first";
            prompt2JLabel.setText("Can you guess my number? Enter your "+attempt+" Guess:"); 
        }
 
        GuessGameFrameHandler handler = new GuessGameFrameHandler();
        userInputJTextField.addActionListener(handler);
        NewGuessGameFrameHandler newGameHandle = new NewGuessGameFrameHandler();
        newGameJButton.addActionListener(newGameHandle);
        
        add(prompt1JLabel);
        add(prompt2JLabel);
        add(userInputJTextField);
        add(messageJLabel);
        add(newGameJButton);
 
 
    }
    public void numberChecker (int userInput){
        guessCount++;
		guessedNumbers.add(userInput);
		
        if (guessCount <= 1)
        {
            attempt = "first";
            prompt2JLabel.setText("Can you guess my number? Enter your "+attempt+" Guess:"); 
        }
        else 
        	if (guessCount == 2)
        {
            prompt1JLabel.setText("Guessed Number(s): "+guessedNumbers.toString().replace("[", "").replace("]", ""));  
            attempt = "nd";
            prompt2JLabel.setText("Can you guess my number? Enter your "+guessCount+attempt+" Guess:");
        }
        else 
        		if(guessCount == 3)
        {
            prompt1JLabel.setText("Guessed Number(s): "+guessedNumbers.toString().replace("[", "").replace("]", ""));  
            attempt = "rd";
            prompt2JLabel.setText("Can you guess my number? Enter your "+guessCount+attempt+" Guess:");
        }
        else 
        			if (guessCount >= 4)
        {
            prompt1JLabel.setText("Guessed Number(s): "+guessedNumbers.toString().replace("[", "").replace("]", ""));  
            attempt = "th";
            prompt2JLabel.setText("Can you guess my number? Enter your "+guessCount+attempt+" Guess:");
        }

        currentDistance = userInput - randomGenerator;
        if(currentDistance < 0)
        	currentDistance = -currentDistance;
        
        if (userInput == randomGenerator){
            prompt1JLabel.setText("After "+guessedNumbers.size()+" attempts, you got the number "+randomGenerator+" correct.");
            prompt2JLabel.setText("You are great! Try again? Click \"New Game\" button");
            messageJLabel.setText("Correct!");
            userInputJTextField.setEditable(false);
        }
        else 
        	if (userInput > randomGenerator){	
        		messageJLabel.setText("Too High, Try a lower number.");
        }
        else 
        		if (userInput < randomGenerator){	
        			messageJLabel.setText("Too Low, Try a higher number.");
        }
        
        if (userInput == randomGenerator){
        	getContentPane().setBackground(Color.GREEN);
        }
        else
        	if (currentDistance > lastDistance || lastDistance == 0)
        	{
			getContentPane().setBackground(Color.ORANGE);
        	} 
        else 
        	{
			getContentPane().setBackground(Color.RED);
        	}
       lastDistance = currentDistance;
    }
    
    private class GuessGameFrameHandler implements ActionListener {
        
        public void actionPerformed (ActionEvent event)
        {
            turnToString = userInputJTextField.getText();
            userInput = Integer.parseInt(turnToString);
            userInputJTextField.setText("");
            numberChecker(userInput);          	
        }
    }
    
 private class NewGuessGameFrameHandler implements ActionListener {
        
        public void actionPerformed (ActionEvent event)
        {
            generator = new Random(); 
            randomGenerator = 1 + generator.nextInt(1000);
            getContentPane().setBackground(Color.YELLOW);
            guessCount = 1;
            currentDistance = 0;
            lastDistance = 0;
            guessedNumbers = new ArrayList<>();
            prompt1JLabel.setText("I have a number between 1 and 1000.");
            messageJLabel.setText("Guess result appears here.");
            attempt = "first";
            prompt2JLabel.setText("Can you guess my number? Enter your "+attempt+" Guess:");
            userInputJTextField.setEditable(true);
        }
    }
}
