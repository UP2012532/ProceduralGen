import java.util.Random;
import java.awt.Color;

public class RandomLogic {

    Random random;

    public RandomLogic() {
        random = new Random();
    }

    public int getSeed(int x, int y) {
        int xBias;
        int yBias;

        if (x > 0) {
            xBias = 1223;
        } else {
            xBias = 2437;
        }

        if (y > 0) {
            yBias = 7919;
        }
        else {
            yBias = 7571;
        }
        return (x * xBias) + (y * yBias);
    }

    //Returns an array of 3 ints representing a colour.
    public Color getTile(int x, int y) {

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
