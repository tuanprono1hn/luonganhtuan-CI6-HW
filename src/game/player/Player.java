package game.player;

import base.GameObject;
import base.Vector2D;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject {
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;

    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(
                Color.red,
                new Vector2D(),
                new Vector2D(0,16),
                new Vector2D(20,8)
        );
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
    }
    @Override
    public void run(){
        super.run();
        this.playerMove.run(this);
        this.playerShoot.run(this);
//        this.playerShoot.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.run());
        ((PolygonRenderer)this.renderer).angle = this.playerMove.angle;
    }

    public void render(Graphics graphics) {
        super.render(graphics);
//        this.playerShoot.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }

//    public void updatePolygon(){
//        this.polygon.reset();
////        base.Vector2D center = new base.Vector2D();
////        this.verties.forEach(vector2D -> center.addUp(vector2D));
////        center.multiply(1.0f/this.verties.size());
//
//        base.Vector2D center = this.verties
//                .stream()
//                .reduce(new base.Vector2D(), (v1, v2) -> v1.add(v2))
//                .multiply(1.0f/this.verties.size()).rotate(this.angle);
//        base.Vector2D translate = this.position.subtract(center);
////        List<base.Vector2D> newverties = new ArrayList<>();
////        this.verties.forEach(vector2D -> {
////            base.Vector2D newPosition = vector2D.add(translate);
////            newverties.add(newPosition);
////        });
////        List<base.Vector2D> newVerties = this.verties.stream().map(vector2D -> vector2D.add(translate)).collect(Collectors.toList());
//        this.verties.stream()
//                .map(vector2D -> vector2D.rotate(angle))
//                .map(vector2D -> vector2D.add(translate))
//                .forEach(vertex -> polygon.addPoint((int)vertex.x, (int)vertex.y));
//    }
}