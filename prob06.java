import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class prob06 {
    private static int[] arabic = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
    private static String[] martian = {"B", "BB", "BBB", "BW", "W", "WB", "WBB", "WBBB", "BK", "Z", "ZZ", "ZZZ", "ZP", "P", "PZ", "PZZ", "PZZZ", "ZB", "B", "BB", "BBB", "BG", "G", "GB", "GBB", "GBBB", "BR", "R"};
    private static List<Integer> orignal = new ArrayList<Integer>();




    public static void main(String[] args) throws IOException {
       Scanner in = new Scanner(new File("input.txt"));
        while (in.hasNext())
            orignal.add(in.nextInt());

        for(int temp: orignal){
            if(temp>=100){
                int temp1 = temp/100;
                temp1*=100;
                find(temp1);
                int temp2 = (temp-temp1)/10;
                temp2*=10;
                find(temp2);
                int temp3 = (temp - temp1 - temp2);
                find(temp3);
                System.out.println();
            }
            else{
                if(temp>=10){
                    int temp1 = temp/10;
                    temp1*=10;
                    find(temp1);
                    int temp2 = temp - temp1;
                    find(temp2);
                    System.out.println();
                }
                else{
                    find(temp);
                    System.out.println();
                }
            }
        }

/*        for (String temp : orignal) {
            if (temp.length() == 1) {
                find(temp);
                System.out.println();
            }

            if (temp.length() == 2) {
                if (temp.charAt(1) == '0') {
                    find(temp);
                    System.out.println();
                }
                else{
                    find(temp.substring(0,1));
                    find(temp.substring(1));
                    System.out.println();
                }
            }

            if(temp.length() == 3){
                if(temp.charAt(2)=='0')
                {
                    if(temp.charAt(1)=='0'){
                        find(temp);
                        System.out.println();
                    }
                    else{
                        find(temp.substring(0,1));
                        find(temp.substring(1));
                        System.out.println();
                    }
                }
                else if(temp.charAt(1)=='0'){
                    find(temp.substring(0,2));
                    find(temp.substring(2));
                    System.out.println();
                }
                else{
                    find(temp.substring(0,1));
                    find(temp.substring(1,2));
                    find(temp.substring(2));
                    System.out.println();
                }
            }

        }*/
    }

    private static void find(int temp) {
        int i = 0;
        for (int num: arabic) {
            if (num==temp) {
                break;
            }
            i++;
        }
        if(i<28)
            System.out.print(martian[i]);
    }
}
