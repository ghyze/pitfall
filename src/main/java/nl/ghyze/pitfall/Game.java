package nl.ghyze.pitfall;

import java.awt.*;

/**
 * Hello world!
 *
 */
public class Game
{
    private boolean running = true;
    private long startTime;

    public Game(){
        Window myWindow = new Window(null, null);

        try {
            ScreenFactory.getGraphicsDevice().setFullScreenWindow(myWindow);
            ScreenFactory.getGraphicsDevice().setDisplayMode(ScreenFactory.getDisplayMode());
            startTime = System.currentTimeMillis();

            renderLoop(myWindow.getGraphics());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ScreenFactory.getGraphicsDevice().setDisplayMode(ScreenFactory.getDisplayMode());
            ScreenFactory.getGraphicsDevice().setFullScreenWindow(null);
        }
        System.exit(0);
    }

    public void renderLoop(Graphics gr){
        while(running){
            gr.setColor(Color.blue);
            gr.drawString("Hello world!", 512, 384);
            checkTime();
        }
    }

    private void checkTime(){
        if (System.currentTimeMillis() - startTime > 10*1000){
            running = false;
        }
    }



    public static void main( String[] args )
    {
        new Game();
    }
}
