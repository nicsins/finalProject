package Shooter;

import Game1.GamePanel;

import java.awt.*;

public class Player {
   private int x,y,r,dx,dy,speed;

   private boolean left,right,up,down;

    public void setLeft(boolean b) {
        this.left = b;
    }

    public void setRight(boolean b) {
        this.right = b;
    }

    public void setUp(boolean b) {
        this.up = b;
    }

    public void setDown(boolean b) {
        this.down = b;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    public void setPosition(int x,int y){
        this.x=x;
        this.y=y;
    }


   private int lives;
   private Color color1;
   private Color color2;

   public Player(){

       x= GamePanel.WIDTH /2;
       y=GamePanel.HEIGHT/2;
       dx=0;
       dy=0;
       speed=5;
       lives=3;
        color1=Color.BLUE;
        color2=Color.RED;
   }

   //Functions
    public void update(){
       if(left) { dx = -speed;
       }
       if(right){ dx=speed;
       }
       if (up) { dy = -speed;
       }
       if (down) { dy = speed;
       }
       x+=dx;
       y+=dy;
       if(x<r)x=r;
       if(y<r)y=r;
       if (x<GamePanel.WIDTH-r)x=GamePanel.WIDTH-r;
       if (y<GamePanel.HEIGHT-r)y=GamePanel.HEIGHT-r;
        dx=0;
        dy=0;


    }
    public void draw(Graphics2D g){
       g.setColor(color1);
       g.fillOval(x-r,y-r,2*r,2*r);

       g.setStroke(new BasicStroke(3));
       g.setColor(color1.darker());
       g.drawOval(x-r,y-r,2*r,2*r);
       g.setStroke(new BasicStroke(1));

    }


}

