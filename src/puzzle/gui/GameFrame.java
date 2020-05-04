package puzzle.gui;

import javax.swing.*;

public class GameFrame extends JFrame {
    private final JPanel panel;
    private static GameFrame frameInstance;

    private GameFrame(){
        panel = GamePanel.getInstance();
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
        setSize(panel.getSize());
        setLocation(panel.getLocation());
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        addKeyListener(new MyKeyListener());
        setVisible(true);
    }
}
