import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    public Vector2D position;
    public Vector2D velocity;
    private Random random;
//    private List<Vector2D> verties;
//    private Polygon polygon;
    public double angle = 0.0;
    private PolygonRenderer renderer;
    private PlayerShoot playerShoot;

    public Player() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.random = new Random();
        this.renderer = new PolygonRenderer(
                Color.red,
                new Vector2D(),
                new Vector2D(0,16),
                new Vector2D(20,8)
        );
    }

    public void run(){
        this.position.addUp(this.velocity);
//        this.setVerties();
        this.renderer.angle = this.angle;
        this.backToScreen();
    }

    private void backToScreen(){
        if (this.position.x > 1024){
            this.position.set(0, this.random.nextInt(600));
        }
        if (this.position.x < 0){
            this.position.set(1024, this.random.nextInt(600));
        }
        if (this.position.y > 600){
            this.position.set(this.random.nextInt(1024), 0);
        }
        if (this.position.y < 0){
            this.position.set(this.random.nextInt(1024), 600);
        }
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }

//    public void updatePolygon(){
//        this.polygon.reset();
////        Vector2D center = new Vector2D();
////        this.verties.forEach(vector2D -> center.addUp(vector2D));
////        center.multiply(1.0f/this.verties.size());
//
//        Vector2D center = this.verties
//                .stream()
//                .reduce(new Vector2D(), (v1, v2) -> v1.add(v2))
//                .multiply(1.0f/this.verties.size()).rotate(this.angle);
//        Vector2D translate = this.position.subtract(center);
////        List<Vector2D> newverties = new ArrayList<>();
////        this.verties.forEach(vector2D -> {
////            Vector2D newPosition = vector2D.add(translate);
////            newverties.add(newPosition);
////        });
////        List<Vector2D> newVerties = this.verties.stream().map(vector2D -> vector2D.add(translate)).collect(Collectors.toList());
//        this.verties.stream()
//                .map(vector2D -> vector2D.rotate(angle))
//                .map(vector2D -> vector2D.add(translate))
//                .forEach(vertex -> polygon.addPoint((int)vertex.x, (int)vertex.y));
//    }
}