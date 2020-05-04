package Puzzle.gui;

import Puzzle.Puzzle;
import Puzzle.logic.PuzzlePiece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();
    private int missingPiece = 0;

    private GamePanel() {
        configPanel();
    }

    private void configPanel(){
        setSize(Puzzle.n * Puzzle.squareLength, Puzzle.n * Puzzle.squareLength + 20);

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int maxSize = Math.max(screenWidth, screenHeight) / 3;
        setLocation(screenWidth / 2 - maxSize / 2, screenHeight / 2 - maxSize / 2);
    }

    private String gameState = "#";

    private static GamePanel panelInstance;

    public static GamePanel getInstance() {
        if (panelInstance == null) {
            panelInstance = new GamePanel();
            return panelInstance;
        }
        return panelInstance;
    }

    public void setPuzzlePieces(ArrayList<PuzzlePiece> puzzlePieces) {
        this.puzzlePieces = puzzlePieces;
    }

    public void setMissingPiece(int missingPiece) {
        this.missingPiece = missingPiece;
    }

    public int getMissingPiece() {
        return missingPiece;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public void swapPieces(int i, int j) {
        PuzzlePiece copy = this.puzzlePieces.get(i).getClone();
        puzzlePieces.get(i).setImage(puzzlePieces.get(j).getImage());
        puzzlePieces.get(i).setPieceNumber(puzzlePieces.get(j).getPieceNumber());
        puzzlePieces.get(j).setImage(copy.getImage());
        puzzlePieces.get(j).setPieceNumber(copy.getPieceNumber());


        if (gameFinished()) {
            gameState = "finished";
        }
    }

    private boolean gameFinished() {
        for (int i = 0; i < 9; i++) {
            int pieceIdentifier = puzzlePieces.get(i).getPieceNumber();
            if (pieceIdentifier == 8) {
                continue;
            }

            if (pieceIdentifier != i) {
                return false;
            }
        }
        return true;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PuzzlePiece piece : puzzlePieces) {
            g.drawImage(piece.getImage(), piece.location.getX(), piece.location.getY(), (int) this.getSize().getWidth() / 3, (int) this.getSize().getHeight() / 3, null);
        }
    }
}
