package puzzle.logic;

import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleBoard {
    private static PuzzleBoard puzzleBoardInstance;

    private ArrayList<PuzzlePiece> puzzlePieces;
    private ArrayList<Integer> initOrder;
    private int missingPiece = 0;

    private PuzzleBoard() {
        puzzlePieces = new ArrayList<>();
        initOrder = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 8, 7));

        for (int i = 0; i < 9; i++) {
            puzzlePieces.add(new PuzzlePiece(new Location(
                    (i % 3),
                    (i / 3)),
                    initOrder.get(i)));
        }

        for(int i = 0; i < puzzlePieces.size(); i++){
            if(puzzlePieces.get(i).getPieceNumber() == 8){
                missingPiece = i;
                break;
            }
        }
    }

    public static PuzzleBoard getInstance() {
        return puzzleBoardInstance;
    }

    public static void makeNewInstance() {
        puzzleBoardInstance = new PuzzleBoard();
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

    // End of getter setter
    public void swapPieces(int i, int j) {
        PuzzlePiece copy = puzzlePieces.get(i).getClone();
        puzzlePieces.get(i).setPieceNumber(puzzlePieces.get(j).getPieceNumber());
        puzzlePieces.get(j).setPieceNumber(copy.getPieceNumber());
    }

    public boolean solvable() {
        int inversionCount = 0;
        for (int i = 0; i < initOrder.size(); i++) {
            for (int j = i + 1; j < initOrder.size(); j++) {
                if (initOrder.get(i) > initOrder.get(j)) {
                    inversionCount += 1;
                }
            }
        }

        int parity = inversionCount % 2;

        int distanceOfMissingPiece = (2 - (missingPiece % 3)) + (2 - (missingPiece / 3));

        parity ^= (distanceOfMissingPiece % 2);
        if (parity == 0) {
            return true;
        }
        return false;
    }

    public boolean isFinished() {
        for (int i = 0; i < 8; i++) {
            if (puzzlePieces.get(i).getPieceNumber() != i) {
                return false;
            }
        }
        return true;
    }
}
