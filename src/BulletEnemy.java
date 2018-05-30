import java.awt.*;
import java.util.Random;

public class BulletEnemy {
    private ImageRenderer renderer;
    public Vector2D position;
    public Vector2D velocity;
    private Random random;

    public BulletEnemy() {
//        this.image = image;
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.random = new Random();
        this.renderer = new ImageRenderer("resources-rocket/resources/images/circle.png", 6,6);
    }

    public void run(Vector2D playerPosition){
//        this.velocity = this.chase(playerPosition).multiply(3);
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

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}
