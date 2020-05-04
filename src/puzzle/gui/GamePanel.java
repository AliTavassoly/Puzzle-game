package puzzle.gui;

import puzzle.Mapper;
import puzzle.Game;
import puzzle.logic.PuzzlePiece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
    private static GamePanel panelInstance;

    private GamePanel() {
        configPanel();
    }

    private void configPanel() {
        setSize(Game.n * Game.squareLength, Game.n * Game.squareLength);

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int maxSize = Math.max(screenWidth, screenHeight) / 3;
        setLocation(screenWidth / 2 - maxSize / 2, screenHeight / 2 - maxSize / 2);
    }

    public static GamePanel getInstance() {
        if (panelInstance == null) {
            return panelInstance = new GamePanel();
        } else {
            return panelInstance;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PuzzlePiece piece : Mapper.getInstance().getPuzzlePieces()) {
            Image image = null;
            try {
                if (piece.getPieceNumber() != 8) {
                    image = ImageIO.read(new File("src/assets/" + (piece.getPieceNumber() + 1) + ".jpg"));
                }
                else {
                    image = ImageIO.read(new File("src/assets/missing.jpg"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(image, getHeight() / 3 * piece.getLocation().getX(), getWidth() / 3 * piece.getLocation().getY(), (int) this.getSize().getWidth() / 3, (int) this.getSize().getHeight() / 3, null);
        }
    }
}
