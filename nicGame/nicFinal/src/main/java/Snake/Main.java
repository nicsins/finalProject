package Snake;
;


import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame=new JFrame("Snake");
        frame.setContentPane(new GamePanel());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(GamePanel.WIDTH,GamePanel.HEIGHT));//game panel stays same size
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
