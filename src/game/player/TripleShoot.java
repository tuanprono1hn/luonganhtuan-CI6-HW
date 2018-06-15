package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
//import game.bullet.Bullet;
import game.bullet.BulletPlayer;

public class TripleShoot implements Shoot {
    @Override
    public void shoot(Player player) {
        for (double alpha = 0.0; alpha <= 360.0; alpha += 120.0){
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);

            Vector2D rotate = player.playerMove.velocity.add(
                    (new Vector2D(2,0)).rotate(player.playerMove.angle)
            );

            bulletPlayer.velocity.set(rotate);
            GameObjectManager.instance.add(bulletPlayer);
        }
    }
}
