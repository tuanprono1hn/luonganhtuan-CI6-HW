import java.util.ArrayList;
import java.util.List;

public class EnemyShoot {
    private int bulletcount;

    public List<BulletEnemy> bulletEnemies;

    public EnemyShoot(){
        this.bulletEnemies = new ArrayList<>();
    }

    public void run(Enemy enemy){
        //create bullet
        BulletEnemy bulletEnemy = new BulletEnemy();
        if (this.bulletcount == 30){
            bulletEnemy.position.set(enemy.position);
            bulletEnemy.velocity.set(3, 0);
            this.bulletEnemies.add(bulletEnemy);
            this.bulletcount = 0;
        } else {
            bulletcount += 1;
        }
    }

}
