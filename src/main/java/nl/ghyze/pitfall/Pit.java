package nl.ghyze.pitfall;


import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.*;

public class Pit {

    private List<Line> lines = new ArrayList<>();
    private Player player;
    public boolean collission = false;


    public Pit(Player player){
        this.player= player;
        lines.add(new Line(700, 1300, 1080));
    }

    public void draw(Graphics graphics){
        for (Line line : lines) {
            line.draw(graphics);
        }
        if(collission){
            graphics.setColor(Color.RED);
            graphics.drawString("You've died, loser!", 940, 500);
        }
    }

    public void tick(){
        collission = collission(player);
        if (!collission) {
            Iterator<Line> lineIterator = lines.iterator();
            while (lineIterator.hasNext()) {
                Line line = lineIterator.next();
                if (line.getHeightOffset() < -10) {
                    lineIterator.remove();
                }
                line.moveUp();
            }

            List<Line> linesInRange = getLinesInRange(1070);
            if (linesInRange.size() == 1) {
                lines.add(linesInRange.get(0).createNextLine());
            }
        }
    }



    public boolean collission(Player player){
        boolean localCollission = false;
        for (Line line : getLinesInRange(600)) {
            if (player.bounds().x < line.getLeftBorder()) {
                localCollission = true;
            }
            if( player.bounds().x + player.bounds().width > line.getRightBorder()){
                localCollission = true;
            }
        }
        return localCollission;
    }

    private List<Line> getLinesInRange(int height){
        return lines.stream()
                .filter(line -> line.getHeightOffset() > height && line.getHeightOffset() < height+20)
                .collect(Collectors.toList());
    }

}
