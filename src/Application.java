import javax.swing.*;
import java.awt.*;
import java.awt.geom.Dimension2D;

///CLASS MADE BY ANDREW MATAYKA
public class Application extends JFrame {
    public static Dimension size;
    Cave cave;

    public Application() {
        initUI();
    }

    ///INITIALIZING KEY JFRAME ELEMENTS
    public void initUI() {
        cave = new Cave();

        setSize(1366, 768);
        setTitle("Mason Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(cave);
        setVisible(true);
        setLocationRelativeTo(null);

        Application.size = getContentPane().getSize();
    }

    ///Creating instance of code and displaying it to the screen
    public static void main(String[] args) {
        Application app = new Application();
        app.go();
    }

    public void go() {
        ///Initializing the JPanel Game Loop
        cave.startGame();
    }
}
