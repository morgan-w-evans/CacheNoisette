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
        if(colourInput == "grey" | colourInput == "GREY" | colourInput == "Grey")
        {
            this.name = "grey";
            this.filePath = "Grey";
        }
        if(colourInput == "brown" | colourInput == "BROWN" | colourInput == "Brown")
        {
            this.name = "brown";
            this.filePath = "Brown";
        }
        if(colourInput == "black" | colourInput == "BLACK" | colourInput == "Black")
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
    }

    public Picture add(String choice)
    {
        int n = 0;

        if(choice == "nut")
        {
            n = 0;
        }
        if(choice == "head")
        {
            n = 1;
        }
        if(choice == "tail")
        {
            n = 2;
        }
        if(choice == "flowers")
        {
            n = 3;
        }
        
        return this.squirrelPicture[n];
    }

    public int getRotation()
    {
        return this.rotation;
    }
}