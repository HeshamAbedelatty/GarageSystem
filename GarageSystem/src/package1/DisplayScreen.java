package package1;


import java.text.ParseException;
import java.time.Duration;
import java.util.Scanner;

public class DisplayScreen {

    public static void displayFreeSlots()
    {
        for (int i = 0 ;i < Spaces.getInstance().getSize();i++)
        {
            if (Spaces.getInstance().getSpace(i).getSlottedVehicle()==null) {
                System.out.print("S " + Spaces.getInstance().getSpace(i).getId() + " ");
                System.out.print("Depth: "+ Spaces.getInstance().getSpace(i).getDepth()+ " ");
                System.out.print("Width: "+ Spaces.getInstance().getSpace(i).getWidth()+ " ");
            }
        }
        System.out.println();
    }
    public static void startSystem()
    {
        String str;
        int numOfSlots;
        int j =0;
        Scanner keyboard = new Scanner (System.in);
        System.out.println("Wellcome to Your Garage System");
        System.out.println("..........................................");
        System.out.print("Enter Manager's Password: ");
        str = keyboard.next();
        Garage.getInstance().setPassword(str);
        System.out.print("Enter number of slots: ");
        numOfSlots  = keyboard.nextInt();
        Spaces.getInstance().setSize(numOfSlots);

        for (int i = 0; i < Spaces.getInstance().getSize();i++)
        {
            j++;
            System.out.println("Slot "+j+": ");
            System.out.print("Enter depth of slot: ");
            double dep = keyboard.nextDouble();
            System.out.print("Enter width of slot: ");
            double wid = keyboard.nextDouble();
            Spaces.getInstance().addSlot(i,wid,dep);
        }
        System.out.println();
    }
    public static void info()
    {
        System.out.println();
        System.out.println("Choose operation number:");
        System.out.println("1.Park in.");
        System.out.println("2.Change configration.");
        System.out.println("3.Display free slots.");
        System.out.println("4.Park out.");
        System.out.println("5.Total income.");
        System.out.println("5.Total number of vehicles.");
        System.out.println("7.Exit.");
        System.out.print("Number: ");
    }

    public static void operations() throws ParseException {
        Scanner keyboard = new Scanner(System.in);
        int number;
        DisplayScreen.info();
        number = keyboard.nextInt();
        while (true) {
            if (number >= 7) {
                System.out.println("Exit.");
                break;
            }
            if (number == 1) {
                double depth, width;
                int modelYear;
                String modelName;
                Vehicle vehicle = new Vehicle();
                System.out.print("Enter Vehicle's depth: ");
                depth = keyboard.nextDouble();
                vehicle.setDepth(depth);
                System.out.print("Enter Vehicle's width: ");
                width = keyboard.nextDouble();
                vehicle.setWidth(width);
                System.out.print("Enter Vehicle's model year: ");
                modelYear = keyboard.nextInt();
                vehicle.setModelYear(modelYear);
                System.out.print("Enter Vehicle's model name: ");
                modelName = keyboard.next();
                vehicle.setModelName(modelName);
                boolean check = Spaces.getInstance().getConfigration().parkIn(vehicle);
                if (!check && Spaces.getInstance().getConfigration() instanceof BestFit) {
                    System.out.println("Error!! There is no fit slot.");
                }
                else if (!check && Spaces.getInstance().getConfigration() instanceof FirstCome) {
                    System.out.println("Error!! There is no free slot.");
                }
                else {
                    System.out.println("Id is " + Spaces.getInstance().getConfigration().getSlot_Id_That_Parked());
                    System.out.println("You should save this Id Because of needing for parking out");
                    System.out.println("Successful Operation.........");
                    vehicle = null;
                }
            }
            if (number == 2) {
                String password;
                System.out.print("Enter Password Manager: ");
                password = keyboard.next();
                while (! password.equals(Garage.getInstance().getPassword()))
                {
                    System.out.print("Error!! wrong password Enter again: ");
                    password = keyboard.next();
                }
                Spaces.getInstance().changeConfigration();
                System.out.println("Successful Operation.........");
            }
            if (number == 3) {
                DisplayScreen.displayFreeSlots();
                System.out.println("Successful Operation.........");
            }
            if (number == 4) {
                int id;
                Slot s;
                System.out.print("Enter Slot Id: ");
                id = keyboard.nextInt();
                while (!Spaces.getInstance().checkSlotId(id)) {
                    System.out.print("Error!! wrong Id Enter again: ");
                    id = keyboard.nextInt();
                }
                s = Garage.getInstance().parkOut(id);
                System.out.println("Vehicle Arrive Time: " + s.getArriveTime());
                System.out.println("Vehicle leave Time: " + s.getLeaveTime());
                System.out.println("Vehicle Model name: " + s.getSlottedVehicle().getModelName());
                System.out.println("Vehicle Model year: " + s.getSlottedVehicle().getModelYear());
                System.out.println("Vehicle Depth: " + s.getSlottedVehicle().getDepth());
                System.out.println("Vehicle Width: " + s.getSlottedVehicle().getWidth());
                System.out.println("Fees is " + Garage.getInstance().getFees());
                s.setSlottedVehicle(null);

            }
            if (number == 5) {
                String password;
                System.out.print("Enter Password Manager: ");
                password = keyboard.next();
                while (! password.equals(Garage.getInstance().getPassword()))
                {
                    System.out.print("Error!! wrong password Enter again: ");
                    password = keyboard.next();
                }
                System.out.println("Total Income: " + Garage.getTotalIncome());
                System.out.println("Successful Operation.........");
            }
            if (number == 6)
            {
                String password;
                System.out.print("Enter Password Manager: ");
                password = keyboard.next();
                while (! password.equals(Garage.getInstance().getPassword()))
                {
                    System.out.print("Error!! wrong password Enter again: ");
                    password = keyboard.next();
                }
                System.out.println("Total Number of Vehicle: " + Spaces.getTotalNumberVehicle());
            }
                DisplayScreen.info();
            number = keyboard.nextInt();
        }
        System.out.println();
    }

}
