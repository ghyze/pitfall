package nl.ghyze.pitfall;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Hello world!
 *
 */
public class GameLauncher
{
    private FpsLimiter limiter = new FpsLimiter();
    private Game game = new Game();

    public GameLauncher(){
        game.setUndecorated(true);

        try {
            ScreenFactory.getGraphicsDevice().setFullScreenWindow(game);
            ScreenFactory.getGraphicsDevice().setDisplayMode(ScreenFactory.getDisplayMode());

            game.createBufferStrategy(2);
            game.requestFocus();

            renderLoop(game);

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
        while(game.running){
            Graphics gr = strategy.getDrawGraphics();
            if (! strategy.contentsLost()) {
                game.draw(gr);
                strategy.show();
                gr.dispose();
                limiter.tick();
            }
        }
    }


    public static void main( String[] args )
    {
        new GameLauncher();
    }
}
