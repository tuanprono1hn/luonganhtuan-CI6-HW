package game.background;

import base.GameObject;
import base.Vector2D;
import renderer.BackgroundRenderer;

import java.awt.*;

public class Background extends GameObject {

    public Background() {
        this.position = new Vector2D();
        this.renderer = new BackgroundRenderer(Color.black,1024,600);
    }

//    public void render(Graphics graphics){
//        this.renderer.render(graphics,this.position);
//    }
}
