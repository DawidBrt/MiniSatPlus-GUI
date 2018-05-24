import gui.MenuPanel;
import gui.MyFrame;
import script.ScriptRunner;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        ScriptRunner scriptRunner = null;
        try {
            scriptRunner = new ScriptRunner();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        MenuPanel menuPanel = new MenuPanel(430,170,scriptRunner);
        MyFrame myFrame = new MyFrame(menuPanel);
    }
}
