import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.prefs.PreferenceChangeListener;

import static java.lang.System.out;

final class prob29 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("input.txt"));
		String error[] = {"10 Variable declared but not used", "20 Unexpected indentation", "30 Trailing whitespace", "40 Func declaration without documentation"};
		int line = 1;
		StringBuilder indent = new StringBuilder("    ");
		boolean func = false;
		ArrayList<Integer> var = new ArrayList<Integer>();
		ArrayList<String> errors = new ArrayList<String>();
		String funcname = "";
		ArrayList<String> code = new ArrayList<String>();//arraylist to hold variables
		String[] arr;
		while (in.hasNextLine()) {
			boolean TFM=false;
			String og = in.nextLine();//full line w errors

			String fix = og.trim();//trimmed line without errors
			StringBuilder lines = new StringBuilder(fix);//trimmed line without errors


			if (fix.isEmpty()){
				line++;}
			else if (og.charAt(0) == 'V') {

				arr = fix.split(" ");
				code.add(arr[1]);
				var.add(line);
				line++;

			} else if (og.charAt(0) == '#') {

				arr = fix.split(" ");
				if(og.length()==1)
					line++;
				else{
				funcname = arr[1];
				line++;}

			} else if (fix.substring(0, 5).equals("FUNC ")) {

				if(!(fix.charAt(0)==(og.charAt(0)))){
					errors.add(line + ":" + error[1]);

				}
				else if(!(fix.charAt(fix.length()-1)==(og.charAt(og.length()-1)))){
					errors.add(line + ":" + error[2]);
				}



				arr = fix.split(" ");
				if(funcname.length()==0)
					errors.add(line + ":" + error[3]);
				else if (!((arr[1].substring(0,funcname.length())).equals(funcname))) {
					errors.add(line + ":" + error[3]);

				}
				line++;

				og = in.nextLine();
				fix = og.trim();

				lines = new StringBuilder(fix);
				indent = new StringBuilder("    ");
				while (!og.contains("ENDFUNC")) {


					String fix2=new String(fix);
					String og2=new String(og);

					if(fix2.contains("$") ){
						int k=0;

						arr=fix2.split(" ");
						TFM=false;
						while(fix2.contains("$") && code.size()!=0 && !TFM) {

							boolean TF = false;

							for (int i = 0; (i < code.size()) && (!TF) && (code.size()!=0) ; i++) {

								for (int j = 0; (j < arr.length) && (!TF )&& (code.size()!=0)  ; j++) {
									if((i==code.size()-1) && (j==arr.length-1))
										TFM=true;
									if ((("$" + code.get(i)).equals(arr[j])) && code.size()!=0 && ((fix2.indexOf("#") == -1 ||fix2.indexOf("#")>fix.indexOf(arr[j])) )) {

										TF = true;

										code.remove(i);
										var.remove(i);

										fix2=fix2.replaceFirst("[$]","%");

									}

								}


							}

						}


					}

					indent = new StringBuilder("    ");


					if (!((indent.append(fix)).toString().equals(og))) {
						errors.add(line + ":" + error[1]);

					}
					indent = new StringBuilder("    ");
					og = in.nextLine();
					fix = og.trim();
					line++;

				}
				if(!(fix.charAt(0)==(og.charAt(0)))){
					errors.add(line + ":" + error[1]);

				}
				if(!(fix.charAt(fix.length()-1)==(og.charAt(og.length()-1)))){
					errors.add(line + ":" + error[2]);
				}
				line++;


			}
			else if (fix.substring(0, 3).equals("IF ")) {
				if(!(fix.charAt(0)==(og.charAt(0)))){
					errors.add(line + ":" + error[1]);

				}
				else if(!(fix.charAt(fix.length()-1)==(og.charAt(og.length()-1)))){
					errors.add(line + ":" + error[2]);
				}
				og = in.nextLine();
				fix = og.trim();
				line++;

				lines = new StringBuilder(fix);
				indent = new StringBuilder("    ");
				while (!og.contains("ENDIF")) {


					String fix2=new String(fix);
					String og2=new String(og);

					if(fix2.contains("$") ){
						int k=0;

						arr=fix2.split(" ");
						TFM=false;
						while(fix2.contains("$") && code.size()!=0 && !TFM) {

							boolean TF = false;

							for (int i = 0; (i < code.size()) && (!TF) && (code.size()!=0) ; i++) {

								for (int j = 0; (j < arr.length) && (!TF )&& (code.size()!=0)  ; j++) {
									if((i==code.size()-1) && (j==arr.length-1))
										TFM=true;
									if ((("$" + code.get(i)).equals(arr[j])) && code.size()!=0 && ((fix2.indexOf("#") == -1 ||fix2.indexOf("#")>fix.indexOf(arr[j])) )) {

										TF = true;



										code.remove(i);
										var.remove(i);

										fix2=fix2.replaceFirst("[$]","%");

									}

								}


							}

						}


					}


					if (!indent.append(fix).toString().equals(og)) {
						errors.add(line + ":" + error[1]);

					}
					indent = new StringBuilder("    ");
					og = in.nextLine();
					fix = og.trim();
					line++;

				}
				if(!(fix.charAt(0)==(og.charAt(0)))){
					errors.add(line + ":" + error[1]);

				}
				if(!(fix.charAt(fix.length()-1)==(og.charAt(og.length()-1)))){
					errors.add(line + ":" + error[2]);
				}
				line++;

			} else if (fix.substring(0, 4).equals("FOR ")) {
				if(!(fix.charAt(0)==(og.charAt(0)))){
					errors.add(line + ":" + error[1]);

				}
				else if(!(fix.charAt(fix.length()-1)==(og.charAt(og.length()-1)))){
					errors.add(line + ":" + error[2]);
				}
				lines = new StringBuilder(fix);
				indent = new StringBuilder("    ");
				og = in.nextLine();
				fix = og.trim();
				line++;

				while (!og.contains("NEXT")) {

					String fix2=new String(fix);
					String og2=new String(og);

					if(fix2.contains("$") ){
						int k=0;

						arr=fix2.split(" ");
						TFM=false;
						while(fix2.contains("$") && code.size()!=0 && !TFM) {

							boolean TF = false;

							for (int i = 0; (i < code.size()) && (!TF) && (code.size()!=0) ; i++) {

								for (int j = 0; (j < arr.length) && (!TF )&& (code.size()!=0)  ; j++) {
									if((i==code.size()-1) && (j==arr.length-1))
										TFM=true;
									if ((("$" + code.get(i)).equals(arr[j])) && code.size()!=0 && ((fix2.indexOf("#") == -1 ||fix2.indexOf("#")>fix.indexOf(arr[j])) )) {

										TF = true;



										code.remove(i);
										var.remove(i);

										fix2=fix2.replaceFirst("[$]","%");

									}


								}


							}

						}


					}


					indent = new StringBuilder("    ");

					if (!indent.append(fix).toString().equals(og)) {
						errors.add(line + ":" + error[1]);

					}
					indent = new StringBuilder("    ");
					og = in.nextLine();
					fix = og.trim();
					line++;

				}
				if(!(fix.charAt(0)==(og.charAt(0)))){
					errors.add(line + ":" + error[1]);

				}
				if(!(fix.charAt(fix.length()-1)==(og.charAt(og.length()-1)))){
					errors.add(line + ":" + error[2]);
				}
				line++;


			}
			else if(fix.contains("$") ){
				int k=0;
				String fix2=new String(fix);
				String og2=new String(og);
				arr=fix.split(" ");
				TFM=false;
				while(fix.contains("$") && code.size()!=0 && !TFM) {

					boolean TF = false;

					for (int i = 0; (i < code.size()) && (!TF) && (code.size()!=0) ; i++) {

						for (int j = 0; (j < arr.length) && (!TF )&& (code.size()!=0)  ; j++) {
							if((i==code.size()-1) && (j==arr.length-1))
								TFM=true;
							if ((("$" + code.get(i)).equals(arr[j])) && code.size()!=0 && ((fix2.indexOf("#") == -1 ||fix2.indexOf("#")>fix.indexOf(arr[j])) )) {

								TF = true;



								code.remove(i);
								var.remove(i);

								fix=fix.replaceFirst("[$]","%");



							}






						}


					}

				}
				if(!(fix2.charAt(0)==(og2.charAt(0)))){
					errors.add(line + ":" + error[1]);

				}
				if(!(fix2.charAt(fix2.length()-1)==(og2.charAt(og2.length()-1)))){
					errors.add(line + ":" + error[2]);
				}
				line++;





			}
			else{
				if(!(fix.charAt(0)==(og.charAt(0)))){
					errors.add(line + ":" + error[1]);

				}
				if(!(fix.charAt(fix.length()-1)==(og.charAt(og.length()-1)))){
					errors.add(line + ":" + error[2]);
				}
				line++;
			}



		}



		for(int p=0;p<code.size();p++){
			errors.add(var.get(p) + ":" + error[0] );

		}


		String[] all=new String[errors.size()];
		String[] allc=new String[errors.size()];

		for(int k=0;k<all.length;k++){
			all[k]=errors.get(k);
			allc[k]=errors.get(k).replaceAll("[^\\d.]", "");}
			int alld[]=new int[all.length];
		for(int k=0;k<all.length;k++){
			alld[k]=Integer.parseInt(allc[k]);}

		int n = allc.length;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if (alld[j] > alld[j+1])
				{
					// swap arr[j+1] and arr[i]
					String temp = all[j];
					all[j] = all[j+1];
					all[j+1] = temp;

					int temp2 = alld[j];
					alld[j] = alld[j+1];
					alld[j+1] = temp2;

				}

		//for(String a:allc)
		//	out.println(a);



		for(String a: all)
			out.println(a);


	}
}



