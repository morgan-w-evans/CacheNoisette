import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LevelStore
{
    public LevelStore(int level)
    {
        if (level == 1) {

            GameBoard g = new GameBoard(1);
            Squirrel red = new Squirrel("red", 1, 1, 270);
            Squirrel grey = new Squirrel("grey", 2, 2, 0);
            g.add(red);
            g.add(grey);
            g.addFlowerBlock(2);
        }
        else if (level == 2) {

            GameBoard g = new GameBoard(2);
            Squirrel grey = new Squirrel("grey", 1, 0, 0);
            Squirrel brown = new Squirrel("brown", 2, 2, 270);
            g.add(grey);
            g.add(brown);
            g.addFlowerBlock(1);
        }
        else if (level == 3) {

            GameBoard g = new GameBoard(3);
            Squirrel black = new Squirrel("black", 1, 0, 90);
            Squirrel red = new Squirrel("red", 0, 3, 270);
            g.add(black);
            g.add(red);
            g.addFlowerBlock(0);
        }
        else if (level == 4) {

            GameBoard g = new GameBoard(4);
            Squirrel brown = new Squirrel("brown", 3, 1, 180);
            Squirrel black = new Squirrel("black", 2, 3, 270);
            g.add(brown);
            g.add(black);
            g.addFlowerBlock(1);
        }
    }
}