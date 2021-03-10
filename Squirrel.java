import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates the squirrel pieces that are used to navigate the gameboard.
 * 
 * @author Morgan Evans
 */
public class Squirrel
{
    private int rotation;
    private Picture squirrelPicture[] = new Picture[4];
    private Picture head, tail;
    private boolean nutDropped = false;
    //private JButton squirrel[] = new JButton[4];

    int elements = 2;
    String name, filePath;

    public Squirrel(String colourInput, int rot)
    {
        //Mathcing input selection
        if(colourInput == "red" | colourInput == "RED" | colourInput == "Red")
        {
            this.name = "red";
            this.filePath = "Red";
        }
        else if(colourInput == "grey" | colourInput == "GREY" | colourInput == "Grey")
        {
            this.name = "grey";
            this.filePath = "Grey";
        }
        else if(colourInput == "brown" | colourInput == "BROWN" | colourInput == "Brown")
        {
            this.name = "brown";
            this.filePath = "Brown";
        }
        else if(colourInput == "black" | colourInput == "BLACK" | colourInput == "Black")
        {
            this.name = "black";
            this.filePath = "Black";
        }
        else
        {
            System.out.println("Invalid squirrel colour");
        }

        // Initialising Pictures
        this.rotation = rot;
        this.squirrelPicture[0] = new Picture("icons/"+filePath+"Squirrel1Nut.png", this.rotation);
        this.squirrelPicture[1] = new Picture("icons/"+filePath+"Squirrel1.png", this.rotation);
        this.squirrelPicture[2] = new Picture("icons/"+filePath+"Squirrel2.png", this.rotation);
        this.squirrelPicture[3] = new Picture("icons/SquirrelFlower.png", 0);

        this.head = this.squirrelPicture[0];
        this.tail = this.squirrelPicture[2];
    }

    /**
     * Returns image for desired part of the squirrel.
     * 
     * @param choice enter: "nut", "head", "tail" or "flowers".
     * @return picture of squirrel's body part.
     */
    public Picture add(String choice)
    {
        int n = 0;

        if(choice == "head")
        {
            return this.head;
        }
        else if(choice == "tail")
        {
            return this.tail;
        }
        else{
            
            System.out.println("Incorrect squirrel part");
            return null;
        }
    }

    public void nutDrop()
    {
        this.head = this.squirrelPicture[1];
        nutDropped = true;
    }

    public boolean nutDropped()
    {
        return this.nutDropped;
    }

    /**
     * Returns the rotation of the squirrel.
     * 
     * @return squirrel rotation (int).
     */
    public int getRotation()
    {
        return this.rotation;
    }
}