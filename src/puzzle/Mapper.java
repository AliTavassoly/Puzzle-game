package puzzle;

import puzzle.gui.GameFrame;
import puzzle.gui.GamePanel;
import puzzle.logic.PuzzleBoard;
import puzzle.logic.PuzzlePiece;

import java.util.ArrayList;

public class Mapper {
    private static Mapper mapper;

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

    public void updateGui(){
        GamePanel.getInstance().repaint();
        GameFrame.getInstance().repaint();
    }
}
