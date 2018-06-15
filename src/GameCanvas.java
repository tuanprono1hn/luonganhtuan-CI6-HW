import base.GameObjectManager;
import game.background.Background;
import game.enemy.EnemySpawner;
import game.player.Player;
import game.star.StarSpawner;
import input.KeyboardInput;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;

    public Player player;

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
        GameObjectManager.instance.add(new Background());
//        this.background = new game.background.Background();
        this.createPlayer();
        GameObjectManager.instance.add(new EnemySpawner());
        GameObjectManager.instance.add(new StarSpawner());
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();
    }

    public void runAll () {
        GameObjectManager.instance.runAll();
        KeyboardInput.instance.reset();
    }

    private void createPlayer(){
        this.player = new Player();
        this.player.position.set(500,300);
        this.player.playerMove.velocity.set(4,0);
        GameObjectManager.instance.add(this.player);
    }

}