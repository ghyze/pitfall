package nl.ghyze.pitfall;

public class FpsLimiter {
    int counter = 0;

    long previousTick = System.currentTimeMillis();

    public void tick(){
        counter++;

        long currentTick = System.currentTimeMillis();
        long duration = currentTick - previousTick;
        System.out.println(duration);
        if (duration < 16) {
            try {
                Thread.sleep(16 - duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        previousTick= currentTick;
    }
}
