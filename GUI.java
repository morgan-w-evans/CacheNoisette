import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener
{
    private JFrame window = new JFrame();
    
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
        window.setTitle("Cache Noisettes!");
        window.setSize(600, 625);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        
        mainPanel.setLayout(null);
        mainPanel.setSize(600, 600);
        mainPanel.setLocation(0, 0);
        this.format(titleButton, 0, 0, 600, 244);
        this.format(startGameButton, 0, 244, 200, 203);
        this.format(levelsButton, 200, 244, 200, 203);
        this.format(howToPlayButton, 400, 244, 200, 203);
        this.format(bottomButton, 0, 414, 600, 188);

        this.startGameButton.addActionListener(this);
        this.levelsButton.addActionListener(this);
        this.howToPlayButton.addActionListener(this);

        window.setContentPane(mainPanel);
        window.setVisible(true);
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
            LevelStore l = new LevelStore(1);
        }
        if(e.getSource() == this.levelsButton)
        {
            Levels l = new Levels();
        }
        if(e.getSource() == this.howToPlayButton)
        {
            HowToPlay h = new HowToPlay();
        }
    }
}