import java.awt.Dimension;
import javax.swing.JFrame;

/**
* Main window for the application.
*/
class MainWindow extends JFrame {

    private DrawArea canvas;

    //Entry point.
    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        mw.run();
    }

    //Create the main window from which the application will be run.
    public MainWindow() {
        //Set window title and set close opperation.
        setTitle("Procedural Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set initial sixe and add drawing area.
        setSize(new Dimension(1024, 576));
        canvas = new DrawArea();
        add(canvas);

        //Maximize and show window
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    //Start the mainloop for the application.
    public void run() {
        setVisible(true);
    }
}