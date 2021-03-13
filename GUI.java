import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener
{
    private JPanel mainPanel = new JPanel();

    private Picture titlePicture = new Picture("icons/Title.png", 0);
    private Picture startGamePicture = new Picture("icons/StartGame.png", 0);
    private Picture levelsPicture = new Picture("icons/Levels.png", 0);
    private Picture howToPlayPicture = new Picture("icons/HowToPlay.png", 0);
    private Picture bottomPicture = new Picture("icons/Bottom.png", 0);

    private JButton titleButton = new JButton(titlePicture);
    private JButton startGameButton = new JButton(startGamePicture);
    private JButton levelsButton = new JButton(levelsPicture);
    private JButton howToPlayButton = new JButton(howToPlayPicture);
    private JButton bottomButton = new JButton(bottomPicture);

    private JButton level[] = new JButton[60];
    private int levelSelect = 0;

    public GUI()
    {
        mainPanel.setLayout(null);
        this.format(titleButton, 0, 0, 600, 244);
        this.format(startGameButton, 0, 244, 200, 203);
        this.format(levelsButton, 200, 244, 200, 203);
        this.format(howToPlayButton, 400, 244, 200, 203);
        this.format(bottomButton, 0, 414, 600, 188);

        this.startGameButton.addActionListener(this);
        this.levelsButton.addActionListener(this);
        this.howToPlayButton.addActionListener(this);
    }

    public void format(JButton button, int posX, int posY, int sizX, int sizY)
    {
        mainPanel.add(button);
        button.setSize(sizX, sizY);
        button.setLocation(posX, posY);
        button.setBorderPainted(false);
        button.setRolloverEnabled(false);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.startGameButton)
        {
            this.levelSelect = 1;
            System.out.println("Test");
        }
        if(e.getSource() == this.levelsButton)
        {
            System.out.println("Levels");
        }
        if(e.getSource() == this.howToPlayButton)
        {
            System.out.println("How to Play");
        }
    }

    public JPanel fetch()
    {
        return this.mainPanel;
    }

    public int level()
    {
        int i = this.levelSelect;
        this.levelSelect = 0;
        return i;
    }

    public void level(int i)
    {
        this.levelSelect = i;
    }
}