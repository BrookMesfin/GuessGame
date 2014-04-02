package guessgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuessGameFrame extends JFrame {
        
    private Random generator = new Random();
    private int number;
    private int guessCount;
    private int lastDistance;
    private JTextField userInputJTextField;
    private JLabel prompt1JLabel;
    private JLabel prompt2JLabel;
    private JLabel messageJLabel;
    private JButton newGameJButton;
    private Color background;
  
    public GuessGameFrame(){
        super("Guessing Game");
        
        prompt1JLabel = new JLabel();
        prompt2JLabel = new JLabel();
        userInputJTextField = new JTextField();
        
        prompt1JLabel.setText("I have a number between 1 and 1000.");
        prompt2JLabel.setText("Can you guess my number? Enter your "+guessCount+" Guess:");
//        prompt1JLabel.setHorizontalTextPosition(SwingConstants.CENTER);
//        prompt1JLabel.setVerticalTextPosition(SwingConstants.NORTH);
        add(prompt1JLabel);
        add(prompt2JLabel);
    }
    
}
