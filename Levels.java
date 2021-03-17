import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Levels class creates a window that allows the user to select any of the 60 game levels.
 * 
 * @author Morgan Evans
 */
public class Levels implements ActionListener, KeyListener
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

    /**
     * Creates an instance of Levels.
     */
    public Levels()
    {
        // Initialise the window
        window.setTitle("Select Level");
        window.setSize(600, 725);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        // Format the panels
        panel.setSize(600,700);
        panel.setLocation(0, 0);
        panel.setLayout(null);

        formatComponent(buttonPanel, null, 560, 400, 20, 200, false);
        buttonPanel.setLayout(grid);
        buttonPanel.setBackground(Color.BLACK);

        // Add and format the level buttons
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

        // Format the components
        formatComponent(null, titleButton, 600, 200, 0, 0, true);
        formatComponent(null, close, 300, 100, 150, 600, false);
        formatComponent(null, blankLeft, 20, 400, 0, 200, true);
        formatComponent(null, blankRight, 20, 400, 580, 200, true);
        formatComponent(null, blank, 150, 100, 0, 600, true);
        formatComponent(null, blank2, 150, 100, 450, 600, true);
        
        window.setContentPane(panel);
        window.setVisible(true);

        // Add Action Listener
        close.addActionListener(this);

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
     * @param sizX button width. (pixels)
     * @param sizY button height. (pixels)
     * @param posX x-position. (pixels)
     * @param posY y-position. (pixels)
     * @param disabled disable button.
     */
    private void formatComponent(JPanel jpanel, JButton button, int sizX, int sizY, int posX, int posY, boolean disabled)
    {
        if (jpanel == null) {

            panel.add(button);
            button.setSize(sizX, sizY);
            button.setLocation(posX, posY);
            button.setBorderPainted(false);
            button.setRolloverEnabled(false);

            if (disabled) {

                button.setEnabled(false);
                button.setDisabledIcon(button.getIcon());
            }
        }
        else if (button == null) {

            panel.add(jpanel);
            jpanel.setSize(sizX, sizY);
            jpanel.setLocation(posX, posY);
        }
    }

    /**
     * Performs an action when an ActionEvent occurs.
     */
    public void actionPerformed(ActionEvent e)
    {
        // If one of the level buttons are selected, open the corresponding level
        int j = 0;
        
        for (int i = 0; i < 60; i++) {

            j++;

            if (e.getSource() == this.levels[i]) {

                LevelStore l = new LevelStore(j);
                window.dispose();
            }
        }

        // Open a new instance of GUI and close this window if close is selected
        if (e.getSource() == close) {

            GUI g = new GUI();
            window.dispose();
        }
    }

    /**
     * Performs an action when a KeyEvent occurs.
     */
    public void keyPressed(KeyEvent e)
    {
        // Open a new instance of GUI and close this window if close is selected
        if (e.getKeyCode() == KeyEvent.VK_C) {

            GUI g = new GUI();
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