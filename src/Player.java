import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;

public class Player {
    public Vector2D position;
    public Vector2D velocity;
    private Random random;
    private List<Vector2D> verties;
    private Polygon polygon;

    public Player() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.random = new Random();
        this.verties = Arrays.asList(
                new Vector2D(),
                new Vector2D(0,16),
                new Vector2D(20,8)
        );
        this.polygon = new Polygon();
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
        this.position.addUp(this.velocity);
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
        graphics.setColor(Color.red);
        this.polygon.reset();
        this.verties.forEach(vertex -> polygon.addPoint((int)vertex.x, (int)vertex.y));
        graphics.fillPolygon(this.polygon);
    }
}