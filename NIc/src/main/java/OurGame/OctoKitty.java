package OurGame;
import  java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OctoKitty {
    int x,left, dx, y, nx2,nx;

    Image Dude;


    public OctoKitty() {
        ImageIcon i= new ImageIcon("img/octogif.gif");
        Dude =i.getImage();
        x=400;
        left=-100;
        nx2=905;
        nx=0;
        y=700;

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

            if (e.getKeyCode()==KeyEvent.VK_LEFT){
            dx=-2;}
            if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            dx=1;}
            if(e.getKeyCode()==KeyEvent.VK_UP) {

            }

        }
        public void keyReleased(KeyEvent e){

            dx=0;
        }
    }


