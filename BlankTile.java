import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlankTile
{
    private Picture pic;
    private JButton button;

    public BlankTile()
    {
        this.pic = new Picture("icons/Empty.png", 0);
        this.button = new JButton(this.pic);
        this.button.setRolloverEnabled(false);
        this.button.setBorderPainted(false);
        
    }

    public JButton button()
    {
        return this.button;
    }
}