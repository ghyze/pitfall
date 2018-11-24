package nl.ghyze.pitfall;

import java.awt.*;

public class Player {

    private int xPos = 955;

    public void moveLeft(){
        xPos--;
    }

    public void moveRight(){
        xPos++;
    }

    public void draw(Graphics graphics){
        graphics.setColor(Color.GREEN);
        graphics.drawRect(xPos,600, 10,10);
    }

    public Rectangle bounds(){
        return new Rectangle(xPos, 600, 10, 10);
    }
}
