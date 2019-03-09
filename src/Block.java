import java.awt.*;
import java.awt.image.*;

public class Block extends Entity {
    int id = 0;

    public Block(int ID, BufferedImage Texture, int col, int row) {
        super(Texture, col, row);
        id = ID;
    }

    public Block(int ID, BufferedImage Texture, int col, int row, Graphics2D g) {
        super(Texture, col, row);
        id = ID;

        Cave.map.setCoordinates(id, row, col);
        g.fillRect(super.getXCord(), super.getYCord(), super.getWidth(), super.getHeight());
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        id = ID;
    }

    public void setCoordinates(int row, int col) {
        super.setRow(row);
        super.setColumn(col);
    }
}
