import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class prob21 {
    static String name, line, line1, line2, line3, line4, line5, ans;
    static double rate, hours, pay;
    static int in1, out1, in2, out2;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        DecimalFormat df = new DecimalFormat("######0.00");

        while(in.hasNext()){
            line = in.nextLine();
            name = line.substring(9);
            line1 = in.nextLine(); line1 = line1.substring(5);
            line2 = in.nextLine(); line2 = line2.substring(3);
            line3 = in.nextLine(); line3 = line3.substring(4);
            line4 = in.nextLine(); line4 = line4.substring(3);
            line5 = in.nextLine(); line5 = line5.substring(4);

            rate = Double.parseDouble(line1);
            in1 = Integer.parseInt(line2);
            out1 = Integer.parseInt(line3);
            in2 = Integer.parseInt(line4);
            out2 = Integer.parseInt(line5);

            hours = (out1/100 - in1/100) + (out2/100 - in2/100);
            hours += ((out1%100 - in1%100) + (out2%100 - in2%100))/60.0;
            pay = hours*rate;
            ans = df.format(pay);


            System.out.println(name + " earned $" + ans);

        }

    }
}
