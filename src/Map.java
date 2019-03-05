public class Map {
	private int m[][] = new int[20][20];
	private int pr = 0;
	private int pc = 0;

	public Map() {
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 20; y++) {
				m[x][y] = (int) (Math.random() * 5);
			}//This generates a random map of values, for different blocks
		}
	}

	public boolean North() {
		boolean b = false;
		if (pr - 1 > 0) {
			if (pr - 1 != 1 && pr - 1 != 2 && pr - 1 != 3 && pr - 1 != 4) {//As long as the block the player moves to is a zero, 
				//it'll return boolean b as true, which allows us to coordinate pixel movement in the applet
				pr++;
				b = true;
			}
		}
		return b;
	}

	public boolean South() {
		boolean b = false;
		if (pr + 1 < m.length) {
			if (pr + 1 != 1 && pr + 1 != 2 && pr + 1 != 3 && pr + 1 != 4) {
				pr++;
				b = true;
			}
		}
		return b;
	}

	public boolean East() {
		boolean b = false;
		if (pc + 1 < m.length) {
			if (pc + 1 != 1 && pc + 1 != 2 && pc + 1 != 3 && pc + 1 != 4) {
				pc++;
				b = true;
			}
		}
		return b;
	}

	public boolean West() {
		boolean b = false;
		if (pc - 1 < m.length) {
			if (pc - 1 != 1 && pc - 1 != 2 && pc - 1 != 3 && pc - 1 != 4) {
				pc--;
				b = true;
			}
		}
		return b;
	}

	public void remove() {// this will eventually be how we'll remove blocks when the player "mines" or destroys them
	}

	//This makes it so I can retrieve specific values from coordinates - MASON
	public int getCoordinates(int c, int r) {
		int x = m[c][r];
		return x;
	}
}
