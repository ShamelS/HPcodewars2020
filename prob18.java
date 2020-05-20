import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class prob18 {
    public static void main(String[] args) throws IOException {
        DecimalFormat df = new DecimalFormat("######0.00");
        Scanner in = new Scanner(new File("input.txt"));
        String line;
        int hour, mins;
        double hourDeg, minDeg, degree;
        while(in.hasNext()){
            line = in.nextLine();
            Scanner input = new Scanner(new String(line));
            input.useDelimiter(":");
            hour = input.nextInt();
            if(hour>=12)
                hour-=12;
            mins = input.nextInt();

            hourDeg = hour*30.0 + mins/2.0;
            minDeg = mins*6.0;
            degree = hourDeg - minDeg;
            if(degree<0)
                degree*=-1;
            if(degree>180)
                degree = 360-degree;

            String ans = df.format(degree);
            System.out.println("The angle between the Hour hand and Minute hand is " + ans + " degrees.");
        }
    }
}
