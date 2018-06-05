import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;

    Background background;
    public Player player;
    private Random random = new Random();
    private EnemySpawner enemySpawner = new EnemySpawner();
    private StarSpawner starSpawner = new StarSpawner();

//    Star star;
//    Enemy enemy;
//    Player player;

    public GameCanvas() {
        this.setSize(1024, 600);
        this.setupCharacter();
        this.setupBackBuffered();
        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.background = new Background();
        this.createPlayer();
//        this.setupStar();
//        this.setupEnemy();
    }

//    private void setupStar() {
//        this.stars = new ArrayList<>();
//    }
//    private void setupEnemy() {
//        this.enemies = new ArrayList<>();
//    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
//       lambdas expression
        this.background.render(this.graphics);
        this.starSpawner.stars.forEach(star -> star.render(graphics));
        this.player.render(this.graphics);
        this.enemySpawner.enemies.forEach(enemy -> enemy.render(graphics));
        this.repaint();
    }

    public void runAll () {
//        this.createStar();
//        this.createEnemy();
        this.starSpawner.run();
        this.enemySpawner.enemies.forEach(enemy -> {
            Vector2D velocity = player.position.subtract(enemy.position).normalize().multiply(2);
            enemy.velocity.set(velocity);
        });
        this.starSpawner.stars.forEach(star -> star.run());
        this.enemySpawner.run();
        this.player.run();
    }

    private void createPlayer(){
        this.player = new Player();
        this.player.position.set(500,300);
        this.player.playerMove.velocity.set(4,0);
    }

}