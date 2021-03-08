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
        GameBoard program = new GameBoard();
        Squirrel red = new Squirrel("red", 270);
        program.add(red, 1, 1, false);

        Squirrel grey = new Squirrel("grey", 0);
        program.add(grey, 2, 2, false);

        program.addFlower(1,2);
    }
}