import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// 25,28
public class prob01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        System.out.println("Welcome to CodeWars, " + in.nextLine()+ "!");
    }
}
