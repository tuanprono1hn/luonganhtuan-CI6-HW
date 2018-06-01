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
    List<Star> stars;
    List<Enemy> enemies;
    public Player player;
    private Random random = new Random();
    private int countStar = 0;
    private int countEnemy = 0;

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
//        this.background.color = Color.black;
        this.createPlayer();
        this.setupStar();
        this.setupEnemy();
    }

    private void setupStar() {
        this.stars = new ArrayList<>();
    }
    private void setupEnemy() {
        this.enemies = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
//       lambdas expression
        this.background.render(this.graphics);
        this.stars.forEach(star -> star.render(graphics));
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.player.render(this.graphics);
        this.repaint();
    }

    private void renderBackground() {
        this.graphics.setColor(Color.black);
        this.graphics.fillRect(0,0,1024,600);
    }

    public void runAll () {
        this.createStar();
        this.createEnemy();
        this.enemies.forEach(enemy -> {
            Vector2D velocity = player.position.subtract(enemy.position).normalize().multiply(2);
            enemy.velocity.set(velocity);
        });
        this.stars.forEach(star -> star.run());
        this.enemies.forEach(enemy -> enemy.run(this.player.position));
        this.player.run();
    }

    private void createPlayer(){
        this.player = new Player();
        this.player.position.set(500,300);
        this.player.velocity.set(4,0);
    }

    private void createStar() {
        if (this.countStar == 30) {
//            Star star = new Star(this.loadImage("resources-rocket/resources/images/star.png"), new Vector2D(this.random.nextInt(1024), this.random.nextInt(600)), 5, 5, new Vector2D(-this.random.nextInt(3) - 1, 0));
            Star star = new Star();
            star.image = this.loadImage("resources-rocket/resources/images/star.png");
            star.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            star.velocity.set(-this.random.nextInt(3)+1,0);
            star.width = 5;
            star.height = 5;
            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }
    }

    private void createEnemy() {
        if (this.countEnemy == 200) {
//            int dau = this.random.nextInt(2);
//            if (dau == 0) dau = -1;
//            else dau = 1;
//            int velocityX = dau * (this.random.nextInt(4)+1);
//
//            dau = this.random.nextInt(2);
//            if (dau == 0) dau = -1;
//            else dau = 1;
//            int velocityY = dau * (this.random.nextInt(4)+1);

//            Enemy enemy = new Enemy(this.loadImage("resources-rocket/resources/images/circle.png"), new Vector2D(this.random.nextInt(1024), this.random.nextInt(600)), 15, 15, new Vector2D(velocityX,velocityY));
            Enemy enemy = new Enemy();
            enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            this.enemies.add(enemy);
            this.countEnemy = 0;
        } else {
            this.countEnemy += 1;
        }
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}