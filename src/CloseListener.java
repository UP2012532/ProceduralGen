import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseListener extends WindowAdapter {

    private boolean open = true;
    
    //---Window open methods---
    @Override
    public void windowClosing(WindowEvent e) {
        open = false;
    }

    public void close() {
        open = false;
    }

    public boolean isWinOpen() {
        return open;
    }
}
