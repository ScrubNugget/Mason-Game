import java.awt.image.BufferedImage;

public class Player extends Entity {
    int hp, xp, atk, def;

    public Player(BufferedImage image, int xCord, int yCord, int health, int experience, int attack, int defense) {
        super(image, xCord, yCord);
        hp = health;
        xp = experience;
        atk = attack;
        def = defense;
    }
}