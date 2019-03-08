import java.awt.image.*;

public class Block extends Entity {
    int id = 0;

    public Block(int ID, BufferedImage Texture, int row, int col) {
        super(Texture, row, col);
        id = ID;
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
