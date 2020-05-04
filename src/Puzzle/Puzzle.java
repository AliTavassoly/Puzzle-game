package Puzzle;

import Puzzle.gui.GameFrame;
import Puzzle.gui.GamePanel;
import Puzzle.logic.Location;
import Puzzle.logic.PuzzlePiece;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Puzzle {
    public static int n = 3;
    public static int squareLength = 150;

    private GamePanel gamePanel;
    private GameFrame gameFrame;

    boolean gameFinished = false;

    public Puzzle(){
        gamePanel = GamePanel.getInstance();
        gameFrame = new GameFrame(gamePanel);

        makeInitPuzzle();
        runGame();
    }

    private void runGame(){
        while (true) {
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gamePanel.repaint();
            gameFrame.repaint();

            if (gameFinished) {
                break;
            }
            if (gamePanel.getGameState().equals("finished")) {
                JOptionPane.showMessageDialog(gameFrame, "You finished the game, congratulation", "game finished", JOptionPane.INFORMATION_MESSAGE);
                gameFinished = true;
            }
        }
    }

    private void makeInitPuzzle(){
        ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();

        ArrayList<Integer> piecesRandomOrder = new ArrayList<>(Arrays.asList(0, 5, 6, 7, 4, 3, 2, 8, 1));
        gamePanel.setMissingPiece(7);

        if (!solvable(gamePanel.getMissingPiece(), piecesRandomOrder)) {
            JOptionPane.showMessageDialog(gameFrame, "this puzzle is not solvable, change your config and try again", "Puzzle not solvable", JOptionPane.WARNING_MESSAGE);
            gameFinished = true;
        }

        for (int i = 0; i < 9; i++) {
            if (gamePanel.getMissingPiece() != i) {
                puzzlePieces.add(new PuzzlePiece(piecesRandomOrder.get(i) + 1 + ".jpg", new Location(gamePanel.getHeight() / 3 * (i % 3), gamePanel.getWidth() / 3 * (i / 3))));
            } else {
                puzzlePieces.add(new PuzzlePiece("missing.jpg", new Location(gamePanel.getHeight() / 3 * (i % 3), gamePanel.getWidth() / 3 * (i / 3))));
            }
        }
        gamePanel.setPuzzlePieces(puzzlePieces);
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
