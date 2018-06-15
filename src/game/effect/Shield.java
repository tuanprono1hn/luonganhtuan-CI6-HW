package game.effect;

import base.GameObject;
import base.GameObjectManager;
import game.player.Player;
import physic.BoxCollider;
import physic.PhisicBody;

public class Shield extends GameObject implements PhisicBody {

    @Override
    public void run(){
        super.run();
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null){
            this.position.set(player.position);
        }
    }
    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }
}
