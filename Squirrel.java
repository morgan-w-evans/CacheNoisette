/**
 * This class creates the properties requried to add a squirrel to GameBoard.
 * 
 * @author Morgan Evans
 */
public class Squirrel
{
    private String filePath;
    private int xHeadPos, yHeadPos, xTailPos, yTailPos, xFlowersPos, yFlowersPos, rotation;
    private Picture squirrelPicture[] = new Picture[4];
    private Picture head;
    private boolean nutDropped = false;

    /**
     * Creates an instance of Squirrel.
     * 
     * @param colourInput colour of squirrel. (Red, Grey, Brown or Black)
     * @param x x-coordinate of squirrel's head. (0-3)
     * @param y y-coordinate of squirrel's head. (0-3)
     * @param rot direction of squirrel. (0, 90, 180 or 270)
     */
    public Squirrel(String colourInput, int x, int y, int rot)
    {
        //Mathcing various input formats to the correct filename format
        if (colourInput == "red" | colourInput == "RED" | colourInput == "Red") {

            this.filePath = "Red";
        }
        else if (colourInput == "grey" | colourInput == "GREY" | colourInput == "Grey") {

            this.filePath = "Grey";
        }
        else if (colourInput == "brown" | colourInput == "BROWN" | colourInput == "Brown") {

            this.filePath = "Brown";
        }
        else if (colourInput == "black" | colourInput == "BLACK" | colourInput == "Black") {

            this.filePath = "Black";
        }
        else if (colourInput == "empty" | colourInput == null) {
            
            this.filePath = "Blank";
        }
        else {

            System.out.println("Invalid squirrel colour");
        }

        // Initialising Pictures
        if (colourInput == "empty" | colourInput == null) {

            return;
        }    
        else if (colourInput != "empty") {
            
            this.rotation = rot;
            this.squirrelPicture[0] = new Picture("icons/"+filePath+"Squirrel1Nut.png", this.rotation);
            this.squirrelPicture[1] = new Picture("icons/"+filePath+"Squirrel1.png", this.rotation);
            this.squirrelPicture[2] = new Picture("icons/"+filePath+"Squirrel2.png", this.rotation);
            this.squirrelPicture[3] = new Picture("icons/SquirrelFlower.png", 0);
            this.head = this.squirrelPicture[0];
        }

        // Save coordinates of squirrel
        this.xHeadPos = x;
        this.yHeadPos = y;

        // Calculate tail and flower coordinates
        this.calculatePieceLocation();
    }

    /**
     * Calculates the coordinates of the tail and flower pieces (if applicable), based on the head coordinates.
     */
    public void calculatePieceLocation()
    {
        // Initiate coordinates
        this.xTailPos = this.xHeadPos;
        this.yTailPos = this.yHeadPos;
        this.xFlowersPos = this.xHeadPos;
        this.yFlowersPos = this.yHeadPos;

        // Alter coordinates of the squirrel's tail and flower piece, based on its rotation
        if (this.rotation == 0) {

            this.yTailPos = this.yHeadPos + 1;

            if (this.filePath == "Brown") {

                this.xFlowersPos = this.xHeadPos + 1;
            }
            else if (this.filePath == "Black") {

                this.xFlowersPos = this.xHeadPos + 1;
                this.yFlowersPos = this.yHeadPos + 1;
            }
        }
        else if (this.rotation == 90) {

            this.xTailPos = this.xHeadPos - 1;

            if (this.filePath == "Brown") {

                this.yFlowersPos = this.yHeadPos + 1;
            }
            else if (this.filePath == "Black") {

                this.xFlowersPos = this.xHeadPos - 1;
                this.yFlowersPos = this.yHeadPos + 1;
            }
        }
        else if (this.rotation == 180) {

            this.yTailPos = this.yHeadPos - 1;

            if (this.filePath == "Brown") {

                this.xFlowersPos = this.xHeadPos - 1;
            }
            else if (this.filePath == "Black") {

                this.xFlowersPos = this.xHeadPos - 1;
                this.yFlowersPos = this.yHeadPos - 1;
            }
        }
        else if (this.rotation == 270) {

            this.xTailPos = this.xHeadPos + 1;

            if (this.filePath == "Brown") {

                this.yFlowersPos = this.yHeadPos - 1;
            }
            else if (this.filePath == "Black") {

                this.xFlowersPos = this.xHeadPos + 1;
                this.yFlowersPos = this.yHeadPos - 1;
            }
        }
    }

    /**
     * Returns image for desired part of the squirrel.
     * 
     * @param choice enter: "head", "tail" or "flowers".
     * @return picture of squirrel's body part.
     */
    public Picture add(String choice)
    {
        int n = 0;

        if (choice == "head") {

            return this.head;
        }
        else if (choice == "tail") {

            return this.squirrelPicture[2];
        }
        else if (choice == "flowers") {

            return this.squirrelPicture[3];
        }
        else {
            
            System.out.println("Incorrect squirrel part");
            return null;
        }
    }

    /**
     * Updates squirrel's head when nut is dropped.
     */
    public void nutDrop()
    {
        this.head = this.squirrelPicture[1];
        nutDropped = true;
    }

    /**
     * Returns the state of the nut.
     * 
     * @return true if nut has been dropped.
     */
    public boolean nutDropped()
    {
        return this.nutDropped;
    }

    /**
     * Returns the rotation of the squirrel.
     * 
     * @return squirrel rotation.
     */
    public int getRotation()
    {
        return this.rotation;
    }

    /**
     * Returns filePath string.
     * 
     * @return squirrel colour.
     */
    public String type()
    {
        return this.filePath;
    }

    /**
     * Returns x-coordinate of the squirrel's head.
     * 
     * @return head x-coordinate
     */
    public int xHeadPos()
    {
        return this.xHeadPos;
    }

    /**
     * Updates x-coordinate of the squirrel's head and recalculates the other cooridnates.
     * 
     * @param i head x-coordinate.
     */
    public void xHeadPos(int i)
    {
        this.xHeadPos = i;
        this.calculatePieceLocation();
    }

    /**
     * Returns y-coordinate of the squirrel's head.
     * 
     * @return head y-coordinate.
     */
    public int yHeadPos()
    {
        return this.yHeadPos;
    }

    /**
     * Updates y-coordinate of the squirrel's head and recalculates the other coordinates.
     * 
     * @param i head y-coordinate.
     */
    public void yHeadPos(int i)
    {
        this.yHeadPos = i;
        this.calculatePieceLocation();
    }

    /**
     * Returns x-coordinate of the squirrel's tail.
     * 
     * @return tail x-coordinate.
     */
    public int xTailPos()
    {
        return this.xTailPos;
    }

    /**
     * Returns the y-cooridnate of the squirrel's tail.
     * 
     * @return tail y-coordinate.
     */
    public int yTailPos()
    {
        return this.yTailPos;
    }

    /**
     * Returns the x-cooridnate of the squirrel's flowers (if applicable).
     * 
     * @return flowers x-coordinate.
     */
    public int xFlowersPos()
    {
        return this.xFlowersPos;
    }

    /**
     * Returns the y-coordinate of the squirrel's flowers (if applicable).
     * 
     * @return flowers y-coordinate.
     */
    public int yFlowersPos()
    {
        return this.yFlowersPos;
    }
}