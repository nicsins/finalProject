package OurGame;
import  java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Dude {
    int x, dx, y;
    Image Dude;


    public Dude() {
        ImageIcon i= new ImageIcon("C:OurGame.img/Dude.jpg");
        Dude =i.getImage();
        x=10;
        x=172;

    }
    public void move(){
        x = x+ dx;

    }
    public int getX(){
        return x;
    }
    public int getY(){
        return  y;
    }
    public Image getImage(){
        return Dude;
    }

        public void keyReleased (KeyEvent e){
           int key =e.getKeyCode();
            if (key==KeyEvent.VK_LEFT);
            dx=-1;
            if (key==KeyEvent.VK_RIGHT);
            dx=1;

        }
        public void keyPressed(KeyEvent e){
            int key =e.getKeyCode();
            if (key==KeyEvent.VK_LEFT);
            dx=0;
            if (key==KeyEvent.VK_RIGHT);
            dx=0;
        }
    }


