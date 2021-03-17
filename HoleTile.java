import javax.swing.*;
import java.awt.*;

/**
 * This class creates an instance of a tile containing a hole.
 * 
 * @author Morgan Evans
 */
public class HoleTile
{
    private Picture pic = new Picture("icons/Hole.png", 0);
    private JButton button = new JButton(this.pic);

    /**
     * Creates an instance of HoleTile and formats the button.
     */
    public HoleTile()
    {
        // Remove the border from the object and disable it, until it is enabled when a squirrel moves over it
        this.button.setRolloverEnabled(false);
        this.button.setBorderPainted(false);
        this.button.setEnabled(false);
        this.button.setDisabledIcon(this.pic);
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