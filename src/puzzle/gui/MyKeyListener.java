package puzzle.gui;

import puzzle.logic.PuzzleBoard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        int missingPieceIndex = PuzzleBoard.getInstance().getMissingPiece();
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {

            if (missingPieceIndex % 3 == 2) {
                return;
            }
            PuzzleBoard.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + 1);
            PuzzleBoard.getInstance().setMissingPiece(missingPieceIndex + 1);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            if (missingPieceIndex % 3 == 0) {
                return;
            }
            PuzzleBoard.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - 1);
            PuzzleBoard.getInstance().setMissingPiece(missingPieceIndex - 1);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            if (missingPieceIndex <= 2) {
                return;
            }
            PuzzleBoard.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - 3);
            PuzzleBoard.getInstance().setMissingPiece(missingPieceIndex - 3);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            if (missingPieceIndex >= 6) {
                return;
            }
            PuzzleBoard.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + 3);
            PuzzleBoard.getInstance().setMissingPiece(missingPieceIndex + 3);
        }

        if (PuzzleBoard.getInstance().isFinished()) {
            return;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
