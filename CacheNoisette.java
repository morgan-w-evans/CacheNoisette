import java.util.*;

/**
 * Cache Noisette has been designed as part of the SCC.110 Java Coursework for 2020-21.
 * 
 * This class contains the main method required to run the program.
 * The program consists of GUIs that create a fully functional board game,
 * allowing the user to navigate objects around a grid, in order to
 * accomplish a task and complete the level.
 * 
 * @author Morgan Evans
 */
public class CacheNoisette
{
    public static void main (String[] args)
    {
        GUI u = new GUI();
        GameBoard g = new GameBoard(u);
        boolean play = true;
        
        Squirrel redUp = new Squirrel("red", 0, 0, 0);
        Squirrel redRight = new Squirrel("red", 1, 0, 90);
        Squirrel redDown = new Squirrel("red", 0, 1, 180);
        Squirrel redLeft = new Squirrel("red", 0, 0, 270);

        Squirrel greyUp = new Squirrel("grey", 0, 0, 0);
        Squirrel greyRight = new Squirrel("grey", 1, 0, 90);
        Squirrel greyDown = new Squirrel("grey", 0, 1, 180);
        Squirrel greyLeft = new Squirrel("grey", 0, 0, 270);

        Squirrel brownUp = new Squirrel("brown", 0, 0, 0);
        Squirrel brownRight = new Squirrel("brown", 1, 0, 90);
        Squirrel brownDown = new Squirrel("brown", 0, 1, 180);
        Squirrel brownLeft = new Squirrel("brown", 0, 0, 270);

        Squirrel blackUp = new Squirrel("black", 0, 0, 90);
        Squirrel blackRight = new Squirrel("black", 1, 0, 90);
        Squirrel blackDown = new Squirrel("black", 0, 1, 180);
        Squirrel blackLeft = new Squirrel("black", 0, 0, 270);

        while (play) {

            System.out.print("");

            if (u.level() == 1) {

                g.add(redLeft);
                g.move(redLeft, 1, 1);
                g.add(greyUp);
                
                g.move(greyUp, 2, 2);
                g.addFlowerBlock(2);
                g.startTimer();
            }
            else if (u.level() == 101 | g.levelComplete()) {

                g.remove(redLeft);
                g.remove(greyUp);
                g.removeFlowerBlock(2);
            }

        }
    }
}