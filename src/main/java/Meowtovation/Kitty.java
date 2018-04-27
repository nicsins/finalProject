package Meowtovation;
import  java.awt.Image;
import javax.swing.*;
import java.awt.event.KeyEvent;

public class Kitty {
    int x,left, dx, y, nx2,nx;
    Image Dude;


    public Kitty() {
        ImageIcon i= new ImageIcon("img/Kitty.jpg");
        Dude =i.getImage();
        x=125;
        left=100;
        nx2=685;
        nx=0;
        y=25;

    }
    public void move() {
        if (dx != -1) {
            if (left + dx >= 150)
                left += dx;
            else {
                x = x + dx;

                nx2 = nx2 + dx;
                nx = nx + dx;
            }
        } else


        {
            if (left + dx > 0)
                left = left + dx;
        }
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

        public void keyPressed (KeyEvent e){
           int key =e.getKeyCode();
            if (key==KeyEvent.VK_LEFT);
            dx=-1;
            if (key==KeyEvent.VK_RIGHT);
            dx=1;

        }
        public void keyReleased(KeyEvent e){
            int key =e.getKeyCode();
            if (key==KeyEvent.VK_LEFT);
            dx=0;
            if (key==KeyEvent.VK_RIGHT);
            dx=0;
        }
    }


