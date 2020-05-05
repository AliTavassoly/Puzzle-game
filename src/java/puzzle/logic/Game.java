package puzzle.logic;

import puzzle.util.ConfigLoader;
import puzzle.util.Mapper;

import java.util.Map;

public class Game {
    public static int n;
    public static int squareLength;
    public static Map<Integer, String> imagesPath;
    public static Map<String , Object> gameSizes;

    public Game() {
        loadConfigs();

        Mapper.getInstance().makeGui();

        Puzzle.getNewInstance();

        runGame();
    }

    private static void loadConfigs(){
        imagesPath = ConfigLoader.getInstance().getImagesPath();
        gameSizes = ConfigLoader.getInstance().getGameSizes();

        n = ((Double)gameSizes.get("n")).intValue();
        squareLength = ((Double)gameSizes.get("squareLength")).intValue();
    }

    private void gameNotSolvable(){
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
        int reply = Mapper.getInstance().notSolvableDialog(
                "You finished the game, congratulation. do you want to play new game?",
                "game finished");
        if(reply == 0){
            Game game = new Game();
        } else {
            System.exit(0);
        }
    }

    private void runGame() {
        if (!Puzzle.getInstance().solvable()) {
            gameNotSolvable();
        }

        while (true) {
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Mapper.getInstance().updateGui();

            if (Puzzle.getInstance().isFinished()) {
                gameFinished();
            }
        }
    }
}