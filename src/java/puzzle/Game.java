package puzzle;

import puzzle.logic.PuzzleBoard;
import puzzle.util.Mapper;

import javax.swing.*;

public class Game {
    public static int n = 3;
    public static int squareLength = 150;

    public Game() {
        Mapper.getInstance().makeGui();

        PuzzleBoard.makeNewInstance();

        runGame();
    }

    private void runGame() {
        if (!PuzzleBoard.getInstance().solvable()) {
            Mapper.getInstance().showDialog(
                    "this puzzle is not solvable, change your config and try again",
                    "Puzzle not solvable", JOptionPane.WARNING_MESSAGE);
        }

        while (true) {
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Mapper.getInstance().updateGui();

            if (PuzzleBoard.getInstance().isFinished()) {
                Mapper.getInstance().showDialog(
                        "You finished the game, congratulation",
                        "game finished", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }
}
