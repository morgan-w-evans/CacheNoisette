import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Levels
{
    //private int levelSelect = 0;
    
    GUI u = new GUI();
    GameBoard g = new GameBoard(u);
    boolean play = true;
    
    Squirrel redUp = new Squirrel("red", 0, 0, 0);
    Squirrel redDown = new Squirrel("red", 0, 0, 90);
    Squirrel redLeft = new Squirrel("red", 0, 0, 180);
    Squirrel redRight = new Squirrel("red", 0, 0, 270);

    Squirrel greyUp = new Squirrel("grey", 0, 0, 0);
    Squirrel greyDown = new Squirrel("grey", 0, 0, 90);
    Squirrel greyLeft = new Squirrel("grey", 0, 0, 180);
    Squirrel greyRight = new Squirrel("grey", 0, 0, 270);

    Squirrel brownUp = new Squirrel("brown", 0, 0, 0);

    public Levels()
    {
        
    }

    public void levelSelect()
    {
        while(play) {
            System.out.println("");

            if (u.level() == 1) {

                redRight.xHeadPos(1);
                redRight.yHeadPos(1);
                g.add(redRight);

                greyUp.xHeadPos(2);
                greyUp.yHeadPos(2);
                g.add(greyUp);

                g.addFlowerBlock(2);
            }
            else if (u.level() == 101 | g.levelComplete()) {
                
                g.remove(redRight);
                g.remove(greyUp);
                g.removeFlowerBlock(2);
            }

        }
    }
}