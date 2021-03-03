import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArrowButton
{
    
    private GameBoard board;
    
    private Picture big;
    private JButton button;


    public ArrowButton()
    {
       this.big = new Picture ("icons/BigArrow.pnG", 0);
       this.button = new JButton(this.big);
       

    }

}