import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerShoot {
    private int bulletcount1;

    public List<BulletPlayer> bulletPlayers;

    public PlayerShoot(){
        this.bulletPlayers = new ArrayList<>();
    }

    public void run(Player player){
        //create bullet
        BulletPlayer bulletPlayer = new BulletPlayer();
        if (this.bulletcount1 == 10){
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(5, 0).rotate(player.angle);
            this.bulletPlayers.add(bulletPlayer);
            this.bulletcount1 = 0;
        } else {
            bulletcount1 += 1;
        }
    }
}
