package game.player;

import base.Vector2D;
import input.KeyboardInput;

import java.util.Random;

public class PlayerMove {

    public Vector2D velocity;
    private Random random;
    public double angle = 0.0;

    public PlayerMove() {
        this.velocity = new Vector2D();
        this.random = new Random();
    }

    public void run(Player player){
        player.position.addUp(this.velocity);
        if (KeyboardInput.instance.leftPressed){
            this.angle -= 5.0;
        }
        if (KeyboardInput.instance.rightPressed){
            this.angle += 5.0;
        }
        Vector2D rotate = (new Vector2D(3.5f,0)).rotate(this.angle);
        this.velocity.set(rotate);
        if (KeyboardInput.instance.upPressed) {
            Vector2D boost = (new Vector2D(5,0)).rotate((this.angle));
            this.velocity.set(boost);
        }
        if (KeyboardInput.instance.upReleased){
//            base.Vector2D rotate = (new base.Vector2D(3.5f,0)).rotate(this.angle);
            this.velocity.set(rotate);
        }
        this.backToScreen(player);
    }

    private void backToScreen(Player player){
        if (player.position.x > 1024){
            player.position.set(0, this.random.nextInt(600));
        }
        if (player.position.x < 0){
            player.position.set(1024, this.random.nextInt(600));
        }
        if (player.position.y > 600){
            player.position.set(this.random.nextInt(1024), 0);
        }
        if (player.position.y < 0){
            player.position.set(this.random.nextInt(1024), 600);
        }
    }
}
