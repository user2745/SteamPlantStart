import java.util.Random;
import java.util.concurrent.TimeUnit;
import SteamPlant; 

public class SystemClock implements Runnable {
    private SteamPlant steamPlant;

    public SystemClock() {
        steamPlant = SteamPlant.getInstance();
    }

    @Override
    public void run() {
        double pressureChange;
        Random r = new Random(System.currentTimeMillis());
        while(true) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            steamPlant.reportHeatProduction();
            pressureChange = (2 * r.nextDouble()) - 1;
            steamPlant.changeCurrentPressure(pressureChange);
        }
    }
}