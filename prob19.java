import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class prob19 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        String rawMessage = in.nextLine();
        String hexMessage = "";
        String encryptedMessage = "";
        String realMessage = "";

        rawMessage = rawMessage.replaceAll(" ", "");
        //change to hex
        for(int i = 0; i < rawMessage.length(); i++) {
            hexMessage += String.format("%x", (int) rawMessage.charAt(i)) + " ";
        }
        System.out.println(hexMessage);

        hexMessage = hexMessage.replaceAll(" ", "");
        for(int i = hexMessage.length()-1; i > 0 ; i-=4) {
            encryptedMessage += hexMessage.charAt(i);
        }
        encryptedMessage = StringFormatter.reverseString(encryptedMessage);
        System.out.println(encryptedMessage);

        for(int i = 0; i < encryptedMessage.length()-1; i+=2) {
            realMessage += (char)Integer.parseInt("" + encryptedMessage.charAt(i)+encryptedMessage.charAt(i+1), 16) ;
        }
        System.out.println(realMessage);
    }
    public static class StringFormatter {
        public static String reverseString(String str){
            char ch[]=str.toCharArray();
            String rev="";
            for(int i=ch.length-1;i>=0;i--){
                rev+=ch[i];
            }
            return rev;
        }
    }
}
