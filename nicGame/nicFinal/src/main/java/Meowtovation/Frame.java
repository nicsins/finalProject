package Meowtovation;

import javax.swing.*;

public class Frame {
    public static void main(String[] args) {
        JFrame frame=new JFrame("2D GamePanel");
        frame.add(new Board());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300,1200);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
