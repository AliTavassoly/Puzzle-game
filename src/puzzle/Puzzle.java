package puzzle;

import puzzle.gui.GameFrame;
import puzzle.gui.GamePanel;
import puzzle.logic.Location;
import puzzle.logic.PuzzleBoard;
import puzzle.logic.PuzzlePiece;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Puzzle {
    public static int n = 3;
    public static int squareLength = 150;

    private GamePanel gamePanel;
    private GameFrame gameFrame;

    boolean gameFinished = false;

    public Puzzle() {
        gamePanel = GamePanel.getInstance();
        gameFrame = GameFrame.getInstance();

        makeInitPuzzle();
        runGame();
    }

    private void makeInitPuzzle() {
        ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();
        ArrayList<Integer> piecesRandomOrder = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 8, 7));

        for (int i = 0; i < 9; i++) {
            puzzlePieces.add(new PuzzlePiece(new Location(
                    gamePanel.getHeight() / 3 * (i % 3),
                    gamePanel.getWidth() / 3 * (i / 3)),
                    piecesRandomOrder.get(i)));
        }
        PuzzleBoard.makeInstance(puzzlePieces);

        if (!solvable(PuzzleBoard.getInstance().getMissingPiece(), piecesRandomOrder)) {
            JOptionPane.showMessageDialog(gameFrame, "this puzzle is not solvable, change your config and try again", "Puzzle not solvable", JOptionPane.WARNING_MESSAGE);
            gameFinished = true;
        }
    }

    private void runGame() {
        while (true) {
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Mapper.getInstance().updateGui();

            if (PuzzleBoard.getInstance().isFinished()) {
                JOptionPane.showMessageDialog(gameFrame, "You finished the game, congratulation", "game finished", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }

    private static boolean solvable(int missingPiece, ArrayList<Integer> piecesOrder) {
        int inversionCount = 0;
        for (int i = 0; i < piecesOrder.size(); i++) {
            for (int j = i + 1; j < piecesOrder.size(); j++) {
                if (piecesOrder.get(i) > piecesOrder.get(j)) {
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
}
