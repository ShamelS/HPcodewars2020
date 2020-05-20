import java.io.File;
import java.io.IOException;
import java.util.*;

public class prob17 {
    static String[] cities;
    static boolean[][] grid;
    static List<String> lists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        String line;
        int city1, city2;
        int amount = in.nextInt();
        in.nextLine();
        grid = new boolean[amount][amount];
        cities = new String[amount];
        for (int i = 0; i < amount; i++) {
            cities[i] = in.nextLine();
        }


        while (in.hasNext()) {
            line = in.nextLine();
            city1 = findCity(line.substring(5, 6));
            city2 = findCity(line.substring(28, 29));
            if (!(line.substring(33, 36).equals("air"))) {
                grid[city1][city2] = true;
            }
        }

        for (int assign = 0; assign < amount; assign++) {
            lists.add("");
        }
        lists.set(0, (lists.get(0) + cities[0]));
        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < amount; j++) {
                if (grid[i][j]) {
                    findAdd(i, j);
                }
            }
        }

        removeBlank();
        deleteRepeat();
        int index;
        for(String city: cities){
            index = locate(city);
            print(city, index);
        }

    }

    public static void findAdd(int i, int j) {
        String a = cities[i];
        String b = cities[j];
        int index = 0;
        for (String temporary : lists) {
                if (temporary.contains(a)) {
                    lists.set(index, (lists.get(index) + b));
                    break;
                } else if (temporary.contains(b)) {
                    lists.set(index, (lists.get(index) + a));
                    break;
                } else if (temporary.length()==0) {
                    lists.set(index, b);
                    break;
                }
            index++;
        }
    }

    public static int findCity(String x) {
        int i = 0;
        for (String temp : cities) {
            if (temp.equals(x))
                return i;
            i++;
        }
        return -1;
    }

    public static void removeBlank(){
        for(int i = 0; i<lists.size(); i++){
            if(lists.get(i).isBlank())
                lists.remove(i);
            else
                i++;
        }
    }

    public static void deleteRepeat(){
        String string;
        char[] chars;
        Set<Character> charSet;
        StringBuilder sb;
        for(int i = 0; i<lists.size(); i++){
            string = lists.get(i);
            chars = string.toCharArray();
            charSet = new LinkedHashSet<Character>();
            for (char c : chars) {
                charSet.add(c);
            }

            sb = new StringBuilder();
            for (Character character : charSet) {
                sb.append(character);
            }
            lists.set(i, sb.toString());
        }
    }

    public static int locate(String city){
        int index = 0;
        for(String item: lists){
            if(item.contains(city))
                return index;
            index++;
        }
        return -1;
    }

    public static void print(String city, int index){
        System.out.print("City " + city + " is ");
        if(index==-1)
            System.out.println("remote and has no neighbors!");
        else{
            System.out.print("neighbour to Cities ");
            String temp = lists.get(index);
            temp = removeChar(temp, city);
            char[] tempArr = temp.toCharArray();
            String s = "";
            for (String n:cities)
                s+= n;
            char[] c = s.toCharArray();
            tempArr = sortByPattern(tempArr, c);
            temp = String.valueOf(tempArr);
            for(int i = 0; i<(temp.length()-1); i++){
                System.out.print(temp.charAt(i) + ",");
            }
            System.out.println(temp.charAt(temp.length()-1));


        }
    }

    public static char[] sortByPattern(char[] str, char[] pat)
    {
        String string = String.valueOf(str);
        int amount = str.length;
        str = new char[amount];
        int i = 0;
        for(char temp: pat){
            if(string.contains(String.valueOf(temp))){
                str[i] = temp;
                i++;
            }
        }
        return str;
    }

    public static String removeChar(String temp, String city){
        StringBuilder check = new StringBuilder(temp);
        int index = temp.indexOf(city);
        check.delete(index,(index+city.length()));
        temp = check.toString();
        return temp;
    }
}
