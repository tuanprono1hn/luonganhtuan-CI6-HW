import java.awt.*;

public class Background {
    public Vector2D position;
    public int width;
    public int height;
    public Color color;

    public Background() {
        this.position = new Vector2D();
//        this.width = width;
//        this.height = height;
//        this.color = color;
    }

    public void render(Graphics graphics){
        graphics.setColor(this.color);
        graphics.fillRect((int)this.position.x, (int)this.position.y,1024,600);
    }
}
