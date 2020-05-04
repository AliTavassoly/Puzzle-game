package puzzle.gui;

import puzzle.util.Mapper;
import puzzle.logic.Game;
import puzzle.logic.PuzzlePiece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel {
    private static GamePanel panelInstance;

    private GamePanel() {
        configPanel();
    }

    private void configPanel() {
        setSize(Game.n * Game.squareLength, Game.n * Game.squareLength);
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

        Graphics2D g2 = (Graphics2D) g;
        for (PuzzlePiece piece : Mapper.getInstance().getPuzzlePieces()) {
            BufferedImage image = null;
            try {
                if (piece.getPieceNumber() != Game.n * Game.n - 1) {
                    image = ImageIO.read(this.getClass().getResourceAsStream(
                      "/images/" + (piece.getPieceNumber() + 1) + ".jpg"));
                }
                else {
                    image = ImageIO.read(this.getClass().getResourceAsStream(
                            "/images/missing.jpg"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
            g2.drawImage(image, getHeight() / Game.n * piece.getLocation().getX(), getWidth() / Game.n * piece.getLocation().getY(), (int) this.getSize().getWidth() / 3, (int) this.getSize().getHeight() / 3, null);
        }
    }
}
