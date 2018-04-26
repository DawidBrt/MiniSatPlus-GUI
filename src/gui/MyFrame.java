package gui;

import javax.swing.JFrame;

public class MyFrame extends JFrame{

    public MyFrame(MenuPanel menuPanel){
        super("MiniSat+");
        add(menuPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}