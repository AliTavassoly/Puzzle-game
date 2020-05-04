package puzzle.gui;

import puzzle.gui.util.MyKeyListener;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private static GameFrame frameInstance;

    private GameFrame(){
        configFrame();
    }

    public static GameFrame getInstance(){
        if(frameInstance == null){
            return frameInstance = new GameFrame();
        } else{
            return frameInstance;
        }
    }

    private void configFrame(){
        setSize(GamePanel.getInstance().getSize());
        setLocation(GamePanel.getInstance().getLocation());
        add(GamePanel.getInstance());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setUndecorated(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        addKeyListener(new MyKeyListener());
        setVisible(true);
    }
}
