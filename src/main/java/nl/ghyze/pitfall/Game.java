package nl.ghyze.pitfall;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.TreeSet;

public class Game extends Frame{

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

    public Game(){
        this.addKeyListener(keyAdapter);
    }

    public void draw(Graphics gr){
        gr.setColor(Color.BLACK);
        gr.fillRect(0, 0, 1920, 1080);
        gr.setColor(Color.BLUE);
        StringBuilder keysPressed = new StringBuilder();
        keysDown.stream()
                .map(key -> " "+key.intValue())
                .forEach(keysPressed::append);
        gr.drawString(keysPressed.toString(), 512, 384);
        tick();
    }

    private void tick(){
        if (keysDown.contains(Integer.valueOf(27))){
            // exit!
            running = false;

        }
    }
}
