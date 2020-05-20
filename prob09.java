import java.io.File;
import java.io.IOException;
import java.util.*;

public class prob09 {
    public static int time = 3000;  //50*60
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        int min = in.nextInt();
        int sec = in.nextInt();
        int seconds = sec + min*60;

        time-=seconds;
        int finMin = time/60;
        int finSec = time%60;
        if(seconds<=1500)
            System.out.println("Time remaining " + finMin + " minutes and " + finSec + " seconds");
        else
            if(seconds<=3000)
                System.out.println("Time remaining " + finMin + " minutes and " + finSec + " seconds (we'll need both sides)");
            else
                System.out.println("Time remaining " + finMin + " minutes and " + finSec + " seconds (we're gonna need a bigger record)");
    }
}