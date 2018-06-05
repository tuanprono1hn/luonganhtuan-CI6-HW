import java.awt.*;
import java.util.Random;

public class Bullet extends GameObject{
    public Vector2D velocity;
    private Random random;

    public Bullet() {
        this.velocity = new Vector2D();
        this.random = new Random();
        this.renderer = new ImageRenderer("resources-rocket/resources/images/circle.png", 6,6);
    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
    }

}
