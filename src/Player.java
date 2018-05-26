import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player {
    public BufferedImage image;
    public int x;
    public int y;
    public int width;
    public int height;
    public int velocityX;
    public int velocityY;
    Random random = new Random();

    public Player(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void run(String move, int windowX, int windowY){
        int dX = 0;
        int dY = 0;
        if (move.equalsIgnoreCase("left")) {
            dX -= this.velocityX;
        } else if (move.equalsIgnoreCase("right")){
            dX += this.velocityX;
        }
        if (move.equalsIgnoreCase("up")){
            dY -= this.velocityY;
        } else if (move.equalsIgnoreCase("down")){
            dY += this.velocityY;
        }
        if (this.x + dX <=0) {
            this.x = windowX;
            this.y = random.nextInt(windowY);
        } else if (this.x + dX >= windowX){
            this.x = 0;
            this.y = random.nextInt(windowY);
        } else {
            this.x += dX;
        }
        if (this.y + dY <= 0){
            this.x = random.nextInt(windowX);
            this.y = windowY;
        } else if (this.y + dY>= windowY){
            this.x = random.nextInt(windowX);
            this.y = 0;
        } else {
            this.y += dY;
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, this.width, this.height, null);
    }
}