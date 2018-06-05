import java.awt.*;

public class Background extends GameObject{

    public Background() {
        this.position = new Vector2D();
        this.renderer = new BackgroundRenderer(Color.black,1024,600);
    }

//    public void render(Graphics graphics){
//        this.renderer.render(graphics,this.position);
//    }
}
