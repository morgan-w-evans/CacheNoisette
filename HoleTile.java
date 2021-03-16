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
    private Picture pic = new Picture("icons/Hole.png", 0);
    private JButton button = new JButton(this.pic);

    /**
     * Creates an instance of HoleTile by creating a JButton and inserting the hole icon.
     */
    public HoleTile()
    {
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