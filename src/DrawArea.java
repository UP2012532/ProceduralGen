import javax.swing.JPanel;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Font;
import java.awt.FontMetrics;

/**
* Component that can be painted to and displayed.
*/
public class DrawArea extends JPanel {

    private RandomLogic logic;
    private ClickListener clickListen;
    private ScrollListener scrollListen;

    //The width and height of each cell
    private int cellSize = 100;

    //Coordinate at the top left of the screen.
    private int xPos = 0;
    private int yPos = 0;

    //Constructor.
    public DrawArea() {
        setBackground(Color.gray);
        setDoubleBuffered(true);

        logic = new RandomLogic();

        clickListen = new ClickListener(this);
        addMouseListener(clickListen);

        scrollListen = new ScrollListener(this);
        addMouseWheelListener(scrollListen);
    }
    
    //Where all the window painting happens (called by this.repaint()).
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setFont(new Font("Arial", Font.PLAIN, 14));

        //Draw cells.
        drawCells(g2d);

        //Optionally draw grid.
        drawGrid(g2d);
    }

    /**
    * Draws each cell to the drawing area.
    *
    * @param  g2d  Graphics object that the cells are draw to.
    */
    private void drawCells(Graphics2D g2d) {
        //Offset: how far does each cell needs to be shifted over.
        int xOffset =  xPos % cellSize;
        int yOffset =  yPos % cellSize;

        //When the offset is negative it needs to be altered.
        if (xOffset < 0) xOffset = cellSize - Math.abs(xOffset);
        if (yOffset < 0) yOffset = cellSize - Math.abs(yOffset);

        //Finds the lowest x and y indexes of the cells on the screen.
        final int startXIndex = (int)(Math.floor((double)(xPos) / (double)cellSize));
        final int startYIndex = (int)(Math.floor((double)(yPos) / (double)cellSize));

        //Cell x and y: track the current cell that is being worked on
        int cellX = startXIndex;
        int cellY = startYIndex;

        //Iterate across screen space.
        for (int y = -yOffset; y < getHeight(); y += cellSize) {
            for (int x = -xOffset; x < getWidth(); x += cellSize) {
                //Draw cells to screen.
                g2d.setColor(logic.getCell(cellX, cellY));

                g2d.fillRect(x, y, cellSize, cellSize);
                
                //If the cells are too small don't bother drawing strings.
                if (cellSize >= 100) {
                    drawText(g2d, ""+logic.getSeed(cellX, cellY), x, y);
                }
                
                cellX++;
            }
            cellX = startXIndex;
            cellY++;
        }
    }

    /**
    * Draws a string in the center of a cell.
    *
    * @param  g2d  Graphics object that the cells are draw to.
    * @param  text  String to be drawn to the screen.
    * @param  x  The x coordinate of the top left corner of the cell.
    * @param  y  The y coordinate of the top left corner of the cell.
    */
    private void drawText(Graphics2D g2d, String text, int x, int y) {
        FontMetrics metrics = g2d.getFontMetrics(); //Get font data

        //Center text on cell.
        x += (cellSize - metrics.stringWidth(text)) / 2;
        y += ((cellSize - metrics.getHeight()) / 2) + metrics.getAscent();

        g2d.setColor(Color.white);
        g2d.drawString(text, x, y);
    }

    /**
    * Draws the grid lines to the drawing area.
    *
    * @param  g2d  Graphics object that the lines are draw to.
    */
    private void drawGrid(Graphics2D g2d) {
        //Offset: how far does each cell need to be shifted over.
        int xOffset =  xPos % cellSize;
        int yOffset =  yPos % cellSize;

        //When the offset is negative it needs to be altered.
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

    //---Getters---

    /**
    * Returns the x position of the coordinate in the top left corner.
    *
    * @return The x position of the draw area.
    */
    public int getScreenX() {
        return xPos;
    }

    /**
    * Returns the y position of the coordinate in the top left corner.
    *
    * @return The y position of the draw area.
    */
    public int getScreenY() {
        return yPos;
    }

    /**
    * Returns the current cell size.
    *
    * @return cellsize.
    */
    public int getCellSize() {
        return cellSize;
    }

    //---Setters---

    /**
    * Sets the x position of the drawing area.
    *
    * @param  x  The new x position of the window.
    */
    public void setScreenX(int x) {
        xPos = x;
    }

    /**
    * Sets the y position of the drawing area.
    *
    * @param  y  The new y position of the window.
    */
    public void setScreenY(int y) {
        yPos = y;
    }

    /**
    * Sets the cell size of the drawing area.
    *
    * @param  size  The new cell size for the window.
    */
    public void setCellSize(int size) {
        cellSize = size;
    }
}
