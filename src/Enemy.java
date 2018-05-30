import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy {

    public BufferedImage image;
    public Vector2D position;
    public int width;
    public int height;
    public Vector2D velocity;
    private Random random;

    public Enemy(BufferedImage image, Vector2D position, int width, int height, Vector2D velocity) {
        this.image = image;
        this.position = position;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
        this.random = new Random();
    }

    public void run(Vector2D playerPosition){
        this.velocity = this.chase(playerPosition).multiply(3);
        this.position.x += this.velocity.x;
        this.position.y += this.velocity.y;
        this.backToScreen();
    }

    public void backToScreen() {
        if (this.position.x < 0){
            this.position.set(1024,random.nextInt(600));
        }
        if (this.position.x > 1024){
            this.position.set(0,random.nextInt(600));
        }
        if (this.position.y < 0){
            this.position.set(random.nextInt(1024),600);
        }
        if (this.position.y > 600){
            this.position.set(random.nextInt(1024),0);
        }
    }

    public Vector2D chase(Vector2D playerPosition){
        Vector2D velocitySubtract;
        velocitySubtract = playerPosition.subtract(this.position);
        return velocitySubtract.normalize();
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int)this.position.x,(int)this.position.y, this.width, this.height, null);
    }
}