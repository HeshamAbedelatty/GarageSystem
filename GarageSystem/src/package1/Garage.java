package package1;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Garage {
    private String password;
    private static double totalIncome;

    private final static double salary_Of_Hour = 5.0;
    private double fees ;
    private static Garage obj;

    private Garage() {}

    public static Garage getInstance() {
        if (obj == null)
            obj = new Garage();
        return obj;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public double getFees() {
        double fee = fees;
        fees = 0.0;
        return fee;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public static double getTotalIncome() {
        return totalIncome;
    }
    public Slot parkOut(int id)
    {
        String str1,str2;
        double f;
        Slot s= Spaces.getInstance().searchById(id);
        s.setLeaveTime(Spaces.getInstance().calculateTime());
        str1 = s.getArriveTime();
        str2 = s.getLeaveTime();
        f = calculateFees(str1,str2);
        Garage.getInstance().increaseIncome(f);
        Garage.getInstance().setFees(f);
        return s;
    }



     public double  calculateFees(String start ,String end)
    {
        double Hours;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime .parse(start,formatter);
        LocalDateTime dateTime2 = LocalDateTime .parse(end,formatter);
        long diffInHours = java.time.Duration.between(dateTime1,dateTime2).toSeconds();
        Hours= Math.ceil((diffInHours/3600.0));
        return Hours*salary_Of_Hour;
    }
    public void increaseIncome(double fees)
    {
        totalIncome+=fees;
    }
}
