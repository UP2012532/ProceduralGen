import javax.swing.JPanel;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class DrawArea extends JPanel {

    RandomLogic logic;
    ClickListener listener;
    int cellSize = 100;
    int xPos = 0;
    int yPos = 0;

    //Constructor.
    public DrawArea() {
        setBackground(Color.gray);
        setDoubleBuffered(true);

        logic = new RandomLogic();

        listener = new ClickListener(this);
        addMouseListener(listener);
    }
    
    //Where all the window painting happens.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //Draw cells.
        drawCells(g2d);

        //Optionally draw grid.
        drawGrid(g2d);
    }

    //Draw tiles to window.
    private void drawCells(Graphics2D g2d) {
        int xOffset =  xPos % cellSize;
        int yOffset =  yPos % cellSize;

        if (xOffset < 0) xOffset = cellSize - Math.abs(xOffset);
        if (yOffset < 0) yOffset = cellSize - Math.abs(yOffset);

        final int startXIndex = (int)(Math.floor((double)(xPos) / (double)cellSize));
        final int startYIndex = (int)(Math.floor((double)(yPos) / (double)cellSize));

        int cellX = startXIndex;
        int cellY = startYIndex;

        for (int y = -yOffset; y < getHeight(); y += cellSize) {
            for (int x = -xOffset; x < getWidth(); x += cellSize) {
                g2d.setColor(logic.getTile(cellX, cellY));
                g2d.fillRect(x, y, cellSize, cellSize);

                g2d.setColor(Color.white);
                g2d.drawString("" + logic.getSeed(cellX, cellY), x + cellSize / 2, y + cellSize / 2);
                
                cellX++;
            }
            cellX = startXIndex;
            cellY++;
        }
    }

    //Draw the grid that the cells will occupy.
    private void drawGrid(Graphics2D g2d) {
        int xOffset =  xPos % cellSize;
        int yOffset =  yPos % cellSize;

        if (xOffset < 0) xOffset = cellSize - Math.abs(xOffset);
        if (yOffset < 0) yOffset = cellSize - Math.abs(yOffset);

        g2d.setColor(Color.black);
        
        //Draw horizontal lines.
        for (int y = -yOffset; y < getHeight(); y += cellSize) {
            g2d.drawLine(0, y, getWidth(), y);
        }

        //Draw vertical lines.
        for (int x = -xOffset; x < getWidth(); x += cellSize) {
            g2d.drawLine(x, 0, x, getHeight());
        }
    }
}
