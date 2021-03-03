import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArrowButton
{
    private int rotation = 0;
    private String size;
    
    private Picture arrow = new Picture("icons/"+size+"Arrow.png", rotation);
    private JButton arrowButton = new JButton(arrow);

    public ArrowButton(boolean b, int n)
    {
        this.rotation = n;

        if(b == true){
            this.size = "Big";
        }

        return;

    }
}