package base;

import game.bullet.Bullet;
import game.enemy.Enemy;
import game.player.Player;
import physic.BoxCollider;
import physic.PhisicBody;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//singleton

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    private List<GameObject> list;
    private List<GameObject> templist;

    private GameObjectManager(){
        this.list = new ArrayList<>();
        this.templist = new ArrayList<>();
    }

    public void add(GameObject gameObject){
        this.templist.add(gameObject);
    }

    public void runAll(){

        this.list.forEach(gameObject -> gameObject.run());
    }

    public void renderAll(Graphics graphics){
        this.list.stream().filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics));
        this.list.addAll(this.templist);
        this.templist.clear();
    }

    public Player findPlayer(){
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElse(null);
    }

//    public Enemy checkCollision(Bullet bullet){
//        return (Enemy) this.list
//                .stream()
//                .filter(gameObject -> gameObject.isAlive)
//                .filter(gameObject -> gameObject instanceof Enemy)
//                .filter(gameObject -> {
//                    BoxCollider other = ((Enemy) gameObject).boxCollider;
//                    return bullet.boxCollider.checkBoxCollider(other);
//                })
//                .findFirst()
//                .orElse(null);
//    }

    public <T extends GameObject> T checkCollision(BoxCollider boxCollider, Class<T> cls){
        return (T) this.list.stream().filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject) )
                .filter(gameObject -> gameObject instanceof PhisicBody)
                .filter(gameObject -> {
                    BoxCollider other = ((PhisicBody)gameObject).getBoxCollider();
                    return boxCollider.checkBoxCollider(other);
                })
                .findFirst()
                .orElse(null);
    }

    public <T extends GameObject> T recycle(Class<T> cls){
        T object = (T) this.list.stream()
                .filter(gameObject -> !gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject))
                .findFirst()
                .orElse(null);
        if (object != null){
            object.isAlive = true;
        } else {
            try {
                object = cls.newInstance();
                this.add(object);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return object;
    }
}
