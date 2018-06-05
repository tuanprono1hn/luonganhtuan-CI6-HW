import java.util.ArrayList;
import java.util.List;

public class PlayerShoot {

    private FrameCounter frameCounter;

    public List<Bullet> bulletPlayers;

    public PlayerShoot() {
        this.bulletPlayers = new ArrayList<>();
        this.frameCounter = new FrameCounter(10);
    }

    public void run(Player player){
        Bullet bulletPlayer = new Bullet();
        if (this.frameCounter.run()){
            bulletPlayer.position.set(player.position);

            Vector2D rotate = player.playerMove.velocity.add(new Vector2D(2,0).rotate(player.playerMove.angle));

            bulletPlayer.velocity.set(rotate);
            this.bulletPlayers.add(bulletPlayer);
            this.frameCounter.reset();
        }
        this.bulletPlayers.forEach(bullet -> bullet.run());
    }
}
