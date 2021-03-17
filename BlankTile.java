import javax.swing.*;
import java.awt.*;

/**
 * This class creates a blank tile.
 * 
 * @author Morgan Evans
 */
public class BlankTile
{
    private Picture pic = new Picture("icons/Empty.png", 0);
    private JButton button = new JButton(pic);

    /**
     * Creates an instance of BlankTile and formats the button.
     */
    public BlankTile()
    {
        // Removes the border and disables the button until a squirrel lands on it.
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

    /**
     * Returns the icon of the button when called.
     * 
     * @return blankTile icon.
     */
    public Icon icon()
    {
        return this.button.getIcon();
    }
}