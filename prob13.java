import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class prob13 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int walletSum = in.nextInt();
        int n = in.nextInt();
        in.nextLine();//dummy

        Item[] items = new Item[n];

        for(int i = 0; i < n; i++) {
            items[i] = new Item(in.next(), in.nextInt());

        }
        Arrays.sort(items);

        int itemCount = 0;
        for(int i = 0; i < n; i++) {
            if(!(walletSum - items[i].cost < 0)) {
                walletSum -= items[i].cost;
                itemCount++;
            } else
                break;
        }

        for(int i = 0; i < itemCount; i++) {
            System.out.println("I can afford " + items[i].name);
        }
        for(int i = itemCount; i < n; i++) {
            System.out.println("I can't afford " + items[i].name);
        }

        if(itemCount == 0)
            System.out.println("I need more Yen!");
        System.out.println(walletSum);
    }
}

class Item implements Comparable<Item>{
    String name;
    int cost;
    public Item(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public int compareTo(Item item) {
        return (cost-item.cost);
    }
}
