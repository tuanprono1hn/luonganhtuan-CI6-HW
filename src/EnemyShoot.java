import java.util.ArrayList;
import java.util.List;

public class EnemyShoot {
    private int bulletcount = 0;

    public List<Bullet> bulletEnemies;

    public EnemyShoot(){
        this.bulletEnemies = new ArrayList<>();
    }

    public void run(Enemy enemy){
        //create bullet
        for (double angle = 0.0; angle <= 360; angle += 15.0) {
            Bullet bulletEnemy = new Bullet();
            if (this.bulletcount == 100) {
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set((new Vector2D(3,0)).rotate(angle));
                this.bulletEnemies.add(bulletEnemy);
                this.bulletcount = 0;
            } else {
                bulletcount += 1;
            }
        }
    }

}
