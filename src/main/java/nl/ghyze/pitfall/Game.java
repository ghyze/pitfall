package nl.ghyze.pitfall;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Game extends Frame{

    public static final Integer ESCAPE = Integer.valueOf(27);
    public static final Integer ARROW_LEFT = Integer.valueOf(37);
    public static final Integer ARROW_RIGHT = Integer.valueOf(39);
    public boolean running = true;

    public Set<Integer> keysDown = new TreeSet<>();

    KeyAdapter keyAdapter = new KeyAdapter() {

        @Override
        public void keyPressed(KeyEvent e) {
            keysDown.add(e.getKeyCode());
            System.out.println("Down: "+e.getKeyChar());
        }

        @Override
        public void keyReleased(KeyEvent e) {
            keysDown.remove(e.getKeyCode());
            System.out.println("Up: "+e.getKeyChar());
        }
    };

    Player player;

    Pit pit;

    public Game(){
        player = new Player();
        pit = new Pit(player);
        this.addKeyListener(keyAdapter);
    }

    public void draw(Graphics gr){
        gr.setColor(Color.BLACK);
        gr.fillRect(0, 0, 1920, 1080);
//        gr.setColor(Color.BLUE);
//        StringBuilder keysPressed = new StringBuilder();
//        keysDown.stream()
//                .map(key -> " "+key.intValue())
//                .forEach(keysPressed::append);
//        gr.drawString(keysPressed.toString(), 512, 384);
        player.draw(gr);
        pit.draw(gr);

    }

    public void tick(){
        handleInput();
        pit.tick();
    }

    private void handleInput() {
        if (keysDown.contains(ESCAPE)){
            // exit!
            running = false;
        }

        if (keysDown.contains(ARROW_LEFT)){
            // move left
            player.moveLeft();
        }

        if (keysDown.contains(ARROW_RIGHT)){
            // move right
            player.moveRight();
        }
    }
}
