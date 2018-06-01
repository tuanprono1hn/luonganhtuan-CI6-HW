import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerShoot {
    private int bulletcount;

    public List<BulletPlayer> bulletPlayers;

    public PlayerShoot(){
        this.bulletPlayers = new ArrayList<>();
    }

    public void run(Enemy enemy){
        //create bullet
        BulletPlayer bulletPlayer = new BulletPlayer();
        if (this.bulletcount == 10){
            bulletPlayer.position.set(enemy.position);
            bulletPlayer.velocity.set(3, 0);
            this.bulletPlayers.add(bulletPlayer);
            this.bulletcount = 0;
        } else {
            bulletcount += 1;
        }
    }
}
