package puzzle.logic;

import puzzle.util.Mapper;

public class Game {
    public static int n = 3;
    public static int squareLength = 100;

    public Game() {
        Mapper.getInstance().makeGui();

        PuzzleBoard.getNewInstance();

        runGame();
    }

    private void gameNotSolveAble(){
        int reply = Mapper.getInstance().endGameDialog(
                "this puzzle is not solvable, do you want to play new one?",
                "Puzzle not solvable");
        if(reply == 0){
            Game game = new Game();
        } else {
            System.exit(0);
        }
    }

    private void gameFinished(){
        int reply = Mapper.getInstance().notSolveAbleDialog(
                "You finished the game, congratulation. do you want to play new game?",
                "game finished");
        if(reply == 0){
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