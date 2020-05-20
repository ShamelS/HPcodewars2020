import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class prob16 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        while(in.hasNextInt()) {
            double n1 = in.nextInt();
            double n2 = in.nextInt();
            String operator = in.next();
            double inputAnswer = in.nextDouble();
            double calcAnswer = 0;

            if(operator.equals("ADD")) {
                calcAnswer = n1 + n2;
            } else if(operator.equals("SUBTRACT")) {
                calcAnswer = n1 - n2;
            }else if(operator.equals("MULTIPLY")) {
                calcAnswer = n1 * n2;
            }else if(operator.equals("DIVIDE")) {
                calcAnswer = n1 / n2;
            }else if(operator.equals("POWER")) {
                calcAnswer = Math.pow(n1,n2);
            }
            calcAnswer = (double)Math.round(calcAnswer*10)/10;

            DecimalFormat df = new DecimalFormat("0.0");
            String charOperator = "";
            switch (operator) {
                case "ADD": charOperator = " + "; break;
                case "SUBTRACT": charOperator = " - "; break;
                case "MULTIPLY": charOperator = " * "; break;
                case "DIVIDE": charOperator = " / "; break;
                case "POWER": charOperator = " ^ "; break;
            }
            if(calcAnswer == inputAnswer) {
                System.out.println(df.format(inputAnswer) + " is correct for " + df.format(n1) + charOperator + df.format(n2));
            } else {
                System.out.println(df.format(n1) + charOperator + df.format(n2) + " = " + df.format(calcAnswer) + ", not " + df.format(inputAnswer));
            }
        }
    }
}
