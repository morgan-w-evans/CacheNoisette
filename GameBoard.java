import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBoard
{
    private JFrame window = new JFrame();
    private JPanel outerPanel = new JPanel();
    private JPanel innerPanel = new JPanel();
    private GridLayout innerLayout = new GridLayout(4, 4);

    private Picture upArrow = new Picture("BigArrow.png", 0);
    private Picture downArrow = new Picture("BigArrow.png", 180);
    private Picture leftArrow = new Picture("Arrow.png", 270);
    private Picture rightArrow = new Picture("Arrow.png", 90);

    private Picture emptyBoxPicture = new Picture("Empty.png", 0);
    private Picture holeBoxPicture = new Picture("Hole.png", 0);
    private JButton emptyBox = new JButton(emptyBoxPicture);
    private JButton holeBox = new JButton(holeBoxPicture);

    private JButton upButton = new JButton(upArrow);
    private JButton downButton = new JButton(downArrow);
    private JButton leftButton = new JButton(leftArrow);
    private JButton rightButton = new JButton(rightArrow);

    public GameBoard()
    {
        window.setTitle("Cache Noisettes!");
        window.setSize(600, 630);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        innerPanel.setLayout(innerLayout);

        innerPanel.add(emptyBox);
        innerPanel.add(emptyBox);
        innerPanel.add(holeBox);
        innerPanel.add(emptyBox);
        innerPanel.add(holeBox);
        innerPanel.add(emptyBox);
        innerPanel.add(emptyBox);
        innerPanel.add(emptyBox);
        innerPanel.add(emptyBox);
        innerPanel.add(holeBox);
        innerPanel.add(emptyBox);
        innerPanel.add(emptyBox);
        innerPanel.add(emptyBox);
        innerPanel.add(emptyBox);
        innerPanel.add(emptyBox);
        innerPanel.add(holeBox);

        outerPanel.setLayout(null);

        outerPanel.add("North", upButton);
        upButton.setLocation(0,0);
        upButton.setSize(600,100);
        upButton.setRolloverEnabled(false);
        upButton.setBorderPainted(false);

        outerPanel.add("South", downButton);
        downButton.setLocation(0,500);
        downButton.setSize(600,100);
        downButton.setRolloverEnabled(false);
        downButton.setBorderPainted(false);

        outerPanel.add ("East", rightButton);
        rightButton.setLocation(500,100);
        rightButton.setSize(100,400);
        rightButton.setRolloverEnabled(false);
        rightButton.setBorderPainted(false);

        outerPanel.add("West", leftButton);
        leftButton.setLocation(0,100);
        leftButton.setSize(100,400);
        leftButton.setRolloverEnabled(false);
        leftButton.setBorderPainted(false);

        outerPanel.add("Center", innerPanel);
        innerPanel.setLocation(100,100);
        innerPanel.setSize(400,400);

        window.setContentPane(outerPanel);

        window.setVisible(true);

    }

    public void actionPerformned(ActionEvent e)
    {
        if(e.getSource()==upButton)
        {
            return;
        }

        if(e.getSource()==downButton)
        {
            return;
        }

        if(e.getSource()==leftButton)
        {
            return;
        }

        if(e.getSource()==rightButton)
        {
            return;
        }
    }
}