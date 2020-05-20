import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.out;

final class prob11 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("input.txt"));

		while (in.hasNextInt()) {
			int var = in.nextInt();
			String a= Integer.toBinaryString(var);
			if(a.length()%2 ==0)
				out.print(var+ " no\n" );
			else if (a.contains("0") == false){
				out.print(var+ " no\n" );
			}

			else if (a.indexOf("0")==((a.length()/2))) {
				if (a.indexOf("0", (a.length() / 2)+1) != -1)
					out.print(var + " no\n");
				else
					out.print(var + " yes\n");
			}
			else if(a.indexOf("0")==-1 || a.indexOf("0") != (a.length()/2))
				out.print(var+ " no\n" );


		}
	}
}
