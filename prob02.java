import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.System.out;


final class prob02 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("input.txt"));
		int N = 1;

		while (N-- > 0) {
			StringBuilder input1= new StringBuilder(in.nextLine());
			out.println(input1.reverse());


		}
	}
}
