import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    ///0 right; 1 left; 2 up; 3 down;
    int x, y, speed, width, height, lastDirection;
    boolean up, down, right, left, collision;
    BufferedImage image;

    public Entity (int xCord, int yCord) {
        x = xCord;
        y = yCord;
        speed = 3;
        width = 50;
        height = 50;
        image = null;
        up = false;
        down = false;
        right = false;
        left = false;
        collision = false;
    }

    public Entity (BufferedImage entityImage, int xCord, int yCord) {
        x = xCord;
        y = yCord;
        speed = 3;
        width = 50;
        height = 50;
        image = entityImage;
        up = false;
        down = false;
        right = false;
        left = false;
        collision = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(),getY(),getWidth(),getHeight());
    }

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

    public BufferedImage getImage() {
        return image;
    }

    public void setX(int xCord) {
        x = xCord;
    }

    public void setY(int yCord) {
        y = yCord;
    }

    public void setImage(BufferedImage entityImage) {
        image = entityImage;
    }

    public void Move() {
        if (up) {
            y -= speed;
        }
        if (down) {
            y += speed;;
        }
        if (left) {
            x -= speed;
        }
        if (right) {
            x += speed;
        }
    }
}
