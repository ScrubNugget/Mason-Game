import java.awt.image.BufferedImage;

public class Player extends Entity {
    int hp, xp, atk, def;

    public Player(BufferedImage image, int row, int col, int health, int experience, int attack, int defense) {
        super(image, row, col);
        super.setSpeed(50);
        hp = health;
        xp = experience;
        atk = attack;
        def = defense;
    }
}