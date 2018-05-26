import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy {

    public BufferedImage image;
    public int x;
    public int y;
    public int width;
    public int height;
    public int velocityX;
    public int velocityY;
    Random random = new Random();


    public Enemy(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void run() {
        if (this.x + velocityX <= 0) {
            this.x = 1024;
            this.y = random.nextInt(600);
        } else if (this.x + velocityX >= 1024){
            this.x = 0;
            this.y = random.nextInt(600);
        } else {
            this.x += velocityX;
        }
        if (this.y + velocityY <= 0){
            this.x = random.nextInt(1024);
            this.y = 600;
        } else if (this.y + velocityY >= 600){
            this.x = random.nextInt(1024);
            this.y = 0;
        } else {
            this.y += velocityY;
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, this.width, this.height, null);
    }
}