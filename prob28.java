import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class prob28 {
    static String line;
    static List<Double> numbers, testing;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File(("input.txt")));
        Scanner input;


        while (in.hasNext()) {
            numbers = new ArrayList<>();
            line = in.nextLine();
            input = new Scanner(line);
            while (input.hasNext()) {
                numbers.add(input.nextDouble());
            }
            fibonacci();
        }
    }

    public static void fibonacci() {
        testing = new ArrayList<>();
        double sum;
        boolean check = true;
        for (int i = 0; i < (numbers.size() - 2); i++) {
            sum = numbers.get(i) + numbers.get(i + 1);
            testing.add(sum);
        }
        double temp1, temp2;
        for (int j = 2; j < numbers.size(); j++) {
            temp1 = numbers.get(j);
            temp2 = testing.get(j - 2);
            if (temp1!=temp2)
                check = false;
        }

        if (check) {
            System.out.println("Fibonacci");
        } else
            exponential2();
    }

    public static void exponential2() {
        testing = new ArrayList<>();
        double sum;
        boolean check = true;
        for (int i = 0; i < (numbers.size() - 1); i++) {
            sum = Math.pow(numbers.get(i), 2);
            testing.add(sum);
        }
        double temp1, temp2;
        for (int j = 1; j < numbers.size(); j++) {
            temp1 = numbers.get(j);
            temp2 = testing.get(j-1);
            if (temp1 != temp2) {
                check = false;
            }
        }

        if (check)
            System.out.println("X^2");
        else
            exponential3();
    }

    public static void exponential3() {
        testing = new ArrayList<>();
        double sum;
        boolean check = true;
        for (int i = 0; i < (numbers.size() - 1); i++) {
            sum = Math.pow(numbers.get(i), 3);
            testing.add(sum);
        }
        double temp1, temp2;
        for (int j = 1; j < numbers.size(); j++) {
            temp1 = numbers.get(j);
            temp2 = testing.get(j-1);
            if (temp1!=temp2)
                check = false;
        }
        if (check)
            System.out.println("X^3");
        else
            geometric();
    }

    public static void geometric() {
        testing = new ArrayList<>();
        double sum;
        boolean check;
        for (int i = 1; i < (numbers.size()); i++) {
            sum = numbers.get(i) / numbers.get(i - 1);
            testing.add(sum);
        }
        check = true;
        double temp1, temp2;
        for (int j = 1; j < testing.size(); j++) {
            temp1 = testing.get(0);
            temp2 = testing.get(j);
            if (temp1!=temp2){
                check = false;}
        }

        if (check)
            System.out.println("Geometric");
        else
            geometricGaps();
    }

    public static void geometricGaps() {
        boolean check;
        int traverse = 0;
        int find = 0;
        double temp1, temp2;
        for (int j = 1; j < testing.size(); j++) {
            temp1 = testing.get(0);
            temp2 = testing.get(j);
            if (temp1==temp2){
                traverse++;}
        }
        if(traverse<1){
            find = 1;
            for (int j = 2; j < testing.size(); j++) {
                temp1 = testing.get(1);
                temp2 = testing.get(j);
                if (temp1==temp2)
                    traverse++;
            }
        }
        check = false;
        int mistake = 0;
        if(traverse==(testing.size()-2)){
            if(find!=0)
                mistake = 0;
            else{
                double temp3, temp4;
                for(int i = 1; i<testing.size(); i++){
                    temp3 = testing.get(0);
                    temp4 = testing.get(i);
                    if(temp3!=temp4) {
                        mistake = i;
                    }
                }

            }
            double temporary, temp3, temp4;
            for(int k = 2; k<=10; k++){
                temp3 = testing.get(mistake);
                temp4 = testing.get(find);
                if (temp3!= 0 && temp3>-1 && temp3<1){
                    temp3 = 1/temp3;
                    temp4 = 1/temp4;
                }

                temporary = Math.pow(temp3,k);
                if(temporary==temp4)
                    check = true;

                if(!check){
                    temporary = Math.pow(temp4,k);
                    if(temporary==temp3)
                        check = true;
                }
            }


        }

        if(check)
            System.out.println("Geometric (With Gaps)");
        else{
            int a;
            for(double printing: numbers) {
                a = (int)printing;
                System.out.print(a + " ");
            }
            System.out.println("is an Unknown series");
        }


    }

}
