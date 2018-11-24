package nl.ghyze.pitfall;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Hello world!
 *
 */
public class GameLauncher
{
    private boolean running = true;
    private long startTime;
    private FpsLimiter limiter = new FpsLimiter();

    public GameLauncher(){
        Window myWindow = new Window(null, null);

        try {
            ScreenFactory.getGraphicsDevice().setFullScreenWindow(myWindow);
            ScreenFactory.getGraphicsDevice().setDisplayMode(ScreenFactory.getDisplayMode());
            startTime = System.currentTimeMillis();

            myWindow.createBufferStrategy(2);

            renderLoop(myWindow);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ScreenFactory.getGraphicsDevice().setDisplayMode(ScreenFactory.getDisplayMode());
            ScreenFactory.getGraphicsDevice().setFullScreenWindow(null);
        }
        System.out.println(limiter.counter/10);
        System.exit(0);
    }

    public void renderLoop(Window window){
        BufferStrategy strategy = window.getBufferStrategy();
        while(running){
            Graphics gr = strategy.getDrawGraphics();
            if (! strategy.contentsLost()) {
                gr.setColor(Color.BLACK);
                gr.fillRect(0, 0, 1920, 1080);
                gr.setColor(Color.BLUE);
                gr.drawString("Hello world!", 512, 384);
                strategy.show();
                gr.dispose();
                limiter.tick();
                checkTime();
            }
        }
    }

    private void checkTime(){
        if (System.currentTimeMillis() - startTime > 10*1000){
            running = false;
        }
    }

    public static void main( String[] args )
    {
        new GameLauncher();
    }
}
