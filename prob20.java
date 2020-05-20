import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.out;

final class prob20 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("input.txt"));
		int top[][] =     /*0*/ {{32, 16, 84, 20, 12, 28, 40, 36},
		                         /*1*/  {0, 0, 84, 0, 0, 0, 0, 36},
		                         /*2*/  {0, 16, 0, 20, 0, 28, 40, 0},
		                         /*3*/  {0, 0, 0, 0, 12, 28, 0, 0},
		                         /*4*/  {32, 0, 0, 0, 0, 0, 40, 36},
		                         /*5*/  {0, 0, 0, 0, 0, 0, 0, 0}
		};

		int total[] = {0, 0, 0, 0, 0, 0, 0, 0};

		String topn[][] = {{"Pepperoni", "Red Peppers", "Pineapple", "Olives", "Sardines", "Onion", "Sausage", "Ham"},
		                   {"Hawaiian"},
		                   {"Combo"},
		                   {"Fishaster"},
		                   {"Meat-Lovers"},
		                   {"Cheese"},
		                   };

		int N = 2;
		while (in.hasNextLine()) {
			int n = in.nextInt();
			String line = in.nextLine();
			String m1[] = line.split(" ");
			int k = 0;


			while (k < m1.length) {


				switch (m1[k]) {
					case "1/4":
						k++;
						switch (m1[k]) {
							case "Pepperoni": total[0] += (n * (top[0][0] / 4));
							k++;
								break;
							case "Red": total[1] += (n * top[0][1] / 4);
							k++;
								break;
							case "Pineapple": total[2] += (n * top[0][2] / 4);
							k++;
								break;
							case "Olives": total[3] += (n * top[0][3] / 4);
							k++;
								break;
							case "Sardines": total[4] += (n * top[0][4] / 4);
							k++;
								break;
							case "Onion": total[5] += (n * top[0][5] / 4);
							k++;
								break;
							case "Sausage": total[6] += (n * top[0][6] / 4);
							k++;
								break;
							case "Ham": total[7] += (n * top[0][7] / 4);
							k++;
								break;
							case "Hawaiian":
								for (int i = 0; i < total.length; i++)
									total[i] += (n * top[1][i] / 4);
								k++;
								break;

							case "Combo":
								for (int i = 0; i < total.length; i++)
									total[i] += (n * top[2][i] / 4);
								k++;
								break;

							case "Fishaster":
								for (int i = 0; i < total.length; i++)
									total[i] += (n * top[3][i] / 4);
								k++;
								break;

							case "Meat-Lovers":
								for (int i = 0; i < total.length; i++)
									total[i] += (n * top[4][i] / 4);
								k++;
								break;

								case "Cheese":
									k++;
									break;


						}
						break;
					case "1/2":
						k++;
						switch (m1[k]) {
							case "Pepperoni": total[0] += (n * top[0][0] / 2);
								k++;
								break;
							case "Red": total[1] += (n * top[0][1] / 2);
								k++;
								break;
							case "Pineapple": total[2] += (n * top[0][2] / 2);
								k++;
								break;
							case "Olives": total[3] += (n * top[0][3] / 2);
								k++;
								break;
							case "Sardines": total[4] += (n * top[0][4] / 2);
								k++;
								break;
							case "Onion": total[5] += (n * top[0][5] / 2);
								k++;
								break;
							case "Sausage": total[6] += (n * top[0][6] / 2);
								k++;
								break;
							case "Ham": total[7] += (n * top[0][7] / 2);
								k++;
								break;
							case "Hawaiian":
								for (int i = 0; i < total.length; i++)
									total[i] += (n * top[1][i] / 2);
								k++;
								break;

							case "Combo":
								for (int i = 0; i < total.length; i++)
									total[i] += (n * top[2][i] / 2);
								k++;
								break;

							case "Fishaster":
								for (int i = 0; i < total.length; i++)
									total[i] += (n * top[3][i] / 2);
								k++;
								break;

							case "Meat-Lovers":
								for (int i = 0; i < total.length; i++)
									total[i] += (n * top[4][i] / 2);
								k++;
								break;

								case "Cheese":
									k++;
									break;


						}

						break;



							case "Pepperoni": total[0] += (n * top[0][0]);
								k++;
								break;
							case "Red": total[1] += (n * top[0][1]);
								k++;
								break;
							case "Pineapple": total[2] += (n * top[0][2]);
								k++;
								break;
							case "Olives": total[3] += (n * top[0][3]);
								k++;
								break;
							case "Sardines": total[4] += (n * top[0][4]);
								k++;
								break;
							case "Onion": total[5] += (n * top[0][5]);
								k++;
								break;
							case "Sausage": total[6] += (n * top[0][6]);
								k++;
								break;
							case "Ham": total[7] += (n * top[0][7]);
								k++;
								break;
							case "Hawaiian":
								for (int i = 0; i < total.length; i++)
									total[i] += (n * top[1][i]);
								k++;
								break;


							case "Combo":
								for (int i = 0; i < total.length; i++)
									total[i] += (n * top[2][i]);
								k++;
								break;

							case "Fishaster":
								for (int i = 0; i < total.length; i++)
									total[i] += (n * top[3][i]);
								k++;
								break;

							case "Meat-Lovers":
								for (int i = 0; i < total.length; i++)
									total[i] += (n * top[4][i]);
								k++;
								break;

					default: k++;
							break;


				}


			}


		}
		for (int j = 0; j < total.length; j++) {
			out.println(topn[0][j] + ": " + total[j]);

		}

	}
}

