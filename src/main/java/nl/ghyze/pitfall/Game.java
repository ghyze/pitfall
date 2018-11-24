package nl.ghyze.pitfall;

import java.awt.*;

/**
 * Hello world!
 *
 */
public class Game
{
    public Game(){
        Window myWindow = new Window(null, null);

        try {
            ScreenFactory.getGraphicsDevice().setFullScreenWindow(myWindow);
            ScreenFactory.getGraphicsDevice().setDisplayMode(ScreenFactory.getDisplayMode());
            Thread.sleep(10 * 1000);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ScreenFactory.getGraphicsDevice().setDisplayMode(ScreenFactory.getDisplayMode());
            ScreenFactory.getGraphicsDevice().setFullScreenWindow(null);
        }
        System.exit(0);
    }



    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        new Game();
    }
}
