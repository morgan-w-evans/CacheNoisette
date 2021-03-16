import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a graphical interface that opens when the program is run.
 * Allows the user to begin a game, open the level select window or view the help section.
 * When closed, the program exits.
 */
public class GUI implements ActionListener, KeyListener
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

    /**
     * Creates a GUI window.
     */
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

        window.addKeyListener(this);
        window.setFocusable(true);
        window.requestFocus();
    }

    /**
     * Adds the buttons to the JPanel and formats them.
     * 
     * @param button button to add.
     * @param posX x-coordinate of button. (pixels)
     * @param posY y-coordinate of button. (pixels)
     * @param sizX button width. (pixels)
     * @param sizY button height. (pixels)
     */
    private void format(JButton button, int posX, int posY, int sizX, int sizY)
    {
        mainPanel.add(button);
        button.setSize(sizX, sizY);
        button.setLocation(posX, posY);
        button.setBorderPainted(false);
        button.setRolloverEnabled(false);
    }

    /**
     * Called when an Action Event occurs.
     */
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.startGameButton) {

            LevelStore l = new LevelStore(1);
            window.dispose();
        }
        else if (e.getSource() == this.levelsButton) {

            Levels l = new Levels();
            window.dispose();
        }
        else if (e.getSource() == this.howToPlayButton) {

            HowToPlay h = new HowToPlay();
        }
    }

    /**
     * Called when a Key Event occurs.
     */
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_1) {

            LevelStore l = new LevelStore(1);
            window.dispose();
        }
        else if (e.getKeyCode() == KeyEvent.VK_2) {

            Levels l = new Levels();
            window.dispose();
        }
        else if (e.getKeyCode() == KeyEvent.VK_3) {

            HowToPlay h = new HowToPlay();
            window.requestFocus();
        }
    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void keyTyped(KeyEvent e)
    {

    }
}