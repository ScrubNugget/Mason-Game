import java.awt.*;

public class Map {
	//COLUMN : ROW
	public static Block m[][] = new Block[20][20];
	private int pr = 0;
	private int pc = 0;

	public Map() {
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 20; y++) {
				m[x][y] = new Block((int) (Math.random() * 0), null, 0, 0);
			}
		}
	}

	//This makes it so I can retrieve specific values from coordinates - MASON
	public int getCoordinates(int r, int c) {
		return m[c][r].id;
	}

	public void setCoordinates(int value, int r, int c) {
		m[c][r].id = value;
	}
}