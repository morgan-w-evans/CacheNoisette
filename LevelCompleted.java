import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a window which displays the statistics when a user completes a level.
 * Options are then available to the user to either retry or move on to the next level.
 * 
 * @author Morgan Evans
 */
public class LevelCompleted implements ActionListener, KeyListener
{
    private JFrame window = new JFrame();
    private JPanel panel = new JPanel();
    private JPanel details = new JPanel();

    private Picture title = new Picture("icons/Title.png", 0);
    private Picture blank = new Picture("icons/Blank.png", 0);
    private Picture bottom = new Picture("icons/Bottom.png", 0);
    private Picture nextLevelPicture = new Picture("icons/NextLevel.png", 0);
    private Picture retryImage = new Picture("icons/Retry.png", 0);

    private JButton titleButton = new JButton(title);
    private JButton blankButton = new JButton(blank);
    private JButton blankButton2 = new JButton(blank);
    private JButton blankButton3 = new JButton(blank);
    private JButton bottomButton = new JButton(bottom);
    private JButton nextLevel = new JButton(nextLevelPicture);
    private JButton retry = new JButton(retryImage);

    private JTextArea playerMoves, minimumMoves, time;
    
    private int levelMoves[] = new int[60];
    private int level = 0;

    /**
     * Creates an instance of LevelCompleted and opens a new window.
     * 
     * @param levelInput current level completed.
     * @param moveCount number of moves by user to complete the level.
     * @param min time to complete the level. (minutes)
     * @param sec time to complete the level. (seconds)
     */
    public LevelCompleted(int levelInput, int moveCount, long min, long sec)
    {
        this.level = levelInput;
        
        // Adding minimum moves to array
        this.levelMoves[0] = 3;
        this.levelMoves[1] = 4;
        this.levelMoves[2] = 8;
        this.levelMoves[3] = 6;
        this.levelMoves[4] = 10;
        this.levelMoves[5] = 10;
        this.levelMoves[6] = 10;
        this.levelMoves[7] = 9;
        this.levelMoves[8] = 8;
        this.levelMoves[9] = 8;
        this.levelMoves[10] = 9;
        this.levelMoves[11] = 17;
        this.levelMoves[12] = 13;
        this.levelMoves[13] = 11;
        this.levelMoves[14] = 17;
        this.levelMoves[15] = 20;
        this.levelMoves[16] = 13;
        this.levelMoves[17] = 20;
        this.levelMoves[18] = 16;
        this.levelMoves[19] = 22;
        this.levelMoves[20] = 21;
        this.levelMoves[21] = 15;
        this.levelMoves[22] = 19;
        this.levelMoves[23] = 23;
        this.levelMoves[24] = 12;
        this.levelMoves[25] = 18;
        this.levelMoves[26] = 31;
        this.levelMoves[27] = 15;
        this.levelMoves[28] = 20;
        this.levelMoves[29] = 21;
        this.levelMoves[30] = 27;
        this.levelMoves[31] = 23;
        this.levelMoves[32] = 22;
        this.levelMoves[33] = 28;
        this.levelMoves[34] = 26;
        this.levelMoves[35] = 25;
        this.levelMoves[36] = 24;
        this.levelMoves[37] = 26;
        this.levelMoves[38] = 12;
        this.levelMoves[39] = 33;
        this.levelMoves[40] = 33;
        this.levelMoves[41] = 32;
        this.levelMoves[42] = 30;
        this.levelMoves[43] = 30;
        this.levelMoves[44] = 22;
        this.levelMoves[45] = 31;
        this.levelMoves[46] = 36;
        this.levelMoves[47] = 38;
        this.levelMoves[48] = 33;
        this.levelMoves[49] = 46;
        this.levelMoves[50] = 28;
        this.levelMoves[51] = 40;
        this.levelMoves[52] = 33;
        this.levelMoves[53] = 39;
        this.levelMoves[54] = 40;
        this.levelMoves[55] = 41;
        this.levelMoves[56] = 43;
        this.levelMoves[57] = 46;
        this.levelMoves[58] = 50;
        this.levelMoves[59] = 58;

        // Initialising Window
        window.setTitle("Level " + level + " Completed");
        window.setSize(600, 625);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        panel.add(details);

        // Initialise text areas
        int k = level - 1;
        time = new JTextArea("\n         Level completed in: " + min + " minutes, " + sec + " seconds.");
        playerMoves = new JTextArea("\n         Level completed in " + moveCount + " moves.");
        minimumMoves = new JTextArea("\n         Target: " + levelMoves[k] + ".");

        // Format all components
        formatComponent(panel, null, null, 600, 600, 0, 0, null);
        formatComponent(details, null, null, 400, 203, 100, 244, null);

        formatComponent(null, titleButton, null, 600, 203, 0, 0, panel);
        formatComponent(null, blankButton, null, 100, 203, 0, 244, panel);
        formatComponent(null, blankButton2, null, 100, 203, 500, 244, panel);
        formatComponent(null, blankButton3, null, 600, 44, 0, 200, panel);
        formatComponent(null, bottomButton, null, 600, 188, 0, 414, panel);

        formatComponent(null, null, time, 400, 51, 0, 0, details);
        formatComponent(null, null, playerMoves, 400, 51, 0, 51, details);
        formatComponent(null, null, minimumMoves, 400, 51, 0, 102, details);
        formatComponent(null, retry, null, 150, 50, 0, 153, details);
        formatComponent(null, nextLevel, null, 250, 50, 150, 153, details);

        // Show window
        window.setContentPane(panel);
        window.setVisible(true);

        // Add Action Listeners
        retry.addActionListener(this);
        nextLevel.addActionListener(this);

        // Add Key Listener
        window.addKeyListener(this);
        window.setFocusable(true);
        window.requestFocus();
    }

    /**
     * Function adds a component to panel and formats it appropriately.
     * 
     * @param jpanel JPanel to add.
     * @param button JButton to add.
     * @param textArea JTextArea to add.
     * @param sizX button width. (pixels)
     * @param sizY button height. (pixels)
     * @param posX x-position. (pixels)
     * @param posY y-position. (pixels)
     * @param addPanel panel to add component to.
     */
    private void formatComponent(JPanel jpanel, JButton button, JTextArea textArea, int sizX, int sizY, int posX, int posY, JPanel addPanel)
    {
        if (jpanel == null & textArea == null) {

            addPanel.add(button);
            button.setSize(sizX, sizY);
            button.setLocation(posX, posY);
            button.setRolloverEnabled(false);
            button.setBorderPainted(false);

            if (addPanel == panel) {

                button.setEnabled(false);
                button.setDisabledIcon(button.getIcon());
            }
        }
        else if (jpanel == null & button == null) {

            addPanel.add(textArea);
            textArea.setSize(sizX, sizY);
            textArea.setLocation(posX, posY);
            textArea.setEditable(false);
        }
        else if (button == null & textArea == null) {

            jpanel.setSize(sizX, sizY);
            jpanel.setLocation(posX, posY);
            jpanel.setLayout(null);
        }
    }

    /**
     * Performs task when action event occurs.
     */
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == nextLevel) {

            this.level++;
            LevelStore l = new LevelStore(this.level);
            window.dispose();
        }
        else if (e.getSource() == retry) {

            LevelStore l = new LevelStore(this.level);
            window.dispose();
        }
    }

    /**
     * Performs task when key event occurs.
     */
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_2) {

            this.level++;
            LevelStore l = new LevelStore(this.level);
            window.dispose();
        }
        else if (e.getKeyCode() == KeyEvent.VK_1) {

            LevelStore l = new LevelStore(this.level);
            window.dispose();
        }
    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void keyTyped(KeyEvent e)
    {

    }
}