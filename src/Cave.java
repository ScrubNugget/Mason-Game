import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Ellipse2D;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

/// = ANDREW
// = MASON

public class Cave extends JPanel implements KeyListener {
	Dimension screenSize;
	BufferedImage buffer;

	Player player;
	Player enemy;

	int imgxpos;
	int imgypos;
	int bx;
	int by;

	public Cave() {
	    setBackground(Color.black);
	    setIgnoreRepaint(true);
	    addKeyListener(this);
	    setFocusable(true);

		imgxpos = 0;
		imgypos = 0;
		bx = 0;
		by = 0;
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
		player = new Player(null, 100, 100, 10, 10, 10, 10);
		enemy = new Player(null, 200, 100, 10, 10, 10, 10);

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

		///DRAWING PLAYER AND ENEMY, AS WELL AS SETTING BACKGROUND COLOR
		b.setColor(Color.black);
		b.fillRect(0, 0, screenSize.width, screenSize.height);

		b.setColor(Color.red);
		b.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), this);
		b.setColor(Color.blue);
		b.fillRect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());

		///DRAWING WALLS AROUND BORDER
		for (int y = 0; y < (int)(screenSize.height / 50); y++) {
			drawBlock(0, y * 50, b);
			drawBlock(screenSize.width - 50, y * 50, b);
		}
		for (int x = 0; x < (int)(screenSize.width / 50) + 1; x++) {
			drawBlock(x * 50, 0, b);
			drawBlock(x * 50, screenSize.height - 50, b);
		}
		System.out.println(screenSize.width / 50);
		///END

		///DRAWING STRINGS FOR DATA
		b.setColor(Color.white);
		b.drawString("" + player.getX() + ", " + player.getY(), 10, 20);
		b.drawString("" + player.collision + " | " + player.getCollisionDirection(enemy.getBounds()), 10, 40);

		///ENDING DRAW METHODS AND DISPOSING GRAPHICS
		b.dispose();
	}

	///RESPONSIBLE FOR DRAWING SINGLE BLOCK AT COORDINATES
	public void drawBlock(int xCord, int yCord, Graphics2D g) {
		g.setColor(Color.lightGray);
		g.fillRect(xCord, yCord, 50, 50);

		///ADD COLLISION DETECTION
		player.getCollisionDirection(new Rectangle(xCord, yCord, 50, 50));
	}

	//NO TOUCH | Draws the buffer to the screen so we can draw anything to the screen
	public void drawScreen() {
		Graphics2D g = (Graphics2D)this.getGraphics();

		g.drawImage(buffer,0,0,this);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public void checkCollisions() {
		if (player.getBounds().intersects(enemy.getBounds()))
			player.collision = true;
		else
			player.collision = false;
	}

	/*
    //DRAW GROUND METHOD
    private void drawGround(Graphics g) {
		//DRAWING MAP
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 20; y++) {
				if (m.getCoordinates(x, y) == 1) {
					g2d.setColor(Color.red);
					g2d.fillRect(x*50, y*50, 50, 50);
				}
				if (m.getCoordinates(x, y) == 2) {
					g2d.setColor(Color.blue);
					g2d.fillRect(x*50, y*50, 50, 50);
				}
				if (m.getCoordinates(x, y) == 3) {
					g2d.setColor(Color.yellow);
					g2d.fillRect(x*50, y*50, 50, 50);
				}
				if (m.getCoordinates(x, y) == 4) {
					g2d.setColor(Color.magenta);
					g2d.fillRect(x*50, y*50, 50, 50);
				}
			}
		}
		//END
		g2d.setColor(Color.white);
		g2d.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), this);

		g2d.setColor(Color.green);
	}
	*/

	///UPDATE CALLED EVERY FRAME
	public void update() {
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
}