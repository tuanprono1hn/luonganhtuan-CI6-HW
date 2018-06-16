package game.star;

import Actions.*;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class StarSpawner extends GameObject {

    private FrameCounter frameCounter;
    private Random random;

    public StarSpawner(){
        this.random = new Random();
        this.createAction();
//        this.frameCounter = new FrameCounter(30);
    }

    public void createAction(){
//        Action waitAction = new WaitAction(50);
//        Action createAction = new ActionAdapter() {
//            @Override
//            public boolean run(GameObject owner) {
//                Star star = GameObjectManager.instance.recycle(Star.class);
//                star.position.set(random.nextInt(1024), random.nextInt(600));
//                star.velocity.set(-1,0);
//                return true;
//            }
//        };
//        Action sequenceAction = new SequenceAction(waitAction,createAction);
//        Action repeatAction = new RepeatActionForever(sequenceAction);
//
//        this.addAction(repeatAction);

//        this.addAction(
//                new RepeatActionForever(
//                        new SequenceAction(
//                                new WaitAction(30),
//                                new ActionAdapter() {
//                                    @Override
//                                    public boolean run(GameObject owner){
//                                        Star star = GameObjectManager.instance.recycle(Star.class);
//                                        star.position.set(random.nextInt(1024), random.nextInt(600));
//                                        star.velocity.set(-1,0);
//                                        return true;
//                                    }
//                                }
//                        )
//                )
//        );

        this.addAction(
                new LimitAction(
                        new SequenceAction(
                                new WaitAction(30),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner){
                                        Star star = GameObjectManager.instance.recycle(Star.class);
                                        star.position.set(random.nextInt(1024), random.nextInt(600));
                                        star.velocity.set(-1,0);
                                        return true;
                                    }
                                }
                        ),
                        2
                )
        );
    }

    @Override
    public void run() {
        super.run();
//        if (this.frameCounter.run()){
//            Star star = new Star();
//            star.position.set(this.random.nextInt(1024), this.random.nextInt(600));
//            star.velocity.set(-1,0);
//            GameObjectManager.instance.add(star);
//            this.frameCounter.reset();
//        }
    }
}
