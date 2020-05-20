import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class prob04 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int a, b, max, step, lcm = 0;
        a = in.nextInt();
        b = in.nextInt();

        if(a > b) {
            max = step = a;
        } else {
            max = step = b;
        }

        while (a != 0 && b!= 0) {
            if(max % a == 0 && max % b == 0) {
                lcm = max;
                break;
            }
            max += step;
        }
        System.out.println(lcm);
    }
}
