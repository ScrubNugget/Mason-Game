import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Ellipse2D;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;

/// = ANDREW
// = MASON

public class Cave extends JPanel implements KeyListener, MouseListener {
	public static Map map = new Map(25, 15);

	public LinkedList<Block> blockList = new LinkedList<Block>();

	Dimension screenSize;
	BufferedImage buffer;

	Player player;

	public Cave() {
	    setBackground(Color.black);
	    setIgnoreRepaint(true);
	    addKeyListener(this);
	    addMouseListener(this);
	    setFocusable(true);
	}

	///MAKE THE GAME LOOP, REFRESH EVERY 15 MILLISECONDS
	public void startGame() {
		Initialize();
		while (true) {
			try {
				update();
				checkCollisions();
				drawBuffer();
				drawScreen();
				Thread.sleep(15);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void Initialize() {
		///Get screen size
		screenSize = Application.size;

		///Maybe make the buffer size dynamic?
		buffer = new BufferedImage(screenSize.width, screenSize.height, BufferedImage.TYPE_INT_RGB);

		///CREATE PLAYER AND ENEMY
		player = new Player(null, 1, 1, 10, 10, 10, 10);
		//enemy = new Player(null, 200, 100, 10, 10, 10, 10);

		///LOAD IMAGES HERE
		try {
			player.setImage(ImageIO.read(getClass().getResource("/resources/Chair_Skeleton.gif")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		///END
	}

	///NEW DRAW METHOD - ANDREW
	public void drawBuffer() {
		Graphics2D b = buffer.createGraphics();

		///IMPLEMENTING ANTI ALIASING
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		b.setRenderingHints(rh);

		///SETTING BACKGROUND COLOR
		b.setColor(Color.black);
		b.fillRect(0, 0, screenSize.width, screenSize.height);

		///DRAWING PLAYER
		b.drawImage(player.getImage(), player.getXCord(), player.getYCord(), player.getWidth(), player.getHeight(), this);

		///IF DEBUGGING DRAW SOME EXTRA STUFF
		if (Application.debuging) {
			b.setColor(Color.red);
			b.drawRect(player.getXCord(), player.getYCord(), player.getWidth(), player.getHeight());
		}

		///DRAWING STRINGS FOR DATA
		b.setColor(Color.yellow);
		b.drawString("" + player.getXCord() + ", " + player.getYCord(), 10, 20);

		///DRAWING BLOCKS
		drawRoom(map, b);


		///END

		///DRAW CLICKED BLOCKS
		for (int i = 0; i < blockList.size(); i++) {
			drawBlock(blockList.get(i), b);
		}
		///END

		///DEBUG MAP CLASS
		b.setColor(Color.yellow);
		for (int y = 0; y < map.getBlockHeight(); y++) {
			String mapmap = "";
			for (int x = 0; x < map.getBlockWidth(); x++) {
				mapmap += (map.getCoordinates(y, x).getId() + "  ");
			}
			b.drawString(mapmap, 10, (y * 12) + 50);
		}

		///ENDING DRAW METHODS AND DISPOSING GRAPHICS
		b.dispose();
	}

	public void drawBlock(int c, int r, Graphics2D g) {
		g.setColor(Color.lightGray);

		Block testBlock = new Block(1, null, c, r, g);
	}

	public void drawBlock(Block block, Graphics2D g) {
		g.setColor(Color.blue);

		new Block(block.getId(), null, block.getColumn(), block.getRow(), g);
	}

	public void drawRoom(Map m, Graphics2D b) {
		for (int c = 0; c < m.getBlockWidth(); c++) {
			drawBlock(c, 0, b);
			drawBlock(c, m.getBlockHeight() - 1, b);
		}
		for (int r = 0; r < m.getBlockHeight(); r++) {
			drawBlock(0, r, b);
			drawBlock(m.getBlockWidth() - 1, r, b);
		}
	}

	///NO TOUCH | Draws the buffer to the screen so we can draw anything to the screen
	public void drawScreen() {
		Graphics2D g = (Graphics2D)this.getGraphics();

		g.drawImage(buffer,0,0,this);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public void checkCollisions() {
	}

	///UPDATE CALLED EVERY FRAME
	public void update() {
		try {
			Thread.sleep(75);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.Move();
	}

	//CALLED ON KEY PRESS
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			player.left = true;
		}
		if (key == KeyEvent.VK_RIGHT) {
			player.right = true;
		}
		if (key == KeyEvent.VK_UP) {
			player.up = true;
		}
		if (key == KeyEvent.VK_DOWN) {
			player.down = true;
		}
	}

	//CALLED ON KEY RELEASE
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			player.left = false;
		}
		if (key == KeyEvent.VK_RIGHT) {
			player.right = false;
		}
		if (key == KeyEvent.VK_UP) {
			player.up = false;
		}
		if (key == KeyEvent.VK_DOWN) {
			player.down = false;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	///REEEEE
	public void mouseExited(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("MOUSE INFO: (" + e.getX() + " ," + e.getY() + ")");


		///TODO: IMPLEMENT BLOCK CHECK
		blockList.add(new Block(2, null, e.getX() / 50, e.getY() / 50));
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {
	}
}