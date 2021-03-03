import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBoard
{
    private JFrame window = new JFrame();
    private JPanel outerPanel = new JPanel();
    private JPanel innerPanel = new JPanel();
    private GridLayout innerLayout = new GridLayout(4, 4);

    private Picture upArrow = new Picture("icons/BigArrow.png", 0);
    private Picture downArrow = new Picture("icons/BigArrow.png", 180);
    private Picture leftArrow = new Picture("icons/Arrow.png", 270);
    private Picture rightArrow = new Picture("icons/Arrow.png", 90);

    private Picture emptyBoxPicture = new Picture("icons/Empty.png", 0);
    private Picture holeBoxPicture = new Picture("icons/Hole.png", 0);
    private JButton emptyBox[] = new JButton[12];
    private JButton holeBox[] = new JButton[4];

    private JButton upButton = new JButton(upArrow);
    private JButton downButton = new JButton(downArrow);
    private JButton leftButton = new JButton(leftArrow);
    private JButton rightButton = new JButton(rightArrow);

    private ArrowButton arrow;

    public GameBoard()
    {
        window.setTitle("Cache Noisettes!");
        window.setSize(600, 630);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int i = 0; i<12; i++){
            emptyBox[i] = new JButton(emptyBoxPicture);
        }

        for(int j = 0; j < 4; j++){
            holeBox[j] = new JButton(holeBoxPicture);
        }

        innerPanel.setLayout(innerLayout);

        innerPanel.add(emptyBox[0]);
        innerPanel.add(emptyBox[1]);
        innerPanel.add(holeBox[0]);
        innerPanel.add(emptyBox[2]);
        innerPanel.add(holeBox[1]);
        innerPanel.add(emptyBox[3]);
        innerPanel.add(emptyBox[4]);
        innerPanel.add(emptyBox[5]);
        innerPanel.add(emptyBox[6]);
        innerPanel.add(holeBox[2]);
        innerPanel.add(emptyBox[7]);
        innerPanel.add(emptyBox[8]);
        innerPanel.add(emptyBox[9]);
        innerPanel.add(emptyBox[10]);
        innerPanel.add(emptyBox[11]);
        innerPanel.add(holeBox[3]);

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


}