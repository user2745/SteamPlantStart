import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Building implements Runnable {
    private SteamPlant steamPlant;
    private int size;
    private int thermostatSetting;
    private int outsideTemperature;
    private String name;

    public Building(String name, int size, int thermostatSetting, int outsideTemperature) {
        steamPlant = steamPlant.getInstance();
        this.size = size;
        this.thermostatSetting = thermostatSetting;
        this.outsideTemperature = outsideTemperature;
        this.name = name;
    }

    @Override
    public void run() {
        int h=0;
        Random r = new Random(System.currentTimeMillis());
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            h = (thermostatSetting-outsideTemperature)*(size/2500) + (int) (r.nextDouble()*0.6*h);
            if (h < 0) h = 0;
            steamPlant.consumeHeat(name, h);
        }
    }
}
