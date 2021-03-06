import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Point;

/**
* Listens for mouse clicks and move draw area.
*/
public class ClickListener implements MouseListener {
    
    private boolean mouse1Down = false;
    private DrawArea area;

    //Constructor.
    public ClickListener(DrawArea area) {
        this.area = area;
    }

    //Called when a mouse button is pressed.
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            ViewMover whileClick = new ViewMover();
            mouse1Down = true;
            whileClick.start(); //Start thread to move the view in the window.
        }
    }

    //Called when a mouse button is released
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            mouse1Down = false;
        }
    }

    //Must be included because implements.
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    /**
     * ViewMover
     * 
     * Holds a thread that enables the window to be moved whilst allowing
     * mouse events to still be listened to.
     */
    public class ViewMover extends Thread {
        
        //Called when the thread is started(this.start()).
        @Override
        public void run() {
            Point point = area.getMousePosition();

            if (point == null) { return; } //User has clicked outside the window.

            int xDist = area.getScreenX() - ((int) point.getX() * -1);
            int yDist = area.getScreenY() - ((int) point.getY() * -1);

            while (mouse1Down) {
                point = area.getMousePosition();
                if (point != null) {
                    area.setScreenX(((int) point.getX() * -1) + xDist);
                    area.setScreenY(((int) point.getY() * -1) + yDist);

                    area.repaint();
                }

                //Sleep so the thread doesn't use all the cpu time. lol.
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
