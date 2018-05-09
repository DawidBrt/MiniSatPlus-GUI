import gui.MenuPanel;
import gui.MyFrame;
import script.ScriptRunner;

public class Main {

    public static void main(String[] args) {
        ScriptRunner scriptRunner = new ScriptRunner();
        MenuPanel menuPanel = new MenuPanel(435,100,scriptRunner);
        MyFrame myFrame = new MyFrame(menuPanel);
    }
}
