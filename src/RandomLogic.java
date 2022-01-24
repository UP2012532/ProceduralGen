import java.awt.Color;

/**
* Contains random logic that determines how the cells are drawn.
*/
public class RandomLogic {

    private long nLehmer = 0;

    /**
    * Given a coordinate returns a semi randomised seed to be used later.
    *
    * @param  x  The x coordinate of the cell.
    * @param  y  The y coordinate of the cell.
    * @return Returns the seed for the given seed.
    */
    public long getSeed(int x, int y) {
        return (x & 0xFFFF) << 16 | (y & 0xFFFF);
    }

    /**
    * Based on Lehmer random number generator.
    *
    * https://en.wikipedia.org/wiki/Lehmer_random_number_generator
    *
    * @return Returns the randomised long.
    */
    private long Lehmer() {
        nLehmer += 0xe120fc15;
        long tmp;
        tmp = (long)nLehmer * 0x4a39b70d;
        long m1 = (tmp >> 32) ^ tmp;
        tmp = (long)m1 * 0x12fad5c9;
        long m2 = (tmp >> 32) ^ tmp;
        return m2;
    }

    /**
    * Given a coordinate returns a colour for the cell.
    *
    * @param  min  The minimum integer to generate (inclusive).
    * @param  max  The maximum integer to generate (exclusive).
    * @return The randomly generated number.
    */
    private int randInt(int min, int max) {
        return (int)((Lehmer() % (max - min)) + min);
    }

    /**
    * Given a coordinate returns a colour for the cell.
    *
    * @param  x  The x coordinate of the cell.
    * @param  y  The y coordinate of the cell.
    * @return Colour the specified cell should be.
    */
    public Color getCell(int x, int y) {
        nLehmer = getSeed(x, y);

        if (x == 0 && y == 0) return new Color(255, 0, 0);

        switch (randInt(0, 2)) {
            case 0: //Green
                return new Color(0, randInt(0, 256), 0);
            case 1: //Blue
                return new Color(0, 0, randInt(0, 256));
            default:
                return new Color(255, 255, 255);
        }
    }
}
