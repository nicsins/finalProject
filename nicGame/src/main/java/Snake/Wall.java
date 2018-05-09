package Snake;

import java.awt.*;

public class Wall {
    private int x,y,length,width;


    public Wall(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public  void setPosition(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void move(int dx,int dy){
        x+=dx;
        y+=dy;
    }
    public Rectangle getBound(){
        return new Rectangle(x,y,length,width);
    }

    public boolean isCollision(Entity o){

        return getBound().intersects(o.getBound());
    }
    public void render(Graphics2D g2d){
        g2d.fillRect(x+1,y+1,length,width);
    }
}
