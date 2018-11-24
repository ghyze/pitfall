package nl.ghyze.pitfall;

import java.awt.*;

public class Line {

    private int leftBorder = 700;
    private int rightBorder = 1300;

    public void draw(Graphics graphics){
        graphics.setColor(Color.ORANGE);
        graphics.drawLine(leftBorder,550,leftBorder, 650);
        graphics.drawLine(rightBorder,550,rightBorder, 650);
    }

    public int getLeftBorder(){
        return leftBorder;
    }

    public int getRightBorder() {
        return rightBorder;
    }
}
