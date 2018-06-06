package base;

import game.bullet.Bullet;
import game.enemy.Enemy;
import game.player.Player;
import physic.BoxCollider;

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

    public Enemy checkCollision(Bullet bullet){
        return (Enemy) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Enemy)
                .filter(gameObject -> {
                    BoxCollider other = ((Enemy) gameObject).boxCollider;
                    return bullet.boxCollider.checkBoxCollider(other);
                })
                .findFirst()
                .orElse(null);
    }
}
