package game1;
import java.awt.*;
import javax.swing.*;


public class ImageBackground extends JFrame{
    private ImageIcon image1;
    private JLabel label1;
    private ImageIcon image2;
    private JLabel label2;

    ImageBackground(){
        setLayout(new FlowLayout());
        image1=new ImageIcon(getClass().getResource("background1.png"));
        label1=new JLabel(image1);
        add(label1);

        image2=new ImageIcon(getClass().getResource("Kitty.jpg"));
        label2=new JLabel(image2);
        add(label2);

    }

    public static void main(String[] args) {
        ImageBackground gui = new ImageBackground();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.pack();
        gui.setTitle("Images");
    }
}
