import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HowToPlay
{
    private JFrame window = new JFrame();
    private JPanel panel = new JPanel();
    private Picture picture = new Picture("icons/HowToPlayImage.png", 0);
    private JButton button = new JButton(picture);

    public HowToPlay()
    {
        window.setTitle("How To Play");
        window.setSize(1200, 825);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setSize(1200,800);
        panel.setLocation(0, 0);
        panel.setLayout(null);

        panel.add(button);
        button.setSize(1200, 800);
        button.setLocation(0,0);
        button.setRolloverEnabled(false);
        button.setBorderPainted(false);
        
        window.setContentPane(panel);
        window.setVisible(true);
    }
}