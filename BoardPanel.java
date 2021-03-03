import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardPanel extends JPanel
{
    JPanel panel = new JPanel();
    GridLayout layout = new GridLayout(4,4);
    Picture emptyPicture = new Picture ("icons/Empty.png", 0);
    Picture holePicture = new Picture("icons/Hole.png", 0);

    JButton empty[] = new JButton[12];
    JButton hole[] = new JButton[4];

    public BoardPanel()
    {
        this.panel.setLayout(this.layout);

        for(int i = 0; i < 12; i++)
        {
            this.empty[i] = new JButton(this.emptyPicture);
        }

        for(int j = 0; j < 4; j++)
        {
            this.hole[j] = new JButton(this.holePicture);
        }

        this.panel.add(this.empty[0]);
        this.panel.add(this.empty[1]);
        this.panel.add(this.hole[0]);
        this.panel.add(this.empty[2]);
        this.panel.add(this.hole[1]);
        this.panel.add(this.empty[3]);
        this.panel.add(this.empty[4]);
        this.panel.add(this.empty[5]);
        this.panel.add(this.empty[6]);
        this.panel.add(this.hole[2]);
        this.panel.add(this.empty[7]);
        this.panel.add(this.empty[8]);
        this.panel.add(this.empty[9]);
        this.panel.add(this.empty[10]);
        this.panel.add(this.empty[11]);
        this.panel.add(this.hole[3]);

    }
}