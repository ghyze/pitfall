package nl.ghyze;

import java.awt.*;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public App(){
        GraphicsEnvironment localGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice myDevice = localGraphicsEnvironment.getDefaultScreenDevice();

        Window myWindow = new Window(null, null);
        DisplayMode oldDisplayMode
                = myDevice.getDisplayMode();

//        Arrays.asList(myDevice.getDisplayModes()).stream()
//                .map(App::displayModeToString)
//                .forEach(System.out::println);

        DisplayMode newDisplayMode = Arrays.asList(myDevice.getDisplayModes()).stream()
                .filter(mode -> mode.getWidth() == 1024)
                .findFirst()
                .orElseThrow(() -> new RuntimeException());

        try {
            myDevice.setFullScreenWindow(myWindow);
            myDevice.setDisplayMode(newDisplayMode);
            Thread.sleep(10 * 1000);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            myDevice.setDisplayMode(oldDisplayMode);
            myDevice.setFullScreenWindow(null);
        }
        System.exit(0);

    }

    static String displayModeToString(DisplayMode mode){
        StringBuilder builder = new StringBuilder();
        builder.append("Display mode: ")
                .append("width: ")
                .append(mode.getWidth())
                .append(", height: ")
                .append(mode.getHeight())
                .append(", depth: ")
                .append(mode.getBitDepth())
                .append(", refresh: ")
                .append(mode.getRefreshRate());
        return builder.toString();
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        new App();
    }
}
