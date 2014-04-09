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
        
    private Random generator = new Random();
    private int randomGenerator;
    private int number;
    private int guessCount = 36;
    private String message;
    private int lastDistance;
    private JTextField userInputJTextField;
    private JLabel prompt1JLabel;
    private JLabel prompt2JLabel;
    private JLabel messageJLabel;
    private JButton newGameJButton;
    private Color background;
  
    public GuessGameFrame(){
        super("Guessing Game");
        setLayout(new FlowLayout());
        
        if (guessCount == 1)
        {
            message = "first";
        }
        else if (guessCount == 2)
        {
            message = "nd";
        }
        else if(guessCount == 3)
        {
            message = "rd";
        }
        else if (guessCount > 3)
        {
            message = "th";
        }
        
       randomGenerator = 1 + generator.nextInt(1000);
        
        prompt1JLabel = new JLabel();
        prompt2JLabel = new JLabel();
        userInputJTextField = new JTextField(5);
   
        if (guessCount <= 1 )
        {
            prompt2JLabel.setText("Can you guess my number? Enter your "+message+" Guess:"); 
        } 
        else 
        {
            prompt2JLabel.setText("Can you guess my number? Enter your "+guessCount+message+" Guess:");
        }
                    
        prompt1JLabel.setText("I have a number between 1 and 1000.");
       
//        prompt1JLabel.setHorizontalTextPosition(SwingConstants.CENTER);
//        prompt1JLabel.setVerticalTextPosition(SwingConstants.NORTH);
        
        add(prompt1JLabel);
        add(prompt2JLabel);
        add(userInputJTextField);
    }
    
    private class GuessGameFrameHandler implements ActionListener {
        
        public void actionPerformed (ActionEvent event)
        {
            if (randomGenerator == userInputJTextField){
                
            }
        }
 
}
