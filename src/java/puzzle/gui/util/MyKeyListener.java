package puzzle.gui.util;

import puzzle.logic.Game;
import puzzle.logic.Puzzle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int missingPieceIndex = Puzzle.getInstance().getMissingPiece();
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (missingPieceIndex % Game.n == Game.n - 1) {
                return;
            }
            Puzzle.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + 1);
            Puzzle.getInstance().setMissingPiece(missingPieceIndex + 1);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            if (missingPieceIndex % Game.n == 0) {
                return;
            }
            Puzzle.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - 1);
            Puzzle.getInstance().setMissingPiece(missingPieceIndex - 1);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            if (missingPieceIndex / Game.n == 0) {
                return;
            }
            Puzzle.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - Game.n);
            Puzzle.getInstance().setMissingPiece(missingPieceIndex - Game.n);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            if (missingPieceIndex / Game.n == Game.n - 1) {
                return;
            }
            Puzzle.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + Game.n);
            Puzzle.getInstance().setMissingPiece(missingPieceIndex + Game.n);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
