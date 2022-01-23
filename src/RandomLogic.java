import java.util.Random;
import java.awt.Color;

/**
* Class for all the logic that determines how the cells are drawn.
*/
public class RandomLogic {

    Random random;

    //Constructer.
    public RandomLogic() {
        random = new Random();
    }

    /**
    * Given a coordinate returns a semi randomised seed to be used later (Based on PRNG).
    *
    * @param  x  The x coordinate of the cell.
    * @param  y  The y coordinate of the cell.
    * @return Returns the seed for the given seed.
    */
    public int getSeed(int x, int y) {
        final int a = 1664525;
        final int c = 1013904223; //1013904223
        final int m = (int)Math.pow(2, 32);

        final int inSeed = (x << y) + (x + y);
            
        return ((a * inSeed) + c) % m;
    }

    /**
    * Given a coordinate returns a colour for the cell.
    *
    * @param  x  The x coordinate of the cell.
    * @param  y  The y coordinate of the cell.
    * @return Colour the specified cell should be.
    */
    public Color getCell(int x, int y) {

        random.setSeed(getSeed(x, y));

        if (x == 0 && y == 0) return new Color(255, 0, 0);

        switch (random.nextInt(2)) {
            case 0: //Green
                return new Color(0, random.nextInt(256), 0);
            case 1: //Blue
                return new Color(0, 0, random.nextInt(256));
            default:
                return new Color(255, 255, 255);
        }
    }
}
