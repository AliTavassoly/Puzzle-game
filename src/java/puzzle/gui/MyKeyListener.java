package puzzle.gui;

import puzzle.logic.Game;
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
            if (missingPieceIndex % Game.n == Game.n - 1) {
                return;
            }
            PuzzleBoard.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + 1);
            PuzzleBoard.getInstance().setMissingPiece(missingPieceIndex + 1);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            if (missingPieceIndex % Game.n == 0) {
                return;
            }
            PuzzleBoard.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - 1);
            PuzzleBoard.getInstance().setMissingPiece(missingPieceIndex - 1);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            if (missingPieceIndex / Game.n == 0) {
                return;
            }
            PuzzleBoard.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - Game.n);
            PuzzleBoard.getInstance().setMissingPiece(missingPieceIndex - Game.n);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            if (missingPieceIndex / Game.n == Game.n - 1) {
                return;
            }
            PuzzleBoard.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + Game.n);
            PuzzleBoard.getInstance().setMissingPiece(missingPieceIndex + Game.n);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
