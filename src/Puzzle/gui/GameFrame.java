package Puzzle.gui;

import javax.swing.*;

public class GameFrame extends JFrame {
    private JPanel panel;

    public GameFrame(JPanel panel){
        this.panel = panel;

        configFrame();
    }

    private void configFrame(){
        setSize(panel.getSize());
        setLocation(panel.getLocation());
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addKeyListener(new MyKeyListener());
        setVisible(true);
    }
}
