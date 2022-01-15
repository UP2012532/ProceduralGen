import java.awt.Dimension;
import javax.swing.JFrame;

class MainWindow extends JFrame {

    private DrawArea canvas;
    private EventListener listener;

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        mw.run();
    }

    //Create the main window from which the application will be run.
    public MainWindow() {
        //Set window title and set close opperation.
        setTitle("");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Set initial sixe and add drawing area.
        setSize(new Dimension(1024, 576));
        canvas = new DrawArea();
        add(canvas);

        //Maximize and show window
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //Create event listeners.
        listener = new EventListener();
        addWindowListener(listener);
    }

    //Start the mainloop for the application.
    public void run() {
        setVisible(true);
        System.out.println("Running");

        while (listener.isOpen()) {
            setTitle("x:" + canvas.xPos + ", y:" + canvas.yPos);
            canvas.repaint();

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //listener.close();
        }

        System.out.println("Stopping");
    }
}