import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DrawArea extends JPanel {
    public DrawArea() {
        this.setBackground(Color.CYAN);
        this.setDoubleBuffered(true);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //Draw cells.
        //drawCells(g2, cellSize, xOffset, yOffset)

        //Optionally draw grid.
        drawGrid(g2, 100, 0, 0);
    }

    //Draw the grid that the cells will occupy.
    private void drawGrid(Graphics2D g2, int cellSize, int xOffset, int yOffset) {
        g2.setColor(Color.BLACK);

        for (int y = yOffset; y < this.getHeight() - yOffset; y += cellSize) {
            g2.drawLine(0, y, this.getWidth(), y);
        }

        for (int x = xOffset; x < this.getWidth() - xOffset; x += cellSize) {
            g2.drawLine(x, 0, x, this.getHeight());
        }
    }
}
