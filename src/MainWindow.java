import java.awt.Dimension;
import javax.swing.JFrame;

class MainWindow extends JFrame {
    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        mw.run();
    }

    //Create the main window from which the application will be run.
    public MainWindow() {
        this.setTitle("Hello World");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(new Dimension(400, 400));
        this.setVisible(true);
    }

    //Start the mainloop for the application.
    public void run() {
        System.out.println("Running");
    }
}