import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class prob27 {
    static String line;
    static String[] words;
    static int amount;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        line = in.nextLine();
        amount = Integer.parseInt(line.substring(0, 1));

        while (amount != 0) {
            line = line.substring(2);
            words = line.split(" ");
            copy();

            line = in.nextLine();
            amount = Integer.parseInt(line.substring(0, 1));
        }
    }

    public static void copy() {
        boolean check = false;
        for (String temp : words) {
            if (temp.equals(words[0]))
                check = true;
            else
                check = false;
        }
        if (check) {
            System.out.println(line + "  COPY");
        } else {
            shm();
        }
    }

    public static void rhyme() {
        boolean check = false;
        int[] vow = new int[words.length];
        int a = 0;
        for(String findingVowel: words){
            vow[a] = findVowel(findingVowel);
            a++;
        }
        for(int b = 1; b<words.length; b++){
            if(words[0].substring(vow[0]).equals(words[b].substring(vow[b])))
                check = true;
            else
                check = false;
        }

        if (check)
            System.out.println(line + "  RHYMING");
        else
            ablaut();
    }

    public static int findVowel(String word) {
        int length = word.length();
        String vowels = "AEIOUY";

        for (int index = 0; index < word.length(); index++) {
            if (vowels.contains(String.valueOf(word.charAt(index)))) {
                return index;
            }
        }
        return -1;
    }

    public static void shm() {
        boolean check = false;
        if (words[0].length() >= 3 && !words[0].substring(0, 3).equals("SHM")) {
            if (words[1].substring(0, 3).equals("SHM"))
                check = true;
        }
        if (check)
            System.out.println(line + "  SHM");
        else
            rhyme();
    }

    public static void ablaut() {
        String word = words[0];
        boolean checking = false;
        ArrayList<String> vow = new ArrayList<String>();
        int index = -1;
        while (!checking) {
            index = index + findVowel(word) + 1;
            if (words[0].charAt(index) == words[1].charAt(index)) {
                word = word.substring(index + 1);
            } else {
                checking = true;
                for(String temp: words){
                    vow.add(temp.substring(index, (index+1)));
                }
                boolean progess = progessive(vow);
                if(progess)
                    System.out.println(line + "  PROGRESSIVE");
                else
                    System.out.println(line + "  ABLAUT");
            }
        }
    }

    public static boolean progessive(ArrayList<String> vow){
        boolean check = true;
        int[] num = new int[vow.size()];
        for(int i = 0; i<vow.size(); i++){
            if(vow.get(i).equals("I"))
                num[i] = 1;
            if(vow.get(i).equals("A"))
                num[i] = 2;
            if(vow.get(i).equals("E"))
                num[i] = 3;
            if(vow.get(i).equals("O"))
                num[i] = 4;
            if(vow.get(i).equals("U"))
                num[i] = 5;
        }
        for(int j = 1; j<num.length; j++){
            if(num[j]<num[j-1])
                check=false;
        }
        return check;
    }
}
