package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;
import game.player.Player;
import physic.BoxCollider;
import physic.PhisicBody;
import renderer.ImageRenderer;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject implements PhisicBody {

    public Vector2D velocity;
//    private EnemyShoot enemyShoot;
    public BoxCollider boxCollider;

    public Enemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket/resources/images/circle.png", 20,20, Color.BLUE);
        this.boxCollider = new BoxCollider(20,20);
//        this.enemyShoot = new EnemyShoot();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
//        this.enemyShoot.run(this);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            this.velocity.set(player.position.subtract(this.position).normalize().multiply(3));
        }
//        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }

    @Override
    public void getHit(GameObject gameObject){
        if (gameObject instanceof Bullet){
            this.isAlive = false;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    //    public void run(){
//        this.position.addUp(this.velocity);
//        this.enemyShoot.run(this);
//        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
//    }
//    @Override
//    public void render(Graphics graphics) {
//        super.render(graphics);
//        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
//    }
}