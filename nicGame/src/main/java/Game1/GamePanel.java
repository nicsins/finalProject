package Game1;

import Shooter.Player;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;

public class GamePanel extends JPanel implements Runnable, KeyListener {
    //fields
    public static int WIDTH = 400;
    public static int HEIGHT = 400;
    private Thread thread;// create thread to start game
    private boolean running;

    private BufferedImage image;
    private Graphics2D g;
    private int FPS = 30;
    private double averageFPS;
    private Player player;

    //  constructor
    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify() {//tells you jpanel is done loading
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            thread.start();


        }
        addKeyListener(this);
    }

    public void run() {
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        player = new Player();
        long startTime;
        long URDTimeMillis;
        long waitTime;
        long totalTime = 0;

        int frameCount = 0;
        int maxFrameCount = 30;
        long targetTime = 1000 / FPS;
        // amount of time it takes for one loop to run in order to maintain 30 fps
        // game loop
        while (running) {
            startTime = System.nanoTime();
            gameUpdate();
            gameRender();
            gameDraw();
            URDTimeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - URDTimeMillis;

            try {
                Thread.sleep(waitTime);
            } catch (Exception e) {
            }
            totalTime += System.nanoTime() - startTime;
            frameCount++;
            if (frameCount == maxFrameCount) {//adds sppeedlimit on game lop
                averageFPS = 1000.0 / ((totalTime / frameCount) / 1000000);
                frameCount = 0;
                totalTime = 0;
            }

        }
    }

    private void gameUpdate() {
        player.update();

    }

    private void gameRender() {// draws to offscreen immage double buiffer ing
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.drawString("FPS:" + averageFPS, 10, 10);
        g.setColor(Color.YELLOW);
        player.draw(g);
        player.setPosition(50,50);
    }

    private void gameDraw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();

    }
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e) {
        int keyCode=e.getKeyCode();
        if(keyCode==KeyEvent.VK_LEFT){
            player.setLeft(true);
        }
        if (keyCode==KeyEvent.VK_RIGHT){
            player.setRight(true);
        }
        if (keyCode==KeyEvent.VK_UP){
            player.setUp(true);
        }
        if (keyCode==KeyEvent.VK_DOWN){
            player.setDown(true);
        }
    }

    public void keyReleased(KeyEvent e) {
        int keyCode=e.getKeyCode();
        if(keyCode==KeyEvent.VK_LEFT){
            player.setLeft(false);
        }
        if (keyCode==KeyEvent.VK_RIGHT){
            player.setRight(false);
        }
        if (keyCode==KeyEvent.VK_UP){
            player.setUp(false);
        }
        if (keyCode==KeyEvent.VK_DOWN){
            player.setDown(false);
        }
    }
}