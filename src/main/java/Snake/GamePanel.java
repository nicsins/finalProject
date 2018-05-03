package Snake;



import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;



public class GamePanel extends JPanel implements Runnable, KeyListener {

    public static final int WIDTH=400;
    public static final int HEIGHT=400;
    ///render
    private Graphics2D g2d;
    private BufferedImage image;
    //Shooter.ShooterGame loop
    private Thread thread;
    private boolean running ;
    private long targetTime;

    //Shooter.ShooterGame Stuff
    private int SIZE=10;
    Wall wall,wall2;
    Entity head,apple,bomb,brick;
    ArrayList<Entity>snake;


    int score;
    private int level;
    public boolean gameOver;
    //movement
    private int dx,dy;
   //key input
   private boolean up,right,left,down,start;


    public GamePanel(){
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



    private void init(){// initialize gameboard
        image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
        g2d=image.createGraphics();
            running=true;
            setUplevel();

        }
    public void setUplevel(){//function called above
        snake=new ArrayList<Entity>();//snake starts with 3 parts
        head =new Entity(SIZE);
        head.setPosition(WIDTH/2,HEIGHT/2);
        snake.add(head);

        for (int i=1;i<3;i++){
            Entity e=new Entity(SIZE);
            e.setPosition(head.getX()+(i*SIZE),head.getY());
            snake.add(e);
        }
        apple =new Entity(SIZE);
        setApple();
        brick=new Entity(2*SIZE);
        setBrick();
        bomb=new Entity(SIZE);
        setBomb();
        wall=new Wall(10,100);
        setWall();
        wall2=new Wall(150,10);
        setWall();



        score=0;
        gameOver=false;
        level=1;
        dx=dy=0;
        setFPS(level*10);

    }
    public void setApple(){
        int x=(int)(Math.random()*( WIDTH-SIZE));
        int y=(int)(Math.random()*( HEIGHT-SIZE));
        x=x-(x%SIZE);
        y=y-(y%SIZE);

        apple.setPosition(x,y);


    }

    //create obstacles....
    public void setBomb(){

        int x=(int)(Math.random()*( WIDTH-SIZE));
        int y=(int)(Math.random()*( HEIGHT-SIZE));
        x=x-(x%SIZE);
        y=y-(y%SIZE);

        bomb.setPosition(x,y);

    }
    public void setBrick(){

        int x=(int)(Math.random()*( WIDTH-SIZE));
        int y=(int)(Math.random()*( HEIGHT-SIZE));
        x=x-(x%SIZE);
        y=y-(y%SIZE);

        brick.setPosition(x,y);

    }
    public void setWall(){

        int x=(int)(Math.random()*( WIDTH-SIZE));
        int y=(int)(Math.random()*( HEIGHT-SIZE));
        x=x-(x%SIZE);
        y=y-(y%SIZE);

        wall.setPosition(x,y);


    }
    public void setWall2(){

        int x=(int)(Math.random()*( WIDTH-SIZE));
        int y=(int)(Math.random()*( HEIGHT-SIZE));
        x=x-(x%SIZE);
        y=y-(y%SIZE);

        wall2.setPosition(x,y);


    }





    private void requestRender() {
        render(g2d);
        Graphics g = getGraphics();
        g.drawImage(image,0,0,null);
        g.dispose();

    }
    public void setFPS(int fps) {
        targetTime=1000/fps;;
    }
    private void update(){
        if(gameOver){
            if(start){
                setUplevel();
            }return;

        }
        if(up && dy == 0){
            dy = -SIZE;
            dx = 0;
        }if(down && dy == 0){
            dy = SIZE;
            dx = 0;
        }if(left && dx == 0){
            dy = 0;
            dx = -SIZE;
        }if(right && dx==0&& dy!=0){
            dy = 0;
            dx = SIZE;
        }
        if(dx!=0|| dy!=0) {
            for (int i = snake.size() - 1; i > 0; i--) {
                snake.get(i).setPosition(
                        snake.get(i - 1).getX()
                        , snake.get(i - 1).getY()
                );
            }
            head.move(dx, dy);
        }

        for(Entity e:snake){//game logic what happens if head hits something..
            if (e.isCollision(head)){
                gameOver=true;
                break;
            }

        }
        if(bomb.isCollision(head)){
            gameOver=true; }
        if(brick.isCollision(head)){
            gameOver=true;
            }
        if(wall.isCollision(head)){
            gameOver=true;
            }
        if(wall2.isCollision(head)){
            gameOver=true;
            }

        if (apple.isCollision(head)){
            score++;
            setApple();
            Entity e=new Entity(SIZE);
            e.setPosition(-100,-100);
            snake.add(e);
            setBomb();
            setBrick();
            setWall();
            setWall2();
            if (score%10==0){
                level++;
                if(level>10)level=10;
                setFPS(level*10);


            }
        }

        if(head.getX()<0)head.setX(WIDTH);
        if(head.getY()<0)head.setY(HEIGHT);
        if(head.getX()>WIDTH)head.setX(0);
        if(head.getY()>HEIGHT)head.setY(0);



    }
    public void render(Graphics2D g2d){//specifics on what colors to make objects and what to print and where when needed

        g2d.clearRect(0,0,WIDTH,HEIGHT);
        g2d.setColor(Color.GREEN);
        for(Entity e:snake){
             e.render(g2d);
        }
        g2d.setColor(Color.RED);
        apple.render(g2d);
        if(gameOver){
            g2d.drawString("GAME OVER",150,150);
        }
        g2d.setColor(Color.WHITE);
        bomb.render(g2d);
        brick.render(g2d);
        wall.render(g2d);
        wall2.render(g2d);
        g2d.drawString("SCORE:"+score+"LEVEL"+level,10,10);
        if(dx==0&&dy==0){
            g2d.drawString("READY!",150,150);
        }



    }


}
