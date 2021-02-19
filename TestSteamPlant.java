import java.util.Scanner;

public class TestSteamPlant {
    public static void main(String args[]) {
         Scanner in = new Scanner(System.in);
         System.out.println("Building 1");
         System.out.print("Enter the building size: ");
         int size1 = in.nextInt();
         System.out.print("Enter thermostat setting (in F): ");
         int thermostat1 = in.nextInt();
         System.out.print("Enter outside temperature (in F): ");
         int outsideTemperature1 = in.nextInt();

         System.out.println("Building 2");
         System.out.print("Enter the building size: ");
         int size2 = in.nextInt();
         System.out.print("Enter thermostat setting (in F): ");
         int thermostat2 = in.nextInt();
         System.out.print("Enter outside temperature (in F): ");
         int outsideTemperature2 = in.nextInt();

        SystemClock myClock = new SystemClock ();
        Thread t1 = new Thread(myClock);
        t1.start();

        Building myBuilding1 = new Building("Building 1", size1, thermostat1, outsideTemperature1);
        Thread t2 = new Thread(myBuilding1);
        t2.start();

        Building myBuilding2 = new Building("Building 2", size2, thermostat2, outsideTemperature2);
        Thread t3 = new Thread(myBuilding2);
        t3.start();
    }
}
