package package1;

public class Vehicle {
    private double depth;
    private double width;
    private int modelYear;
    private String modelName;

    public Vehicle()
    {
        depth = 0;
        width = 0;
        modelYear = 0;
        modelName = "";
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public void setDepth(double depth)
    {
        this.depth = depth;
    }


    public void setModelName(String modelName)
    {
        this.modelName = modelName;
    }

    public void setModelYear(int modelYear)
    {
        this.modelYear = modelYear;
    }

    public double getDepth()
    {
        return depth;
    }
    public double getWidth()
    {
        return width;
    }

    public int getModelYear()
    {
        return modelYear;
    }

    public String getModelName()
    {
        return modelName;
    }


}
