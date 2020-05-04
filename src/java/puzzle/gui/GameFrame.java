package puzzle.gui;

import javax.swing.*;

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
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        addKeyListener(new MyKeyListener());
        setVisible(true);
    }
}
