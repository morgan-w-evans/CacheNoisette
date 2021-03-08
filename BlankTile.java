import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a blank tile.
 * 
 * @author Morgan Evans
 */
public class BlankTile
{
    private Picture pic;
    private JButton button;

    /**
     * Creates an instance of BlankTile by creating a JButton and inserting the tile icon.
     */
    public BlankTile()
    {
        this.pic = new Picture("icons/Empty.png", 0);
        this.button = new JButton(this.pic);
        this.button.setRolloverEnabled(false);
        this.button.setBorderPainted(false);
    }

    /**
     * Retrieves the button created from within this class, so that it can be integrated into another class.
     * 
     * @return the button created in the instance.
     */
    public JButton button()
    {
        return this.button;
    }
}