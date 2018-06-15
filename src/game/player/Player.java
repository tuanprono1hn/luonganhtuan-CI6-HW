package game.player;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.BulletEnemy;
import game.bullet.BulletPlayer;
import game.effect.Smoke;
import game.enemy.Enemy;
import physic.BoxCollider;
import physic.PhisicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject implements PhisicBody {
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;
    private RunHitObject runHitObject;
    public BoxCollider boxCollider;
    private FrameCounter frameCounter = new FrameCounter(10);

    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(
                Color.red,
                new Vector2D(),
                new Vector2D(0,16),
                new Vector2D(20,8)
        );
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(20,20);
        this.runHitObject = new RunHitObject(Enemy.class, BulletEnemy.class);
    }
    @Override
    public void run(){
        super.run();
        this.boxCollider.position.set(this.position.x -10, this.position.y - 10);
        this.runHitObject.run(this);
        this.playerMove.run(this);
        this.playerShoot.run(this);
        ((PolygonRenderer)this.renderer).angle = this.playerMove.angle;
        this.createSmoke();
    }

    private void createSmoke (){
        if (this.frameCounter.run()){
            Smoke smoke = GameObjectManager.instance.recycle(Smoke.class);
            smoke.renderer = new ImageRenderer("resources-rocket/resources/images/circle.png",12,12, Color.lightGray);
            smoke.position.set(position);

            Vector2D rotate = this.playerMove.velocity.add(
                    new Vector2D(2,0).rotate(this.playerMove.angle));

            smoke.velocity.set(rotate);
            this.frameCounter.reset();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof BulletEnemy || gameObject instanceof BulletEnemy) {
            this.isAlive = false;
        }
    }
    public void render(Graphics graphics) {
        super.render(graphics);
    }
}