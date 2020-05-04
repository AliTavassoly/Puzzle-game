package puzzle.util;

import puzzle.gui.GameFrame;
import puzzle.gui.GamePanel;
import puzzle.logic.PuzzleBoard;
import puzzle.logic.PuzzlePiece;

import javax.swing.*;
import java.util.ArrayList;

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

    public ArrayList<PuzzlePiece> getPuzzlePieces(){
        return PuzzleBoard.getInstance().getPuzzlePieces();
    }

    public void makeGui(){
        gameFrame = GameFrame.getInstance();
        gamePanel = GamePanel.getInstance();
    }

    public void updateGui(){
        GamePanel.getInstance().repaint();
        GameFrame.getInstance().repaint();
    }

    public void showDialog(String message, String title, int jOptionPane){
        JOptionPane.showMessageDialog(gameFrame,
                message, title,
                jOptionPane);
    }
}
