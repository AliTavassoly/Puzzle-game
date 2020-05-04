package puzzle.logic;

import java.util.ArrayList;

public class PuzzleBoard {
    private static PuzzleBoard puzzleBoardInstance;

    private int missingPiece = 0;
    private boolean isFinished;
    private ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();

    private PuzzleBoard(){

    }

    public static PuzzleBoard getInstance(){
        if(puzzleBoardInstance == null){
            return puzzleBoardInstance = new PuzzleBoard();
        } else {
            return puzzleBoardInstance;
        }
    }

    // Start of getter setter
    public void setPuzzlePieces(ArrayList<PuzzlePiece> puzzlePieces) {
        this.puzzlePieces = puzzlePieces;
    }
    public ArrayList<PuzzlePiece> getPuzzlePieces() {
        return puzzlePieces;
    }

    public void setMissingPiece(int missingPiece) {
        this.missingPiece = missingPiece;
    }
    public int getMissingPiece() {
        return missingPiece;
    }

    public boolean isFinished() {
        return isFinished;
    }
    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    // End of getter setter
    public void swapPieces(int i, int j) {
        PuzzlePiece copy = puzzlePieces.get(i).getClone();
        puzzlePieces.get(i).setPieceNumber(puzzlePieces.get(j).getPieceNumber());
        puzzlePieces.get(j).setPieceNumber(copy.getPieceNumber());

        if (gameFinished()) {
            isFinished = true;
        }
    }

    private boolean gameFinished() {
        for (int i = 0; i < 8; i++) {
            if (puzzlePieces.get(i).getPieceNumber() != i) {
                return false;
            }
        }
        return true;
    }
}
