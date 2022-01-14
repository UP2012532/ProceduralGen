import javax.swing.JPanel;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class DrawArea extends JPanel {

    RandomLogic logic;

    public DrawArea() {
        setBackground(Color.CYAN);
        setDoubleBuffered(true);

        logic = new RandomLogic();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        final int cellSize = 50;

        //Draw cells.
        drawCells(g2d, cellSize, 0, 0);

        //Optionally draw grid.
        drawGrid(g2d, cellSize, 0, 0);
    }

    //Draw tiles to window
    private void drawCells(Graphics2D g2d, int cellSize, int xOffset, int yOffset) {
        for (int y = yOffset; y < getHeight() - yOffset; y += cellSize) {
            for (int x = xOffset; x < getWidth() - xOffset; x += cellSize) {
                g2d.setColor(logic.getTile());
                g2d.fillRect(x, y, 100, 100);
            }
        }
    }

    //Draw the grid that the cells will occupy.
    private void drawGrid(Graphics2D g2d, int cellSize, int xOffset, int yOffset) {
        g2d.setColor(Color.black);
        
        //Draw horizontal lines.
        for (int y = yOffset; y < getHeight() - yOffset; y += cellSize) {
            g2d.drawLine(0, y, getWidth(), y);
        }

        //Draw vertical lines.
        for (int x = xOffset; x < getWidth() - xOffset; x += cellSize) {
            g2d.drawLine(x, 0, x, getHeight());
        }
    }
}
