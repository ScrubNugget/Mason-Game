import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Cave extends JPanel implements KeyListener {
    BufferedImage player;
	int imgxpos;
	int imgypos;
	int bx;
	int by;
	Map m = new Map();

	public Cave() {
	    setBackground(Color.black);

		m = new Map();
		imgxpos = 0;
		imgypos = 0;
		bx = 0;
		by = 0;
	}

	@Override
    public void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    drawGround(g);
    }

    //DRAW GROUND METHOD -- ANDREW MATAYKA
    private void drawGround(Graphics g) {
		try {
			player = ImageIO.read(getClass().getResource("/resources/Chair_Skeleton.gif"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);

		Dimension size = getSize();
		double w = size.getWidth();
		double h = size.getHeight();

		//DRAWING MAP -- ANDREW MATAYKA
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
					g2d.setColor(Color.darkGray);
					g2d.fillRect(x*50, y*50, 50, 50);
				}
			}
		}
		g2d.setColor(Color.white);
		g2d.drawImage(player, imgxpos, imgypos, 50, 50, this);

		g2d.setColor(Color.green);
		g2d.drawString("" + imgxpos + ", " + imgypos, 10, 20);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 37) {
			//boolean b = m.West();
			//if (b == true)
				imgxpos = imgxpos - 50;// Left Arrow=37
		}
		if (e.getKeyCode() == 38) {
			//boolean b = m.North();
			//if (b == true)
				imgypos = imgypos - 50;// Up Arrow=38
		}
		if (e.getKeyCode() == 39) {
			//boolean b = m.East();
			//if (b == true)
				imgxpos = imgxpos + 50;// Right Arrow=39
		}
		if (e.getKeyCode() == 40) {
			//boolean b = m.South();
			//if (b == true)
				imgypos = imgypos + 50;// Down Arrow=40
		}

		repaint();
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}
}