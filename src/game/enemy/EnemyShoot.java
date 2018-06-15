package game.enemy;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
//import game.bullet.Bullet;
import game.bullet.BulletEnemy;

public class EnemyShoot {
    private FrameCounter frameCounter;
//    private base.GameObjectManager manager = new base.GameObjectManager();

    public EnemyShoot(){
        this.frameCounter = new FrameCounter(100);
    }

    public void run(Enemy enemy){
        //create bullet
        if (this.frameCounter.run()) {
            for (double angle = 0.0; angle <= 360; angle += 15.0) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set((new Vector2D(3,0)).rotate(angle));
                GameObjectManager.instance.add(bulletEnemy);
            }
            this.frameCounter.reset();
        }
    }

}
