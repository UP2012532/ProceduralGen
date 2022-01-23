import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseListener extends WindowAdapter {

    private boolean open = true;
    
    //Called when the window X button is clicked.
    @Override
    public void windowClosing(WindowEvent e) {
        open = false;
    }

    //Changes the open state of the window to be false (closed).
    public void close() {
        open = false;
    }

    //Returns the state of the window
    public boolean isWinOpen() {
        return open;
    }
}
