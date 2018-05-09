package Shooter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Panel extends JPanel implements Runnable,KeyListener {
    //sets up size
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    ///render
    private Graphics2D g2d;
    private BufferedImage image;
    //Shooter.ShooterGame loop
    private Thread thread;
    private boolean running;
    private long targetTime;

    //movement
    private int dx, dy;
    //key input
    private boolean up, right, left, down, start;


    public Panel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }

    @Override
    public void addNotify() {//tells you jpanel is done loading
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            thread.start();


        }
    }
    public void setFPS(int fps) {
        targetTime=1000/fps;;
    }


    public void keyTyped(KeyEvent e) {


    }

    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        if (k == KeyEvent.VK_UP) up = true;
        if (k == KeyEvent.VK_DOWN) down = true;
        if (k == KeyEvent.VK_RIGHT) right = true;
        if (k == KeyEvent.VK_LEFT) left = true;
        if (k == KeyEvent.VK_ENTER) start = true;

    }

    public void keyReleased(KeyEvent e) {
        int k = e.getKeyCode();
        if (k == KeyEvent.VK_UP) up = false;
        if (k == KeyEvent.VK_DOWN) down = false;
        if (k == KeyEvent.VK_RIGHT) right = false;
        if (k == KeyEvent.VK_LEFT) left = false;
        if (k == KeyEvent.VK_ENTER) start = false;

    }

    private void init(){
        image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
        g2d=image.createGraphics();
        running=true;
        setUplevel();

    }

    private void setUplevel() {
    }

    public void run() {
        if (running) return;
        init();
        long startTime;
        long elapsed;
        long wait;
        while (running) {
            startTime = System.nanoTime();

            update();
            requestRender();
            elapsed = System.nanoTime() - startTime;
            wait = targetTime - elapsed / 1000000;
            if (wait > 0) {
                try {
                    Thread.sleep(wait);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }
    private void update(){

    }

    private void requestRender() {
        render(g2d);
        Graphics g = getGraphics();
        g.drawImage(image,0,0,null);
        g.dispose();
    }


    public void render(Graphics2D g2d) {

        g2d.clearRect(0, 0, WIDTH, HEIGHT);

    }

}
