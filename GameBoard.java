import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

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
    private JPanel windowPanel = new JPanel();
    private GridLayout windowLayout = new GridLayout(2, 1);
    private JPanel gui = new JPanel();
    private GUI gui2 = new GUI();
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
    private int tileAccess[][] = new int[4][4];

    // Flower icon
    private Picture flower = new Picture("icons/Flower.png", 0);

    // Storing squirrels
    private int xCoord;
    private int yCoord;
    private Icon savedIconHead[][] = new Icon[4][4];
    private Icon savedIconTail[][] = new Icon[4][4];
    private Icon savedIconFlowers[][] = new Icon[4][4];
    private Squirrel savedSquirrel[][] = new Squirrel[4][4];
    private Squirrel selectedSquirrel;
    private int squirrelCount = 0;

    // Nut drop
    private Picture holeNut = new Picture("icons/HoleNut.png", 0);
    private int holeEmpty[][] = new int[4][4];
    private int nutDropCount = 0;
    private boolean levelComplete = false;

    /**
     * Creates a gameboard window.
     */
    public GameBoard()
    {
        // Initialising the window.
        window.setTitle("Cache Noisettes!");
        window.setSize(1200, 625);
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

        arrowButton(upButton, 0, 0, 600, 100);
        arrowButton(downButton, 0, 500, 600, 100);
        arrowButton(rightButton, 500, 100, 100, 400);
        arrowButton(leftButton, 0, 100, 100, 400);

        outerPanel.add(innerPanel);
        innerPanel.setLocation(100,100);
        innerPanel.setSize(400,400);

        gui = gui2.fetch();
        windowPanel.setLayout(null);
        windowPanel.add(gui);
        gui.setLocation(0, 0);
        gui.setSize(600,635);

        window.setVisible(true);
        windowPanel.add(outerPanel);
        outerPanel.setLocation(600, 0);
        outerPanel.setSize(600,635);

        window.setContentPane(windowPanel);
        window.setVisible(true);

        // Initialising array to store squirrel in
        // Allowing access to all tiles
        for(int m = 0; m < 4; m++)
        {
            for(int n = 0; n < 4; n++)
            {
                this.savedSquirrel[n][m] = new Squirrel("red", 0);
                this.tileAccess[n][m] = 1;
            }
        }

        // Initialsing hole identifier
        this.holeEmpty[2][0] = 1;
        this.holeEmpty[0][1] = 1;
        this.holeEmpty[1][2] = 1;
        this.holeEmpty[3][3] = 1;
    }

    public void addGUI(GUI u)
    {
        this.gui = u.fetch();
        
        
        
    }

    /**
     * Adds arrow buttons to JPanel and provides formatting.
     * 
     * @param button button to add to JPanel.
     * @param posX x position of button in JPanel (pixels).
     * @param posY y position of button in JPanel (pixels).
     * @param sizX width of button (pixels).
     * @param sizY height of button (pixels).
     */
    private void arrowButton(JButton button, int posX, int posY, int sizX, int sizY)
    {
        outerPanel.add(button);
        button.setLocation(posX,posY);
        button.setSize(sizX,sizY);
        button.setRolloverEnabled(false);
        button.setBorderPainted(false);
        button.addActionListener(this);
    }

    /**
     * Adds a squirrel onto the gameboard.
     * 
     * @param squirrel squirrel to add.
     * @param x x-coordinate of the head. (0,0) to (3,3)
     * @param y y-coordinate of the head. (0,0) to (3,3)
     */
    public void add(Squirrel squirrel, int x, int y)
    {
        // Determining location of the squirrel pieces
        int secondCoord[] = pieceLocation(squirrel, x, y);
        int x2 = secondCoord[0], y2 = secondCoord[1], x3 = secondCoord[2], y3 = secondCoord[3];

        // Update tile access
        this.tileAccess[x][y] = 0;
        this.tileAccess[x2][y2] = 0;
        
        // Adding squirrel by replacing icons. Stores icons and squirrels in arrays for retrieval
        savedIconHead[y][x] = this.cell[y][x].getIcon();
        this.cell[y][x].setIcon(squirrel.add("head"));
        this.cell[y][x].addActionListener(this);

        savedIconTail[y2][x2] = this.cell[y2][x2].getIcon();
        this.cell[y2][x2].setIcon(squirrel.add("tail"));
        
        // Adding flower piece
        if(squirrel.squirrelFlowers())
        {
            this.tileAccess[x3][y3] = 0;
            savedIconFlowers[y3][x3] = this.cell[y3][x3].getIcon();
            this.cell[y3][x3].setIcon(squirrel.add("flowers"));
        }

        savedSquirrel[x][y] = squirrel;

        // Squirrel counter
        this.squirrelCount++;

        if(this.squirrelCount >= 5)
        {
            this.remove(squirrel, x, y);
            System.out.println("Squirrel removed. Maximum of 4 on the board at once.");
        }
    }

    /**
     * Removes a squirrel from the gameboard.
     * 
     * @param squirrel squirrel to remove.
     * @param x x-coordinate of the head. (0,0) to (3,3)
     * @param y y-coordinate of the head. (0,0) to (3,3)
     */
    public void remove(Squirrel squirrel, int x, int y)
    {
        // Determining the location of the squirrel pieces
        int secondCoord[] = pieceLocation(squirrel, x, y);
        int x2 = secondCoord[0], y2 = secondCoord[1], x3 = secondCoord[2], y3 = secondCoord[3];
        
        // Make tile available again
        this.tileAccess[x][y] = 1;
        this.tileAccess[x2][y2] = 1;
        
        // Removing squirrel by replacing icons
        this.cell[y][x].setIcon(savedIconHead[y][x]);
        this.cell[y][x].removeActionListener(this);

        this.cell[y2][x2].setIcon(savedIconTail[y2][x2]);
        
        // Removing flower piece
        if(squirrel.squirrelFlowers())
        {
            this.tileAccess[x3][y3] = 1;
            this.cell[y3][x3].setIcon(savedIconFlowers[y3][x3]);
        }

        savedSquirrel[x][y] = null;

        // Squirrel counter
        this.squirrelCount--;
    }

    /**
     * Adds a flower block onto the gameboard, to prevent holes from being used.
     * 
     * @param x x-coordinate to be placed at. (0,0) to (3,3)
     * @param y y-coordinate to be placed at. (0,0) to (3,3)
     */
    public void addFlower(int x, int y)
    {
        this.cell[y][x].setIcon(this.flower);
        this.tileAccess[x][y] = 0;
    }

    /**
     * Listens for actions from button clicks.
     * 
     * @param e input from buttons.
     */
    public void actionPerformed(ActionEvent e)
    {
        // Squirrel Selection
        for(int m = 0; m < 4; m++)
        {
            for(int n = 0; n < 4; n++)
            {
                if(e.getSource() == cell[n][m])
                {
                    this.xCoord = m;
                    this.yCoord = n;
                    selectedSquirrel = savedSquirrel[m][n];
                }
            }
        }
        
        if(Objects.isNull(this.xCoord) | Objects.isNull(this.yCoord) | Objects.isNull(this.selectedSquirrel))
        {
            return;
        }
        
        // Navigation Button Event
        if(e.getSource() == upButton)
        {
            this.move(this.selectedSquirrel, this.xCoord, this.yCoord, this.xCoord, this.yCoord-1);
        }
        if(e.getSource() == downButton)
        {
            this.move(this.selectedSquirrel, this.xCoord, this.yCoord, this.xCoord, this.yCoord+1);
        }
        if(e.getSource() == leftButton)
        {
            this.move(this.selectedSquirrel, this.xCoord, this.yCoord, this.xCoord-1, this.yCoord);
        }
        if(e.getSource() == rightButton)
        {
            this.move(this.selectedSquirrel, this.xCoord, this.yCoord, this.xCoord+1, this.yCoord);
        }
    }

    /**
     * Moves a squirrel from one position to another.
     * 
     * @param squirrel squirrel to be moved.
     * @param xCurrent current x-position of the squirrel.
     * @param yCurrent current y-position of the squirrel.
     * @param xNew new x-position to move squirrel to.
     * @param yNew new y-position to move squirrel to.
     */
    public void move(Squirrel squirrel, int xCurrent, int yCurrent, int xNew, int yNew)
    {
        int coord[] = pieceLocation(squirrel, xNew, yNew);
        
        if(this.inBoundary(xNew, yNew, coord[0], coord[1], coord[2], coord[3])==false){
            return;
        }
        
        this.remove(squirrel, xCurrent, yCurrent);

        if(this.tileAccess[xNew][yNew] == 0 | this.tileAccess[coord[0]][coord[1]] == 0 | this.tileAccess[coord[2]][coord[3]] == 0)
        {
            this.add(squirrel, xCurrent, yCurrent);
        }
        else{
            //this.add(squirrel, xCurrent, yCurrent, flowers);

            this.xCoord = xNew;
            this.yCoord = yNew;

            // Applying nut drop rule
            if(xNew == 2 & yNew == 0 & holeEmpty[2][0] == 1 & squirrel.nutDropped()==false| xNew == 0 & yNew == 1 & holeEmpty[0][1] == 1 & squirrel.nutDropped()==false| xNew == 1 & yNew == 2 & holeEmpty[1][2] == 1 & squirrel.nutDropped()==false| xNew == 3 & yNew == 3 & holeEmpty[3][3] == 1 & squirrel.nutDropped()==false)
            {
                squirrel.nutDrop();
                this.holeEmpty[xNew][yNew] = 0;
                this.cell[yNew][xNew].setIcon(holeNut);
                this.nutDropCount++;
            }

            this.add(squirrel, xNew, yNew);

            if(nutDropCount == squirrelCount)
            {
                levelComplete = true;
                System.out.println("Level Complete");
            }
        }
    }

    /**
     * Calculates the coordinates of the squirrel's tail and flowers, based on the rotation of the squirrel.
     * 
     * @param squirrel squirrel in question.
     * @param x x position of squirrel's head.
     * @param y y position of squirrel's head.
     * @return returns the coordinates of the squirrel's tail and flowers as an array {xTail, yTail, xFlowers, yFlowers}.
     */
    public int[] pieceLocation(Squirrel squirrel, int x, int y)
    {
        int x2 = x, y2 = y, x3 = x, y3 = y;

        if(squirrel.getRotation() == 0)
        {
            y2 = y + 1;

            if(squirrel.squirrelFlowers() & squirrel.type() == "Brown")
            {
                x3 = x + 1;
            }
            if(squirrel.squirrelFlowers() & squirrel.type() == "Black")
            {
                x3 = x + 1;
                y3 = y - 1;
            }
        }
        if(squirrel.getRotation() == 90)
        {
            x2 = x - 1;

            if(squirrel.squirrelFlowers() & squirrel.type() == "Brown")
            {
                y3 = y - 1;
            }
            if(squirrel.squirrelFlowers() & squirrel.type() == "Black")
            {
                x3 = x - 1;
                y3 = y + 1;
            }
        }
        if(squirrel.getRotation() == 180)
        {
            y2 = y - 1;

            if(squirrel.squirrelFlowers() & squirrel.type() == "Brown")
            {
                y3 = x - 1;
            }
            if(squirrel.squirrelFlowers() & squirrel.type() == "Black")
            {
                x3 = x - 1;
                y3 = y - 1;
            }
        }
        if(squirrel.getRotation() == 270)
        {
            x2 = x + 1;

            if(squirrel.squirrelFlowers() & squirrel.type() == "Brown")
            {
                y3 = y - 1;
            }
            if(squirrel.squirrelFlowers() & squirrel.type() == "Black")
            {
                x3 = x + 1;
                y3 = y - 1;
            }
        }

        return new int[] {x2, y2, x3, y3};
    }

    /**
     * Checks to ensure that the new location of the squirrel remains on the gameboard.
     * 
     * @param x x coordinate of squirrel's head.
     * @param y y coordinate of squirrel's head.
     * @param x2 x coordinate of squirrel's tail.
     * @param y2 y coordinate of squirrel's tail.
     * @return true if squirrel is within the boundary.
     */
    public boolean inBoundary(int x, int y, int x2, int y2, int x3, int y3)
    {
        boolean inBoundary = true;
        
        if(x > 3 | x < 0 | y > 3 | y < 0 | x2 > 3 | x2 < 0 | y2 > 3 | y2 < 0 | x3 > 3 | x3 < 0 | y3 > 3 | y3 < 0)
        {
            inBoundary = false;
        }
        
        return inBoundary;
    }

    /**
     * Retrieves the current state of the levelComplete boolean.
     * 
     * @return true if level has been completed.
     */
    public boolean levelComplete()
    {
        return this.levelComplete;
    }
}