import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class prob07 {
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * red = 1
         * blue = 3
         * yellow = 5
         *
         * purple = (1+3)/2 = 2
         * green = (3+5)/2 = 4
         * orange = 1+5 = 6
         *
         * white = light __
         * black = dark __
         */

        Scanner in = new Scanner(new File("input.txt"));
        while(in.hasNextLine()) {
            boolean neutral = false;
            String blendedColor = "";
            String rawColors = in.nextLine();
            String colors[] = rawColors.split(" ");

            int colorVal1 = getColorValue(colors[0]);
            int colorVal2 = getColorValue(colors[1]);

            if(colorVal1 == 1000 && colorVal2 == 1000) {
                blendedColor = "WHITE";
                neutral = true;
            } else if(colorVal1 == -1000 && colorVal2 == -1000) {
                blendedColor = "BLACK";
                neutral = true;
            } else if(colorVal1 == 1000 || colorVal2== 1000) {
                blendedColor += "LIGHT ";
            } else if (colorVal1 == -1000 || colorVal2 == -1000) {
                blendedColor += "DARK ";
            }

            if(Math.abs(colorVal1) == 1000)
                colorVal1 = 0;
            if(Math.abs(colorVal2) == 1000)
                colorVal2 = 0;

            if(colorVal1 == colorVal2 && !neutral) {
                blendedColor = getColorString(colorVal1);
            } else {
                blendedColor += (getColorString(colorVal1+colorVal2));
            }

            System.out.println(blendedColor);
//            System.out.println(colorVal1 +" "+ colorVal2);
//            System.out.println(colors[0] + colors[1]);

        }
    }

    public static int getColorValue(String colorStr) {
        int colorValue = 0;
        switch (colorStr) {
            case "RED": colorValue = 100; break;
            case "BLUE": colorValue = 10; break;
            case "YELLOW": colorValue = 1; break;

            case "PURPLE": colorValue = 110; break;
            case "GREEN": colorValue = 11; break;
            case "ORANGE": colorValue = 101; break;

            case "WHITE": colorValue = 1000; break;
            case "BLACK": colorValue = -1000; break;
        }
        return colorValue;
    }

    public static String getColorString(int colorVal) {
        String colorStr = "";
        switch (colorVal) {
            case 100: colorStr = "RED"; break;
            case 10: colorStr = "BLUE"; break;
            case 1: colorStr = "YELLOW"; break;

            case 110: colorStr = "PURPLE"; break;
            case 11: colorStr = "GREEN"; break;
            case 101: colorStr = "ORANGE"; break;
        }
        return colorStr;
    }
}
