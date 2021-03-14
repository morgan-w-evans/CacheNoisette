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
    private JButton titleButton = new JButton(title);
    private JButton levels[] = new JButton[60];

    public Levels()
    {
        window.setTitle("Select Level");
        window.setSize(600, 625);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);

        panel.setSize(600,600);
        panel.setLocation(0, 0);
        panel.setLayout(null);

        panel.add(titleButton);
        titleButton.setSize(600, 200);
        titleButton.setLocation(0, 0);
        titleButton.setRolloverEnabled(false);
        titleButton.setBorderPainted(false);

        panel.add(buttonPanel);
        buttonPanel.setSize(600, 400);
        buttonPanel.setLocation(0,200);
        buttonPanel.setLayout(grid);

        for (int i = 0; i < 60; i++) {

            int j = i + 1;
            this.levels[i] = new JButton(""+j+"");
            buttonPanel.add(this.levels[i]);
            this.levels[i].addActionListener(this);
            this.levels[i].setBorderPainted(false);
            this.levels[i].setBackground(Color.GREEN.darker().darker());
            this.levels[i].setOpaque(true);
        }
        
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
            }
        }

        window.dispose();
    }
}