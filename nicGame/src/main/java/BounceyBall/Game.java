package BounceyBall;


import Snake.Entity;
import Snake.Wall;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;
        import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel  implements Runnable, KeyListener {

    public static final int WIDTH=400;
    public static final int HEIGHT=400;
    ///render
    private Graphics2D g2d;
    private BufferedImage image;
    //Shooter.ShooterGame loop
    private Thread thread;
    private boolean running ;
    private long targetTime;
    //movement
    private int dx,dy;
    //key input
    private boolean up,right,left,down,start;
    //game parts
    private int SIZE=10;
    Wall wall,wall2;
    Entity head,apple,bomb,brick;
    ArrayList<Entity>snake;

    int score;
    private int level;
    public boolean gameOver;


    public Game(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }

    Ball ball = new Ball(this);

    public void move() {
        ball.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,//rounds out the curves of ball

                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);

    }
    @Override
    public void addNotify() {//tells you jpanel is done loading
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            thread.start();


        }
    }

    public void keyTyped(KeyEvent e) {


    }

    public void keyPressed(KeyEvent e) {
        int k=e.getKeyCode();
        if (k==KeyEvent.VK_UP)up=true;
        if (k==KeyEvent.VK_DOWN)down=true;
        if (k==KeyEvent.VK_RIGHT)right=true;
        if (k==KeyEvent.VK_LEFT)left=true;
        if (k==KeyEvent.VK_ENTER)start=true;

    }

    public void keyReleased(KeyEvent e) {
        int k=e.getKeyCode();
        if (k==KeyEvent.VK_UP)up=false;
        if (k==KeyEvent.VK_DOWN)down=false;
        if (k==KeyEvent.VK_RIGHT)right=false;
        if (k==KeyEvent.VK_LEFT)left=false;
        if (k==KeyEvent.VK_ENTER)start=false;

    }

    public void run() {
        if (running)return;
        init();
        long startTime;
        long elapsed;
        long wait;
        while (running ){
            startTime= System.nanoTime();

            update();
            requestRender();
            elapsed= System.nanoTime()-startTime;
            wait=targetTime-elapsed/1000000;
            if(wait>0){
                try{
                    Thread.sleep(wait);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }


    }
        private void init () {// initialize gameboard
            image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
            g2d = image.createGraphics();
            running = true;
            setUplevel();

        }
        public void setUplevel () {//function called above


            snake = new ArrayList<Entity>();//snake starts with 3 parts
            head = new Entity(SIZE);
            head.setPosition(WIDTH / 2, HEIGHT / 2);
            snake.add(head);

            for (int i = 1; i < 3; i++) {
                Entity e = new Entity(SIZE);
                e.setPosition(head.getX() + (i * SIZE), head.getY());
                snake.add(e);
            }


        }
        private void update () {
            if (gameOver) {
                if (start) {
                    setUplevel();
                }
                return;

            }
            if (up && dy == 0) {
                dy = -SIZE;
                dx = 0;
            }
            if (down && dy == 0) {
                dy = SIZE;
                dx = 0;
            }
            if (left && dx == 0) {
                dy = 0;
                dx = -SIZE;
            }
            if (right && dx == 0 && dy != 0) {
                dy = 0;
                dx = SIZE;
            }
            if (dx != 0 || dy != 0) {
                for (int i = snake.size() - 1; i > 0; i--) {
                    snake.get(i).setPosition(
                            snake.get(i - 1).getX()
                            , snake.get(i - 1).getY()
                    );
                }
                head.move(dx, dy);
            }


        }
    private void requestRender() {
        render(g2d);
        Graphics g = getGraphics();
        g.drawImage(image,0,0,null);
        g.dispose();

    }
    public void render(Graphics2D g2d){//specifics on what colors to make objects and what to print and where when needed

        g2d.clearRect(0,0,WIDTH,HEIGHT);
        g2d.setColor(Color.GREEN);
        for(Entity e:snake){
            e.render(g2d);
        }
        g2d.setColor(Color.RED);
//        apple.render(g2d);
        if(gameOver){
            g2d.drawString("GAME OVER",150,150);
        }
        g2d.setColor(Color.WHITE);
//        bomb.render(g2d);
//        brick.render(g2d);
//        wall.render(g2d);
//        wall2.render(g2d);
        g2d.drawString("SCORE:"+score+"LEVEL"+level,10,10);
        if(dx==0&&dy==0){
            g2d.drawString("READY!",150,150);
        }



    }


}