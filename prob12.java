import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class prob12 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        String line;

        while(in.hasNext()){
            line = in.nextLine();
            convert(line);
        }

    }

    public static void convert(String line)throws IOException{
        DecimalFormat df = new DecimalFormat("######0.00");
        int yard = 0;
        int feet = 0;
        int inch = 0;
        double cm;
        Scanner in = new Scanner(new String(line));
        if(in.hasNext())
            yard = in.nextInt();
        if(in.hasNext()) {
            feet = in.nextInt();
        }
        if(in.hasNext())
            inch = in.nextInt();

        feet+=yard*3;
        inch+=feet*12;

        cm = inch*2.54;
        String ans = df.format(cm);

        System.out.println(ans);
    }


}
