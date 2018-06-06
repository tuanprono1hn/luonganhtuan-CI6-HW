package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;

public class PlayerShoot {

    private FrameCounter frameCounter;


    public PlayerShoot() {
        this.frameCounter = new FrameCounter(10);
    }

    public void run(Player player){
        Bullet bulletPlayer = new Bullet();
        if (this.frameCounter.run()){
            bulletPlayer.position.set(player.position);

            Vector2D rotate = player.playerMove.velocity.add(new Vector2D(2,0).rotate(player.playerMove.angle));

            bulletPlayer.velocity.set(rotate);
            GameObjectManager.instance.add(bulletPlayer);
            this.frameCounter.reset();
        }
    }
}
