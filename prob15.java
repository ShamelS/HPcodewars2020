import java.io.File;
import java.io.IOException;
import java.util.*;

public class prob15 {
    public static int num1,num2;
    public static String[] item1,item2;
    public static String line1,line2, line3, line4;
    public static Set<String> ans;
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("input.txt"));
        num1 = in.nextInt();
        num2 = in.nextInt();
        do{
            ans = new HashSet<>();
            in.nextLine();
            line1 = line3 = in.nextLine();
            line2 = line4 = in.nextLine();
            line1 = line1.toLowerCase();
            line2 = line2.toLowerCase();
            item1 = line1.split(" ");
            item2 = line2.split(" ");

            solve();
            display();
            System.out.println();
            num1 = in.nextInt();
            num2 = in.nextInt();

        }while((num1!=0 || num2!=0));
    }

    public static void solve(){
        for(String temp1: item1){
            for(String temp2: item2){
                    if (temp1.equals(temp2))
                        ans.add(temp1);
            }
        }
    }

    public static void display(){
        System.out.println(line3);
        System.out.println(line4);
        System.out.print(ans.size());
        for(String temp: ans)
            System.out.print(" " + temp);
    }
}
