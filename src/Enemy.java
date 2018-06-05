import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy {

    private Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;
    private Random random;
    private EnemyShoot enemyShoot;

    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.random = new Random();
        this.renderer = new ImageRenderer("resources-rocket/resources/images/circle.png", 20,20);
        this.enemyShoot = new EnemyShoot();
    }

    public void run(){
//        this.velocity = this.chase(playerPosition).multiply(3);
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
//        this.backToScreen();
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

//    public Vector2D chase(Vector2D playerPosition){
//        Vector2D velocitySubtract;
//        velocitySubtract = playerPosition.subtract(this.position);
//        return velocitySubtract.normalize();
//    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}