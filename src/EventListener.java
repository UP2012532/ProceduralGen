import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventListener extends WindowAdapter {

    private boolean open = true;
    
    @Override
    public void windowClosing(WindowEvent e) {
        open = false;
    }

    public void close() {
        open = false;
    }

    public boolean isOpen() {
        return open;
    }
}
