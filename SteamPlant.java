public class SteamPlant {
    private static final double MAX_PRESSURE = 10.0;
    private static final double MIN_PRESSURE = 0.5;
    private static final double INITIAL_PRESSURE = 6.0;
    private static final int INITIAL_HEAT_AVAILABLE = 2000;
    private static final int FUEL_FLOW = 320;
    private double currentPressure;
    private int heatAvailable;
    private static volatile SteamPlant uniqueInstance;

    private SteamPlant() {
        currentPressure = INITIAL_PRESSURE;
        heatAvailable = INITIAL_HEAT_AVAILABLE;
    }

    public static SteamPlant getInstance()
    {
        if (uniqueInstance == null)
        {
            synchronized (SteamPlant.class)
            {
                if (uniqueInstance == null)
                {
                    uniqueInstance = new SteamPlant();
                }
            }
        }
        return uniqueInstance;
    }

    public int consumeHeat(String name, int h) {
        int consumed = (h < heatAvailable) ? h : heatAvailable;
        heatAvailable -= consumed;
        System.out.printf("%s: consumeHeat(%d): Consuming Heat Units: %d;" +
                          " Available Heat Left: %d\n", name, h, consumed, heatAvailable);
        return consumed;
    }

    public void setCurrentPressure(double p) {
        if (p > MAX_PRESSURE)
            currentPressure = MAX_PRESSURE;
        else if (p < MIN_PRESSURE)
            currentPressure = MIN_PRESSURE;
        else
            currentPressure = p;
    }

    public double changeCurrentPressure(double p) {
        setCurrentPressure(currentPressure + p);
        return currentPressure;
    }

    public void reportHeatProduction() {
        int newHeat = (int) (currentPressure - 2) * FUEL_FLOW;
        if (newHeat < 0) newHeat = 0;
        heatAvailable += newHeat;
        System.out.println ("Heat Production Report... Heat Produced: " + newHeat + " Heat Available: " + heatAvailable);
    }
}
