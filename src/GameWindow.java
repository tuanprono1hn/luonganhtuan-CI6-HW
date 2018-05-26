import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//                    gameCanvas.positionXplayer -= 3;
                    gameCanvas.player.run("left",1024,600);

                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//                    gameCanvas.positionXplayer += 3;
                    gameCanvas.player.run("right",1024,600);
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
//                    gameCanvas.positionYplayer -= 3;
                    gameCanvas.player.run("up",1024,600);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//                    gameCanvas.positionYplayer += 3;
                    gameCanvas.player.run("down",1024,600);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
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
//                this.gameCanvas.positionXenemy += 2;
//                this.gameCanvas.positionYenemy += 1;
//                this.gameCanvas.positionXplayer += 2;
//                this.gameCanvas.positionYplayer += 2;
//                this.gameCanvas.repaint();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}