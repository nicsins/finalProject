package Meowtovation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {
    OctoKitty p;
    Image img;
    Timer time;

    public Board(){
        p=new OctoKitty();
        addKeyListener(new AL());
        setFocusable(true);
        ImageIcon i=new ImageIcon("img/background1.jpg");
        img =i.getImage();
        time =new Timer(5,this);
        time.start();

    }
    public void actionPerformed(ActionEvent e){
        p.move();
        repaint();
    }
    public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2d= (Graphics2D) g;
        if(p.getX()==400)
            p.nx=0;
        if(p.getX()==300)
            p.nx2=0;

            g2d.drawImage(img,685-p.nx2,0,null);
            if(p.getX()>590){
                g2d.drawImage(img,685-p.nx2,0,null);
            }
        System.out.println(p.getX());
        g2d.drawImage(p.getImage(),175,p.getY(),null);


    }
    private class AL extends KeyAdapter{
        @Override
        public void keyReleased (KeyEvent e){
            p.keyReleased(e);

        }

        public void keyPressed(KeyEvent e){
            p.keyPressed(e);
        }
    }
}
