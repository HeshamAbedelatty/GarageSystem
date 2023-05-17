package package1;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Spaces {
    private static Spaces obj;
    private  Slot [] parkingSpace ;
    private static int totalNumberVehicle ;

    public void setSize(int j) {
        size = j;
        parkingSpace = new Slot[size];
    }

    private int size ;
    private  FittingSrag configration;

    public FittingSrag getConfigration() {
        return configration;
    }

    private Spaces()
    {
        configration = new FirstCome();
    }
    public  static Spaces getInstance()
    {
        if (obj == null)
            obj = new Spaces();
        return obj;
    }
    public int getSize() {
        return size;
    }
    public Slot getSpace(int i)
    {
        return parkingSpace[i];
    }
    public Slot searchById(int id)
    {
        int j =0;
        for (int i = 0 ;i < Spaces.getInstance().getSize();i++)
        {
            if (Spaces.getInstance().getSpace(i).getId() == id)
            {
                j = i;
                break;
            }
        }
        return parkingSpace[j];
    }
    public String  calculateTime()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String str = dtf.format(now);
        return str;
    }
    public void changeConfigration()
    {
        if (configration instanceof BestFit)
        {
            configration = new FirstCome();
        }
        else if (configration instanceof FirstCome)
        {
            configration = new BestFit();
        }
    }
    public void addSlot(int i , double wid, double dep)
    {
        parkingSpace[i] = new Slot();
        Spaces.getInstance().parkingSpace[i].setWidth(wid);
        Spaces.getInstance().parkingSpace[i].setDepth(dep);
    }
    public static int getTotalNumberVehicle()
    {
        return totalNumberVehicle;
    }
    public void addNumOfVechlie()
    {
        totalNumberVehicle ++;
    }
    public boolean checkSlotId(int id)
    {
        for (int i = 0 ;i < Spaces.getInstance().getSize();i++)
        {
            if (Spaces.getInstance().getSpace(i).getId() == id)
            {
                return true;
            }
        }
        return false;
    }

}
