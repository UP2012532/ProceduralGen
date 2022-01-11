import java.awt.Dimension;
import javax.swing.JFrame;

class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(new Dimension(400, 400));
        frame.setVisible(true);
    }
}