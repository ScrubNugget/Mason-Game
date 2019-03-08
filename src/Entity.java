import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    ///0 right; 1 left; 2 up; 3 down;
    int row, col, speed, width, height, x, y;
    boolean up, down, right, left;
    BufferedImage image;

    public Entity (int r, int c) {
        row = r;
        col = c;
        speed = 3;
        width = 50;
        height = 50;
        image = null;
        up = false;
        down = false;
        right = false;
        left = false;
        x = col * speed;
        y = row * speed;
    }

    public Entity (BufferedImage entityImage, int r, int c) {
        row = r;
        col = c;
        speed = 3;
        width = 50;
        height = 50;
        image = entityImage;
        up = false;
        down = false;
        right = false;
        left = false;
        x = col * speed;
        y = row * speed;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }

    public int getXCord() { return (col * speed); }

    public int getYCord() { return (row * speed); }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    //public Rectangle getBounds() {
    //    return new Rectangle(getRow() * speed,getColumn() * speed,getWidth(),getHeight());
    //}

    /*
    public String getCollisionDirection(Rectangle entity) {
        ///RIGHT COLLISION OF PLAYER
        ///LEFT || RIGHT
        if (getX() + (getWidth() / 2) > entity.getX() - (entity.getWidth() / 2) && getX() + (getWidth() / 2) < entity.getX()) {
            //TOP || BOTTOM
            if (getY() + (getHeight() / 2) > entity.getY() - (entity.getHeight() / 2) && getY() - (getHeight() / 2) < entity.getY() + (entity.getHeight() / 2)) {
                if (right == true) {
                    setX(getX() - (int)((getX() + (getWidth() / 2)) - (entity.getX() - (entity.getWidth() / 2))));
                    return "Right";
                }
            }
        }

        ///LEFT COLLISION OF PLAYER
        ///RIGHT || LEFT
        if (getX() - (getWidth() / 2) < entity.getX() + (entity.getWidth() / 2) && getX() - (getWidth() / 2) > entity.getX()) {
            ///TOP || BOTTOM
            if (getY() + (getHeight() / 2) > entity.getY() - (entity.getHeight() / 2) && getY() - (getHeight() / 2) < entity.getY() + (entity.getHeight() / 2)) {
                if (left == true) {
                    setX(getX() + (int)((entity.getX() + (entity.getWidth() / 2)) - (getX() - (getWidth() / 2 ))));
                    return "Left";
                }
            }
        }

        ///TOP COLLISION OF PLAYER
        ///BOTTOM || TOP
        if (getY() - (getHeight() / 2) < entity.getY() + (entity.getHeight() / 2) && getY() - (getHeight() / 2) > entity.getY()) {
            ///LEFT || RIGHT
            if (getX() + (getWidth() / 2) > entity.getX() - (entity.getWidth() / 2) && getX() - (getWidth() / 2) < entity.getX() + (entity.getWidth() / 2)) {
                if (up == true) {
                    setY(getY() + (int)((entity.getY() + (entity.getHeight() / 2)) - (getY() - (getHeight() / 2))));
                    return "Top";
                }
            }
        }

        ///BOTTOM COLLISION OF PLAYER
        ///TOP || BOTTOM
        if (getY() + (getHeight() / 2) < entity.getY() && getY() + (getHeight() / 2) > entity.getY() - (entity.getHeight() / 2)) {
            ///LEFT || RIGHT
            if (getX() + (getWidth() / 2) > entity.getX() - (entity.getWidth() / 2) && getX() - (getWidth() / 2) < entity.getX() + (entity.getWidth() / 2)) {
                if (down == true) {
                    setY(getY() - (int)((getY() + (getHeight() / 2)) - (entity.getY() - (entity.getHeight() / 2))));
                    return "Bottom";
                }
            }
        }

        return "Error";
    }
    */

    public String getCollisionDirection(Rectangle entity) {

        return "Error";
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setRow(int r) {
        row = r;
    }

    public void setColumn(int c) {
        col = c;
    }

    public void setImage(BufferedImage entityImage) {
        image = entityImage;
    }

    public void setSpeed(int s) {
        speed = s;
    }

    public void Move() {
        if (up) {
            Cave.map.setCoordinates(0, row, col);
            row--;
            y = row * speed;
            Cave.map.setCoordinates(-1, row, col);
        }
        if (down) {
            Cave.map.setCoordinates(0, row, col);
            row++;
            y = row * speed;
            Cave.map.setCoordinates(-1, row, col);
        }
        if (left) {
            Cave.map.setCoordinates(0, row, col);
            col--;
            x = col * speed;
            Cave.map.setCoordinates(-1, row, col);
        }
        if (right) {
            Cave.map.setCoordinates(0, row, col);
            col++;
            x = col * speed;
            Cave.map.setCoordinates(-1, row, col);
        }
    }
}
