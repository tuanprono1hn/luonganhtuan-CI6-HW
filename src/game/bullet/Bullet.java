package game.bullet;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import physic.BoxCollider;
import physic.PhisicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.Random;

public class Bullet extends GameObject implements PhisicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    public Bullet() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket/resources/images/circle.png", 6,6, Color.green);
        this.boxCollider = new BoxCollider(6,6);
//        this.runHitObject = new RunHitObject(
//                Enemy.class
//                Bullet.class;
//        );
    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 3, this.position.y - 3);
//        Enemy enemy = GameObjectManager.instance.checkCollision(this.boxCollider, Enemy.class);
//        if (enemy != null){
//            this.getHit();
//            enemy.getHit();
//        this.runHitObject.run(this);
        }

    @Override
    public void getHit(GameObject gameObject){
        if (gameObject instanceof Enemy){
            this.isAlive = false;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
