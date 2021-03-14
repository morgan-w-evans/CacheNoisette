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
public class GameBoard implements ActionListener, KeyListener
{
    // Generates the window and layout.
    private JFrame window = new JFrame();
    private JPanel windowPanel = new JPanel();
    private GridLayout windowLayout = new GridLayout(2, 1);
    private JPanel gui = new JPanel();
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

    // Flower block icon
    private Picture flower = new Picture("icons/Flower.png", 0);
    private Icon savedIconFlowerBlock[][] = new Icon[4][4];

    // Squirrels
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

    // Additional Features
    private int moveCount = 0;
    private long startTime, timeTaken;

    /**
     * Creates an instance of GameBoard.
     */
    public GameBoard(GUI gui2)
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

        // Initialising squirrel store array
        // Initialising tile access array
        for (int m = 0; m < 4; m++) {

            for (int n = 0; n < 4; n++) {

                this.savedSquirrel[n][m] = new Squirrel("red", 0, 0, 0);
                this.tileAccess[n][m] = 1;
            }
        }

        // Initialsing holes as empty
        this.holeEmpty[2][0] = 1;
        this.holeEmpty[0][1] = 1;
        this.holeEmpty[1][2] = 1;
        this.holeEmpty[3][3] = 1;

        // Implement key listener
        outerPanel.addKeyListener(this);
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
     */
    public void add(Squirrel squirrel)
    {
        // Update tile access
        this.tileAccess[squirrel.xHeadPos()][squirrel.yHeadPos()] = 0;
        this.tileAccess[squirrel.xTailPos()][squirrel.yTailPos()] = 0;
        
        // Adding squirrel by replacing icons. Stores icons and squirrels in arrays for retrieval
        savedIconHead[squirrel.yHeadPos()][squirrel.xHeadPos()] = this.cell[squirrel.yHeadPos()][squirrel.xHeadPos()].getIcon();
        this.cell[squirrel.yHeadPos()][squirrel.xHeadPos()].setIcon(squirrel.add("head"));
        this.cell[squirrel.yHeadPos()][squirrel.xHeadPos()].addActionListener(this);

        savedIconTail[squirrel.yTailPos()][squirrel.xTailPos()] = this.cell[squirrel.yTailPos()][squirrel.xTailPos()].getIcon();
        this.cell[squirrel.yTailPos()][squirrel.xTailPos()].setIcon(squirrel.add("tail"));
        
        // Adding flower piece
        if (squirrel.type() == "Brown" | squirrel.type() == "Black") {

            this.tileAccess[squirrel.xFlowersPos()][squirrel.yFlowersPos()] = 0;
            savedIconFlowers[squirrel.yFlowersPos()][squirrel.xFlowersPos()] = this.cell[squirrel.yFlowersPos()][squirrel.xFlowersPos()].getIcon();
            this.cell[squirrel.yFlowersPos()][squirrel.xFlowersPos()].setIcon(squirrel.add("flowers"));
        }

        savedSquirrel[squirrel.xHeadPos()][squirrel.yHeadPos()] = squirrel;

        // Squirrel counter
        this.squirrelCount++;

        if (this.squirrelCount >= 5) {

            this.remove(squirrel);
            System.out.println("Squirrel removed. Maximum of 4 on the board at once.");
        }
    }

    /**
     * Removes a squirrel from the gameboard.
     * 
     * @param squirrel squirrel to remove.
     */
    public void remove(Squirrel squirrel)
    {
        // Make tile available again
        this.tileAccess[squirrel.xHeadPos()][squirrel.yHeadPos()] = 1;
        this.tileAccess[squirrel.xTailPos()][squirrel.yTailPos()] = 1;
        
        // Removing squirrel by replacing icons
        this.cell[squirrel.yHeadPos()][squirrel.xHeadPos()].setIcon(savedIconHead[squirrel.yHeadPos()][squirrel.xHeadPos()]);
        this.cell[squirrel.yHeadPos()][squirrel.xHeadPos()].removeActionListener(this);

        this.cell[squirrel.yTailPos()][squirrel.xTailPos()].setIcon(savedIconTail[squirrel.yTailPos()][squirrel.xTailPos()]);
        
        // Removing flower piece
        if (squirrel.type() == "Brown" | squirrel.type() == "Black") {

            this.tileAccess[squirrel.xFlowersPos()][squirrel.yFlowersPos()] = 1;
            this.cell[squirrel.yFlowersPos()][squirrel.xFlowersPos()].setIcon(savedIconFlowers[squirrel.yFlowersPos()][squirrel.xFlowersPos()]);
        }

        savedSquirrel[squirrel.xHeadPos()][squirrel.yHeadPos()] = null;

        // Squirrel counter
        this.squirrelCount--;
    }

    /**
     * Adds a flower block onto the gameboard, to prevent holes from being used.
     * 
     * @param y y-coordinate of hole. (0-3)
     */
    public void addFlowerBlock(int y)
    {
        int x = 4;

        // Initiate x position based on location of hole
        if (y == 0) {

            x = 2;
        }
        else if (y == 1) {

            x = 0;
        }
        else if (y == 2) {

            x = 1;
        }
        else if (y == 3) {

            x = 3;
        }
        else {

            System.out.println("Incorrect value");
            return;
        }

        // Replace icon and revoke tile access
        this.savedIconFlowerBlock[x][y] = this.cell[y][x].getIcon();
        this.cell[y][x].setIcon(this.flower);
        this.tileAccess[x][y] = 0;
    }

    /**
     * Removes a flower block from the gameboard, to allow holes to be used.
     * 
     * @param y y-coordinate of hole. (0-3)
     */
    public void removeFlowerBlock(int y)
    {
        int x = 4;

        // Initiate x position based on location of hole
        if (y == 0) {

            x = 2;
        }
        else if (y == 1) {

            x = 0;
        }
        else if (y == 2) {

            x = 1;
        }
        else if (y == 3) {

            x = 3;
        }
        else {
            
            System.out.println("Incorrect value");
            return;
        }
        
        // Reset icon and allow tile access
        this.cell[y][x].setIcon(this.savedIconFlowerBlock[x][y]);
        this.tileAccess[x][y] = 0;
    }

    /**
     * Listens for actions from button clicks.
     * 
     * @param e input from buttons.
     */
    public void actionPerformed(ActionEvent e)
    {
        // Identify squirrel clicked
        for (int m = 0; m < 4; m++) {

            for (int n = 0; n < 4; n++) {

                if (e.getSource() == cell[n][m]) {

                    selectedSquirrel = savedSquirrel[m][n];
                }
            }
        }
        
        // Don't allow use of arrow buttons if a squirrel hasn't been selected
        if (Objects.isNull(this.selectedSquirrel)) {

            return;
        }
        
        // Navigation Button Event
        else if (e.getSource() == upButton) {

            this.move(this.selectedSquirrel, selectedSquirrel.xHeadPos(), selectedSquirrel.yHeadPos()-1);
        }
        else if (e.getSource() == downButton) {

            this.move(this.selectedSquirrel, selectedSquirrel.xHeadPos(), selectedSquirrel.yHeadPos()+1);
        }
        else if (e.getSource() == leftButton) {

            this.move(this.selectedSquirrel, selectedSquirrel.xHeadPos()-1, selectedSquirrel.yHeadPos());
        }
        else if (e.getSource() == rightButton) {

            this.move(this.selectedSquirrel, selectedSquirrel.xHeadPos()+1, selectedSquirrel.yHeadPos());
        }
    }

    public void keyTyped(KeyEvent e)
    {
        
    }

    public void keyPressed(KeyEvent e)
    {
        keyAction(e);
    }

    public void keyReleased(KeyEvent e)
    {
        
    }

    public void keyAction(KeyEvent e)
    {
        int code = e.getKeyCode();
        System.out.println(code);

        if (Objects.isNull(this.selectedSquirrel)) {

            return;
        }
        
        if (code == KeyEvent.VK_UP) {

            this.move(this.selectedSquirrel, selectedSquirrel.xHeadPos(), selectedSquirrel.yHeadPos()-1);
            System.out.println("IT WORKED");
        }

        if (code == KeyEvent.VK_DOWN) {

            System.out.println("Down");
        }
    }

    /**
     * Moves a squirrel from one position to another.
     * 
     * @param squirrel squirrel to be moved.
     * @param xNew new x-position to move squirrel to.
     * @param yNew new y-position to move squirrel to.
     */
    public void move(Squirrel squirrel, int xNew, int yNew)
    {
        // Store current squirrel coordinates in the event of a revert
        int restoreXHeadPos = squirrel.xHeadPos();
        int restoreYHeadPos = squirrel.yHeadPos();

        // Update squirrel to new coordinates and check boundary. If not in boundary, revert coordinate change and return
        squirrel.xHeadPos(xNew);
        squirrel.yHeadPos(yNew);
        
        if (this.inBoundary(squirrel) == false) {

            squirrel.xHeadPos(restoreXHeadPos);
            squirrel.yHeadPos(restoreYHeadPos);
            return;
        }
        
        // Remove squirrel at original position to remove potential for blocked tiles
        squirrel.xHeadPos(restoreXHeadPos);
        squirrel.yHeadPos(restoreYHeadPos);
        this.remove(squirrel);

        // Apply new coordinates to add new squirrel in
        squirrel.xHeadPos(xNew);
        squirrel.yHeadPos(yNew);

        // Check to ensure new location is empty, if not add original squirrel back and finish.
        if (this.tileAccess[squirrel.xHeadPos()][squirrel.yHeadPos()] == 0 | this.tileAccess[squirrel.xTailPos()][squirrel.yTailPos()] == 0 | this.tileAccess[squirrel.xFlowersPos()][squirrel.yFlowersPos()] == 0) {
            
            squirrel.xHeadPos(restoreXHeadPos);
            squirrel.yHeadPos(restoreYHeadPos);
            this.add(squirrel);
        }
        else {
            
            // Applying nut drop rule
            if (xNew == 2 & yNew == 0 & holeEmpty[2][0] == 1 & squirrel.nutDropped()==false | xNew == 0 & yNew == 1 & holeEmpty[0][1] == 1 & squirrel.nutDropped()==false| xNew == 1 & yNew == 2 & holeEmpty[1][2] == 1 & squirrel.nutDropped()==false| xNew == 3 & yNew == 3 & holeEmpty[3][3] == 1 & squirrel.nutDropped()==false) {
                
                squirrel.nutDrop();
                this.holeEmpty[xNew][yNew] = 0;
                this.cell[yNew][xNew].setIcon(holeNut);
                this.nutDropCount++;
            }

            // Add squirrel in new position
            this.add(squirrel);
            moveCount++;

            // Test for level completion
            if (nutDropCount == squirrelCount) {
                
                this.moveCount = this.moveCount - this.squirrelCount;
                this.timeTaken = System.currentTimeMillis() - this.startTime;
                long secondsTaken = this.timeTaken / 1000;
                long secondsDisplay = secondsTaken % 60;
                long minutesDisplay = secondsTaken / 60;
                levelComplete = true;
                System.out.println("Level Complete");
                System.out.println("Level completed in " + this.moveCount + " moves!");
                System.out.println("Level complete in: " + minutesDisplay + " minutes, " + secondsDisplay + " seconds.");
            }
        }
    }

    /**
     * Checks to ensure that the squirrel remains on the gameboard.
     * 
     * @param squirrel squirrel to check boundary of.
     * @return true if squirrel is within the boundary.
     */
    public boolean inBoundary(Squirrel squirrel)
    {
        boolean inBoundary = true;
        
        if (squirrel.xHeadPos() > 3 | squirrel.xHeadPos() < 0 | squirrel.yHeadPos() > 3 | squirrel.yHeadPos() < 0 | squirrel.xTailPos() > 3 | squirrel.xTailPos() < 0 | squirrel.yTailPos() > 3 | squirrel.yTailPos() < 0 | squirrel.xFlowersPos() > 3 | squirrel.xFlowersPos() < 0 | squirrel.yFlowersPos() > 3 | squirrel.yFlowersPos() < 0) {
            
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

    public int returnMoveCount()
    {
        return this.moveCount;
    }

    public void startTimer()
    {
        this.startTime = System.currentTimeMillis();
    }
}