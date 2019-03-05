import javax.swing.*;
import java.awt.*;

//CLASS MADE BY ANDREW MATAYKA
public class Application extends JFrame {
    public Application() {
        initUI();
    }

    public void initUI() {
        Cave cave = new Cave();

        cave.addKeyListener(cave);
        cave.setFocusable(true);

        add (cave);

        setSize(800, 600);

        setTitle("Mason Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    //Creating instance of code and displaying it to the screen
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}
