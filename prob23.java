import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.out;

final class prob23 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("input.txt"));
		int N = Integer.parseInt(in.nextLine());

		String norm= "abcdefghijklmnopqrstuvwxyz ";
		String flip = "eqcpafgyijklwuodbrstnvmxhz ";

		while (N-- > 0) {
			String input= in.nextLine();
			input=input.replaceAll("[^\\p{L} ]","").toLowerCase();
			String input1=new String(input);
			out.print(input + " (");
			StringBuilder rev=new StringBuilder(input);
			rev=rev.reverse();
			input=rev.toString();
			String input2=new String(input);


			char arr[]=input2.toCharArray();
			for(int k=0;k<arr.length;k++){
				arr[k]=flip.charAt(norm.indexOf(arr[k]));
			}
			String input3=new String("");
			for(char b:arr)
				input3+=b;
			input3=input3.replaceAll(" ","");
			String input4=new String (input1.replaceAll(" ",""));

			if(input3.equals(input4))
				out.print("is) ");
			else
				out.print("not) ");
		for(char a:arr)
			out.print(a);
			out.println();






		}
	}
}
