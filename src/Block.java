import java.awt.*;
import java.awt.image.*;

public class Block extends Entity {
    int id = 0;

    public Block(int ID, BufferedImage Texture, int xCord, int yCord) {
        super(Texture, xCord, yCord);
        id = ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        id = ID;
    }

    public void setCoordinates(int xCord, int yCord) {
        x = xCord;
        y = yCord;
    }
}
