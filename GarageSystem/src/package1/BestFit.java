package package1;

public class BestFit implements FittingSrag{
    public int Slot_Id_That_Parked;

    @Override
    public boolean parkIn(Vehicle f) {
        for (int i = 0 ;i < Spaces.getInstance().getSize();i++)
        {
            if(Spaces.getInstance().getSpace(i).getSlottedVehicle() == null)
            {
                if (f.getDepth() == Spaces.getInstance().getSpace(i).getDepth()
                        && f.getWidth() == Spaces.getInstance().getSpace(i).getWidth())
                {
                    Spaces.getInstance().getSpace(i).setSlottedVehicle(f);
                    Spaces.getInstance().getSpace(i).
                            setArriveTime(Spaces.getInstance().calculateTime());
                    Slot_Id_That_Parked = Spaces.getInstance().getSpace(i).getId();
                    Spaces.getInstance().addNumOfVechlie();
                    return true;
                }
            }
        }
        for (int i = 0 ;i < Spaces.getInstance().getSize();i++)
        {
            if (Spaces.getInstance().getSpace(i).getSlottedVehicle() == null)
            {
                if (f.getDepth() < Spaces.getInstance().getSpace(i).getDepth()
                        && f.getWidth() < Spaces.getInstance().getSpace(i).getWidth()) {
                    Spaces.getInstance().getSpace(i).setSlottedVehicle(f);
                    Spaces.getInstance().getSpace(i).
                            setArriveTime(Spaces.getInstance().calculateTime());
                    Slot_Id_That_Parked = Spaces.getInstance().getSpace(i).getId();
                    Spaces.getInstance().addNumOfVechlie();
                    return true;
                }
            }
        }
        return false;
    }

    public int getSlot_Id_That_Parked() {
        return Slot_Id_That_Parked;
    }
}
