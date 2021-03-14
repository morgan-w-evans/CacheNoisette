import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LevelCompleted implements ActionListener
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
    private JTextArea playerMoves, minimumMoves, time;
    private JButton nextLevel = new JButton(nextLevelPicture);
    private JButton retry = new JButton(retryImage);
    private int levelMoves[] = new int[60];
    private int level = 0;

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
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);

        panel.setSize(600,600);
        panel.setLocation(0, 0);
        panel.setLayout(null);

        panel.add(titleButton);
        titleButton.setSize(600, 203);
        titleButton.setLocation(0,0);
        titleButton.setRolloverEnabled(false);
        titleButton.setBorderPainted(false);

        panel.add(blankButton);
        blankButton.setSize(100, 203);
        blankButton.setLocation(0, 244);
        blankButton.setRolloverEnabled(false);
        blankButton.setBorderPainted(false);

        panel.add(blankButton2);
        blankButton2.setSize(100, 203);
        blankButton2.setLocation(500, 244);
        blankButton2.setRolloverEnabled(false);
        blankButton2.setBorderPainted(false);

        panel.add(blankButton3);
        blankButton3.setSize(600, 44);
        blankButton3.setLocation(0, 200);
        blankButton3.setRolloverEnabled(false);
        blankButton3.setBorderPainted(false);

        time = new JTextArea("\n         Level completed in: " + min + " minutes, " + sec + " seconds.");
        details.add(time);
        time.setSize(400, 51);
        time.setLocation(0, 0);
        time.setEditable(false);
        
        playerMoves = new JTextArea("\n         Level completed in " + moveCount + " moves.");
        details.add(playerMoves);
        playerMoves.setSize(400, 51);
        playerMoves.setLocation(0, 51);
        playerMoves.setEditable(false);

        int k = level - 1;
        minimumMoves = new JTextArea("\n         Minimum moves: " + levelMoves[k] + ".");
        details.add(minimumMoves);
        minimumMoves.setSize(400, 51);
        minimumMoves.setLocation(0, 102);
        minimumMoves.setEditable(false);

        details.add(retry);
        retry.setSize(150, 50);
        retry.setLocation(0, 153);
        retry.addActionListener(this);

        details.add(nextLevel);
        nextLevel.setSize(250, 50);
        nextLevel.setLocation(150, 153);
        nextLevel.addActionListener(this);

        panel.add(details);
        details.setLayout(null);
        details.setSize(400,203);
        details.setLocation(100, 244);

        panel.add(bottomButton);
        bottomButton.setSize(600, 188);
        bottomButton.setLocation(0, 414);
        bottomButton.setRolloverEnabled(false);
        bottomButton.setBorderPainted(false);
        
        window.setContentPane(panel);
        window.setVisible(true);
    }

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
}