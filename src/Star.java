import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    public BufferedImage image;
    public Vector2D position;
    public Vector2D velocity;
    public int width;
    public int height;

    public Star() {
//        this.image = image;
        this.position = new Vector2D();
//        this.width = width;
//        this.height = height;
        this.velocity = new Vector2D();
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int)this.position.x, (int)this.position.y, this.width, this.height, null);
    }
}