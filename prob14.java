import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.out;

final class prob14 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("input.txt"));
			int n1 = in.nextInt();
			int n2 = in.nextInt();
			boolean tf=false;
			for(int k=n1;k<n2;k++){
				String equal=""+k;
				if(k>=10 && k<=99){
					int d1= Integer.parseInt(equal.substring(0,1));
					int d2= Integer.parseInt(equal.substring(1,2));
					if (d1==d2) {
						out.print(k + " ");
						tf=true;
					}

				}
				else if ((k>=100 && k<=999))
				{
					int d1= Integer.parseInt(equal.substring(0,1));
					int d2= Integer.parseInt(equal.substring(1,2));
					int d3= Integer.parseInt(equal.substring(2,3));
					if (Math.abs(d1+d3)== Math.abs(d2)) {
						out.print(k + " ");
						tf=true;
					}

				}
				else if((k>=1000 && k<=9999)) {
					int d1 = Integer.parseInt(equal.substring(0, 1));
					int d2 = Integer.parseInt(equal.substring(1, 2));
					int d3 = Integer.parseInt(equal.substring(2, 3));
					int d4 = Integer.parseInt(equal.substring(3, 4));
					if (Math.abs(d1+d3)== Math.abs(d2+d4)) {
						out.print(k + " ");
						tf=true;
					}

				}

			}
		if(!tf)
			out.print("No Numbers found with Equal Sum in the given range!!");

	}
}
