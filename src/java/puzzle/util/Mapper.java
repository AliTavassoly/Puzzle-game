package puzzle.util;

import puzzle.gui.GameFrame;
import puzzle.gui.GamePanel;
import puzzle.logic.Puzzle;

import javax.swing.*;

public class Mapper {
    private static Mapper mapper;
    private GameFrame gameFrame;
    private GamePanel gamePanel;

    private Mapper(){

    }

    public static Mapper getInstance(){
        if(mapper == null){
            return mapper = new Mapper();
        } else {
            return mapper;
        }
    }

    public Puzzle getPuzzle(){
        return Puzzle.getInstance();
    }

    public void makeGui(){
        gameFrame = GameFrame.getInstance();
        gamePanel = GamePanel.getInstance();
    }

    public void updateGui(){
        GamePanel.getInstance().repaint();
        GameFrame.getInstance().repaint();
    }

    public int endGameDialog(String message, String title){
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
    }

    public int notSolvableDialog(String message, String title){
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
    }
}
