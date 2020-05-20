import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static java.lang.System.out;

final class prob26 {
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		Scanner in = new Scanner(new File("input.txt"));


		while (in.hasNextLine()) {
			String[] var = in.nextLine().split(" ");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar dt1= Calendar.getInstance();
			Calendar dt2= Calendar.getInstance();
			String date1=var[0]+" " +var[1];
			Date d1= sdf.parse(date1);
			dt1.setTime(d1);

			String date2=var[2]+" " +var[3];
			Date d2= sdf.parse(date2);
			dt1.setTime(d2);
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;

			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			switch(var[4]){
				case "D": out.println("there are " + ((d2.getTime()-d1.getTime())/1000/60/60/24) + " days remaining until " + var[2]+" " +var[3] );
					break;
				case "H": out.println("there are " + diff/1000/60/60 + " hours remaining until " + var[2]+" " +var[3]  );
					break;
				case "M" : out.println("there are " + ((d2.getTime()-d1.getTime())/1000/60) + " minutes remaining until " + var[2]+" " +var[3]  );
					break;
				case "S": out.println("there are " + ((d2.getTime()-d1.getTime())/1000) + " seconds remaining until " + var[2]+" " +var[3]);
					break;
				case "DHMS": out.println("there are " + diffDays  + " days " + diffHours+ " hours " +diffMinutes+ " minutes " +diffSeconds + " seconds remaining until " + var[2]+" " +var[3]);
					break;
				case "HMS":  out.println("there are "+ (diff/1000/60/60) + " hours " +(diff/(1000)/60 %60)+ " minutes " +(diff/1000 %60) + " seconds remaining until " + var[2]+" " +var[3]);
					break;
				case "MS":  out.println("there are "+(diff/(1000)/60 )+ " minutes " +(diff/1000 %60) + " seconds remaining until " + var[2]+" " +var[3]);
					break;
				case "DH": out.println("there are " + diffDays  + " days " + (diff/1000/60/60 %24)+ " hours remaining until " + var[2]+" " +var[3]);

					break;
				case "DM":  out.println("there are " + diffDays  + " days " + (((diff/1000/60/60 %24)*60)+(diff/1000/60 %60))+ " minutes remaining until " + var[2]+" " +var[3]);
					break;
				case "DS" : out.println("there are " + diffDays  + " days " + (((((diff/1000/60/60 %24)*60)+(diff/1000/60 %60))*60) +diffSeconds)+ " seconds remaining until " + var[2]+" " +var[3]);
					break;
				case "HM":  out.println("there are " + diff/1000/60/60  + " hours " + (diff/1000/60 %60)+ " minutes remaining until " + var[2]+" " +var[3]);
					break;
				case "HS":  out.println("there are " + diff/1000/60/60  + " hours " + (((diff/1000/60 %60)*60)+ (diff/1000 %60))+ " seconds remaining until " + var[2]+" " +var[3]);
					break;
			}






		}
	}
}
