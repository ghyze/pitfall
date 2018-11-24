package nl.ghyze.pitfall;

import java.awt.*;
import java.awt.image.*;

public class Line {

    private int leftBorder;
    private int rightBorder;

    private int heightOffset = 1080;

    private static BufferedImage tile = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);

    static {
        Graphics gr = tile.getGraphics();
        gr.setColor(Color.ORANGE);
        gr.fillRect(0,0,tile.getWidth(),tile.getHeight());
    }

    public Line(int leftBorder, int rightBorder){

        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
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
}
