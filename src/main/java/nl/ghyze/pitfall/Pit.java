package nl.ghyze.pitfall;

import java.awt.*;

public class Pit {

    private Line line = new Line();

    public void draw(Graphics graphics){
        line.draw(graphics);
    }

    public boolean collission(Player player){
        if (player.bounds().x < line.getLeftBorder()){
            return true;
        }
        return player.bounds().x + player.bounds().width > line.getRightBorder();
    }
}
