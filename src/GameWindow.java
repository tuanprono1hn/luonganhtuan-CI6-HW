import input.KeyboardInput;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    long lastTime = 0;

    public GameWindow() {
        this.setSize(1024, 600); //set size window
        this.setupGameCanvas();
        this.event();
        this.setVisible(true); //hien thi sua so
    }

    private void setupGameCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void event() {
        this.keyboardEvent();
        this.windowEvent();
    }

    private void keyboardEvent() {
        this.addKeyListener(KeyboardInput.instance);
//        this.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//                    gameCanvas.player.playerMove.angle -= 5.0;
//                }
//                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//                    gameCanvas.player.playerMove.angle += 5.0;
//                }
//
//                base.Vector2D rotate = (new base.Vector2D(3.5f,0)).rotate(gameCanvas.player.playerMove.angle);
//                gameCanvas.player.playerMove.velocity.set(rotate);
//                if (e.getKeyCode() == KeyEvent.VK_UP) {
//                    base.Vector2D boost = (new base.Vector2D(5,0)).rotate((gameCanvas.player.playerMove.angle));
//                    gameCanvas.player.playerMove.velocity.set(boost);
//                }
////                else {
////                    base.Vector2D rotate = (new base.Vector2D(3.5f,0)).rotate(gameCanvas.player.angle);
////                    gameCanvas.player.velocity.set(rotate);
////                }
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_UP){
//                    base.Vector2D rotate = (new base.Vector2D(3.5f,0)).rotate(gameCanvas.player.playerMove.angle);
//                    gameCanvas.player.playerMove.velocity.set(rotate);
//                }
//            }
//        });
    }

    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }
    public void gameLoop(){
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}