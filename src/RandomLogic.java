import java.util.Random;
import java.awt.Color;

public class RandomLogic {

    Random random;

    public RandomLogic() {
        random = new Random();
    }

    //Returns an array of 3 ints representing a colour.
    public Color getTile(long x, long y) {
        random.setSeed((x * 1223) + (y * 7919));

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
