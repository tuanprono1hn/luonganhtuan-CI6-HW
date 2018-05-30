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
//    public double angle;
    public float speed;
    private Random random;
    private List<Vector2D> verties;
    private Polygon polygon;
    public double angle = 0.0;
    private PolygonRenderer renderer;

    public Player() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.speed = 4;
        this.random = new Random();
        this.renderer = new PolygonRenderer(
                Color.red,
                new Vector2D(),
                new Vector2D(0,16),
                new Vector2D(20,8)
        );
//        this.verties = Arrays.asList(
//                new Vector2D(),
//                new Vector2D(0,16),
//                new Vector2D(20,8)
//        );
//        this.polygon = new Polygon();
    }

//    public void run(String move, int windowX, int windowY){
//        int dX = 0;
//        int dY = 0;
//        if (move.equalsIgnoreCase("left")) {
//            dX -= this.velocityX;
//        } else if (move.equalsIgnoreCase("right")){
//            dX += this.velocityX;
//        }
//        if (move.equalsIgnoreCase("up")){
//            dY -= this.velocityY;
//        } else if (move.equalsIgnoreCase("down")){
//            dY += this.velocityY;
//        }
//        if (this.x + dX <=0) {
//            this.x = windowX;
//            this.y = random.nextInt(windowY);
//        } else if (this.x + dX >= windowX){
//            this.x = 0;
//            this.y = random.nextInt(windowY);
//        } else {
//            this.x += dX;
//        }
//        if (this.y + dY <= 0){
//            this.x = random.nextInt(windowX);
//            this.y = windowY;
//        } else if (this.y + dY>= windowY){
//            this.x = random.nextInt(windowX);
//            this.y = 0;
//        } else {
//            this.y += dY;
//        }
//    }

    public void run(){
//        this.velocity = (this.velocity.normalize().multiply(speed));
//        this.velocity = this.velocity.rotate(angle);
        this.position.addUp(this.velocity);
//        this.setVerties();
        this.renderer.angle = this.angle;
        this.backToScreen();
    }

//    public void setVerties(){
//        this.verties = Arrays.asList(
//                new Vector2D(this.position.x, this.position.y - 10),
//                new Vector2D(this.position.x, this.position.y + 10),
//                new Vector2D(this.position.x + 20, this.position.y)
//        );
//    }

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
//        graphics.setColor(Color.red);
//        this.updatePolygon();
//        graphics.fillPolygon(this.polygon);
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