package Shooter;

import Game1.GamePanel;

import  javax.swing.JFrame;

public class ShooterGame {
    public static void main(String[] args) {
        JFrame window =new JFrame("First Shooter.ShooterGame");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new GamePanel());
        window.pack();
        window.setVisible(true);
    }
}
