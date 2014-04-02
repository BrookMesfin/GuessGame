package guessgame;

import javax.swing.JFrame;

public class GuessGame  {

       
    public static void main(String[] args) {
        GuessGameFrame guessGameFrame = new GuessGameFrame();
        guessGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessGameFrame.setSize(400, 200);
        guessGameFrame.setVisible(true);
    }
    
}
