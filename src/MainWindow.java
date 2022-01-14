import java.awt.Dimension;
import javax.swing.JFrame;

class MainWindow extends JFrame {

    DrawArea canvas;

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        mw.run();
    }

    //Create the main window from which the application will be run.
    public MainWindow() {
        //Set window title and set close opperation
        this.setTitle("Hello World");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set initial sixe and add drawing area
        this.setSize(new Dimension(1024, 576));
        canvas = new DrawArea();
        this.add(canvas);

        //Maximize and show window
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    //Start the mainloop for the application.
    public void run() {
        this.setVisible(true);
        System.out.println("Running");
    }
}