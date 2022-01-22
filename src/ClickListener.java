import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Point;

public class ClickListener implements MouseListener {
    
    boolean mouse1Down = false;
    DrawArea area;

    public ClickListener(DrawArea area) {
        this.area = area;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            InnerClickListener whileClick = new InnerClickListener();
            mouse1Down = true;
            whileClick.start();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
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
     * InnerMouseListen
     */
    public class InnerClickListener extends Thread {
        
        @Override
        public void run() {
            Point point = area.getMousePosition();

            if (point == null) { return; }

            int xDist = area.xPos - ((int) point.getX() * -1);
            int yDist = area.yPos - ((int) point.getY() * -1);

            while (mouse1Down) {
                point = area.getMousePosition();
                if (point != null) {
                    area.xPos = ((int) point.getX() * -1) + xDist;
                    area.yPos = ((int) point.getY() * -1) + yDist;

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
