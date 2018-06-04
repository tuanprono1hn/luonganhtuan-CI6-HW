import java.util.ArrayList;
import java.util.List;

public class PlayerShoot {

    private int bullet = 0;

    public List<Bullet> bulletPlayers;

    public PlayerShoot() {
        this.bulletPlayers = new ArrayList<>();
    }

    public void run(Player player){
        Bullet bulletPlayer = new Bullet();
        if (this.bullet == 20){
            bulletPlayer.position.set(player.position);

            Vector2D rotate = player.playerMove.velocity.add(new Vector2D(2,0).rotate(player.playerMove.angle));

            bulletPlayer.velocity.set(rotate);
            this.bulletPlayers.add(bulletPlayer);
            this.bullet = 0;
        } else {
            bullet += 1;
        }
    }
}
