import java.io.File;
import java.io.IOException;
import java.util.*;

public class prob03 {
    public static void main(String[] args) throws IOException {
        // main throws IOException
        Scanner in = new Scanner(new File("input.txt"));
        int x = in.nextInt();
        int y = in.nextInt();
        int gcf = 0;


        if (x > y)
            gcf = (GCF(x, y));
        else if (y > x)
            gcf = GCF(y, x);
        else
            gcf = x;
        System.out.print(gcf);

    }

    private static int GCF(int X, int Y) {
        if (Y == 0)
            return X;
        else
            return GCF(Y, X % Y);
    }
}
