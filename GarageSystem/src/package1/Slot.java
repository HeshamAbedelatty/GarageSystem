package package1;

public class Slot {
    private double depth;
    private double width;
    private int Id;
    private String arriveTime;

    private String leaveTime;
    private static int counter = 1100;
    private Vehicle SlottedVehicle;

    public Slot()
    {
        Id =  ++counter;
        SlottedVehicle = null;
    }
    public void setLeaveTime(String leaveTime)
    {
        this.leaveTime = leaveTime;
    }

    public void setArriveTime(String arriveTime)
    {
        this.arriveTime = arriveTime;
    }
    public String getArriveTime()
    {
        return arriveTime;
    }

    public String getLeaveTime()
    {
        return leaveTime;
    }
    public void setDepth(double depth) {
        this.depth = depth;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setSlottedVehicle(Vehicle slottedVehicle)
    {
        SlottedVehicle = slottedVehicle;
    }

    public double getDepth()
    {
        return depth;
    }

    public double getWidth()
    {
        return width;
    }

    public int getId()
    {
        return Id;
    }

    public Vehicle getSlottedVehicle()
    {
        return SlottedVehicle;
    }

}
