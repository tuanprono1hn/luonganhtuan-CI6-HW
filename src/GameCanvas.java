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

    BufferedImage playerImage;
    BufferedImage backBuffered;
    Graphics graphics;

    List<Star> stars;
    List<Enemy> enemies;
    private Random random = new Random();
    private int countStar = 0;
    private int countEnemy = 0;

    Star star;
    Enemy enemy;
    Player player;

//    public int positionXenemy = 30;
//    public int positionYenemy = 20;
//
//    public int positionXplayer = 200;
//    public int positionYplayer = 200;

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
        this.renderBackground();
//        this.star.render(this.graphics);
//       lambdas expression
        this.stars.forEach(star -> star.render(graphics));
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.player.render(graphics);
        this.repaint();
    }

    private void renderBackground() {
        this.graphics.setColor(Color.black);
        this.graphics.fillRect(0,0,1024,600);
    }

    public void runAll () {
        this.createStar();
        this.createEnemy();
        this.stars.forEach(star -> star.run());
        this.enemies.forEach(enemy -> enemy.run());
    }

    private void createPlayer(){
        this.player = new Player(this.loadImage("resources-rocket/resources/images/circle.png"), this.random.nextInt(1024), this.random.nextInt(600), 30,30, 10,10);
    }

    private void createStar() {
        if (this.countStar == 30) {
            Star star = new Star(this.loadImage("resources-rocket/resources/images/star.png"), this.random.nextInt(1024), this.random.nextInt(600), 5, 5, -this.random.nextInt(3) - 1, 0);
            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }
    }

    private void createEnemy() {
        if (this.countEnemy == 40) {
            Enemy enemy = new Enemy(this.loadImage("resources-rocket/resources/images/circle.png"), this.random.nextInt(1024), this.random.nextInt(600), 15, 15, -this.random.nextInt(3) - 1, -this.random.nextInt(3) - 1);
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