package game.star;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class StarSpawner extends GameObject {

    private FrameCounter frameCounter;
    private Random random;

    public StarSpawner(){
        this.random = new Random();
        this.frameCounter = new FrameCounter(30);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()){
            Star star = new Star();
            star.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            star.velocity.set(-this.random.nextInt(3)+1,0);
            GameObjectManager.instance.add(star);
            this.frameCounter.reset();
        }
    }
}
