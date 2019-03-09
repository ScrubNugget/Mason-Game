import java.awt.*;

public class Map {
	//COLUMN : ROW
	public static Block m[][];

	int width = 0, height = 0;

	public Map(int blockWidth, int blockHeight) {
		width = blockWidth;
		height = blockHeight;
		m = new Block[width][height];

		for (int c = 0; c < blockWidth; c++) {
			for (int r = 0; r < blockHeight; r++) {
				m[c][r] = new Block((int) (Math.random() * 0), null, 0, 0);
			}
		}
	}

	//This makes it so I can retrieve specific values from coordinates - MASON
	public Block getCoordinates(int r, int c) {
		return m[c][r];
	}
	public Block getCoordinates(double r, double c) {
		return m[(int)c][(int)r];
	}

	public int getBlockWidth() {
		return width;
	}

	public int getBlockHeight() {
		return height;
	}

	public void setCoordinates(int value, double r, double c) {
		m[(int)c][(int)r].id = value;
	}
	public void setCoordinates(int value, int r, int c) {
		m[c][r].id = value;
	}
}