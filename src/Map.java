import java.awt.*;

public class Map {
	private Block m[][] = new Block[20][20];
	private int pr = 0;
	private int pc = 0;

	public Map() {
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 20; y++) {
				m[x][y] = new Block((int) (Math.random() * 5), null, 0, 0);
			}
		}
	}

	public boolean North() {
		boolean b = false;

		if (pr > 0) {
			b = true;
			pr--;
		}

		return b;
	}

	public boolean South() {
		boolean b = false;

		if (pr < (m[1].length - 1)) {
			b = true;
			pr++;
		}

		return b;
	}

	public boolean East() {
		boolean b = false;

		if (pc < (m[0].length - 1)) {
			b = true;
			pc++;
		}

		return b;
	}

	public boolean West() {
		boolean b = false;

		if (pc > 0) {
			b = true;
			pc--;
		}

		return b;
	}

	public void remove() {
	}

	//This makes it so I can retrieve specific values from coordinates - MASON
	public int getCoordinates(int r, int c) {
		return m[r][c].id;
	}
}