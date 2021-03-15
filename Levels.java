import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Levels implements ActionListener
{
    private JFrame window = new JFrame();
    private JPanel panel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private GridLayout grid = new GridLayout(10, 6);
    private Picture title = new Picture("icons/Title.png", 0);
    private Picture closeImage = new Picture("icons/Close.png", 0);
    private Picture blankImage = new Picture("icons/Blank.png", 0);
    private Picture blankLong = new Picture("icons/Blank.png", 90);
    private JButton titleButton = new JButton(title);
    private JButton levels[] = new JButton[60];
    private JButton close = new JButton(closeImage);
    private JButton blank = new JButton(blankImage);
    private JButton blank2 = new JButton(blankImage);
    private JButton blankLeft = new JButton(blankLong);
    private JButton blankRight = new JButton(blankLong);

    public Levels()
    {
        window.setTitle("Select Level");
        window.setSize(600, 725);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        panel.setSize(600,700);
        panel.setLocation(0, 0);
        panel.setLayout(null);

        panel.add(titleButton);
        titleButton.setSize(600, 200);
        titleButton.setLocation(0, 0);
        titleButton.setRolloverEnabled(false);
        titleButton.setBorderPainted(false);

        panel.add(buttonPanel);
        buttonPanel.setSize(560, 400);
        buttonPanel.setLocation(20,200);
        buttonPanel.setLayout(grid);
        buttonPanel.setBorder(null);

        for (int i = 0; i < 60; i++) {

            int j = i + 1;
            this.levels[i] = new JButton(""+j+"");
            buttonPanel.add(this.levels[i]);
            this.levels[i].addActionListener(this);
            this.levels[i].setBorderPainted(false);
            this.levels[i].setBackground(Color.BLACK);
            this.levels[i].setForeground(Color.RED);
            this.levels[i].setOpaque(true);
        }

        panel.add(close);
        close.setSize(300, 100);
        close.setLocation(150, 600);
        close.setRolloverEnabled(false);
        close.setBorderPainted(false);
        close.addActionListener(this);

        panel.add(blankLeft);
        blankLeft.setSize(20, 400);
        blankLeft.setLocation(0, 200);
        blankLeft.setRolloverEnabled(false);
        blankLeft.setBorderPainted(false);

        panel.add(blankRight);
        blankRight.setSize(20, 400);
        blankRight.setLocation(580, 200);
        blankRight.setRolloverEnabled(false);
        blankRight.setBorderPainted(false);
        
        panel.add(blank);
        blank.setSize(150, 100);
        blank.setLocation(0, 600);
        blank.setRolloverEnabled(false);
        blank.setBorderPainted(false);

        panel.add(blank2);
        blank2.setSize(150, 100);
        blank2.setLocation(450, 600);
        blank2.setRolloverEnabled(false);
        blank2.setBorderPainted(false);
        
        window.setContentPane(panel);
        window.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        int j = 0;
        
        for (int i = 0; i < 60; i++) {

            j++;

            if (e.getSource() == this.levels[i]) {

                LevelStore l = new LevelStore(j);
                window.dispose();
            }
        }

        if (e.getSource() == close) {

            GUI g = new GUI();
            window.dispose();
        }
    }
}