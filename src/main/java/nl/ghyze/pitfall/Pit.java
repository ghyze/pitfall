package nl.ghyze.pitfall;


import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.*;

public class Pit {

    private List<Line> lines = new ArrayList<>();
    private Player player;
    private boolean collission = false;


    public Pit(Player player){
        this.player= player;
        lines.add(new Line(700, 1300));
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
        Iterator<Line> lineIterator = lines.iterator();
        while (lineIterator.hasNext()){
            Line line = lineIterator.next();
            if (line.getHeightOffset() < -10){
                lineIterator.remove();
            }
            line.moveUp();
        }

        List<Line> linesInRange = getLinesInRange(1070);
        if(linesInRange.size() == 1){
            Line previousLine = linesInRange.get(0);
            int leftBorder = getBorder();
            int rightBorder = getBorder();

            lines.add(new Line(previousLine.getLeftBorder()+leftBorder, previousLine.getRightBorder()+rightBorder));
        }
    }

    private int getBorder() {
        double direction = Math.random();
        int border = 0;
        if (direction < 0.2){
            border = -10;
        } else if (direction > 0.8){
            border= 10;
        }
        return border;
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
