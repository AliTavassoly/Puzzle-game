package puzzle.logic;

import puzzle.util.Mapper;

import javax.swing.*;

public class Game {
    public static int n = 4;
    public static int squareLength = 200;

    public Game() {
        Mapper.getInstance().makeGui();

        PuzzleBoard.getNewInstance();

        runGame();
    }

    private void gameNotSolveAble(){
        int reply = Mapper.getInstance().endGameDialog(
                "this puzzle is not solvable, do you want to play new one?",
                "Puzzle not solvable");
        if(reply == JOptionPane.YES_OPTION){
            Game game = new Game();
        } else {
            System.exit(0);
        }
    }

    private void gameFinished(){
        int reply = Mapper.getInstance().notSolveAbleDialog(
                "You finished the game, congratulation. do you want to play new game?",
                "game finished");
        if(reply == JOptionPane.YES_OPTION){
            Game game = new Game();
        } else {
            System.exit(0);
        }
    }

    private void runGame() {
        if (!PuzzleBoard.getInstance().solvable()) {
            gameNotSolveAble();
        }

        while (true) {
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Mapper.getInstance().updateGui();

            if (PuzzleBoard.getInstance().isFinished()) {
                gameFinished();
            }
        }
    }
}
