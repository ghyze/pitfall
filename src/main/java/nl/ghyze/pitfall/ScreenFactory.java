package nl.ghyze.pitfall;

import java.awt.*;
import java.util.Arrays;

public class ScreenFactory {

    private static ScreenFactory instance;
    private DisplayMode oldDisplayMode;
    private DisplayMode newDisplayMode;
    private GraphicsDevice myDevice;

    private ScreenFactory(){
        // intentionaly left empty
    }

    public static DisplayMode getDisplayMode(){
        return getInstance().newDisplayMode;
    }

    public static DisplayMode getOldDisplayMode(){
        return getInstance().oldDisplayMode;
    }

    public static GraphicsDevice getGraphicsDevice(){
        return getInstance().myDevice;
    }

    private static ScreenFactory getInstance(){
        if (instance == null){
            instance = new ScreenFactory();

            if ( instance.newDisplayMode == null) {
                GraphicsEnvironment localGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                instance.myDevice = localGraphicsEnvironment.getDefaultScreenDevice();
                instance.newDisplayMode = Arrays.asList(instance.myDevice.getDisplayModes()).stream()
                        .filter(mode -> mode.getWidth() == 1024)
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException());
                instance.oldDisplayMode = instance.myDevice.getDisplayMode();

//        Arrays.asList(myDevice.getDisplayModes()).stream()
//                .map(Game::displayModeToString)
//                .forEach(System.out::println);
            }
        }
        return instance;
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
}
