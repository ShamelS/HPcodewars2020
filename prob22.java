import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class prob22 {
    public static void main(String[] args) throws FileNotFoundException {
        char[] aString = {'A', '.', 'B', 'C', '.', 'D', '.', 'E', 'F', '.', 'G', '.', 'A'};
        char[] eString = {'E', 'F', '.', 'G', '.', 'A', '.', 'B', 'C', '.', 'D', '.', 'E'};

        Scanner in = new Scanner(new File("input.txt"));
        while(in.hasNextLine()) {
            String input = in.nextLine();
            if(input.equals("")) break;

            if(input.length() > 1) { //gave fret/string
                String[] fret_string = input.split(" ");
                int fret = Integer.parseInt(fret_string[0]);

                if(fret_string[1].equals("A")) {
                    if(fret == 12) {
                        System.out.println(aString[0]);
                    } else {
                        if(aString[fret + 1] != '.')
                            System.out.println(aString[fret + 1]);
                        else
                            System.out.println(aString[fret + 2]);
                    }
                }else if(fret_string[1].equals("E")) {
                    if(fret == 12) {
                        System.out.println(eString[0]);
                    } else {
                        if(eString[fret + 1] != '.')
                            System.out.println(eString[fret + 1]);
                        else
                            System.out.println(eString[fret + 2]);
                    }
                }
            } else { //given note
                char note = input.charAt(0);
                for(int i = 0; i < 13; i++) {
                    if(eString[i] == note) {
                        System.out.print(i + " E ");
                    }
                }
                for(int i = 0; i < 13; i++) {
                    if(aString[i] == note) {
                        System.out.print(i + " A ");
                    }
                }
                System.out.println();
            }
        }
    }
}
