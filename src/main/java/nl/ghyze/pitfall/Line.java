package nl.ghyze.pitfall;

import java.awt.*;
import java.awt.image.*;

public class Line {

    private int leftBorder;
    private int rightBorder;

    private int heightOffset;

    private static BufferedImage tile = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);

    static {
        Graphics gr = tile.getGraphics();
        gr.setColor(Color.ORANGE);
        gr.fillRect(0,0,tile.getWidth(),tile.getHeight());
    }

    public Line(int leftBorder, int rightBorder, int heightOffset){

        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.heightOffset = heightOffset;
    }

    public void draw(Graphics graphics){
        graphics.setColor(Color.ORANGE);
        for(int i = 0; i < leftBorder; i+=10){
            graphics.drawImage(tile,i, heightOffset, null);
        }
        for(int i = rightBorder; i < 1920; i+=10){
            graphics.drawImage(tile,i, heightOffset, null);
        }

    }

    public int getLeftBorder(){
        return leftBorder;
    }

    public int getRightBorder() {
        return rightBorder;
    }

    public int getHeightOffset() {
        return heightOffset;
    }

    public void moveUp(){
        heightOffset = heightOffset- 2;
    }

    public Line createNextLine(){
        Line previousLine = this;
        int leftBorder = getBorder();
        int rightBorder = getBorder();

        Line newLine = new Line(previousLine.getLeftBorder() + leftBorder, previousLine.getRightBorder() + rightBorder, previousLine.getHeightOffset() + 10);
        return newLine;
    }

    private int getBorder() {
        double direction = Math.random();
        int border = 0;
        if (direction < 0.2){
            border = -10;
        } else if (direction > 0.8){
            border= 10;
        }

        if (direction < 0.1){
            border -= 10;
        } else if (direction > 0.9){
            border += 10;
        }
        return border;
    }
}
