import java.awt.*;
import java.util.Random;

public class BulletPlayer {
    public Vector2D position;
    public Vector2D velocity;
    private Random random;
    public double angle = 0.0;
    private PolygonRenderer renderer;

    public BulletPlayer() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.random = new Random();
        this.renderer = new PolygonRenderer(
                Color.orange,
                new Vector2D(),
                new Vector2D(0,4),
                new Vector2D(5,2)
        );
    }

    public void run(){
        this.position.addUp(this.velocity);
        this.renderer.angle = this.angle;
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}
