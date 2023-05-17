import package1.DisplayScreen;
import package1.DisplayScreen;

import java.text.ParseException;

public class Main {
    public static void main(String[] args)
    {
        DisplayScreen.startSystem();
        try {
            DisplayScreen.operations();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

