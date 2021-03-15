import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class stores the layout for all 60 game levels.
 * 
 * @author Morgan Evans
 */
public class LevelStore
{
    /**
     * Creates an instance of LevelStore to load a game level through GameBoard.
     * 
     * @param level level number. (1-60)
     */
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
        else if (level == 5) {

            GameBoard g = new GameBoard(5);
            Squirrel brown = new Squirrel("brown", 2, 2, 270);
            Squirrel black = new Squirrel("black", 1, 3, 180);
            g.add(brown);
            g.add(black);
            g.addFlowerBlock(0);
        }
        else if (level == 6) {

            GameBoard g = new GameBoard(6);
            Squirrel red = new Squirrel("red", 0, 2, 270);
            Squirrel black = new Squirrel("black", 1, 3, 270);
            g.add(red);
            g.add(black);
            g.addFlowerBlock(1);
        }
        else if (level == 7) {

            GameBoard g = new GameBoard(7);
            Squirrel brown = new Squirrel("brown", 1, 0, 90);
            Squirrel red = new Squirrel("red", 3, 0, 0);
            g.add(brown);
            g.add(red);
            g.addFlowerBlock(0);
        }
        else if (level == 8) {

            GameBoard g = new GameBoard(8);
            Squirrel black = new Squirrel("black", 3, 2, 180);
            Squirrel red = new Squirrel("red", 2, 3, 90);
            g.add(black);
            g.add(red);
            g.addFlowerBlock(3);
        }
        else if (level == 9) {

            GameBoard g = new GameBoard(9);
            Squirrel brown = new Squirrel("brown", 1, 0, 90);
            Squirrel black = new Squirrel("black", 2, 1, 0);
            g.add(brown);
            g.add(black);
            g.addFlowerBlock(0);
        }
        else if (level == 10) {

            GameBoard g = new GameBoard(10);
            Squirrel brown = new Squirrel("brown", 0, 2, 0);
            Squirrel black = new Squirrel("black", 3, 2, 180);
            g.add(brown);
            g.add(black);
            g.addFlowerBlock(3);
        }
        else if (level == 11) {

            GameBoard g = new GameBoard(11);
            Squirrel black = new Squirrel("black", 2, 1, 180);
            Squirrel brown = new Squirrel("brown", 3, 2, 180);
            g.add(black);
            g.add(brown);
            g.addFlowerBlock(1);
        }
        else if (level == 12) {

            GameBoard g = new GameBoard(12);
            Squirrel grey = new Squirrel("grey", 2, 2, 180);
            Squirrel black = new Squirrel("black", 2, 3, 270);
            g.add(grey);
            g.add(black);
            g.addFlowerBlock(2);
        }
        else if (level == 13) {

            GameBoard g = new GameBoard(13);
            Squirrel brown = new Squirrel("brown", 1, 3, 180);
            Squirrel grey  = new Squirrel("grey", 2, 2, 0);
            g.add(brown);
            g.add(grey);
            g.addFlowerBlock(0);
        }
        else if (level == 14) {

            GameBoard g = new GameBoard(14);
            Squirrel brown = new Squirrel("brown", 1, 1, 180);
            Squirrel black = new Squirrel("black", 0, 2, 0);
            g.add(brown);
            g.add(black);
            g.addFlowerBlock(3);
        }
        else if (level == 15) {

            GameBoard g = new GameBoard(15);
            Squirrel red = new Squirrel("red", 0, 3, 180);
            Squirrel black = new Squirrel("black", 1, 3, 270);
            g.add(red);
            g.add(black);
            g.addFlowerBlock(2);
        }
        else if (level == 16) {

            GameBoard g = new GameBoard(16);
            Squirrel red = new Squirrel("red", 3, 0, 90);
            Squirrel brown = new Squirrel("brown", 3, 1, 90);
            Squirrel black = new Squirrel("black", 2, 2, 90);
            g.add(red);
            g.add(brown);
            g.add(black);
        }
        else if (level == 17) {

            GameBoard g = new GameBoard(17);
            Squirrel brown = new Squirrel("brown", 0, 2, 0);
            Squirrel red = new Squirrel("red", 2, 3, 90);
            Squirrel grey = new Squirrel("grey", 3, 2, 180);
            g.add(brown);
            g.add(red);
            g.add(grey);
            g.addFlowerBlock(1);
        }
        else if (level == 18) {

            GameBoard g = new GameBoard(18);
            Squirrel brown = new Squirrel("brown", 0, 0, 0);
            Squirrel red = new Squirrel("red", 0, 2, 270);
            Squirrel black = new Squirrel("black", 1, 3, 270);
            g.add(brown);
            g.add(red);
            g.add(black);
            g.addFlowerBlock(3);
        }
        else if (level == 19) {

            GameBoard g = new GameBoard(19);
            Squirrel brown = new Squirrel("brown", 0, 0, 0);
            Squirrel black = new Squirrel("black", 0, 2, 270);
            Squirrel red = new Squirrel("red", 1, 3, 90);
            g.add(brown);
            g.add(black);
            g.add(red);
            g.addFlowerBlock(3);
        }
        else if (level == 20) {

            GameBoard g = new GameBoard(20);
            Squirrel brown = new Squirrel("brown", 3, 1, 180);
            Squirrel red = new Squirrel("red", 1, 1, 0);
            Squirrel black = new Squirrel("black", 1, 3, 270);
            g.add(brown);
            g.add(red);
            g.add(black);
            g.addFlowerBlock(3);
        }
        else if (level == 21) {

            GameBoard g = new GameBoard(21);
            Squirrel black = new Squirrel("black", 1, 1, 180);
            Squirrel grey = new Squirrel("grey", 2, 2, 180);
            Squirrel red = new Squirrel("red", 2, 3, 270);
            g.add(black);
            g.add(grey);
            g.add(red);
            g.addFlowerBlock(1);
        }
        else if (level == 22) {

            GameBoard g = new GameBoard(22);
            Squirrel red = new Squirrel("red", 1, 1, 90);
            Squirrel black = new Squirrel("black", 2, 1, 180);
            Squirrel brown = new Squirrel("brown", 3, 2, 180);
            g.add(red);
            g.add(black);
            g.add(brown);
        }
        else if (level == 23) {

            GameBoard g = new GameBoard(23);
            Squirrel brown = new Squirrel("brown", 1, 1, 270);
            Squirrel red = new Squirrel("red", 1, 3, 90);
            Squirrel black = new Squirrel("black", 2, 2, 0);
            g.add(brown);
            g.add(red);
            g.add(black);
            g.addFlowerBlock(0);
        }
        else if (level == 24) {

            GameBoard g = new GameBoard(24);
            Squirrel grey = new Squirrel("grey", 1, 1, 180);
            Squirrel black = new Squirrel("black", 2, 2, 0);
            Squirrel red = new Squirrel("red", 3, 1, 0);
            g.add(grey);
            g.add(black);
            g.add(red);
            g.addFlowerBlock(0);
        }
        else if (level == 25) {

            GameBoard g = new GameBoard(25);
            Squirrel grey = new Squirrel("grey", 0, 0, 0);
            Squirrel red = new Squirrel("red", 1, 1, 270);
            Squirrel black = new Squirrel("black", 3, 1, 180);
            Squirrel brown = new Squirrel("brown", 2, 2, 0);
            g.add(grey);
            g.add(red);
            g.add(black);
            g.add(brown);
        }
        else if (level == 26) {

            GameBoard g = new GameBoard(26);
            Squirrel grey = new Squirrel("grey", 1, 0, 90);
            Squirrel red = new Squirrel("red", 2, 1, 270);
            Squirrel black = new Squirrel("black", 0, 2, 270);
            Squirrel brown = new Squirrel("brown", 2, 3, 270);
            g.add(grey);
            g.add(red);
            g.add(black);
            g.add(brown);
        }
        else if (level == 27) {

            GameBoard g = new GameBoard(27);
            Squirrel grey = new Squirrel("grey", 0, 0, 0);
            Squirrel red = new Squirrel("red", 1, 1, 180);
            Squirrel brown = new Squirrel("brown", 2, 1, 270);
            Squirrel black = new Squirrel("black", 2, 3, 270);
            g.add(grey);
            g.add(red);
            g.add(brown);
            g.add(black);
        }
        else if (level == 28) {

            GameBoard g = new GameBoard(28);
            Squirrel grey = new Squirrel("grey", 3, 1, 180);
            Squirrel brown = new Squirrel("brown", 2, 1, 90);
            Squirrel black = new Squirrel("black", 1, 3, 180);
            g.add(grey);
            g.add(brown);
            g.add(black);
            g.addFlowerBlock(3);
        }
        else if (level == 29) {

            GameBoard g = new GameBoard(29);
            Squirrel grey = new Squirrel("grey", 0, 0, 270);
            Squirrel red = new Squirrel("red", 0, 2, 180);
            Squirrel brown = new Squirrel("brown", 2, 2, 270);
            g.add(grey);
            g.add(red);
            g.add(brown);
            g.addFlowerBlock(0);
        }
        else if (level == 30) {

            GameBoard g = new GameBoard(30);
            Squirrel brown = new Squirrel("brown", 1, 1, 180);
            Squirrel black = new Squirrel("black", 2, 1, 0);
            Squirrel red = new Squirrel("red", 0, 2, 270);
            g.add(brown);
            g.add(black);
            g.add(red); 
            g.addFlowerBlock(3);
        }
        else if (level == 31) {

            GameBoard g = new GameBoard(31);
            Squirrel black = new Squirrel("black", 2, 1, 270);
            Squirrel red = new Squirrel("red", 1, 3, 180);
            Squirrel grey = new Squirrel("grey", 3, 2, 90);
            g.add(black);
            g.add(red);
            g.add(grey);
            g.addFlowerBlock(1);
        }
        else if (level == 32) {

            GameBoard g = new GameBoard(32);
            Squirrel black = new Squirrel("black", 0, 0, 0);
            Squirrel brown = new Squirrel("brown", 3, 1, 180);
            Squirrel red = new Squirrel("red", 2, 2, 0);
            g.add(black);
            g.add(brown);
            g.add(red);
            g.addFlowerBlock(3);
        }
    }
}