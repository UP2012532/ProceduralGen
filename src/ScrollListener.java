import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import java.awt.Point;

/**
 * Changes the cell size when the scroll wheel is moved.
 */
public class ScrollListener implements MouseWheelListener {

    private DrawArea area;
    
    //Constructor.
    public ScrollListener(DrawArea area) {
        this.area = area;
    }

    //Called when the scroll wheel is moved.
    public void mouseWheelMoved(MouseWheelEvent e) {
        final int increase = e.getWheelRotation() * -10; //How much the cell size be increased by.
        final int newSize = area.getCellSize() + increase;

        if (newSize <= 0 || newSize > 400) { return; }

        final double x = area.getScreenX();
        final double y = area.getScreenY();
        final double size = area.getCellSize();

        final Point point = area.getMousePosition();

        area.setScreenX((int)(x + increase * (x / size + point.getX() / size)));
        area.setScreenY((int)(y + increase * (y / size + point.getY() / size)));

        area.setCellSize(newSize);
        area.repaint();
    }
}
