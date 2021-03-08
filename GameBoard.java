import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
     * This class creates the gameboard, consisiting of blank tiles, with holes inserted in preset locations.
     * 
     * Directional buttons are inserted surrounding the gameboard, to allow the squirrels to be controlled.
     * 
     * @author Morgan Evans
     */
public class GameBoard implements ActionListener
{
    // Generates the window and layout.
    private JFrame window = new JFrame();
    private JPanel outerPanel = new JPanel();
    private JPanel innerPanel = new JPanel();
    private GridLayout innerLayout = new GridLayout(4, 4);
    private JButton cell[][] = new JButton[4][4];
    
    // Inserting arrow images and creating buttons to display them.
    private Picture upArrow = new Picture("icons/BigArrow.png", 0);
    private Picture downArrow = new Picture("icons/BigArrow.png", 180);
    private Picture leftArrow = new Picture("icons/Arrow.png", 270);
    private Picture rightArrow = new Picture("icons/Arrow.png", 90);

    private JButton upButton = new JButton(upArrow);
    private JButton downButton = new JButton(downArrow);
    private JButton leftButton = new JButton(leftArrow);
    private JButton rightButton = new JButton(rightArrow);

    // Instances of the tiles are created in arrarys to construct the gameboard.
    private BlankTile blankTile[] = new BlankTile[16];
    private HoleTile holeTile[] = new HoleTile[4];

    // Flower icon
    private Picture flower = new Picture("icons/Flower.png", 0);

    // Storing squirrels
    private int xCoord[] = new int[3];
    private int yCoord[] = new int[3];
    private Icon copy[] = new Icon[3];

    /**
     * Creates a gameboard window.
     */
    public GameBoard()
    {
        // Initialising the window.
        window.setTitle("Cache Noisette!");
        window.setSize(600, 625);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting the layout and adding elemets to the gameboard.
        innerPanel.setLayout(innerLayout);

        for(int i = 0; i < 16; i++)
        {
            blankTile[i] = new BlankTile();
        }

        boolean run = true;

        while(run)
        {
            int i = 0;

            for(int m = 0; m < 4; m++)
            {
                for(int n = 0; n < 4; n++)
                {
                    cell[m][n] = new JButton();
                    cell[m][n] = blankTile[i].button();
                    i++;
                }
            }

            run = false;
        }

        for (int i = 0; i < 4; i++)
        {
            holeTile[i] = new HoleTile();
        }

        cell[0][2] = holeTile[0].button();
        cell[1][0] = holeTile[1].button();
        cell[2][1] = holeTile[2].button();
        cell[3][3] = holeTile[3].button();
        
        for(int m = 0; m < 4; m++)
        {
            for(int n = 0; n < 4; n++)
            {
                innerPanel.add(cell[m][n]);
            }
        } 
        
        // Creating the outer layout, containing the navigation buttons.
        outerPanel.setLayout(null);

        outerPanel.add("North", upButton);
        upButton.setLocation(0,0);
        upButton.setSize(600,100);
        upButton.setRolloverEnabled(false);
        upButton.setBorderPainted(false);
        upButton.addActionListener(this);

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

    public void add(Squirrel squirrel, int x, int y, boolean flowers)
    {
        int x2 = x, y2 = y;
        

        if(squirrel.getRotation() == 0)
        {
            y2 = y + 1;
        }
        if(squirrel.getRotation() == 90)
        {
            x2 = x - 1;
        }
        if(squirrel.getRotation() == 180)
        {
            y2 = y - 1;
        }
        if(squirrel.getRotation() == 270)
        {
            x2 = x + 1;
        }
        
        this.copy[0] = this.cell[y][x].getIcon();
        this.cell[y][x].setIcon(squirrel.add("nut"));
        this.cell[y][x].addActionListener(this);

        this.copy[1] = this.cell[y2][x2].getIcon();
        this.cell[y2][x2].setIcon(squirrel.add("tail"));
        this.cell[y2][x2].addActionListener(this);
    }

    public void remove(Squirrel squirrel, int x, int y, boolean flowers)
    {
        int x2 = x, y2 = y, x3 = 0, y3 = 0;

        if(squirrel.getRotation() == 0)
        {
            y2 = y + 1;
        }
        if(squirrel.getRotation() == 90)
        {
            x2 = x - 1;
        }
        if(squirrel.getRotation() == 180)
        {
            y2 = y - 1;
        }
        if(squirrel.getRotation() == 270)
        {
            x2 = x + 1;
        }
        
        this.cell[y][x].setIcon(this.copy[0]);
        this.cell[y][x].removeActionListener(this);

        this.cell[y2][x2].setIcon(this.copy[1]);
        this.cell[y2][x2].removeActionListener(this);
    }

    public void addFlower(int x, int y)
    {
        this.cell[y][x].setIcon(this.flower);
    }

    public void actionPerformed(ActionEvent e)
    {
        // Squirrel Selection
        e.getSource();
        
        // Navigation Button Event
        if(e.getSource() == upButton)
        {
            
        }
        if(e.getSource() == downButton)
        {

        }
        if(e.getSource() == leftButton)
        {

        }
        if(e.getSource() == rightButton)
        {

        }
    }

    public void move(Squirrel squirrel, int xCurrent, int yCurrent, int xNew, int yNew, boolean flowers)
    {
        this.remove(squirrel, xCurrent, yCurrent, flowers);
        this.add(squirrel, xNew, yNew, flowers);
    }
}