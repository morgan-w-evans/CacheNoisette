import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a tile containing a hole.
 * 
 * @author Morgan Evans
 */
public class HoleTile
{
    private Picture pic;
    private JButton button;

    /**
     * Creates an instance of HoleTile by creating a JButton and inserting the hole icon.
     */
    public HoleTile()
    {
        this.pic = new Picture("icons/Hole.png", 0);
        this.button = new JButton(this.pic);
        this.button.setRolloverEnabled(false);
        this.button.setBorderPainted(false);
    }

    /**
     * Retrieves the button created from within this class, so that it can be integrated into another class.
     * 
     * @return the button created in this instance.
     */
    public JButton button()
    {
        return this.button;
    }

}